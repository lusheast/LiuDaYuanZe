package mjoys.com.day01liudayuanze.type05;

import android.content.Context;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by zsd on 2018/1/22 17:14
 * desc:
 */

public class XUtilsRequest implements IHttpRequest{

    private PreferencesHttpCache mHttpCache;

    public XUtilsRequest(){
        mHttpCache = new PreferencesHttpCache();
    }
    // 参数还是很多
    public <T> void get(Context context, String url, Map<String, Object> params,
                        final HttpCallBack<T> callback, final boolean cache) {
        RequestParams requestParams = new RequestParams();
        x.http().get(requestParams, new org.xutils.common.Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

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
