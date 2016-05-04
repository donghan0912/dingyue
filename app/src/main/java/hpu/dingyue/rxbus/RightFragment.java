package hpu.dingyue.rxbus;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import hpu.dingyue.R;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/5/3.
 */
public class RightFragment extends Fragment {

    private RxBus rxBus;
    private CompositeSubscription subscription;
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View view = inflater.inflate(R.layout.fragment2, null);
        mListView = (ListView) view.findViewById(R.id.lv);
        rxBus = ((RxBusActivity)getActivity()).getRxBusSingleton();
        subject();
        return view;
    }

    // 这里一定要注意LeftFragment和RightFragment的生命周期
    // 一定要先订阅，否则即使在LeftFragment发送了消息，RightFragment也无法
    private void subject() {
        subscription = new CompositeSubscription();
        subscription.add(rxBus.toObserverable().subscribe(new Action1<Object>() {
            @Override
            public void call(Object event) {
                if (event instanceof List) {
                    DemoAdapter adapter = new DemoAdapter((List) event);
                    mListView.setAdapter(adapter);
                }
            }
        }));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        subscription.clear();
    }

    @Subscribe
    public void ss(String s) {
    }

    class DemoAdapter extends BaseAdapter {

        private List<String> mData;

        public DemoAdapter(List list) {
            this.mData = list;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            textView.setText(getItem(position));
            return textView;
        }
    }
}
