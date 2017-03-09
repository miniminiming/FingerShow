package com.ming.fingersshow.utils;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import com.ming.fingersshow.R;
import com.ming.fingersshow.widget.FingerLayout;
import com.ming.fingersshow.widget.WaterCircleView;

/**
 * Created by Administrator on 2016/7/22 0022.
 */
public class ViewUtils {


    final static String ADDED = "added";

    /**
     * 给activity的根布局外添加一个手指特效布局
     * 在BaseActivity的onResume方法中调用
     *
     * @param activity
     */
    public static void addFingerlayout(Activity activity) {
        //获取的其实是个FrameLayout，也就是DectorView
        ViewGroup rootView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);

        //先检查一下这个activity有没有添加过动态效果,这儿我把是否添加过的标记位放到DectorView的Tag里
        //防止重复添加
        Object isAdded = rootView.getTag(R.id.view_util_first);
        //如果已经添加过，就不再添加了
        if (isAdded != null) {
            return;
        }
        rootView.setTag(R.id.view_util_first, ADDED);
        //这个是setContentView时获取到XML中的根布局对象
        ViewGroup childRootView = (ViewGroup) rootView.getChildAt(0);
        //这时说明activity并没有setContentView，不再往下执行
        if (childRootView == null) {
            return;
        }

        Log.i("rootView", childRootView.getClass().getSimpleName());
        //从父view移除
        rootView.removeView(childRootView);

        //添加到FingerLayout
        FingerLayout fingerLayout = new FingerLayout(activity);
        fingerLayout.addView(childRootView);

        //添加水波纹的view
        //本来这个view是要添加在FingerLayout布局中的，但是这样会导致波纹布局处于最下层
        //因为你先添加了波纹布局,所以要把波纹放在后面添加
        View circleView = new WaterCircleView(activity);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        fingerLayout.addView(circleView, params);
        //把FingerLayout加回去
        rootView.addView(fingerLayout);
    }

//    public static void addFingerlayout(Activity activity,Class<>)

    /**
     * 请求该activity不添加触摸特效
     * 请在需要不添加特效的activity的onCreate方法中调用
     *
     * @param activity
     */
    public static void requestNoFingerShow(Activity activity) {
        //获取的其实是个FrameLayout，也就是DectorView
        ViewGroup rootView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
        rootView.setTag(R.id.view_util_first, ADDED);
    }
}
