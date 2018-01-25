package mjoys.com.day01liudayuanze.http;

import android.content.Context;

import java.util.Map;

/**
 * Created by zsd on 2018/1/20 11:42
 * desc:网络引擎的接口规范
 */

public interface IHttpEngine {
    public void get(Context context, String url, Map<String, Object> headers, Map<String, Object> params, HttpEngineCallback callback);

    public void post(Context context, String url, Map<String, Object> headers, Map<String, Object> params, int mediaType, HttpEngineCallback callback);
}
