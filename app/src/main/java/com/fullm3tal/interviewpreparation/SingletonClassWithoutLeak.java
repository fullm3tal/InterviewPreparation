package com.fullm3tal.interviewpreparation;

import android.content.Context;

import java.lang.ref.WeakReference;

public class SingletonClassWithoutLeak {

    private static SingletonClassWithoutLeak singletonClassInstance;

    private WeakReference<Context> context;

    private SingletonClassWithoutLeak(WeakReference<Context> context){
        this.context = context;
    }

    public static void singletonClassInstance(WeakReference<Context> context){
        if (singletonClassInstance == null){
            singletonClassInstance = new SingletonClassWithoutLeak(context);
        }
    }
}