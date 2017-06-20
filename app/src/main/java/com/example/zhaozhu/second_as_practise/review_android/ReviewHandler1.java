package com.example.zhaozhu.second_as_practise.review_android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * 主要是为了，如何不让编译器提示 handler 使用的问题
 * author: zhaozhu
 * Created on 17/6/20
 */
public class ReviewHandler1 extends Activity {

    private static class MyHandler extends Handler {
        WeakReference<ReviewHandler1> mActivity;

        public MyHandler(ReviewHandler1 activity) {
            mActivity = new WeakReference<ReviewHandler1>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //TODO 不会被编译器提示内存泄漏的 方法1, static内部类 + Activity弱引用
            //因为是static类，所以不能直接引用MainActivity的成员变量，
            //只能通过WeakReference.get().xxx 来引用成员变量xxx；private也可以引用，这是内部类的特性
            //如下方法操作MainActivity的成员变量
            mActivity.get().mView.setVisibility(View.GONE);
        }
    }

    private MyHandler myHandler;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myHandler = new MyHandler(this);
    }

}
