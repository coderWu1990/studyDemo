package com.wd.demo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.wd.demo.R;

public class RotateView extends View {
    // Camera类
    private Camera mCamera;
    private Bitmap face;
    private Matrix mMatrix = new Matrix();
    private Paint mPaint = new Paint();
    private Paint mPaint2 = new Paint();
    // 图片旋转时的中心点坐标
    private int centerX, centerY;

    public RotateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        mCamera = new Camera();
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
        face = BitmapFactory.decodeResource(getResources(), R.drawable.img1);
        centerX = face.getWidth() >> 1;
        centerY = face.getHeight() >> 1;
        rotate(30);
        mPaint2.setColor(Color.RED);
        mPaint2.setStrokeWidth(5);
        mPaint2.setStyle(Paint.Style.STROKE);
    }

    void rotate(int degreeY) {
        mCamera.save();
        mCamera.rotateY(degreeY);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        // 以图片的中心点为旋转中心,如果不加这两句，就是以（0,0）点为旋转中心
        mMatrix.preTranslate(-centerX, -centerY);
        mMatrix.postTranslate(centerX, centerY);
        mCamera.save();

        postInvalidate();
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawBitmap(face, mMatrix, mPaint);
        canvas.drawRect(0, 0, centerX * 2, centerY * 2, mPaint2);
    }
}