package com.example.zhaozhu.second_as_practise.review_android;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Typeface;

/**
 * Created by zhaozhu on 17/3/21.
 */

public class ReviewPaint {

    public ReviewPaint() {
    }

    Paint mPaint;

    //Paint的4个枚举类的用法
    //Paint.Style 画笔类型,3种
    //Paint.Align 文字对齐类型,3种
    //Paint.Cap 线条末端的样式,3种
    //Paint.Join 线条拐角的样式,3种
    //Typeface 文字字体类型
    private void init() {
        //http://blog.csdn.net/abcdef314159/article/details/51720686

        mPaint = new Paint();

        //抗锯齿
        mPaint.setAntiAlias(true);
        //----设置画笔的风格,3种:描边STROKE，实心FILL，描边+实心FILL_AND_STROKE
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔的颜色
        mPaint.setColor(Color.parseColor("#123456"));
        //设置画笔的宽度
        mPaint.setStrokeWidth(8);

        //设置文字大小
        mPaint.setTextSize(15);
        //----设置字体样式，可以是Typeface设置的样式，
        //也可以通过Typeface的createFromAsset(AssetManager mgr, String path)方法加载样式
        mPaint.setTypeface(Typeface.DEFAULT);
        //测量文字长度
        mPaint.measureText("测量文字大小");

        //----文字的对齐方式，有3种:CENTER，LEFT，RIGHT，具体的样子去博客看
        mPaint.setTextAlign(Paint.Align.CENTER);

        //----线条的末端的样式，有3种:BUTT，ROUND，SQUARE，具体的样子去博客看
        mPaint.setStrokeCap(Paint.Cap.BUTT);

        //----线条的拐角的样式，有3种:MITER，ROUND，BEVEL，具体的样子去博客看
        mPaint.setStrokeJoin(Paint.Join.MITER);

        PathEffect pathEffect = new DashPathEffect(new float[]{16, 4}, 0);
        //----设置特殊path
        mPaint.setPathEffect(pathEffect);
    }

}
