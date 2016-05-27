package hpu.dingyue.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/4/25.
 */
public class TabFragment2 extends Fragment {

    public static TabFragment2 newInstance() {
        return new TabFragment2();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, null);
        Log.i("第2个fragment", "1");
        return view;
    }
}
