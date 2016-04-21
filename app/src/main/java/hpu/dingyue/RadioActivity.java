package hpu.dingyue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

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
    }

    @Override
    public void onClick(View v) {

    }
}
