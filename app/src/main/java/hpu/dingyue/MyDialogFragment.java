package hpu.dingyue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by Administrator on 2016/5/4.
 */
public class MyDialogFragment extends DialogFragment {

    private int resource;

    public static MyDialogFragment newInstance(int resourse) {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.resource = resourse;
        return dialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(resource, null);
        return view;
    }
}
