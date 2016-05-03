package hpu.dingyue.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import hpu.dingyue.EventBusActivity;
import hpu.dingyue.R;
import hpu.dingyue.rxbus.RxBus;

/**
 * Created by Administrator on 2016/5/3.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    private RxBus rxBus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
        view.findViewById(R.id.btn3).setOnClickListener(this);
        view.findViewById(R.id.btn4).setOnClickListener(this);
        view.findViewById(R.id.btn5).setOnClickListener(this);
        rxBus = EventBusActivity.getRxBusSingleton();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                rxBus.send("1111111111111111");
//                EventBus.getDefault().post("111111111");
                break;
            case R.id.btn2:
                EventBus.getDefault().post("222222222");
                break;
            case R.id.btn3:
                EventBus.getDefault().post("333333");
                break;
            case R.id.btn4:
                EventBus.getDefault().post("4444444444");
                break;
            case R.id.btn5:
                EventBus.getDefault().post("555555555555555");
                break;
        }
    }
}
