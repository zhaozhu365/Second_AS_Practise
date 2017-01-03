package com.example.zhaozhu.second_as_practise.android_kfysts.chapter03_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhaozhu on 16/12/30.
 * 弹性滑动
 */
public class View03 extends View {

    public View03(Context context) {
        super(context);
    }

    public View03(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View03(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View mView;

    private void test(MotionEvent event) {

    }

    /**
     * 弹性滑动的思想:
     * 将一次大的滑动分成若干次小的滑动,并在一个时间段内完成
     *
     */

    /**
     *
     * 弹性滑动的具体实现方式举例如下:
     * 1,Scroller
     * 2,Handler#postDelayed
     * 3,Thread#sleep
     * ...
     */

    /**
     * <pre>
     * 1,使用Scroller
     *
     * scroller.startScroll()
     * scroller.computeScrollOffset()
     * view.computeScroll()
     * view.scrollTo()
     * </pre>
     */

    /**
     * <pre>
     * 2,通过动画ValueAnimator
     * (1)普通的属性动画,ObjectAnimator
     *
     * (2) "实现view内容的弹性滑动",注意,是view的内容
     * </pre>
     */

    /**
     * <pre>
     * 3,使用延时策略
     * (1)使用Handler或View的postDelayed()方法
     *
     * (2)使用sleep
     *
     * </pre>
     */

}
