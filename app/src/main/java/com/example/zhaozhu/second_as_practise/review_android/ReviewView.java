package com.example.zhaozhu.second_as_practise.review_android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import com.example.zhaozhu.second_as_practise.R;

/**
 * Created by zhaozhu on 17/3/29.
 */

public class ReviewView {

    public ReviewView() {
    }

    private void init() {
        //http://blog.csdn.net/lmj623565791/article/details/24252901
    }


}

class ZView extends View {

    private int color;
    private int gravity = Gravity.LEFT;//left 3, center 17, right 5
    private int tagLayout;

    public ZView(Context context) {
        this(context, null);
    }

    public ZView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ZView, defStyleAttr, 0);
        color = attributes.getColor(R.styleable.ZView_color, Color.RED);
        gravity = attributes.getInt(R.styleable.ZView_gravity, Gravity.LEFT);
        tagLayout = attributes.getResourceId(R.styleable.ZView_tag_layout, 0);

        initTools();
    }

    private Paint mPaint;

    private void initTools() {
        mPaint.setColor(color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode != MeasureSpec.EXACTLY) {
            /** 自定义测量规则 */
            int customWidth = widthSize + getPaddingLeft() + getPaddingRight();
            widthSize = customWidth;

        } else {
            //do nothing
        }

        if (heightMode != MeasureSpec.EXACTLY) {
            /** 自定义测量规则 */
            int customHeight = heightSize + getPaddingTop() + getPaddingBottom();
            heightSize = customHeight;
        } else {
            //do nothing
        }

        setMeasuredDimension(widthSize, heightSize);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("abc", 0, 0, mPaint);
    }

}