package com.wd.demo.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.wd.demo.util.L;

public class Recycle3DView extends RecyclerView {

    private Camera mCamera = new Camera();
    private Matrix mMatrix = new Matrix();
    private int mMaxRotationAngle = 30;
    private int mMaxZoom = -60;//-60
    private int mCoveflowCenter = 0;

    public Recycle3DView(Context context) {
        super(context);
    }

    public Recycle3DView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Recycle3DView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean ret;
        getChildStaticTrans(child, mMatrix);
        int saveCount = canvas.save();
        canvas.concat(mMatrix);
        ret = super.drawChild(canvas, child, drawingTime);
        canvas.restoreToCount(saveCount);
        return ret;
    }

    protected boolean getChildStaticTrans(View child, Matrix mt) {
        final int childCenter = getCenterOfView(child);
        final int childWidth = child.getWidth();
        int rotationAngle = 0;
        if (childCenter == mCoveflowCenter) {
            transformImageBitmap(child, 0);
        } else {
            // Calculate the rotation angle.
            rotationAngle = (int) (((float) (mCoveflowCenter - childCenter) / childWidth) * mMaxRotationAngle);
            // Make the angle is not bigger than maximum.
            if (Math.abs(rotationAngle) > mMaxRotationAngle) {
                rotationAngle = (rotationAngle < 0) ? -mMaxRotationAngle
                        : mMaxRotationAngle;
            }
            transformImageBitmap(child, rotationAngle);
        }
        return true;
    }

    // 获得子view的中点
    private int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }

    private void transformImageBitmap(View child, int rotationAngle) {
        mCamera.save();
        final int halfWidth = child.getLeft() + (child.getMeasuredWidth() >> 1);
        final int halfHeight = child.getMeasuredHeight() >> 1;
        final int rotation = Math.abs(rotationAngle);

        // Zoom on Z axis.
        float zoomAmount = 0;
//		if (rotation < mMaxRotationAngle) {
//			zoomAmount= (float) (mMaxZoom + rotation * 1.5f);
//			mCamera.translate(0, 0, zoomAmount);
//		}else{
//			zoomAmount=mMaxZoom;
//			mCamera.translate(0, 0, zoomAmount);
//		}
        L.i("rotation=" + rotation + " zoomAmount=" + zoomAmount);
        // Rotate the camera on Y axis.
        if (rotation > 5) {
            mCamera.rotateX(-12);
            mCamera.rotateY(24);
            mCamera.rotateZ(4);
        } else {
            mCamera.rotateX(0);
            mCamera.rotateY(rotationAngle);
            mCamera.rotateZ(0);
        }

        // Get the matrix from the camera, in fact, the matrix is S (scale)
        mCamera.getMatrix(mMatrix);

        // 最后的矩阵是t2*s*t1，首先将中心点转换为（0, 0）
        // 然后缩放，然后将中心点转换为其原始点点 t*s*t
        mMatrix.preTranslate(-halfWidth, -halfHeight); // 还没清楚为什么要减去15
        mMatrix.postTranslate(halfWidth, halfHeight);
        mCamera.restore();
    }

    // 获得Coverflow的中点（应该是图片流视图的中点）
    private int getCenterOfCoverflow() {
        return ((getWidth() - getPaddingLeft() - getPaddingRight()) >> 1)
                + getPaddingLeft();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }

}
