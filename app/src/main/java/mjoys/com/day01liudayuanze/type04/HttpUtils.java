package mjoys.com.day01liudayuanze.type04;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;


public class HttpUtils {


    private OKHttpRequest mHttpRequest;
    private final int TYPE_POST = 0x0011;
    private final int TYPE_GET = 0x0022;
    private int mType = TYPE_GET;
    private Map<String,Object> mParams;
    private String mUrl;
    private Context mContext;

    public static HttpUtils with(Context context){
        return new HttpUtils(context);
    }

    public HttpUtils get(){
        mType = TYPE_GET;
        return this;
    }

    private HttpUtils(Context context) {
        mHttpRequest = new OKHttpRequest();
        mParams = new HashMap<>();
        this.mContext = context;
    }

    public HttpUtils param(String key,Object value){
        mParams.put(key,value);
        return this;
    }

    public HttpUtils url(String url){
        this.mUrl = url;
        return this;
    }

    public HttpUtils cache(boolean cache){
        // TODO
        return this;
    }

    public <T> void request(){
        request(null);
    }

    public <T> void request(final HttpCallBack<T> callback){
        // 异常判断
        mHttpRequest.get(mContext,mUrl,mParams,callback,true);
    }

}
