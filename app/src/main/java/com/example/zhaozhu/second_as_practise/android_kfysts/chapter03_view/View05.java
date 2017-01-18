package com.example.zhaozhu.second_as_practise.android_kfysts.chapter03_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhaozhu on 17/01/03.
 * View的滑动冲突
 */
public class View05 extends View {

    public View05(Context context) {
        super(context);
    }

    public View05(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View05(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View mView;

    private void test(MotionEvent event) {

    }

    /**
     * 1,常见的滑动冲突场景
     * 2,滑动冲突的处理规则
     * 3,滑动冲突的解决方式
     *
     */

    /**
     * <pre>
     * 1,常见的滑动冲突场景
     *  (1)外部滑动方向和内部滑动方向不一致
     *  (2)外部滑动方向和内部滑动方向一致
     *  (3)上面两种情况的嵌套
     *
     * </pre>
     */

    /**
     * <pre>
     * 2,滑动冲突的处理规则
     *  (1)场景1:当用户左右滑动时,需要让外面的view拦截点击事件;当用户上下滑动时,需要让里面的view拦截点击事件
     *  (2)场景2:比较特殊,无法根据滑动的角度来解决,只能从业务上解决
     * </pre>
     */

    /**
     * <pre>
     * 3,滑动冲突的解决方式
     *
     * </pre>
     */


}
