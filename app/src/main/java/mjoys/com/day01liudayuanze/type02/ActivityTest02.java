package mjoys.com.day01liudayuanze.type02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import mjoys.com.day01liudayuanze.ConstantValue;
import mjoys.com.day01liudayuanze.R;
import mjoys.com.day01liudayuanze.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zsd on 2018/1/20 15:03
 * desc:对OKhttp简单封装了一下，
 *      对于一些公共逻辑写到了一个工具类中
 */

public class ActivityTest02 extends AppCompatActivity {

    private int pageNum = 1;
    private int pageSize = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /********************访问网络开始*******************/
        Map<String, Object> params = new HashMap<>();
        // 特定参数
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);

        HttpUtils.get(this, ConstantValue.UrlConstant.HOME_DATA_URL, params, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // 失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultJson = response.body().string();
                Log.e("test", resultJson);
                // 1.JSON解析转换

                // 2.显示列表数据

                // 3.缓存数据
            }
        });
        /********************访问网络结束*******************/
    }
}

