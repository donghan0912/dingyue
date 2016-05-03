package hpu.dingyue;

import android.app.Activity;
import android.os.Bundle;

import hpu.dingyue.rxbus.RxBus;

/**
 * Created by Administrator on 2016/5/3.
 */
public class EventBusActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
    }

    private static RxBus _rxBus = null;

    // This is better done with a DI Library like Dagger
    public static RxBus getRxBusSingleton() {
        if (_rxBus == null) {
            _rxBus = new RxBus();
        }

        return _rxBus;
    }
}
