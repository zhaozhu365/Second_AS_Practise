package com.example.zhaozhu.second_as_practise.review_android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by zhaozhu on 17/3/21.
 */

public class ReviewPath {

    public ReviewPath() {
    }

    Canvas mCanvas;
    Paint mPaint;
    Path mPath;

    private void initDefualt() {
        //画布
        mCanvas = new Canvas();
        mPaint = new Paint();
        //画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(12);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(36);
    }

    //Path方法简介
    private void w() {
        //http://blog.csdn.net/abcdef314159/article/details/52797274
        initDefualt();

        RectF rectF = new RectF();
        RectF bounds = new RectF();//边界

        //关于reset和rewind的用法区别，看下面这个网站
        //http://www.2cto.com/kf/201605/510103.html
        mPath.reset();//清除掉path里的线条和曲线，但是不会改变它的fill－type(后面setFillType再说)；
        mPath.rewind();//清除掉path里的线条和曲线，但是会保留内部的数据结构以便重用；

        mPath.setLastPoint(100, 200);//设置轮廓的最后一个点
        mPath.close();//是关闭当前轮廓，闭合当前路径 (系统会自动从起点到终点绘制一条直线，使当前路径闭合)

        mPath.setFillType(Path.FillType.WINDING);//表示设置填充类型，4种
        mPath.isInverseFillType();//表示填充类型是否是相反的，也就是INVERSE_WINDING或者INVERSE_EVEN_ODD
        mPath.toggleInverseFillType();//表示置为相反的状态

        //mPath.isConvex();//
        mPath.isEmpty();//表示Path路线是否是空的
        mPath.isRect(rectF);//表示路径是否是指定的矩形

        mPath.computeBounds(bounds, true);//计算路径的边界保存到bounds中，exact参数没用，
        // 如果只有0或1个点，则bounds为（0,0,0,0），否则提取到他的边界保存到bounds中
        mPath.incReserve(2);//表示将path增加extraPtCount个点，这能使path有效率的分配它的存储空间

        mPath.moveTo(200, 300);//移动到坐标为（x，y）的位置
        mPath.rMoveTo(200, 300);//这个是相对位置，相对上一个位置的增量，如果上一个轮廓没有，则相当于moveTo()方法
        mPath.lineTo(200, 300);//增加一条从上一个点到这一个点的线，如果moveTo()方法没有调用，则上一个点坐标为（0,0）
        mPath.rLineTo(200, 300);
        mPath.quadTo(100, 100, 200, 200);//增加一个2次方的贝赛尔曲线
        mPath.rQuadTo(100, 100, 200, 200);
        mPath.cubicTo(100, 100, 200, 200, 300, 300);//增加一个3次方的贝赛尔曲线
        mPath.rCubicTo(100, 100, 200, 200, 300, 300);

        //mPath.arcTo(200, 200, 300, 300, 0, 135, false);//增加一段指定的弧形连接到path当中，
        // 作为一个新的轮廓，如果path的最后一个点和弧形的第一个点不一样，那么就会先通过lineTo()将这两个点连接起来，
        // 然后再连接圆弧。如果path是空的，那就会调用moveTo()把path的第一个点移到圆弧的第一个点上来，
        // 其中startAngle是开始角度，其中水平往右为0度，sweepAngle是圆弧扫过的角度，按顺时针方向扫描，
        // forceMoveTo表示是否和上一个轮廓连接，如果为false表示连接，如果为true表示不连接

        //----addArc 与 arcTo的区别，看这个网站
        //https://ghui.me/post/2015/10/android-graphics-path/

        mPath.addRect(rectF, Path.Direction.CW);//增加一个闭合的矩形到path当中
        mPath.addArc(rectF, 0, 135);//添加一个指定的弧形到path中作为一个新的轮廓，如果arcTo方法中的最后一个参数为true，和这个方法基本上一样
        mPath.addOval(rectF, Path.Direction.CW);//增加一个闭合的椭圆轮廓到path中
        /** 注意,只有addCircle比较特殊,其他的都用的是外接矩形 */
        mPath.addCircle(200, 200, 100, Path.Direction.CW);//增加一个圆形轮廓到path中
        mPath.addRoundRect(rectF, 50, 50, Path.Direction.CW);//增加圆角矩形,50,50表示4个角的x,y方向的弧度相同
        mPath.addRoundRect(rectF, 50, 100, Path.Direction.CW);//增加圆角矩形,50,100表示4个角的x,y方向的弧度相同x方向弧度为50,y方向的弧度为100
        mPath.addRoundRect(rectF, new float[]{20, 20, 40, 40,
                80, 80, 20, 100}, Path.Direction.CW);//增加圆角矩形,表示按照cw的方向,4个角每个角的弧度为20,20,40,40以此类推

        Matrix matrix = new Matrix();
        matrix.postTranslate(200, 300);
        mPath.addPath(mPath1);//将src添加到path中
        mPath.addPath(mPath1, 200, 300);//将src添加到path中，dx，dy是偏移量，matrix是转换的矩阵
        mPath.addPath(mPath1, matrix);//matrix是转换的矩阵,效果和上面的mPath.addPath(mPath1, 200, 300)效果相同

        mPath.transform(matrix);//对当前path进行matrix变换
        mPath.transform(matrix, mPath1);//将path进行matrix变化后，将结果保存到dst当中，如果dst=null，将结果保存到当前path当中

        mPath.offset(200, 300);//表示将path平移dx,dy
        mPath.offset(200, 300, mPath1);//表示将当前path平移（dx，dy）之后存储到dst中，如果dst=null，将结果保存到当前path当中

    }

