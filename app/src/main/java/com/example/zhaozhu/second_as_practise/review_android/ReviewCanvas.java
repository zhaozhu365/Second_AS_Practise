package com.example.zhaozhu.second_as_practise.review_android;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.PictureDrawable;

/**
 * Created by zhaozhu on 17/3/27.
 */

public class ReviewCanvas {

    private Canvas mCanvas = new Canvas();

    private Path mPath = new Path();

    private Paint mPaint = new Paint();

    private Rect mRect = new Rect();
    private RectF mRectF = new RectF();

    private Bitmap mBitmap;

    private Matrix mMatrix;

    private Picture mPicture;

    public ReviewCanvas() {
    }

    /**
     * Canvas之绘制基本图形
     */
    private void init1() {
        //http://www.gcssloop.com/customview/Canvas_BasicGraphics

        /** Canvas的常用操作速查表 ,每个方法的具体用法，见博客*/

        //绘制颜色  使用单一颜色填充整个画布
        mCanvas.drawColor(Color.RED);
        mCanvas.drawRGB(1, 1, 1);
        mCanvas.drawARGB(0, 1, 1, 1);

        //绘制基本形状    依次为 点、线、矩形、圆角矩形、椭圆、圆、圆弧
        mCanvas.drawPoint(0, 0, mPaint);
        mCanvas.drawPoints(new float[]{0, 0, 100, 100}, mPaint);
        mCanvas.drawLine(0, 0, 100, 100, mPaint);
        mCanvas.drawLines(new float[]{0, 0, 100, 100}, mPaint);
        mCanvas.drawRect(mRect, mPaint);
        mCanvas.drawRoundRect(mRectF, 20, 20, mPaint);
        mCanvas.drawOval(mRectF, mPaint);
        mCanvas.drawCircle(100, 100, 200, mPaint);
        mCanvas.drawArc(mRectF, 0, 13, true, mPaint);//startAngle 开始角度; sweepAngle 扫过角度; useCenter 是否使用中心


        //绘制图片  绘制位图和图片
        mCanvas.drawBitmap(mBitmap, mMatrix, mPaint);
        mCanvas.drawPicture(mPicture);

        //绘制文本  依次为 绘制文字、绘制文字时指定每个文字位置、根据路径绘制文字
        mCanvas.drawText("", 0, 0, mPaint);
        mCanvas.drawPosText("", new float[]{0, 0, 100, 100}, mPaint);
        mCanvas.drawTextOnPath("", mPath, 0, 0, mPaint);

        //绘制路径  绘制路径，绘制贝塞尔曲线时也需要用到该函数
        mCanvas.drawPath(mPath, mPaint);

        //顶点操作  通过对顶点操作可以使图像形变，drawVertices直接对画布作用、 drawBitmapMesh只对绘制的Bitmap作用
//        mCanvas.drawVertices(Canvas.VertexMode.TRIANGLE_FAN, 1, );
//        mCanvas.drawBitmapMesh(mBitmap, );

        //画布剪裁  设置画布的显示区域
        mCanvas.clipPath(mPath);
        mCanvas.clipRect(mRect);

        //画布快照  依次为 保存当前状态、 回滚到上一次保存的状态、 保存图层状态、 回滚到指定状态、 获取保存次数
        mCanvas.save();
        mCanvas.restore();
        mCanvas.saveLayer(mRectF, mPaint, Canvas.ALL_SAVE_FLAG);
        mCanvas.restoreToCount(1);
        mCanvas.getSaveCount();

        //画布变换  依次为 位移、缩放、 旋转、错切
        mCanvas.translate(100, 100);
        mCanvas.scale(0.5f, 0.5f);
        mCanvas.rotate(30.0f);
        mCanvas.skew(30, 30);

        //Matrix(矩阵)  实际上画布的位移，缩放等操作的都是图像矩阵Matrix， 只不过Matrix比较难以理解和使用，故封装了一些常用的方法。
        mCanvas.getMatrix();
        mCanvas.setMatrix(mMatrix);
        mCanvas.concat(mMatrix);

    }

