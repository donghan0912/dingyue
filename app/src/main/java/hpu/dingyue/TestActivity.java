package hpu.dingyue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/23.
 */
public class TestActivity extends Activity {

    private TextView tv2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv = (TextView) findViewById(R.id.tv_right);
        tv2 = (TextView) findViewById(R.id.tv);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        ViewGroup.LayoutParams params = tv.getLayoutParams();
        params.width = 1000;
        params.height = 400;
        tv.setLayoutParams(params);
    }

    public void onClick(View view) {
//        tv2.setVisibility(View.GONE);
        showMenu(tv, -800);
        showMenu(tv2, -800);

        startActivity(new Intent(this, Test2Activity.class));
    }

    // TODO 平移动画
    private void showMenu(View view, float dp) {
        TranslateAnimation tAnimation = new TranslateAnimation(0, dp, 0, 0);
        AccelerateInterpolator inter = new AccelerateInterpolator();
        tAnimation.setDuration(1000);//设置动画持续时间
//        tAnimation.setInterpolator(inter);
        tAnimation.setFillAfter(true);
        view.startAnimation(tAnimation);
//        view.setVisibility(View.VISIBLE);
    }

}
