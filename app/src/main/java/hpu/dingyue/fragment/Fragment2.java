package hpu.dingyue.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import hpu.dingyue.EventBusActivity;
import hpu.dingyue.R;
import hpu.dingyue.rxbus.RxBus;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/5/3.
 */
public class Fragment2 extends Fragment {

    private TextView tv;
    private RxBus rxBus;
    private CompositeSubscription subscription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View view = inflater.inflate(R.layout.fragment2, null);
        tv = (TextView) view.findViewById(R.id.tv);
        rxBus = EventBusActivity.getRxBusSingleton();
        initData();
        return view;
    }

    private void initData() {

        subscription = new CompositeSubscription();
        subscription.add(rxBus.toObserverable().subscribe());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        subscription.clear();
    }

    @Subscribe
    public void ss(String s) {
        tv.setText(s);
    }


}