    /**
     * Canvas之画布操作
     */
    private void init2() {
        //http://www.gcssloop.com/customview/Canvas_Convert

        /** Canvas之画布操作 ,每个方法的具体用法，见博客*/

        //1.画布操作
        //为什么要有画布操作？
        //PS: 所有的画布操作都只影响后续的绘制，对之前已经绘制过的内容没有影响。

        //⑴位移(translate)
        //translate是坐标系的移动，可以为图形绘制选择一个合适的坐标系。
        //请注意，位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动，
        //TODO 两次移动是可叠加的。
        mCanvas.translate(100, 100);

        //2缩放(scale)
        //缩放的中心默认为坐标原点,而缩放中心轴就是坐标轴
        //当缩放比例为"负数"的时候会根据缩放中心轴进行翻转
        //TODO 注意，PS:和位移(translate)一样，缩放也是可以叠加的
        mCanvas.scale(0.5f, 0.5f);
        mCanvas.scale(-0.5f, -0.5f, 100, 100);

        //⑶旋转(rotate)
        //第二种方法多出来的两个参数依旧是控制旋转中心点的。
        //默认的旋转中心依旧是坐标原点
        //TODO 旋转也是可叠加的
        mCanvas.rotate(30);
        mCanvas.rotate(30, 100, 100);

        //⑷错切(skew)
        //float sx:将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，
        //float sy:将画布在y轴方向上倾斜相应的角度，sy为倾斜角度的tan值，
        //TODO 注意，这里全是倾斜角度的tan值哦，比如我们打算在X轴方向上倾斜60度，tan60=根号3，小数对应1.732
        mCanvas.skew((float) Math.tan(60), 0);//这里表示，将x轴倾斜60度

        //⑸快照(save)和回滚(restore)
        //Q: 为什存在快照与回滚
        //A：画布的操作是不可逆的，而且很多画布操作会影响后续的步骤，
        // 例如第一个例子，两个圆形都是在坐标原点绘制的，
        // 而因为坐标系的移动绘制出来的实际位置不同。所以会对画布的一些状态进行保存和回滚。
        mCanvas.save();//把当前的画布的状态进行保存，然后放入特定的栈中
        mCanvas.saveLayer(mRectF, mPaint, Canvas.ALL_SAVE_FLAG);//新建一个图层，并放入特定的栈中
        mCanvas.restore();//把栈中最顶层的画布状态取出来，并按照这个状态恢复当前的画布
        mCanvas.restoreToCount(1);//弹出指定位置及其以上所有的状态，并按照指定位置的状态进行恢复
        mCanvas.getSaveCount();//获取栈中内容的数量(即保存次数),该函数的最小返回值为1，即使弹出了所有的状态，返回值依旧为1，代表默认状态
        //Q：什么是画布和图层？ TODO
        //A：实际上我们看到的画布是由多个图层构成的，如下图(图片来自网络)：
        //实际上我们之前讲解的绘制操作和画布操作都是在默认图层上进行的。
        //在通常情况下，使用默认图层就可满足需求，但是如果需要绘制比较复杂的内容，如地图(地图可以有多个地图层叠加而成，
        // 比如：政区层，道路层，兴趣点层)等，则分图层绘制比较好一些。
        //你可以把这些图层看做是一层一层的玻璃板，你在每层的玻璃板上绘制内容，然后把这些玻璃板叠在一起看就是最终效果。

        //TODO 虽然关于状态的保存和回滚啰嗦了不少，不过大多数情况下只需要记住下面的步骤就可以了：
        mCanvas.save();      //保存状态
        //...          //具体操作
        mCanvas.restore();   //

        //6裁剪画布（clip系列函数）
        //裁剪画布是利用Clip系列函数，通过与Rect、Path、Region取交、并、差等集合运算来获得最新的画布形状。
        //除了调用Save、Restore函数以外，这个操作是不可逆的，一但Canvas画布被裁剪，就不能再被恢复！
        //TODO 这个方法的讲解，见这个博客    http://blog.csdn.net/harvic880925/article/details/39080931
        mCanvas.clipPath(mPath);
        mCanvas.clipPath(mPath, Region.Op.DIFFERENCE);
        mCanvas.clipRect(mRect);
        mCanvas.clipRect(mRect, Region.Op.DIFFERENCE);

    }

