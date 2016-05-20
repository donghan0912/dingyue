package hpu.dingyue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import hpu.dingyue.rxbus.RxBus;

/**
 * Created by Administrator on 2016/5/4.
 */
public class MyDialogFragment extends DialogFragment implements View.OnClickListener{

    private int resource;
    private Button cancle;
    private Button ok;
    private RxBus rxBus;
    private EditText username;
    private EditText password;

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
        username = (EditText) view.findViewById(R.id.et_name);
        password = (EditText) view.findViewById(R.id.et_pwd);
        cancle = (Button) view.findViewById(R.id.btn_cancle);
        ok = (Button) view.findViewById(R.id.btn_ok);

        cancle.setOnClickListener(this);
        ok.setOnClickListener(this);
        rxBus = ((LoginActivity) getActivity()).getRxBus();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancle:
                if (rxBus.hasObservers()) {
                    rxBus.send(password.getText().toString().trim());
                }
                dismiss();
                break;
            case R.id.btn_ok:
                if (rxBus.hasObservers()) {
                    rxBus.send(username.getText().toString().trim());
                }
                dismiss();
                break;
        }
    }
}
