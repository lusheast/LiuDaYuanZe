package mjoys.com.day01liudayuanze.type05;


import mjoys.com.day01liudayuanze.type03.PreferencesUtil;

public class PreferencesHttpCache {
    /**
     * 获取数据
     */
    public String getCacheResultJson(String finalUrl) {
        return (String) PreferencesUtil.getInstance().getParam(finalUrl, "");
    }

    /**
     * 缓存数据
     */
    public void savecCacheData(String finalUrl, String resultJson) {
        PreferencesUtil.getInstance().saveParam(finalUrl, resultJson);
    }
}
