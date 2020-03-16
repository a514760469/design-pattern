package com.gds.observer.generic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 可被观察的
 * @param <S> subject
 * @param <O> GenericObserver
 * @param <A>
 */
public abstract class Observable<S extends Observable<S, O, A>, O extends GenericObserver, A> {

    protected List<O> observers;

    public Observable() {
        this.observers = new CopyOnWriteArrayList<>();
    }

    public void addObserver(O observer) {
        observers.add(observer);
    }

    public void removeObserver(O observer) {
        observers.remove(observer);
    }

    /**
     * 触发所有通知方法
     */
    @SuppressWarnings("unchecked")
    public void notifyObservers(A action) {
        for (O obs : observers) {
            obs.update(this, action);
        }
    }


}
