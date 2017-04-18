package com.example.zhaozhu.second_as_practise.android_kfysts.chapter10_handler;

import android.util.Log;

/**
 * Created by zhaozhu on 17/4/18.
 */

public class ZThreadLocal {

    private static final String TAG = ZThreadLocal.class.getSimpleName();

    private ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();

    private void init() {
        new ZMainThread("ZMainThread") {
            @Override
            public void run() {
                mBooleanThreadLocal.set(true);
                Log.d(TAG, Thread.currentThread().getName() + "#mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }
        };
        new ZThread1("ZThread1") {
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);
                Log.d(TAG, Thread.currentThread().getName() + "#mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }
        };
        new ZThread2("ZThread2") {
            @Override
            public void run() {
                Log.d(TAG, Thread.currentThread().getName() + "#mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }
        };

    }

    private class ZMainThread extends Thread {
        public ZMainThread(String name) {
            super(name);
        }
    }

    private class ZThread1 extends Thread {
        public ZThread1(String name) {
            super(name);
        }
    }

    private class ZThread2 extends Thread {
        public ZThread2(String name) {
            super(name);
        }
    }

}
