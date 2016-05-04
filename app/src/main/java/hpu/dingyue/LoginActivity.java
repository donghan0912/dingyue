package hpu.dingyue;

import android.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import hpu.dingyue.rxbus.RxBusActivity;

/**
 * Created by Administrator on 2016/5/3.
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        initClick();
    }

    private void initClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(MainActivity.getIntent(this));
                break;
            case R.id.btn2:
                startActivity(RxBusActivity.getIntent(this));
                break;
            case R.id.btn3:
                showDg();
                break;
        }
    }

    private void showDg() {

        MyDialogFragment dialog = MyDialogFragment.newInstance(R.layout.dialogfragment_my);
        dialog.show(getSupportFragmentManager(), "dd");

//        AlertDialog dialog = new AlertDialog.Builder(this).create();
//        View view = View.inflate(this, R.layout.dialogfragment_my, null);
//        dialog.setView(view, 0, 0, 0, 0);
//        dialog.show();
//        int width = getWindowManager().getDefaultDisplay().getWidth();
//        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.gravity = Gravity.CENTER;
//        dialog.getWindow().setAttributes(params);
    }

}
