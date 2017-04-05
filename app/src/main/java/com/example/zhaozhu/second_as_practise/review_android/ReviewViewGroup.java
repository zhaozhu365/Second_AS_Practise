package com.example.zhaozhu.second_as_practise.review_android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhaozhu on 17/3/29.
 */

public class ReviewViewGroup {

    private void init() {
        //TODO 这边博客要仔细多看几遍，理清思路
        /** http://blog.csdn.net/harvic880925/article/details/47029169 */

        //绘制流程分为三步：测量、布局、绘制
        //分别对应：onMeasure()、onLayout()、onDraw()
        //其中，他们三个的作用分别如下：
        //TODO onMeasure()：测量自己的大小(注意,是设置自己的大小)，为正式布局提供建议。（注意，只是建议，至于用不用，要看ViewGroup的onLayout()方法 ）;
        //onLayout():使用layout()函数对所有子控件布局；
        //onDraw():根据布局的位置绘图；

        //1,onMeasure与MeasureSpec
        //XML布局和模式有如下对应关系：
        //wrap_content-> MeasureSpec.AT_MOST
        //match_parent -> MeasureSpec.EXACTLY
        //具体值 -> MeasureSpec.EXACTLY

        //当模式是MeasureSpec.EXACTLY时，我们就不必要设定我们计算的大小了，因为这个大小是用户指定的，我们不应更改。
        //但当模式是MeasureSpec.AT_MOST时，也就是说用户将布局设置成了wrap_content，
        // 我们就需要将大小设定为我们计算的数值，因为用户根本没有设置具体值是多少，需要我们自己计算。

        //2,onLayout()
        //onLayout()是实现所有子控件布局的函数,注意，是所有子控件！！！那它自己的布局怎么办？
        //(1)MyLinLayout实现：重写onMeasure()函数
        //ViewGroup中，onMeasure()的作用就是根据container内部的子控件计算"自己的宽和高"
        //最后将"自己的宽高"通过setMeasuredDimension（int width,int height设置进去）
        //(2)MyLinLayout实现：重写onLayout()函数
        //在这部分，就是根据自己的意愿把内部的各个控件排列起来
        //最核心的代码，就是调用layout()函数设置子控件所在的位置：
        //ViewGroup布局最核心的方法 child.layout(int l, int t, int r, int b)
        //(3)TODO getMeasuredWidth()与getWidth()的区别:注意
        //一个很容易出错的问题：getMeasuredWidth()与getWidth()的区别。他们的值大部分时间都是相同的，但意义确是根本不一样的，我们就来简单分析一下。
        //区别主要体现在下面几点：
        //- 首先getMeasureWidth()方法在measure()过程结束后就可以获取到了，而getWidth()方法要在layout()过程结束后才能获取到。
        //- getMeasureWidth()方法中的值是通过setMeasuredDimension()方法来进行设置的，而getWidth()方法中的值则是通过layout(left,top,right,bottom)方法设置的。
        //还记得吗，我们前面讲过，setMeasuredDimension()提供的测量结果只是为布局提供建议，最终的取用与否要看layout()函数。
        // 再看看上面重写的MyLinLayout，是不是我们自己使用child.layout(left,top,right,bottom)来定义了各个子控件所应在的位置：
        //  int childHeight = child.getMeasuredHeight();
        //  int childWidth = child.getMeasuredWidth();
        //  child.layout(0, top, childWidth, top + childHeight);
        //从代码中可以看到，我们使用child.layout(0, top, childWidth, top + childHeight);来布局控件的位置，
        // 其中getWidth()的取值就是这里的右坐标减去左坐标的宽度；因为我们这里的宽度是直接使用的child.getMeasuredWidth()的值，
        // 当然会导致getMeasuredWidth()与getWidth()的值是一样的。
        // 如果我们在调用layout()的时候传进去的宽度值不与getMeasuredWidth()相同，
        // 那必然getMeasuredWidth()与getWidth()的值就不再一样了。
        //一定要注意的一点是：getMeasureWidth()方法在measure()过程结束后就可以获取到了，
        // 而getWidth()方法要在layout()过程结束后才能获取到。再重申一遍！！！！！

        //3,疑问：container自己什么时候被布局
        //它当然也有父控件，它的布局也是在父控件中由它的父控件完成的，就这样一层一层地向上由各自的父控件完成对自己的布局。
        //直到所有控件的最顶层结点，在所有的控件的最顶部有一个ViewRoot，它才是所有控件的最终祖先结点。
        //那让我们来看看它是怎么来做的吧。
        //在它布局里，会调用它自己的一个layout()函数(不能被重载，代码位于View.Java)：
        //public final void layout(int l, int t, int r, int b){
        //    boolean changed = setFrame(l, t, r, b); //设置每个视图位于父视图的坐标轴
        //    if (changed || (mPrivateFlags & LAYOUT_REQUIRED) == LAYOUT_REQUIRED) {
        //        if (ViewDebug.TRACE_HIERARCHY) {
        //            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_LAYOUT);
        //        }
        //        onLayout(changed, l, t, r, b);//回调onLayout函数 ，设置每个子视图的布局
        //        mPrivateFlags &= ~LAYOUT_REQUIRED;
        //    }
        //    mPrivateFlags &= ~FORCE_LAYOUT;
        //}
        //setFrame(l,t,r,b)就是设置自己的位置，设置结束以后才会调用onLayout(changed, l, t, r, b)来设置内部所有子控件的位置。

        //TODO measureChildren()与measureChild()的区别
        //TODO measure()与他们的区别;

        //4,获取子控件Margin的方法
        //(1)、首先，在XML中添加上layout_margin参数
        //(2)、重写generateLayoutParams（）函数
        //(3)、重写onMeasure()
        //我们在计算ViewGroup的宽度和高度时不仅考虑到子控件的本身的大小还要考虑到子控件间的间距问题。
        //MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //int childHeight = child.getMeasuredHeight() + lp.topMargin+lp.bottomMargin;
        //int childWidth = child.getMeasuredWidth() + lp.leftMargin+lp.rightMargin;
        //height += childHeight;
        //width = Math.max(childWidth, width);
        //(4)、重写onLayout()函数
        //child.layout(lp.leftMargin ,top + lp.topMargin, child.getMeasuredWidth() + lp.leftMargin, top+child.getMeasuredHeight + lp.topMargin);

        //5,设置Margin的原理
        //(1)在LayoutInflater中,
        //params = root.generateLayoutParams(attrs);
        //这个generateLayoutParams方法，在ViewGroup中，为
        //public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        //    return new ViewGroup.LayoutParams(getContext(), attrs);
        //}
        //而,ViewGroup.LayoutParams(getContext(), attrs)其实只设置了宽高属性
        //但默认只是生成layout_width和layout_height所以对应的布局参数，
        //即在正常情况下的generateLayoutParams（）函数生成的LayoutParams实例是不能够取到margin值的
        //public LayoutParams(Context c, AttributeSet attrs) {
        //  TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
        //    setBaseAttributes(a,
        //            R.styleable.ViewGroup_Layout_layout_width,
        //            R.styleable.ViewGroup_Layout_layout_height);
        //    a.recycle();
        //}

        //(2)MarginLayoutParams与generateLayoutParams()的实现
        //(3)、MarginLayoutParams实现

        
    }

}

class ZLinLayout extends ViewGroup {

    public ZLinLayout(Context context) {
        super(context);
    }

    public ZLinLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZLinLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //布局见 layout_widget_zlinlayout.xml

        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        //ViewGroup自己的宽高
        int height = 0;
        int width = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            //获得子空间
            View child = getChildAt(i);
            //测量子控件
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //获得已测量过的子控件的高度和宽度
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            //得到ViewGroup的最大宽度，并且累加ViewGroup的高度
            width = Math.max(width, childWidth);
            height += childHeight;
        }

        //根据Mode选择使用哪个宽高
        setMeasuredDimension((measureWidthMode == MeasureSpec.EXACTLY ? measureWidth : width),
                (measureHeightMode == MeasureSpec.EXACTLY ? measureHeight : height));
        //当ViewGroup被设置为width=match_parent,height=wrap_content时,
        //上面的实际结果为：setMeasuredDimension(measureWidth, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //重写onLayout()——布局所有子控件
        int top = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            //ViewGroup布局的核心方法 child.layout(int l, int t, int r, int b)
            child.layout(0, top, childWidth, top + childHeight);
            top += childHeight;
        }
    }
}