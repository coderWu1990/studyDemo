/**
 *
 */
package com.wd.demo.widget.surface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-22 上午9:27:53 <br/>
 *
 */
public class TrackSurfaceView extends SurfaceView implements
        Callback, Runnable {
    private SurfaceHolder mHolder;
    private Paint mPaint;
    private Path mPath;
    private boolean isDraw = false;

    /**
     * @param context
     * @param attrs
     */
    public TrackSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mHolder = this.getHolder();
        mHolder.addCallback(this);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Style.STROKE);
        mPaint.setColor(Color.RED);
        mPath = new Path();
        mPath.moveTo(100, 100);
        mPath.lineTo(200, 200);
        mPath.lineTo(300, 300);
        mPath.lineTo(400, 200);
        mPath.lineTo(500, 100);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDraw = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDraw = false;
    }

    @Override
    public void run() {
        while (isDraw) {
            draw();
        }
    }

    private void draw() {
        Canvas canvas = mHolder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath, mPaint);
        mHolder.unlockCanvasAndPost(canvas);
    }

}
