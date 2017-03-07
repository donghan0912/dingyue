package hpu.dingyue;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

/**
 * Created by Administrator on 2016/4/20.
 */
public class RadioActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        findViewById(R.id.ll).setOnClickListener(this);
        findViewById(R.id.ib).setOnClickListener(this);
        final RadioButton rb1 = (RadioButton) findViewById(R.id.rb_1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb_2);
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e("是否被选中", b + "");
                rb1.setChecked(b);
            }
        });
        rb2.setOnCheckedChangeListener(listener);
    }

    private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Log.e("是否被选中", b + "");
        }
    };

    @Override
    public void onClick(View v) {

    }
}
