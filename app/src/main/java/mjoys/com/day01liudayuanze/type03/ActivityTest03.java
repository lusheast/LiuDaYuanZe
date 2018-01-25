package mjoys.com.day01liudayuanze.type03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import mjoys.com.day01liudayuanze.ConstantValue;
import mjoys.com.day01liudayuanze.R;

/**
 * Created by zsd on 2018/1/20 15:03
 */

public class ActivityTest03 extends AppCompatActivity {

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

        HttpUtils.get(this, ConstantValue.UrlConstant.HOME_DATA_URL, params, new HttpCallBack<SelfProductBean>() {
            @Override
            public void onSuccess(SelfProductBean result) {
                if (result.getCode() != 20000) {
                    // 没有列表数据的情况, 打印 Toast 或者做一些其他处理
                } else {
                    // 有数据列表的情况，显示列表
                    showListData(result);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        },true);
        /********************访问网络结束*******************/
    }

    private void showListData(SelfProductBean result) {

    }
}

