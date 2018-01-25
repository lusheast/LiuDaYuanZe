package mjoys.com.day01liudayuanze;

import android.app.Application;

import org.xutils.x;

import mjoys.com.day01liudayuanze.type03.PreferencesHttpCache;
import mjoys.com.day01liudayuanze.type03.PreferencesUtil;
import mjoys.com.day01liudayuanze.type05.HttpUtils;
import mjoys.com.day01liudayuanze.type05.OKHttpRequest;
import mjoys.com.day01liudayuanze.type05.XUtilsRequest;

/**
 * Created by zsd on 2018/1/22 17:22
 * desc:
 */

public class BaseAppLication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferencesUtil.getInstance().init(this);
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        //我们在Application中初始化网络引擎
        HttpUtils.initHttpRequest(new OKHttpRequest());
        HttpUtils.initHttpRequest(new XUtilsRequest());
    }
}
