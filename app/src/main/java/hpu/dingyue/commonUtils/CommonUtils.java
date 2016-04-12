package hpu.dingyue.commonUtils;

import android.os.Build;

/**
 * Created by Administrator on 2016/4/12.
 */
public class CommonUtils {

    /**
     * 判断当前版本号
     * @return
     */
    public boolean buildVersion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return true;
        }
        return false;
    }
}
