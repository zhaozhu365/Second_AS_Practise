package com.example.zhaozhu.second_as_practise.android_kfysts.chapter03_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhaozhu on 16/12/29.
 * View 的滑动
 */
public class View02 extends View {

    public View02(Context context) {
        super(context);
    }

    public View02(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View02(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View mView;

    private void test(MotionEvent event) {

    }

    /**
     * 3种常见的滑动方式:
     * 1,通过view本身的scollTo/scrollBy方法
     * 2,通过动画给view施加平移效果实现滑动
     * 3,通过改变view的LayoutParams使得view重新布局而实现滑动
     */

    /**
     * <pre>
     * 1,通过view本身的scollTo/scrollBy方法
     *
     * (1)scrollTo() 和 scrollBy()改变的是什么?
     *      ### 注意:scrollTo() 和 scrollBy()只改变View的内容的位置,而不改变View在布局中的位置
     *
     * (2)mScrollX 和 mScrollY 怎么理解?
     *      mScrollX = View的左边缘-View的内容的左边缘
     *          --> 当view的左边缘在view的内容的左边缘的右边时,mScrollX为正值,反之为负值
     *          --> 换句话说,如果从左向右滑动,mScrollX为负值,反之为正值
     *      mScrollY = View的上边缘-View的内容的上边缘
     *          --> 当view的上边缘在view的内容的上边缘的下边时,mScrollY为正值,反之为负值
     *          --> 换句话说,如果从上向下滑动,mScrollY为负值,反之为正值
     * </pre>
     */

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public void scrollBy(int x, int y) {
        super.scrollBy(x, y);
    }

    /**
     * <pre>
     *
     * 2,通过动画给view施加平移效果实现滑动
     * (1),View动画
     * (2),属性动画
     *
     * </pre>
     */

    /**
     * <pre>
     *
     * 3,通过改变view的LayoutParams使得view重新布局而实现滑动
     * (1),View动画
     * (2),属性动画
     *
     * </pre>
     */

    /**
     * <pre>
     * 以上3种实现方式的差异对比:
     * 1,scrollTo/scrollBy:操作简单, 适合对(View内容的滑动)
     * 2,动画:操作简单,主要适用于没有交互的View和实现复杂的动画效果
     * 3,改变布局参数:操作稍微复杂,适用于有交互的View
     *
     * </pre>
     */

}
