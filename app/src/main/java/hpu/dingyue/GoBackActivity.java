package hpu.dingyue;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hpu.dingyue.commonUtils.MemCacheHelper;
import hpu.dingyue.commonUtils.SharePreUtil;
import hpu.dingyue.commonUtils.UIUtils;

/**
 * Created by Administrator on 2016/10/18.
 */

public class GoBackActivity extends AppCompatActivity implements View.OnClickListener{

    private List<String> list;
    private boolean scrollFlag = false;
    private static final String KEY_SCREEN_CAPTURE = "haha";
    private int mDayNightMode = AppCompatDelegate.MODE_NIGHT_NO;
    @BindView(R.id.day)
    SwitchCompat mSwitch;

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_go_back);
        setContentView(R.layout.activity_go_back_toolbar);
        ButterKnife.bind(this);
//        setContentView(R.layout.activity_go_back_tool);
//        final ListView listView = (ListView) findViewById(R.id.list_view);
//        list = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            list.add("这是第" + i + "条数据");
//        }
//        listView.setAdapter(new BackAdapter());
//        final Button button = (Button) findViewById(R.id.btn);
//
//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                int position = listView.getFirstVisiblePosition();
//                Log.e("位置", position + "");
//                if (scrollState == SCROLL_STATE_IDLE && position > 6) {
////                    scrollFlag = true;
//                    button.setVisibility(View.VISIBLE);
//                } else {
////                    scrollFlag = false;
//                    button.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
////                Log.e("滑动", scrollFlag + "");
////                if (scrollFlag && firstVisibleItem > 5) {
////                    button.setVisibility(View.VISIBLE);
////                } else {
////                    button.setVisibility(View.GONE);
////                }
//            }
//        });
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listView.setSelection(0);
//            }
//        });
        final Button btn = (Button) findViewById(R.id.btn);
        final CoordinatorLayout root = (CoordinatorLayout) findViewById(R.id.root);


//        int uiMode = getResources().getConfiguration().uiMode;
//        int dayNightUiMode = uiMode & Configuration.UI_MODE_NIGHT_MASK;