    /**
     * Canvas之图片文字
     */
    private void init3() {
        //http://www.gcssloop.com/customview/Canvas_PictureText

        /** Canvas之图片文字 ,每个方法的具体用法，见博客*/
        //TODO 1.绘制图片
        //绘制有两种方法，drawPicture(矢量图) 和 drawBitmap(位图),接下来我们一一了解。

        //(1)drawPicture
        //使用Picture前请关闭硬件加速，以免引起不必要的问题！
        //在AndroidMenifest文件中application节点下添上 android:hardwareAccelerated=”false”以关闭整个应用的硬件加速。
        //更多请参考这里：Android的硬件加速及可能导致的问题  https://github.com/GcsSloop/AndroidNote/issues/7

        mPicture.getWidth();
        mPicture.getHeight();
        mPicture.beginRecording(100, 100);//开始录制 (返回一个Canvas，在Canvas中所有的绘制都会存储在Picture中)
        mPicture.endRecording();
        mPicture.draw(mCanvas);//将Picture中内容绘制到Canvas中
        //使用示例：
        //准备工作:
        //录制内容，即将一些Canvas操作用Picture存储起来，录制的内容是不会直接显示在屏幕上的，只是存储起来了而已。
        //具体使用:
        //Picture虽然方法就那么几个，但是具体使用起来还是分很多情况的，
        // 由于录制的内容不会直接显示，就像存储的视频不点击播放不会自动播放一样，
        // 同样，想要将Picture中的内容显示出来就需要手动调用播放(绘制)，
        // 将Picture中的内容绘制出来可以有以下几种方法：
        //1	使用Picture提供的draw方法绘制。
        //2	使用Canvas提供的drawPicture方法绘制。
        //3	将Picture包装成为PictureDrawable，使用PictureDrawable的draw方法绘制。
        //区别
        //是否对Canvas有影响	 1有影响
        //                  2,3不影响	此处指绘制完成后是否会影响Canvas的状态(Matrix clip等)
        //可操作性强弱	 1可操作性较弱
        //              2,3可操作性较强	此处的可操作性可以简单理解为对绘制结果可控程度。

        //1.使用Picture提供的draw方法绘制:
        // 将Picture中的内容绘制在Canvas上
        //PS：这种方法在比较低版本的系统上绘制后可能会影响Canvas状态，所以这种方法一般不会使用。
        mPicture.draw(mCanvas);

        //2.使用Canvas提供的drawPicture方法绘制
        //drawPicture有三种方法：
        mCanvas.drawPicture(mPicture);//(1)
        //PS:对照方法(1)的上一张图片，可以比较明显的看出，绘制的内容根据选区进行了缩放。
        mCanvas.drawPicture(mPicture, new RectF(0, 0, mPicture.getWidth(), 200));

        //3.将Picture包装成为PictureDrawable，使用PictureDrawable的draw方法绘制。
        // 包装成为Drawable
        PictureDrawable pictureDrawable = new PictureDrawable(mPicture);
        // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
        //PS:此处setBounds是设置在画布上的绘制区域，并非根据该区域进行缩放，也不是剪裁Picture，每次都从Picture的左上角开始绘制。
        pictureDrawable.setBounds(0, 0, 250, mPicture.getHeight());
        // 绘制
        pictureDrawable.draw(mCanvas);

        //(2)drawBitmap
        //其实一开始知道要讲Bitmap我是拒绝的，为什么呢？
        // 因为Bitmap就是很多问题的根源啊有木有，Bitmap可能导致内存不足，内存泄露，ListView中的复用混乱等诸多问题。
        // 想完美的掌控Bitmap还真不是一件容易的事情。限于篇幅本文对于Bitmap不会过多的展开，只讲解一些常用的功能。
        //获取Bitmap方式:
        //1	通过Bitmap创建	复制一个已有的Bitmap(新Bitmap状态和原有的一致) 或者 创建一个空白的Bitmap(内容可改变)
        //2	通过BitmapDrawable获取	从资源文件 内存卡 网络等地方获取一张图片并转换为内容不可变的Bitmap
        //3	通过BitmapFactory获取	从资源文件 内存卡 网络等地方获取一张图片并转换为内容不可变的Bitmap
        //通常来说，我们绘制Bitmap都是读取已有的图片转换为Bitmap绘制到Canvas上。
        //很明显，第1种方式不能满足我们的要求，暂时排除。
        //第2种方式虽然也可满足我们的要求，但是我不推荐使用这种方式，至于为什么在后续详细讲解Drawable的时候会说明,暂时排除。
        //第3种方法我们会比较详细的说明一下如何从各个位置获取图片。

        //通过BitmapFactory从不同位置获取Bitmap:
        //1,资源文件(drawable/mipmap/raw):
        //Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.raw.bitmap);
        //2,资源文件(assets):
        //Bitmap bitmap=null;
        //try {
        //    InputStream is = mContext.getAssets().open("bitmap.png");
        //    bitmap = BitmapFactory.decodeStream(is);
        //   is.close();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //3,内存卡文件:
        //Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/bitmap.png");
        //4,网络文件:
        // 此处省略了获取网络输入流的代码
        //Bitmap bitmap = BitmapFactory.decodeStream(is);
        //is.close();

        //绘制Bitmap：
        //依照惯例先预览一下drawBitmap的常用方法：
        // 第一种
        mCanvas.drawBitmap(mBitmap, mMatrix, mPaint);
        // 第二种:drawBitmap (Bitmap bitmap, float left, float top, Paint paint)
        mCanvas.drawBitmap(mBitmap, 100, 200, mPaint);
        // 第三种:drawBitmap (Bitmap bitmap, Rect src, Rect dst, Paint paint)
        Rect src = new Rect();
        Rect dst = new Rect();
        mCanvas.drawBitmap(mBitmap, src, dst, mPaint);

        //第一种方法中后两个参数(matrix, paint)是在绘制的时候对图片进行一些改变，
        // 如果只是需要将图片内容绘制出来只需要如下操作就可以了：
        //PS:图片左上角位置默认为坐标原点。
        mCanvas.drawBitmap(mBitmap, new Matrix(), new Paint());

        //第二种方法就是在绘制时指定了图片左上角的坐标(距离坐标原点的距离)：
        //注意：此处指定的是与坐标原点的距离，并非是与屏幕顶部和左侧的距离,
        // 虽然默认状态下两者是重合的，但是也请注意分别两者的不同。
        mCanvas.drawBitmap(mBitmap, 100, 200, mPaint);

        //第三种方法比较有意思，上面多了两个矩形区域(src,dst),这两个矩形选区是干什么用的？
        //名称	作用
        //Rect src	指定绘制图片的区域
        //Rect dst 或RectF dst	指定图片在屏幕上显示(绘制)的区域
        //详解：
        //上面是以绘制该图为例，用src指定了图片绘制部分的区域，即下图中红色方框标注的区域。
        //然后用dst指定了绘制在屏幕上的绘制，即下图中蓝色方框标注的区域，"图片宽高会根据指定的区域自动进行缩放"。
        //从上面可知，第三种方法可以绘制图片的一部分到画布上，这有什么用呢？
        //减少资源文件数量，方便管理，同时也节省了图片文件头、文件结束块以及调色板等占用的空间。

        //TODO 2.绘制文字
        //依旧预览一下相关常用方法：
        // 第一类
        mCanvas.drawText("", 0, 0, mPaint);
        mCanvas.drawText("", 0, 0, 0, 0, mPaint);
        mCanvas.drawText("", 0, 0, 0, 0, mPaint);
        mCanvas.drawText(new char[]{}, 0, 0, 0, 0, mPaint);
        // 第二类
        mCanvas.drawPosText("", new float[]{}, mPaint);
        // 第三类
        mCanvas.drawTextOnPath("", mPath, 0, 0, mPaint);
        mCanvas.drawTextOnPath(new char[]{}, 0, 0, mPath, 0, 0, mPaint);
        //绘制文字部分大致可以分为三类：
        //第一类只能指定文本基线位置(基线x默认在字符串左侧，基线y默认在字符串下方)。
        //第二类可以分别指定每个文字的位置。
        //第三类是指定一个路径，根据路径绘制文字。
        //通过上面常用方法的参数也可看出，绘制文字也是需要画笔的，而且文字的大小,颜色,字体,对齐方式都是由画笔控制的。

        //第一类(drawText)
        //第一类可以指定文本开始的位置，可以截取文本中部分内容进行绘制。
        //其中x，y两个参数是指定文本绘制两个基线,示例：
        // 文本(要绘制的内容)
        String str = "ABCDEFG";
        // 参数分别为 (文本 基线x 基线y 画笔)
        mCanvas.drawText(str, 200, 500, mPaint);
        //只取出文本中的一部分内容进行绘制
        //使用start和end指定的区间是前闭后开的，
        // 即包含start指定的下标，而不包含end指定的下标，
        // 故[1,3)最后获取到的下标只有 下标1 和 下标2 的字符，就是”BC”.
        // 参数分别为 (字符串 开始截取位置 结束截取位置 基线x 基线y 画笔)
        mCanvas.drawText(str, 1, 3, 200, 500, mPaint);
        //对于字符数组char[]我们截取字符串使用起始位置(index)和长度(count)来确定。
        //同样，我们指定index为1，count为3，那么最终截取到的字符串是”BCD”.
        //其实就是从下标位置为1处向后数3位就是截取到的字符串，示例：
        // 字符数组(要绘制的内容)
        char[] chars = "ABCDEFG".toCharArray();
        // 参数为 (字符数组 起始坐标 截取长度 基线x 基线y 画笔)
        mCanvas.drawText(chars, 1, 3, 200, 500, mPaint);

        //第二类(drawPosText)
        //个人是不推荐使用的，因为坑比较多，主要有一下几点：
        //1	必须指定所有字符位置，否则直接crash掉，反人类设计
        //2	性能不佳，在大量使用的时候可能导致卡顿
        //3	不支持emoji等特殊字符，不支持字形组合与分解




    }


}
