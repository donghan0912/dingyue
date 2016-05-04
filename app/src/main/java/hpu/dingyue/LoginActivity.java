package hpu.dingyue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import hpu.dingyue.rxbus.EventBusActivity;

/**
 * Created by Administrator on 2016/5/3.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText mName;
    private EditText mPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_login);

        mName = (EditText) findViewById(R.id.et_name);
        mPwd = (EditText) findViewById(R.id.et_pwd);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
//                String name = mName.getText().toString().trim();
//                String pwd = mPwd.getText().toString().trim();
//                LoginMessage loginMessage = new LoginMessage();
//                loginMessage.setUserName(name);
//                loginMessage.setPassword(pwd);
//                EventBus.getDefault().post(loginMessage);
                startActivity(new Intent(this, EventBusActivity.class));
                break;
        }
    }

    @Subscribe
    public void ss(String s) {
        mName.setText(s);
        mPwd.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
