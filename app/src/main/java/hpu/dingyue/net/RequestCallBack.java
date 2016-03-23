package hpu.dingyue.net;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2016/3/22.
 */
public abstract class RequestCallBack implements Callback.CommonCallback<String> {

    public abstract void success(String result);
    @Override
    public void onSuccess(String result) {
        success(result);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
