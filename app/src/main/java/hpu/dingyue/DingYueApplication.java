package hpu.dingyue;

import android.app.Application;
import android.util.Log;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by Administrator on 2016/3/21.
 */
public class DingYueApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String s) {
                Log.e("device_token:", s);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
}
