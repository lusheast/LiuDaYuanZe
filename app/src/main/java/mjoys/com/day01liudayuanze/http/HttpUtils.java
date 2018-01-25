package mjoys.com.day01liudayuanze.http;

import android.content.Context;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsd on 2017/12/18 13:56
 * desc:自己的一套实现
 */

public class HttpUtils {

    public static final int GET_TYPE = 0x0011;

    public static final int POST_TYPE = 0x0022;


    // 类型为 json
    public static final int MEDIA_TYPE_JSON = 1001;
    // 类型为 x-www-form-urlencoded
    public static final int MEDIA_TYPE_WWW_FORM_URLENCODED = 1002;
    // 如果包含文件
    public static final int MEDIA_TYPE_ALTERNATIVE = 1003;
    // 类型为 form-data
    public static final int MEDIA_TYPE_FORM_DATA = 1004;

    //默认的是okhttp引擎
    private static IHttpEngine mHttpEngine = new OkHttpEngine();

    //url
    private String mUrl;
    //提交方式
    private int mType = GET_TYPE;
    //上下文
    private Context mContext;
    //参数
    private Map<String, Object> mParams;
    //请求头参数
    private Map<String, Object> mHeaderParams;
    //Content-type来指定不同格式的请求信息
    private int mediaType = MEDIA_TYPE_JSON;

    private String mJson;

    private HttpUtils(Context context) {
        this.mContext = context;
        this.mParams = new HashMap<>();
        this.mHeaderParams = new HashMap<>();
    }


    public static HttpUtils with(Context context) {
        return new HttpUtils(context);
    }

    /**
     * post请求
     *
     * @return
     */
    public HttpUtils post() {
        mType = POST_TYPE;
        return this;
    }

    /**
     * get请求
     *
     * @return
     */
    public HttpUtils get() {
        mType = GET_TYPE;
        return this;
    }

    /**
     * 添加参数
     *
     * @param key
     * @param value
     * @return
     */
    public HttpUtils addParam(String key, Object value) {
        mParams.put(key, value);
        return this;
    }

    /**
     * 添加多个请求参数
     *
     * @param params
     * @return
     */
    public HttpUtils addParams(Map<String, Object> params) {
        mParams.putAll(params);
        return this;
    }

    /**
     * 设置mediaType
     *
     * @param mediaType
     * @return
     */
    public HttpUtils setMediaType(int mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    /**
     * url
     *
     * @param url
     * @return
     */
    public HttpUtils url(String url) {
        this.mUrl = url;
        return this;
    }

    /**
     * 添加请求头参数
     * @param key
     * @param value
     * @return
     */
    public HttpUtils addHeaderParam(String key, Object value) {
        mHeaderParams.put(key, value);
        return this;
    }

    /**
     * 添加请求头参数
     *
     * @param params
     * @return
     */
    public HttpUtils addHeaderParams(Map<String, Object> params) {
        mHeaderParams.putAll(params);
        return this;
    }

    /**
     * 添加回调 执行
     *
     * @param callback
     */
    public void execute(HttpEngineCallback callback) {
        //添加公共参数，让callBack去回调
        callback.onPreExecute(mContext, mParams,mHeaderParams);

        if (callback == null) {
            callback = HttpEngineCallback.DEFAULT_CALL_BACK;
        }
        //判断执行方法
        if (mType == POST_TYPE) {
            post(mContext, mUrl, mParams, mediaType, callback);
        }

        if (mType == GET_TYPE) {
            get(mContext, mUrl, mParams, callback);
        }

    }

    public void execute() {
        execute(null);
    }


    //在Application中初始化引擎
    public static void init(IHttpEngine httpEngine) {
        mHttpEngine = httpEngine;
    }

    /**
     * 引擎的切换，假如将来不想用okhttp引擎了，自己写就可以了
     *
     * @param httpEngine
     */
    public void exchangeEngine(IHttpEngine httpEngine) {
        mHttpEngine = httpEngine;
    }


    public void get(Context context, String url, Map<String, Object> params, HttpEngineCallback callback) {
        mHttpEngine.get(context, url, mHeaderParams, params, callback);
    }


    public void post(Context context, String url, Map<String, Object> params, int mediaType, HttpEngineCallback callback) {
        mHttpEngine.post(context, url, mHeaderParams, params, mediaType, callback);
    }

    public static Class<?> analysisClazzInfo(Object object) {
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) params[0];
    }

}
