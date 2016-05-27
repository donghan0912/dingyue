package hpu.dingyue.rxbus;

import rx.Observable;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;


/**
 * Created by Administrator on 2016/5/3.
 */
public class RxBus {
    //private final PublishSubject<Object> _bus = PublishSubject.create();

    // If multiple threads are going to emit events to this
    // then it must be made thread-safe like this instead
    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return _bus;
    }

    // 判断事件是否被订阅
    // 如果返回false(还未被订阅)，即使发送了消息，也收不到
    public boolean hasObservers() {
        return _bus.hasObservers();
    }
}
