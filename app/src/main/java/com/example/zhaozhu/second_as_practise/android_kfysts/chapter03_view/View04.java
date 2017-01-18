package com.example.zhaozhu.second_as_practise.android_kfysts.chapter03_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhaozhu on 17/01/03.
 * View的事件分发机制
 */
public class View04 extends View {

    public View04(Context context) {
        super(context);
    }

    public View04(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View04(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View mView;

    private void test(MotionEvent event) {

    }

    /**
     * 1,点击事件的传递规则
     * 2,事件分发的源码解析
     */

    /**
     * <pre>
     * 1,点击事件的传递规则
     *    (1)所谓点击事件的分发,其实就是对MotionEvent事件的分发过程:
     *      即当一个MotionEvent产生以后,系统需要把这个事件传递给一个具体的View,而这个传递的过程就是分发过程。
     *    (2)点击事件的分发由3个重要的方法共同完成:
     *      dispatchTouchEvent(MotionEvent event);
     *      onInterceptTouchEvent(MotionEvent event);
     *      onTouchEvent(MotionEvent event);
     *    (3)事件传递机制的11个结论:
     *
     * </pre>
     */

    /**
     * <pre>
     * 2,事件分发的源码解析
     * (1)Activity对点击事件的分发过程
     *   Activity#dispatchTouchEvent-->
     *   Window#superDispatchTouchEvent-->
     *   PhoneWindow#superDispatchTouchEvent-->
     *   DecorView#superDispatchTouchEvent
     * (2)顶级View对点击事件的分发过程
     * (3)View对点击事件的处理过程
     *
     * </pre>
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }



}
