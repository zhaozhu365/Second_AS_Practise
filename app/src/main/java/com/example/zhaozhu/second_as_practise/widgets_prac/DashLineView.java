package com.example.zhaozhu.second_as_practise.widgets_prac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhaozhu on 17/3/17.
 */

public class DashLineView extends View {

    private Paint mPaint;
    private Path mPath;

    public DashLineView(Context context) {
        super(context);
        init();
    }

    public DashLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DashLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPath = new Path();

        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xfffec447);
        PathEffect pathEffect = new DashPathEffect(new float[]{16, 4}, 0);
        mPaint.setPathEffect(pathEffect);
    }

    public void setLineColor(int color) {
        mPaint.setColor(color);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(getWidth());
        mPath.moveTo(0, 0);
        mPath.lineTo(0, getHeight());
        canvas.drawPath(mPath, mPaint);
    }
}
