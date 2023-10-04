package com.fullm3tal.interviewpreparation;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxObservableJava {

    static Single<Long> s1 = Single.just(System.currentTimeMillis());
    static Single<Long> s2 = Single.fromCallable(System::currentTimeMillis);
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    public void observable(){
        Observable<String> o1 = Observable.just("Hello");
    }

    public static void single() {
        s1.observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }
            @Override
            public void onSuccess(@NonNull Long aLong) {
                System.out.println(aLong);
            }
            @Override
            public void onError(@NonNull Throwable e) {
            }
        });
    }

    public static void singleCallable(){
        s2.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }
            @Override
            public void onSuccess(@NonNull Long aLong) {
                System.out.println(aLong);
            }
            @Override
            public void onError(@NonNull Throwable e) {
            }
        });
    }

}
