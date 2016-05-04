package hpu.dingyue.rxbus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/5/3.
 */
public class RxBusActivity extends Activity {

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, RxBusActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
    }

    private static RxBus _rxBus = null;

    // This is better done with a DI Library like Dagger
    public RxBus getRxBusSingleton() {
        if (_rxBus == null) {
            _rxBus = new RxBus();
        }

        return _rxBus;
    }
}