//        if (dayNightUiMode == Configuration.UI_MODE_NIGHT_NO) {
//            mDayNightMode = AppCompatDelegate.MODE_NIGHT_NO;
//        } else if (dayNightUiMode == Configuration.UI_MODE_NIGHT_YES) {
//            mDayNightMode = AppCompatDelegate.MODE_NIGHT_YES;
//        } else {
//            mDayNightMode = AppCompatDelegate.MODE_NIGHT_AUTO;
//        }

            mDayNightMode = SharePreUtil.getIntance(this).getInt();

        /*findViewById(R.id.day).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showAnimation();
//                Bitmap bitmap = getBitmap();
//                Intent intent = TranslateActivity.getIntent(GoBackActivity.this, bitmap);
//                startActivity(intent);

//                btn.setVisibility(View.VISIBLE);
//                root.setBackgroundResource(R.color.black);

//                recreate();
                if (mDayNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                    SharePreUtil.getIntance(GoBackActivity.this).setInt(AppCompatDelegate.MODE_NIGHT_NO);
                    // 截图并将图片存储到hashMap中
                    MemCacheHelper.getInstance().put(KEY_SCREEN_CAPTURE,
                            UIUtils.captureContent(GoBackActivity.this));
                    //做为假象截屏替换黑屏
                    Intent starter = new Intent(GoBackActivity.this, CaptureActivity.class);
                    starter.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    starter.putExtra("PARAM_MEM_CACHE_KEY", KEY_SCREEN_CAPTURE);
                    startActivity(starter);
//                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(GoBackActivity.this, "白天", Toast.LENGTH_SHORT).show();
                    recreate();
                } else {
                    SharePreUtil.getIntance(GoBackActivity.this).setInt(AppCompatDelegate.MODE_NIGHT_YES);
                    // 截图并将图片存储到hashMap中
                    MemCacheHelper.getInstance().put(KEY_SCREEN_CAPTURE,
                            UIUtils.captureContent(GoBackActivity.this));
                    //做为假象截屏替换黑屏
                    Intent starter = new Intent(GoBackActivity.this, CaptureActivity.class);
                    starter.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    starter.putExtra("PARAM_MEM_CACHE_KEY", KEY_SCREEN_CAPTURE);
                    startActivity(starter);
//                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(GoBackActivity.this, "黑夜", Toast.LENGTH_SHORT).show();
                    recreate();
                }



            }
        });*/

        findViewById(R.id.night).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnimation();
                btn.setVisibility(View.GONE);
                root.setBackgroundResource(R.color.white);
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();





            }
        });

    }

    @OnClick(R.id.day)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.day:
                if (mDayNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                    SharePreUtil.getIntance(GoBackActivity.this).setInt(AppCompatDelegate.MODE_NIGHT_NO);
                    // 截图并将图片存储到hashMap中
                    MemCacheHelper.getInstance().put(KEY_SCREEN_CAPTURE,
                            UIUtils.captureContent(GoBackActivity.this));
                    //做为假象截屏替换黑屏
                    Intent starter = new Intent(GoBackActivity.this, CaptureActivity.class);
                    starter.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    starter.putExtra("PARAM_MEM_CACHE_KEY", KEY_SCREEN_CAPTURE);
                    startActivity(starter);
//                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(GoBackActivity.this, "白天", Toast.LENGTH_SHORT).show();
                    recreate();
                } else {
                    SharePreUtil.getIntance(GoBackActivity.this).setInt(AppCompatDelegate.MODE_NIGHT_YES);
                    // 截图并将图片存储到hashMap中
                    MemCacheHelper.getInstance().put(KEY_SCREEN_CAPTURE,
                            UIUtils.captureContent(GoBackActivity.this));
                    //做为假象截屏替换黑屏
                    Intent starter = new Intent(GoBackActivity.this, CaptureActivity.class);
                    starter.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    starter.putExtra("PARAM_MEM_CACHE_KEY", KEY_SCREEN_CAPTURE);
                    startActivity(starter);
//                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(GoBackActivity.this, "黑夜", Toast.LENGTH_SHORT).show();
                    recreate();
                }
                break;
        }
    }

    class BackAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(GoBackActivity.this, R.layout.listview_item_left, null);
            TextView textView = (TextView) convertView.findViewById(R.id.tv_left);
            textView.setText(list.get(position));
            return convertView;
        }
    }

    private Bitmap getBitmap() {
        final View decorView = getWindow().getDecorView();
        Bitmap cacheBitmap = getCacheBitmapFromView(decorView);
        return cacheBitmap;
    }


    /**
     * 展示一个切换动画
     */
    private void showAnimation() {
        final View decorView = getWindow().getDecorView();
        Bitmap cacheBitmap = getCacheBitmapFromView(decorView);
        if (decorView instanceof ViewGroup && cacheBitmap != null) {
            final View view = new View(this);
            view.setBackgroundDrawable(new BitmapDrawable(getResources(), cacheBitmap));
            ViewGroup.LayoutParams layoutParam = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) decorView).addView(view, layoutParam);
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
            objectAnimator.setDuration(3000);
            objectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    ((ViewGroup) decorView).removeView(view);
                }
            });
            objectAnimator.start();
        }
    }

    /**
     * 获取一个 View 的缓存视图
     *
     * @param view
     * @return
     */
    private Bitmap getCacheBitmapFromView(View view) {
        final boolean drawingCacheEnabled = true;
        view.setDrawingCacheEnabled(drawingCacheEnabled);
        view.buildDrawingCache(drawingCacheEnabled);
        final Bitmap drawingCache = view.getDrawingCache();
        Bitmap bitmap;
        if (drawingCache != null) {
            bitmap = Bitmap.createBitmap(drawingCache);
            view.setDrawingCacheEnabled(false);
        } else {
            bitmap = null;
        }
        return bitmap;
    }

}
