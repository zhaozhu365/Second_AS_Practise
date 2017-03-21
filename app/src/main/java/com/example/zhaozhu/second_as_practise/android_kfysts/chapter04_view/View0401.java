package com.example.zhaozhu.second_as_practise.android_kfysts.chapter04_view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhaozhu on 16/12/12.
 * 自定义View的示例(1)
 */

public class View0401 extends View {

    private int mColor = Color.RED;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public View0401(Context context) {
        super(context);
        init();
    }

    public View0401(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public View0401(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
