package com.example.zhaozhu.second_as_practise.android_kfysts.chapter03_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;

/**
 * Created by zhaozhu on 16/12/12.
 * View 基础知识
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

    private void test(MotionEvent event) {
        /** test view */
        mView.getLeft();
        mView.getTop();
        mView.getRight();
        mView.getBottom();
        int width = mView.getRight() - mView.getLeft();
        int height = mView.getBottom() - mView.getTop();

        /**  after 3.0 | api 11 */
        mView.getX();
        mView.getY();
        mView.getTranslationX();
        mView.getTranslationY();
        //mView.getX() = mView.getLeft() + mView.getTranslationX();
        //mView.getY() = mView.getTop() + mView.getTranslationY();

        /** test MotionEvent */
        int action = event.getAction();
        action = MotionEvent.ACTION_DOWN;
        action = MotionEvent.ACTION_MOVE;
        action = MotionEvent.ACTION_CANCEL;
        action = MotionEvent.ACTION_UP;

        /** test TouchSlop 系统所能识别出的被认为是滑动的最小距离的标准 */
        ViewConfiguration.get(getContext()).getScaledTouchSlop();

        /** test VelocityTracker 速度跟踪 */
        VelocityTracker velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int yVelocity = (int) velocityTracker.getYVelocity();
        velocityTracker.clear();
        velocityTracker.recycle();

        /** test GestureDetector 手势检测 */
        GestureDetector mGestureDetector = new GestureDetector(getContext(),
                new GestureDetector.OnGestureListener() {
                    @Override
                    public boolean onDown(MotionEvent e) {
                        return false;
                    }

                    @Override
                    public void onShowPress(MotionEvent e) {

                    }

                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return false;
                    }

                    @Override
                    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                        return false;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {

                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        return false;
                    }
                });

        //解决长按屏幕后无法拖动的现象
        mGestureDetector.setIsLongpressEnabled(false);
        //接管view的onTouchEvent方法,然后return这个consume
        boolean consume = mGestureDetector.onTouchEvent(event);
        //return consume

        //双击行为
        mGestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                return false;
            }
        });

    }

    /**
     * test Scroller 弹性滑动对象 ,需要和View的computeScroll() 方法配合来实现平滑滚动
     */
    Scroller mScroller = new Scroller(getContext());

    /**
     * 缓慢滚动到指定位置
     */
    private void smoothScrollTo(int destX, int destY) {
        int scroolX = getScrollX();
        int deltaX = destX - scroolX;
        //1000ms 内滑向destX , 效果是慢慢滑动
        mScroller.startScroll(scroolX, 0, deltaX, 0, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
