package hpu.dingyue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/4/25.
 */
public class TabFragment1 extends Fragment {

    private RecyclerView mRecyclerView;

    public static TabFragment1 newInstance() {
        return new TabFragment1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);
        initData();
        Log.i("第一个fragment", "1");
        setRetainInstance(true);
        return view;
    }

    private void initData() {

    }

}
