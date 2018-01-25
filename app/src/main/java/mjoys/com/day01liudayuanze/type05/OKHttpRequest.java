package mjoys.com.day01liudayuanze.type05;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import mjoys.com.day01liudayuanze.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpRequest implements IHttpRequest{
    private PreferencesHttpCache mHttpCache;

    public OKHttpRequest() {
        mHttpCache = new PreferencesHttpCache();
    }


    @Override
    public <T> void get(Context context, String url, Map<String, Object> params,final HttpCallBack<T> callback,final boolean cache) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        // 公共参数
        //params.put("app_name", "joke_essay");
        //params.put("device_platform", "android");
        //参数拼接
        final String jointUrl = Utils.jointParams(url, params);  //打印
        // 缓存问题
        Log.e("请求路径：", jointUrl);  // 缓存写到  SP 里面，多级缓存（内存中 30条,数据库 ，文件中 ）
        final String cacheJson = mHttpCache.getCacheResultJson(jointUrl);
        // 写一大堆处理逻辑 ，内存怎么扩展等等
        if (cache && !TextUtils.isEmpty(cacheJson)) {
            Gson gson = new Gson();
            T objResult = (T) gson.fromJson(cacheJson,
                    Utils.analysisClazzInfo(callback));
            callback.onSuccess(objResult);
        }

        Request.Builder requestBuilder = new Request.Builder().url(jointUrl).tag(context);
        //可以省略，默认是GET请求
        Request request = requestBuilder.build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // 失败
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultJson = response.body().string();

                Log.e("TAG",resultJson.equals(cacheJson)+"");
                if (cache && resultJson.equals(cacheJson)) {
                    return;
                }
                // 1.JSON解析转换
                // 2.显示列表数据
                // 3.缓存数据
                Gson gson = new Gson();
                // data:{"name","darren"}   data:"请求失败"
                T objResult = (T) gson.fromJson(resultJson,
                        Utils.analysisClazzInfo(callback));
                callback.onSuccess(objResult);

                if (cache) {
                    mHttpCache.savecCacheData(jointUrl, resultJson);
                }
            }
        });
    }

    @Override
    public <T> void post(Context context, String url, Map<String, Object> params, HttpCallBack<T> callback, boolean cache) {

    }

    @Override
    public <T> void download(Context context, String url, Map<String, Object> params, HttpCallBack<T> callback) {

    }

    @Override
    public <T> void upload(Context context, String url, Map<String, Object> params, HttpCallBack<T> callback) {

    }
}
