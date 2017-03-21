package com.example.zhaozhu.second_as_practise.widgets_prac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zhaozhu on 17/3/11.
 */

public class BubbleView extends View {

    private Paint mPaint;
    private float mWidth;
    private float mHeight;
    private float mBigRadius;
    private float mSmallRadius;

    private float mInnerX, mInnerY;
    private int mOuterColor = -1;
    private int mInnerColor = -1;

    public BubbleView(Context context) {
        super(context);
        init();
    }

    public BubbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = this.getMeasuredWidth();
        this.mHeight = this.getMeasuredHeight();
        this.mBigRadius =  (mWidth / 2);
        this.mSmallRadius = mBigRadius / 2;
        calculateInnerCircle();
    }

    private void calculateInnerCircle() {
        int tempRadius = (int) (((Math.random() * 2) - 1) * mSmallRadius);
        this.mInnerX = mBigRadius + tempRadius;
        this.mInnerY = mBigRadius - tempRadius;
    }

    public void setColors(int outerColor, int innerColor) {
        this.mOuterColor = outerColor;
        this.mInnerColor = innerColor;
        postInvalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (mWidth == 0 || mHeight == 0 || mOuterColor == -1 || mInnerColor == -1) {
            return;
        }

        Log.e("zhaozhu", mWidth + " " + mHeight + " " + mOuterColor + " " + mInnerColor);

        // outer circle
//        mPaint.setColor(App.getAppContext().getResources().getColor(mOuterColor));
        mPaint.setColor(mOuterColor);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mBigRadius, mPaint);
        // inner circle
        // 设置shader
//        mPaint.setShader(shader);
//        mPaint.setColor(App.getAppContext().getResources().getColor(mInnerColor));
        mPaint.setColor(mInnerColor);
        canvas.drawCircle(mInnerX, mInnerY, mSmallRadius, mPaint);
    }
}

