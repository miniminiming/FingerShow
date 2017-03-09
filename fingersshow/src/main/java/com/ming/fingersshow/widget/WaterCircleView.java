package com.ming.fingersshow.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/7/22 0022.
 */
public class WaterCircleView extends View {
    public WaterCircleView(Context context) {
        super(context);
        init();
    }

    public WaterCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaterCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint;
    private int[] mColors;

    private List<WaterCircle> mCircles;

    private Random mRandom;

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);

        mColors = new int[]{Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.GRAY};
        mCircles = new ArrayList<>();

        mRandom = new Random();
    }

    class WaterCircle {
        public float cx;
        public float cy;
        public int radius;
        public int strokeWidth;

        public int alpha;
        public int color;

        public int radiusOffset;
        public int alphaOffset;
    }

    public void generateWaterCircle(float x, float y) {
        if (mCircles == null) {
            return;
        }

        WaterCircle circle = new WaterCircle();
        circle.cx = x;
        circle.cy = y;
        circle.radius = 0;

        circle.alpha = 255;
        circle.color = mColors[mRandom.nextInt(mColors.length)];

        circle.strokeWidth = mRandom.nextInt(15) + 15;//半径5到10之间
        circle.radiusOffset = 3;
        circle.alphaOffset = -(mRandom.nextInt(3) + 4);//透明度减少量，决定了圈持续的时间以及最后扩散的大小

        mCircles.add(circle);
//        if (mCircles.size()==1){
//            invalidate();
//        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < mCircles.size(); x++) {
            WaterCircle circle = mCircles.get(x);

            //一定要先设置颜色再设置透明度，否则无效
            mPaint.setColor(circle.color);
            mPaint.setStrokeWidth(circle.strokeWidth);
            mPaint.setAlpha(circle.alpha += circle.alphaOffset);

            canvas.drawCircle(circle.cx, circle.cy, circle.radius += circle.radiusOffset, mPaint);

            //透明度没有就从集合中移除
            if (circle.alpha <= 10) {
                mCircles.remove(circle);
                x--;
            }
        }

        //如果集合中还有就刷新页面，否则就不刷新
        invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        generateWaterCircle(event.getX(), event.getY());

        return true;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        Log.i("circleView", "onAttacthedToWindow========");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
//        Log.i("circleView","onDetachedFromWindow========");
        mCircles.clear();
    }

//    @Override
//    protected void onWindowVisibilityChanged(int visibility) {
//        super.onWindowVisibilityChanged(visibility);
//        switch (visibility){
//            case View.VISIBLE:
//                Log.i("circleView","VISIBLE========");
//                break;
//            case View.INVISIBLE:
//                Log.i("circleView","INVISIBLE========");
//                break;
//            case View.GONE:
//                Log.i("circleView","GONE========");
//                break;
//        }
//    }

    @Override
    /**
     * 焦点改变就会回调这个
     */
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus){
//            Log.i("circleView","hasWindowFocus==="+hasWindowFocus);
        }else{
            //失去焦点时就清空集合
            mCircles.clear();
//            Log.i("circleView","hasWindowFocus==="+hasWindowFocus);
        }
    }
}
