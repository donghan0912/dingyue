package hpu.dingyue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Test2Activity extends Activity {

    private TextView tv;
    private Button btn;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test2);
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        ll = (LinearLayout) findViewById(R.id.ll);
    }

    public void onClick(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tv.getLayoutParams();
//        layoutParams.width = 720;
//        layoutParams.height = 1280;
//
//        tv.setLayoutParams(layoutParams);
        btn.setVisibility(View.GONE);

        ViewGroup.LayoutParams layoutParams1 = ll.getLayoutParams();
        layoutParams1.height = 1280;
        layoutParams1.width = 720;
        ll.setLayoutParams(layoutParams1);
    }

}
