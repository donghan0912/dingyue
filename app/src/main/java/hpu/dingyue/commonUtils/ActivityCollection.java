package hpu.dingyue.commonUtils;

import android.annotation.SuppressLint;
import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class ActivityCollection {

    private final static List<Activity> activityList = new ArrayList<Activity>();

    public static List<Activity> getList() {
        return activityList;
    }

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activityList.clear();
    }

    public static int getLeftSize() {
        return activityList.size();
    }

    @SuppressLint("NewApi")
    public static void refreshAllActivity() {
        for (Activity activity : activityList) {
            // 重新创建Activity
            activity.recreate();
//          activity.overridePendingTransition(android.R.anim.fade_in,
//                  android.R.anim.fade_out);
        }
    }
}
