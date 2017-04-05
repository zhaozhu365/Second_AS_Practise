package com.example.zhaozhu.second_as_practise.review_android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhaozhu on 17/3/31.
 */

public class ReviewViewGroup2 {

    private void init() {

    }

}

class ZFlowLayout extends ViewGroup {

    public ZFlowLayout(Context context) {
        super(context);
    }

    public ZFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //TODO 注意,这部分内容博客有些细节说的不对,比如Margin的理解


        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);

        int lineWidth = 0;//记录每一行的宽度
        int lineHeight = 0;//记录每一行的高度
        int height = 0;//记录整个FlowLayout所占高度
        int width = 0;//记录整个FlowLayout所占宽度

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            //TODO http://blog.csdn.net/harvic880925/article/details/47029169
            //TODO 上面的博客评论,你在onmeasure中计算子view大小不应该使用measureChild方法，而是应该使用measureChildWithMargins方法，因为你的子view已经使用的margin的参数。
            //TODO measureChild方法少减了margin，这会导致父view对子view测量者的最大允许值偏大。当你的子view比较大的时候，可能会出现子view超出父view的显示范围。因为父view所允许子view最大显示尺寸偏大。
            //measureChildWithMargins(child, widthMeasureSpec, );

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            if (childWidth + lineWidth > measureWidth) {
                //需要换行,更新View的高度和宽度
                height += lineHeight;
                width = Math.max(width, lineWidth);
                //设置新一行的行高和行宽
                lineHeight = childHeight;
                lineWidth = childWidth;
            } else {
                //不需要换行,更新行高,行宽
                lineHeight = Math.max(lineHeight, childHeight);
                lineWidth += childWidth;
            }

            //最后一行特殊,需要单独更新,
            // 为啥呢？因为最后一行不会再经历"换行的操作",如果不对最后一行特殊处理,View的宽高不会少了最后一行的信息
            if (i == count - 1) {
                height += lineHeight;
                width = Math.max(width, lineWidth);
            }
        }

        //当属性是MeasureSpec.EXACTLY时，那么它的高度就是确定的，
        // 只有当是wrap_content时，根据内部控件的大小来确定它的大小时，大小是不确定的，属性是AT_MOST,
        // 此时，就需要我们自己计算它的应当的大小，并设置进去
        setMeasuredDimension(measureWidthMode == MeasureSpec.EXACTLY ? measureWidth : width,
                measureHeightMode == MeasureSpec.EXACTLY ? measureHeight : height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //TODO 注意,这部分内容博客有些细节说的不对,比如Margin的理解
        //重写onLayout()——布局所有子控件
        int left = 0;//子view左顶点的坐标
        int top = 0;//子view上顶点的坐标
        int lineHeight = 0;//行高
        int lineWidth = 0;//行宽
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child  = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            if (childWidth + lineWidth > getMeasuredWidth()) {
                //需要换行,更新子view上顶点的坐标,子view左顶点的坐标
                left = 0;
                top += lineHeight;
                //更新行宽,行高
                lineWidth = childWidth;
                lineHeight = childHeight;
            } else {
                //不需要换行,更新行宽
                lineWidth += childWidth;
                lineHeight = Math.max(childHeight, lineHeight);
            }

            //计算childView的left,top,right,bottom
            int cl = left + lp.leftMargin;
            int ct = top + lp.topMargin;
            int cr = cl + child.getMeasuredWidth();
            int cb = ct + child.getMeasuredHeight();
            child.layout(cl, ct, cr, cb);
            //设置下一子控件的起始点
            left = lineWidth;
        }

    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }
}
