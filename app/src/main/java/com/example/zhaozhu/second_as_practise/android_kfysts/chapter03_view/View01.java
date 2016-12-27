package com.example.zhaozhu.second_as_practise.android_kfysts.chapter03_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by zhaozhu on 16/12/12.
 */

public class View01 extends View {

    public View01(Context context) {
        super(context);
    }

    public View01(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View mView;

//    private void test() {
//        //test view
//        mView.getLeft();
//        mView.getTop();
//        mView.getRight();
//        mView.getBottom();
//        int width = mView.getRight() - mView.getLeft();
//        int height = mView.getBottom() - mView.getTop();
//
//        // after 3.0 | api 11
//        mView.getX();
//        mView.getY();
//        mView.getTranslationX();
//        mView.getTranslationY();
//        //mView.getX() = mView.getLeft() + mView.getTranslationX();
//        //mView.getY() = mView.getTop() + mView.getTranslationY();
//
//        //test MotionEvent
//        MotionEvent.ACTION_DOWN;
//        MotionEvent.ACTION_UP;
//        MotionEvent.ACTION_MOVE;
//        MotionEvent.ACTION_CANCEL;
//
//        //test TouchSlop 系统所能识别出的被认为是滑动的最小距离的标准
//        ViewConfiguration.get(getContext()).getScaledTouchSlop();
//
//        //test VelocityTracker 速度跟踪
//        VelocityTracker velocityTracker = VelocityTracker.obtain();
//        velocityTracker.addMovement(event);
//        velocityTracker.computeCurrentVelocity(1000);
//        int xVelocity = (int) velocityTracker.getXVelocity();
//        int yVelocity = (int) velocityTracker.getYVelocity();
//        velocityTracker.clear();
//        velocityTracker.recycle();
//
//        //test GestureDetector 手势检测
//        GestureDetector mGestureDetector = new GestureDetector(listener);
//
//
//
//    }

}
