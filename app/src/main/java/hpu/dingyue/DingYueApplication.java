package hpu.dingyue;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/3/21.
 */
public class DingYueApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);

    }
}
