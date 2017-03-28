package com.example.zhaozhu.second_as_practise.review_android;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;

/**
 * Created by zhaozhu on 17/3/23.
 */

public class ReViewPathMeasure {

    public ReViewPathMeasure() {
    }

    private PathMeasure mPathMeasure = new PathMeasure();
    private Path mPath = new Path();

    private void commonMethods() {
        //http://www.gcssloop.com/customview/Path_PathMeasure

        mPathMeasure.setPath(mPath, false);//关联一个Path
        mPathMeasure.isClosed();//是否闭合
        mPathMeasure.getLength();//获取Path的长度
        mPathMeasure.nextContour();//跳转到下一个轮廓
        mPathMeasure.getSegment(0, 10, mPath, false);//截取片段
        mPathMeasure.getPosTan(10, new float[2], new float[2]);//获取指定长度的位置坐标及该点切线值
        mPathMeasure.getMatrix(10, new Matrix(), PathMeasure.POSITION_MATRIX_FLAG);//获取指定长度的位置坐标及该点Matrix

        /** PathMeasure 的方法的具体作用或者效果，因篇幅过长，去博客中看 */
    }

}
