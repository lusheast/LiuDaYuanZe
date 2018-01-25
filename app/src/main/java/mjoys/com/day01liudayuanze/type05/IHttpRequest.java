package mjoys.com.day01liudayuanze.type05;

import android.content.Context;

import java.util.Map;

/**
 * Created by zsd on 2018/1/22 16:27
 * desc:统一的网络请求规范
 */

public interface IHttpRequest {
    <T> void get(Context context, String url, Map<String, Object> params, final HttpCallBack<T> callback, final boolean cache);

    <T> void post(Context context, String url, Map<String, Object> params,final HttpCallBack<T> callback, final boolean cache);

    <T> void download(Context context, String url, Map<String, Object> params,final HttpCallBack<T> callback);

    <T> void upload(Context context, String url, Map<String, Object> params,final HttpCallBack<T> callback);
}
