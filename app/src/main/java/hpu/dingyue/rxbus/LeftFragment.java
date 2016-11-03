package hpu.dingyue.rxbus;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/5/3.
 */
public class LeftFragment extends Fragment implements View.OnClickListener {

    private RxBus rxBus;
    private Unbinder unbinder;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.layout)
    RelativeLayout layout;
    @BindView(R.id.btn7)
    Button btn7;
    private BottomSheetBehavior<RelativeLayout> behavior;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
//        view.findViewById(R.id.btn1).setOnClickListener(this);
//        view.findViewById(R.id.btn2).setOnClickListener(this);
//        view.findViewById(R.id.btn3).setOnClickListener(this);
//        view.findViewById(R.id.btn4).setOnClickListener(this);
//        view.findViewById(R.id.btn5).setOnClickListener(this);
        rxBus = ((RxBusActivity) getActivity()).getRxBusSingleton();

        unbinder = ButterKnife.bind(this, view);
        behavior = BottomSheetBehavior.from(layout);
//默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // 是为了初始化，默认显示第一个按钮的内容
        if (rxBus.hasObservers()) {
            rxBus.send(getData(1));
        }
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.layout, R.id.btn7})
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
//                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                EventBus.getDefault().post("555555555555555");
                break;
            case R.id.btn6:
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.btn7:
                showBottomDialog();
                break;
            case R.id.layout:
//                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
        }
    }

    // 模拟数据
    List<String> list = new ArrayList<>();

    public List getData(int p) {
        list.clear();
        for (int i = 0; i <= p + 3; i++) {
            list.add("这是第" + p + "项的第" + i + "条数据");
        }
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void showBottomDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.listview_item_left, null);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }
}
