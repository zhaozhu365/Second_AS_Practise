package com.example.zhaozhu.second_as_practise.android_kfysts.chapter10_handler;


import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/**
 * Created by zhaozhu on 17/4/18.
 */

public class CreateHandler {

    private Handler mHandler;

    public void init() {
        HandlerThread handlerThread = new HandlerThread("zz_handler_thread");
        handlerThread.start();//TODO 注意HandlerThread一定要先start,为啥?
        Looper looper = handlerThread.getLooper();
        mHandler = new Handler(looper) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                handleMsgImpl(msg);
            }
        };
        //mHandler.post();
        //mHandler.sendEmptyMessage();


    }

    private void handleMsgImpl(Message msg) {
        switch (msg.what) {
            case 0:
                Message message = mHandler.obtainMessage();
                break;
        }
    }

}
