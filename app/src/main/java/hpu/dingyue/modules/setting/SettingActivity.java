package hpu.dingyue.modules.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/11/7.
 */

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.switch_compat)
    SwitchCompat mSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_setting);
        ButterKnife.bind(this);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "开", Toast.LENGTH_SHORT).show();
                } else if (!isChecked) {
                    Toast.makeText(getApplicationContext(), "关", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_compat:

                break;
        }
    }
}
