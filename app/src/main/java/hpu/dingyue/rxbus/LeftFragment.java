package hpu.dingyue.rxbus;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/5/3.
 */
public class LeftFragment extends Fragment implements View.OnClickListener {

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
        rxBus = ((EventBusActivity)getActivity()).getRxBusSingleton();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                List data1 = getData(1);
                if (rxBus.hasObservers()) {
                    rxBus.send(data1);
                }
//                EventBus.getDefault().post("111111111");
                break;
            case R.id.btn2:
                List data2 = getData(2);
                if (rxBus.hasObservers()) {
                    rxBus.send(data2);
                }
//                EventBus.getDefault().post("222222222");
                break;
            case R.id.btn3:
                List data3 = getData(3);
                if (rxBus.hasObservers()) {
                    rxBus.send(data3);
                }
//                EventBus.getDefault().post("333333");
                break;
            case R.id.btn4:
                List data4 = getData(4);
                if (rxBus.hasObservers()) {
                    rxBus.send(data4);
                }
//                EventBus.getDefault().post("4444444444");
                break;
            case R.id.btn5:
                List data5 = getData(5);
                if (rxBus.hasObservers()) {
                    rxBus.send(data5);
                }
//                EventBus.getDefault().post("555555555555555");
                break;
        }
    }

    // 模拟数据
    List<String> list = new ArrayList<>();
    public List getData(int p) {
        list.clear();
        for (int i = 0; i <= p+3; i++) {
            list.add("这是第" + p + "项的第" + i + "条数据");
        }
        return list;
    }
}
