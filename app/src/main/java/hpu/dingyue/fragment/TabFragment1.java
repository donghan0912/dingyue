package hpu.dingyue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/4/25.
 */
public class TabFragment1 extends Fragment {

    private RecyclerView mRecyclerView;
    private List<String> mData;
    private List<Integer> mHeight;

    public static TabFragment1 newInstance() {
        return new TabFragment1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), OrientationHelper.HORIZONTAL, false));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        initData();
        Log.i("第一个fragment", "1");
        setRetainInstance(true);
        return view;
    }

    private void initData() {
        mData = new ArrayList<>();
        mHeight = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add(i + "");
            mHeight.add(new Random().nextInt(300) + 400);
        }

        mRecyclerView.setAdapter(new TabAdapter());
    }

    class TabAdapter extends RecyclerView.Adapter<TabAdapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(View.inflate(getActivity(), R.layout.item_tabfragment1, null));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ViewGroup.LayoutParams params = holder.tv.getLayoutParams();
            Random random = new Random();
            int i = random.nextInt(300) + 400;
//            int i = (int) (Math.random() * 400 + 400);
            params.height = mHeight.get(position);
            holder.tv.setLayoutParams(params);
            holder.tv.setText(mData.get(position));
        }


        @Override
        public int getItemCount() {
            return mData.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }
}
