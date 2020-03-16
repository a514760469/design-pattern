package com.gds.observer.generic;

/**
 * 观察者类型。 用于观察 com.gds.observer.generic.Observable 这种类型的。
 * @param <S> subject extends Observable
 * @param <O> GenericObserver
 * @param <A> action
 */
public interface GenericObserver<S extends Observable<S, O, A>, O extends  GenericObserver<S, O, A>, A> {

    void update(S subject, A action);
}
