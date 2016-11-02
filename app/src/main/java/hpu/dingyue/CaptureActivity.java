package hpu.dingyue;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import hpu.dingyue.commonUtils.ActivityCollection;
import hpu.dingyue.commonUtils.MemCacheHelper;

/**
 * Created by Administrator on 2016/10/24.
 */

public class CaptureActivity extends AppCompatActivity {

    private static final String PARAM_MEM_CACHE_KEY = "PARAM_MEM_CACHE_KEY";
    private static final int MSG_CLOSE_ACTIVITY = 1;
    private String mCacheKey;

    private Handler closeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_CLOSE_ACTIVITY) {
                finish();
//                overridePendingTransition(android.R.anim.fade_in,
//                        android.R.anim.fade_out);
                overridePendingTransition(0, R.anim.capture_fade_out);
                // 清除map集合中存储的屏幕截图
                MemCacheHelper.getInstance().remove(mCacheKey);
            }
        }
    };

    public static void start(Context context, String memCacheKey) {
        Intent starter = new Intent(context, CaptureActivity.class);
        starter.putExtra(PARAM_MEM_CACHE_KEY, memCacheKey);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        // 获取刚才的屏幕截图
        mCacheKey = getIntent().getStringExtra(PARAM_MEM_CACHE_KEY);
        Bitmap bitmap = MemCacheHelper.getInstance().get(mCacheKey);
        if (bitmap == null)
            return;
        // 找控件，设置背景图
        final ImageView imageView = (ImageView) findViewById(R.id.iv_fullImage);
//        imageView.setImageBitmap(bitmap);

        getWindow().getDecorView().setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));

        new Handler().postDelayed(new Runnable() {
            public void run() {
                // 重新创建所有的Activity
//                ActivityCollection.refreshAllActivity();
                closeHandler.sendEmptyMessageDelayed(MSG_CLOSE_ACTIVITY, 10);
            }
        }, 100);
    }

    /**
     * 切换状态栏颜色值
     * @param colorValue 颜色值
     */
    private void changeStatusColor(int colorValue) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, colorValue));
        }
    }

}
