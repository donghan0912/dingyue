package hpu.dingyue.rxbus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Administrator on 2017/2/10.
 */

public class RxBus2 {
    private static RxBus2 mRxBus = null;
    /**
     * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
     */
    private Subject<Object, Object> mRxBusObserverable = new SerializedSubject<>(PublishSubject.create());
    public static synchronized RxBus2 getInstance() {
        if (mRxBus == null) {
            mRxBus = new RxBus2();
        }
        return mRxBus;
    }
    public void post(Object o) {
        if (hasObservers()) {
            mRxBusObserverable.onNext(o);
        }
    }
    public Observable<Object> toObserverable() {
        return mRxBusObserverable;
    }
    /**
     * 判断是否有订阅者
     */
    public boolean hasObservers() {
        return mRxBusObserverable.hasObservers();
    }
}
