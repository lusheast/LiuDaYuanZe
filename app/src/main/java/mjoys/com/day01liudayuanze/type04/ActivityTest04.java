package mjoys.com.day01liudayuanze.type04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import mjoys.com.day01liudayuanze.R;



public class ActivityTest04 extends AppCompatActivity {

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
        HttpUtils.with(this).cache(true).get().param("iid", 6152551759L).param("aid", 7).request(
                new HttpCallBack<SelfProductBean>() {
                    @Override
                    public void onSuccess(SelfProductBean result) {

                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
        /********************访问网络结束*******************/
    }

    /********************访问网络结束*******************/

    private void showListData(SelfProductBean result) {

    }
}

