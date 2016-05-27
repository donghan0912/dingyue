package hpu.dingyue;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import hpu.dingyue.rxbus.RxBus;
import hpu.dingyue.rxbus.RxBusActivity;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/5/3.
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private CompositeSubscription subscription;
    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        getRxBus();
        initClick();
        subject();
    }

    private void subject() {
        subscription = new CompositeSubscription();
        subscription.add(rxBus.toObserverable().subscribe(new Action1<Object>() {
            @Override
            public void call(Object event) {
                if (event instanceof String) {
                    if (!TextUtils.isEmpty((String) event)) {
                        Toast.makeText(LoginActivity.this, (String) event, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }));
    }

    private void initClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
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
            case R.id.btn4:
//                FeedbackAPI.openFeedbackActivity(this);
                break;
            case R.id.btn5:

                break;
        }
    }

    RxBus rxBus = null;

    public RxBus getRxBus() {
        if (rxBus == null) {
            rxBus = new RxBus();
        }
        return rxBus;
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.clear();
    }
}
