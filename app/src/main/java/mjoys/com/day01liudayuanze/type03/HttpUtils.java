package mjoys.com.day01liudayuanze.type03;

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


public class HttpUtils {
    private HttpUtils() {
    }

    public static <T> void get(Context context, String url, Map<String, Object> params, final HttpCallBack<T> callback, final boolean cache) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        // 公共参数
        //params.put("app_name", "joke_essay");
        //params.put("device_platform", "android");
        //参数的拼接
        final String jointUrl = Utils.jointParams(url, params);  //打印
        // 缓存问题
        Log.e("请求路径：", jointUrl);  // 缓存写到  SP 里面，多级缓存（内存中 30条,数据库 ，文件中 ）
        //从SP里面去拿缓存
        final String cacheJson = (String) PreferencesUtil.getInstance().getParam(jointUrl, "");
        // 写一大堆处理逻辑 ，内存怎么扩展等等
        if (cache && !TextUtils.isEmpty(cacheJson)) {
            Gson gson = new Gson();
            // data:{"name","huyy"}   data:"请求失败"
            T objResult = (T) gson.fromJson(cacheJson,Utils.analysisClazzInfo(callback));
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
                // data:{"name","yfee"}   data:"请求失败"
                T objResult = (T) gson.fromJson(resultJson,
                        Utils.analysisClazzInfo(callback));
                callback.onSuccess(objResult);

                if (cache) {
                    PreferencesUtil.getInstance().saveParam(jointUrl, resultJson);
                }
            }
        });
    }
}
