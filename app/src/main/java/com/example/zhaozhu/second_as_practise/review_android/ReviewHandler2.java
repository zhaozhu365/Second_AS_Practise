package com.example.zhaozhu.second_as_practise.review_android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

/**
 * 主要是为了，如何不让编译器提示 handler 使用的问题
 * author: zhaozhu
 * Created on 17/6/20
 */
public class ReviewHandler2 extends Activity {

    private Handler handler;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO 不会被编译器提示内存泄漏的 方法2,使用另外一个构造方法来初始化
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                handleMessageImpl(msg);
            }
        };
    }

    private void handleMessageImpl(Message msg) {
        //TODO 业务逻辑
    }

}
