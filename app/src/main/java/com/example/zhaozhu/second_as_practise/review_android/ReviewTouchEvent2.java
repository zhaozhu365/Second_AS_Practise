package com.example.zhaozhu.second_as_practise.review_android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaozhu.second_as_practise.App;

/**
 * Created by zhaozhu on 17/6/9.
 * http://blog.csdn.net/guolin_blog/article/details/9097463
 */

public class ReviewTouchEvent2 extends ViewGroup {

    public ReviewTouchEvent2(Context context) {
        super(context);
    }

    public ReviewTouchEvent2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReviewTouchEvent2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * TODO 只要你触摸了任何控件，就一定会调用该控件的dispatchTouchEvent方法。
     * 实际情况是，当你点击了某个控件，首先会去调用该控件所在布局的dispatchTouchEvent方法，
     * 然后在布局的dispatchTouchEvent方法中找到被点击的相应控件，再去调用该控件的dispatchTouchEvent方法。
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
