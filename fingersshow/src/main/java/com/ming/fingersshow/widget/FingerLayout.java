package com.ming.fingersshow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2016/7/22 0022.
 */
public class FingerLayout extends FrameLayout {
    public FingerLayout(Context context) {
        super(context);
        init(context);
    }

    public FingerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FingerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //把水波纹添加到本布局中
//        WaterCircleView circleView = new WaterCircleView(context);
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        addView(circleView, params);

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //分发给每个子view
        for (int i = 0; i < getChildCount(); i++) {
            // 把事件传递给每个子view
            getChildAt(i).dispatchTouchEvent(event);
        }
        return true;
    }
}
