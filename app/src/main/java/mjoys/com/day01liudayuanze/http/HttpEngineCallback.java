package mjoys.com.day01liudayuanze.http;

import android.content.Context;

import java.util.Map;

/**
 * Created by zsd on 2018/1/20 11:43
 * desc:回调接口
 */

public interface HttpEngineCallback {

    //在执行之前的回调方法
    public void onPreExecute(Context context,  Map<String, Object> mHeaderParams,Map<String, Object> params);

    //成功的回调备用方法
    public void onSuccess(String result);

    //失败的回调
    public void onFailure(Exception e);

    //有一个默认的
    public final HttpEngineCallback DEFAULT_CALL_BACK = new HttpEngineCallback() {
        @Override
        public void onPreExecute(Context context,  Map<String, Object> mHeaderParams,Map<String, Object> params) {

        }

        @Override
        public void onSuccess(String result) {

        }


        @Override
        public void onFailure(Exception e) {

        }
    };
}
