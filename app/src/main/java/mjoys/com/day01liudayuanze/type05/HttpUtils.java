package mjoys.com.day01liudayuanze.type05;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;


public class HttpUtils {

    private IHttpRequest mHttpRequest;
    private static IHttpRequest mInitHttpRequest;
    private final int TYPE_POST = 0x0011;
    private final int TYPE_GET = 0x0022;
    private int mType = TYPE_GET;
    private Map<String,Object> mParams;
    private String mUrl;
    private Context mContext;

    public static HttpUtils with(Context context){
        return new HttpUtils(context);
    }

    /**
     * 切换网络引擎
     * @param httpRequest
     * @return
     */
    public HttpUtils exChangeHttpRequest(IHttpRequest httpRequest){
        mHttpRequest = httpRequest;
        return this;
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

    public static void initHttpRequest(IHttpRequest httpRequest) {
        mInitHttpRequest = httpRequest;
    }

    public HttpUtils param(String key, Object value){
        mParams.put(key,value);
        return this;
    }

    public HttpUtils url(String url){
        this.mUrl = url;
        return this;
    }

    public HttpUtils cache(boolean cache){
        // TODO 这里写关于缓存的
        return this;
    }

    public <T> void request(){
        request(null);
    }

    public <T> void request(final HttpCallBack<T> callback){
        if(mHttpRequest == null){
            mHttpRequest = mInitHttpRequest;
        }
        // 异常判断
        mHttpRequest.get(mContext,mUrl,mParams,callback,true);
    }

}
