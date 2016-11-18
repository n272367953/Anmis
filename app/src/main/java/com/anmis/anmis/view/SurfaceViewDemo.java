package com.anmis.anmis.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by Administrator on 2016/10/14.
 */

public class SurfaceViewDemo extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    public static final int INIT = 0;
    public static final int TOP = 1;
    public static final int LEFT = 2;
    public static final int BOTTOM = 3;
    public static final int RIGHT = 4;
    public static final int R = 100;


    public SurfaceViewDemo(Context context) {
        super(context);
    }

    public SurfaceViewDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private Paint paint;

    private void init(Context context) {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    private Thread thread;

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (thread == null) {
            thread = new Thread(this);
        }
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRunning = false;
    }


    private boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            draw();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw() {
        Canvas canvas = getHolder().lockCanvas();
        if (canvas == null) {
            return;
        }
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);
        computePosition();
        canvas.drawCircle(x, y, R, paint);
        getHolder().unlockCanvasAndPost(canvas);
    }

    private int x;
    private int y;
    private int edge = INIT;
    private int step = 10;
    private String edgeStr = "init";


    private void computePosition() {

        switch (edge) {
            case INIT:
                if (x == 0 && y == 0) {
                    x = getWidth() / 2;
                    y = getHeight() / 2;
                }
                y = y + step;
                edgeStr = "init";
                break;
            case BOTTOM:
                x = x + step;
                y = (int) (getHeight() - Math.sqrt(3) * x);
                edgeStr = "BOTTOM";
                break;
            case RIGHT:
                x = x - step;
                y = (int) (getHeight() - Math.sqrt(3) / 3 * x);
                edgeStr = "RIGHT";
                break;
            case TOP:
                x = x - step;
                y = (int) (getHeight() - Math.sqrt(3) * x);
                edgeStr = "TOP";
                break;
            case LEFT:
                x = x + step;
                y = (int) (getHeight() - Math.sqrt(3) / 3 * x);
                edgeStr = "LEFT";
                break;
        }
        handleEdge(getWidth(), getHeight());
    }

    private void handleEdge(int width, int height) {
        if (x - R <= 0) {
            x = R;
            edge = LEFT;
        }
        if (x + R >= width) {
            x = width - R;
            edge = RIGHT;
        }
        if (y + R >= height) {
            y = height - R;
            edge = BOTTOM;
        }
        if (y - R <= 0) {
            y = R;
            edge = TOP;
        }
        Log.i("TAG", " 当前圆心坐标 x = " + x + "y =" + y);
        Log.i("TAG", " 当前位置：" + edgeStr);
    }
}