    //Path.Direction用法:2个方向，顺时针，逆时针
    private void init() {
        //http://blog.csdn.net/abcdef314159/article/details/52797274
        initDefualt();
        mPaint.setStyle(Paint.Style.STROKE);

        //路径
        mPath = new Path();

        //1,----方向  具体效果看博客
        //Path.Direction.CW 顺时针 clockwise，Path.Direction.CCW 逆时针 counter-clockwise，
        mPath.addRect(200, 100, 500, 300, Path.Direction.CW);
        mPath.setLastPoint(50, 200);
        mCanvas.drawPath(mPath, mPaint);
        mPath.reset();
        mPath.addRect(200, 400, 500, 600, Path.Direction.CCW);
        mPath.setLastPoint(50, 200);
        mCanvas.drawPath(mPath, mPaint);

        //2,-----方向+在路径(上方,注意的路径行进方向上的上方)写字  具体效果看博客
        mPath.reset();
        RectF rectF = new RectF(100, 100, 900, 600);
        mPath.addOval(rectF, Path.Direction.CW);
        mCanvas.drawPath(mPath, mPaint);
        mCanvas.drawTextOnPath("123456789", mPath, 0, 0, mPaint);
        mPath.reset();
        mPath.addOval(rectF, Path.Direction.CCW);
        mCanvas.drawPath(mPath, mPaint);
        mCanvas.drawTextOnPath("123456789", mPath, 0, 0, mPaint);

    }

    Path mPath1;
    Path mPath2;

    //Path.Op用法：5种枚举类型
    //具体样式见博客
    private void init01() {
        //http://blog.csdn.net/abcdef314159/article/details/52797274
        initDefualt();
        mPaint.setStyle(Paint.Style.FILL);

        //路径
        mPath1 = new Path();
        mPath2 = new Path();
        mPath1.addCircle(300, 800, 280, Path.Direction.CW);
        mPath2.addRect(400, 900, 800, 1300, Path.Direction.CW);
        //----Op,5种类型
        //--1
        mPath1.op(mPath2, Path.Op.DIFFERENCE);//mPath1 对 mPath2 的差集 (mPath1 - mPath2)
        //--2
        mPath1.op(mPath2, Path.Op.INTERSECT);//mPath1 与 mPath2 的交集 (mPath1 ∩ mPath2)
        //--3
        mPath1.op(mPath2, Path.Op.UNION);//mPath1 对 mPath2 的并集 (mPath1 ∪ mPath2)
        //--4
        mPath1.op(mPath2, Path.Op.XOR);//(mPath1 ∪ mPath2) - (mPath1 ∩ mPath2) == (mPath1 ⊕ mPath2)
        //--5
        mPath1.op(mPath2, Path.Op.REVERSE_DIFFERENCE);//mPath2 对 mPath1 的差集 (mPath2 - mPath1)

        mCanvas.drawPath(mPath1, mPaint);
    }

    //Path.FillType用法：4种枚举类型
    //具体样式见博客
    private void init02() {
        //http://blog.csdn.net/abcdef314159/article/details/52797274
        initDefualt();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        //路径
        mPath = new Path();
        //----FillType,4种类型
        mPath.addCircle(300, 300, 200, Path.Direction.CCW);//circle1
        mPath.addCircle(600, 300, 200, Path.Direction.CCW);//circle2
        //--1
        mPath.setFillType(Path.FillType.WINDING);//(circle1 ∪ circle2)
        //--2
        mPath.setFillType(Path.FillType.EVEN_ODD);//(circle1 ∪ circle2) - (circle1 ∩ circle2) == (circle1 ⊕ circle2)
        //--3
        mPath.setFillType(Path.FillType.INVERSE_WINDING);//U - (circle1 ∪ circle2)
        //--4
        mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);//U - (circle1 ⊕ circle2)

        mCanvas.drawPath(mPath, mPaint);
    }


}
