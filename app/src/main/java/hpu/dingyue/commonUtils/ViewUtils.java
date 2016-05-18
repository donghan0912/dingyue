package hpu.dingyue.commonUtils;

import android.view.View;

/**
 * Created by Administrator on 2016/5/18.
 */
public class ViewUtils {

    // 在onCreate方法中，获取控件宽、高等属性的时候，可以采用下面两种方法
    public void getView(final View view) {

        //1. 将一个runnable添加到Layout队列中：View.post()
        view.post(new Runnable() {
            @Override
            public void run() {
                int height = view.getHeight();
                int width = view.getWidth();
            }
        });

        // 2. 重写Activity的onWindowFocusChanged方法,在该方法中获取
//        @Override
//        public void onWindowFocusChanged(boolean hasFocus) {
//            super.onWindowFocusChanged(hasFocus);
//            //此处可以正常获取width、height等
//        }
    }



}
