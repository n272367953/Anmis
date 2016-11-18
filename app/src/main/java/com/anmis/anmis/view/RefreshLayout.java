package com.anmis.anmis.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by niushuowen on 2016/8/15.
 */
public class RefreshLayout extends FrameLayout {

    private TextView behindView;
    private ScrollView frontView;
    private Context context;


    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mScroller = new Scroller(context);
        behindView = new TextView(context);
        behindView.setText("背景");
        behindView.setBackgroundColor(Color.RED);
        frontView = new ScrollView(context);
        frontView.setBackgroundColor(Color.GREEN);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -1);

        frontView.setLayoutParams(params);
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < 100; i++) {
            TextView view = new TextView(context);
            view.setText(String.valueOf(i));
            ll.addView(view);
        }
        frontView.addView(ll);
        frontView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("TAG", "Child_action_down");
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        frontView.getParent().requestDisallowInterceptTouchEvent(false);
                        int deltaX = lastX - ((int) event.getRawX());
                        int deltaY = lastY - ((int) event.getRawY());
                        childFrontOffSet = deltaY;
                        if (childFrontOffSet < -ViewConfiguration.get(getContext()).getScaledTouchSlop() && frontView.getScrollY() <= 0) {
                            frontView.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                        Log.i("TAG", "Child_action_move");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("TAG", "Child_action_up");
                        break;
                }
                return false;
            }
        });

        addView(behindView);
        addView(frontView);
    }

    private int childFrontOffSet;
    private int frontOffSet;


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.i("TAG", "onDispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    private int lastX;

    private int lastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        boolean intercept = false;
        int curX = 0;
        int curY = 0;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG", "onTnterceptTouchEvent_down");
                curX = (int) ev.getRawX();
                curY = (int) ev.getRawY();
                lastX = curX;
                lastY = curY;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("TAG", "onTnterceptTouchEvent_move");
                int deltaX = lastX - ((int) ev.getRawX());
                int deltaY = lastY - ((int) ev.getRawY());
                frontOffSet = deltaY;
                if (frontOffSet < -ViewConfiguration.get(getContext()).getScaledTouchSlop() && frontView.getScrollY() <= 0) {
                    intercept = true;
                }
//               .6.
                break;
            case MotionEvent.ACTION_UP:
                Log.i("TAG", "onTnterceptTouchEvent_up");
                break;
        }

        return intercept;
    }


    private boolean isPull = false;
    private int curTop = 0;
    private int curBotton;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (isPull) {
//            if (curTop > 300) {
//                frontOffSet = frontOffSet / 4;
//            }
//            if (curTop < 400) {
//                curTop = curTop - frontOffSet;
//            }
            if (curTop - frontOffSet > 150) {
                curTop = curTop - frontOffSet / 5;
            }else{
                curTop = curTop - frontOffSet;
            }
            if (curTop >= 300) {
                curTop = 300;
            }
            curBotton = frontView.getMeasuredHeight() - frontOffSet;
            Log.i("position", "0  " + curTop + "  " + frontView.getMeasuredWidth() + "  " + (frontView.getBottom() - frontOffSet));
//            frontView.setTop(curTop);
            frontView.layout(0, curTop, frontView.getMeasuredWidth(), curTop + frontView.getMeasuredHeight());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isConsume = false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG", "Parent_action_down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("TAG", "Parent_action_move");
                int deltaX = lastX - ((int) event.getRawX());
                int deltaY = lastY - ((int) event.getRawY());
                frontOffSet = deltaY;
                if (frontView.getScrollY() <= 0) {
//                    frontView.setTop(frontView.getTop() - frontOffSet/5);
                    isPull = true;
                    requestLayout();
                }
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                isConsume = true;
                break;
            case MotionEvent.ACTION_UP:
                Log.i("TAG", "Parent_action_up");
                smoothScrollerTo(0, 0);
                break;
        }
        return isConsume;
    }

    private Scroller mScroller;

    /**
     * 在特定时间内滑动到某一位置
     *
     * @param destX
     * @param destY
     */
    private void smoothScrollerTo(int destX, int destY) {
//        int scrollerX = getScrollX();
//        int deltaX = destX - scrollerX;
//        int scrollerY = getScrollY();
//        int deltaY = destY - scrollerY;
        mScroller.startScroll(0, curTop, 0, -curTop, 500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            frontOffSet = -(mScroller.getCurrY() - curTop);
//            postInvalidate();
            requestLayout();
        }
    }
}
