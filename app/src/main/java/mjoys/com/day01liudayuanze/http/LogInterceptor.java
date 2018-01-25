package mjoys.com.day01liudayuanze.http;


import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by zsd on 2017/12/18 17:18
 * desc:
 */

public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        Log.d("请求信息==>:%s", request.toString());
        Log.d("响应信息==>:%s", response.toString());
        return response;
    }
}
