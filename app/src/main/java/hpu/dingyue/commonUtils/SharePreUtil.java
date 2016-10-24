package hpu.dingyue.commonUtils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.R.attr.value;

/**
 * Created by Administrator on 2016/3/18.
 */
public class SharePreUtil {

    private static SharePreUtil mSharePreUtil;
    public static final String PREFERENCE_NAME = "dingyue";
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;

    private SharePreUtil(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public static SharePreUtil getIntance(Context context) {
        if (mSharePreUtil == null) {
            mSharePreUtil = new SharePreUtil(context);
        }
        return mSharePreUtil;
    }

    private void setString(String str_key, String str_value) {
        editor.putString(str_key, str_value);
        editor.apply();
    }

    private String getString(String str_key) {
        return mSharedPreferences.getString(str_key, "");
    }

    private void setInt(String str_key, int value) {
        editor.putInt(str_key, value);
        editor.apply();
    }

    private int getInt(String str_key) {
        return mSharedPreferences.getInt(str_key, 1);
    }
    private void setLong(String str_key, long value) {
        editor.putLong(str_key, value);
        editor.apply();
    }
    
    private long getLong(String str_key) {
        return mSharedPreferences.getLong(str_key, 0);
    }

    private void setBoolean(String str_key, boolean value) {
        editor.putBoolean(str_key, value);
        editor.apply();
    }

    private boolean getBoolean(String str_key) {
        return mSharedPreferences.getBoolean(str_key, false);
    }

    public void setKey(String str_value) {
        setString("test", str_value);
    }

    public String getKey() {
        return getString("test");
    }

    public void setInt(int value) {
        setInt("mode", value);
    }

    public int getInt() {
        return getInt("mode");
    }

}
