package com.example.zhaozhu.second_as_practise.review_android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.zhaozhu.second_as_practise.App;

/**
 * Created by zhaozhu on 17/6/9.
 * http://blog.csdn.net/guolin_blog/article/details/9097463
 */

public class ReviewTouchEvent extends View {

    public ReviewTouchEvent(Context context) {
        super(context);
    }

    public ReviewTouchEvent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReviewTouchEvent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**------*/
    //TODO 注意，要将dispatchTouchEvent的返回值意义和onTouch&onTouchEvent得返回值的意义区分开
    //TODO 即，要将事件分发的返回值得意义和事件处理的返回值的意义区分开
    //TODO （1）dispatchTouchEvent的返回值意义：在"一次touch事件中"中，这个view，要不要接收后续的MotionEvent，true表示接收，false表示不接收
    //TODO （2）onTouch&onTouchEvent的返回值意义：在"一次touch事件中"中，某一个MotionEvent，应该由哪个回调方法处理：
    //TODO OnTouchListener.onTouch回调的优先级高于View.onTouchEvent回调，如果OnTouchListener.onTouch回调返回true，
    //TODO 表示OnTouchListener.onTouch回调中不拦截这个MotionEvent，交给View.onTouchEvent回调处理；
    //TODO 否则表示拦截这个MotionEvent，不让View.onTouchEvent回调处理；

    /** TODO 如果你在执行ACTION_DOWN的时候返回了false，后面一系列其它的action就不会再得到执行了。
     简单的说，就是当dispatchTouchEvent在进行事件分发的时候，只有前一个action返回true，才会触发后一个action。
     说到这里，很多的朋友肯定要有巨大的疑问了。这不是在自相矛盾吗？前面的例子中，明明在onTouch事件里面返回了false，
     ACTION_DOWN和ACTION_UP不是都得到执行了吗？其实你只是被假象所迷惑了，让我们仔细分析一下，在前面的例子当中，我们到底返回的是什么。
     参考着我们前面分析的源码，首先在onTouch事件里返回了false，就一定会进入到onTouchEvent方法中，然后我们来看一下onTouchEvent方法的细节。
     由于我们点击了按钮，就会进入到第14行这个if判断的内部，然后你会发现，不管当前的action是什么，最终都一定会走到第89行，返回一个true。

     是不是有一种被欺骗的感觉？明明在onTouch事件里返回了false，系统还是在onTouchEvent方法中帮你返回了true。
     就因为这个原因，才使得前面的例子中ACTION_UP可以得到执行。

     在dispatchTouchEvent中最先执行的就是onTouch方法，因此onTouch肯定是要优先于onTouchEvent，
     如果OnTouchListener.onTouch返回false，表示外面设置的OnTouchListener不想消费事件，交给
     */

    /** TODO 注意下面这段英文注释，在进行"一次touch事件的分发"时，
     （1）如果"一个view"在dispatchTouchEvent处理MotionEvent的过程中，
     只要有一次MotionEvent的返回false，那么表示"这个view"不再处理"本次touch事件"的后续MotionEvent，
     就是说，"本次touch事件"的后续MotionEvent，,"这个view"都不会再收到,
     （2）只有当dispatchTouchEvent返回true时,表示"这个view"要消费"本次touch事件",
     "本次touch事件"的后续MotionEvent，也要分发给"这个view"才对。
     （3）在进行"一次touch事件的分发"时，一旦"一个view"在dispatchTouchEvent返回了false，这个view就收不到touch事件了。
     */

    /**
     * Pass the touch screen motion event down to the target view, or this
     * view if it is the target.
     *
     * @param event The motion event to be dispatched.
     * @return True if the event was handled by the view, false otherwise.
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
//        if (mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED &&
//                mOnTouchListener.onTouch(this, event)) {
//            return true;
//        }
//        return onTouchEvent(event);

//        第一个条件，mOnTouchListener != null,是否有mOnTouchListener
//        第二个条件(mViewFlags & ENABLED_MASK) == ENABLED是判断当前点击的控件是否是enable的，按钮默认都是enable
//        第三个条件就比较关键了，mOnTouchListener.onTouch(this, event)，其实也就是去回调控件注册touch事件时的onTouch方法
//        如果我们在onTouch方法里返回true，就会让这三个条件全部成立，从而整个方法直接返回true。即事件被消费了,就不会执行onTouchEvent(event)方法
//        如果我们在onTouch方法里返回false，就会再去执行onTouchEvent(event)方法

//        如果onTouch返回true，onClick就不会再执行了
//        由此得出一个重要信息：那就是onClick的调用肯定是在onTouchEvent(event)方法中的！
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

//        看onTouchEvent的源码，点super..onTouchEvent(event);进去看
//        首先在第14行我们可以看出，如果该控件是可以点击的就会进入到第16行的switch判断中去，
//        而如果当前的事件是抬起手指，则会进入到MotionEvent.ACTION_UP这个case当中。
//        在经过种种判断之后，会执行到第38行的performClick()方法

    }

    /**
     * ------
     */

    public static class Test {
        ReviewTouchEvent view = new ReviewTouchEvent(App.getAppContext());


    }

}
