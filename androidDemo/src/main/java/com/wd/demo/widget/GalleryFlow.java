package com.wd.demo.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Gallery;

import com.wd.demo.util.L;

public class GalleryFlow extends Gallery {
    /**
     * The camera class is used to 3D transformation matrix.
     */
    private Camera mCamera = new Camera();
    private Matrix mMatrix = new Matrix();
    /**
     * The max rotation angle.（控制后面图标旋转角度）
     */
    private int mMaxRotationAngle = 30;

    /**
     * The max zoom value (Z axis).
     */
    private int mMaxZoom = -60;

    /**
     * The center of the gallery.
     */
    private int mCoveflowCenter = 0;

    public GalleryFlow(Context context) {
        this(context, null);
        // this.setStaticTransformationsEnabled(true);
        // Enable set the children drawing order.
        this.setChildrenDrawingOrderEnabled(true);
    }

    public GalleryFlow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // this.setStaticTransformationsEnabled(true);
        // Enable set the children drawing order.
        this.setChildrenDrawingOrderEnabled(true);
    }

    public GalleryFlow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // Enable set transformation.
        // this.setStaticTransformationsEnabled(true);
        // Enable set the children drawing order.
        this.setChildrenDrawingOrderEnabled(true);
    }

    public int getMaxRotationAngle() {
        return mMaxRotationAngle;
    }

    public void setMaxRotationAngle(int maxRotationAngle) {
        mMaxRotationAngle = maxRotationAngle;
    }

    public int getMaxZoom() {
        return mMaxZoom;
    }

    public void setMaxZoom(int maxZoom) {
        mMaxZoom = maxZoom;
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        // Current selected index.
        // L.i("getChildDrawingOrder:"+getSelectedItemPosition());
        int selectedIndex = getSelectedItemPosition()
                - getFirstVisiblePosition();
        if (selectedIndex < 0) {
            return i;
        }
        if (i < selectedIndex) {
            return i;
        } else if (i >= selectedIndex) {
            return childCount - 1 - i + selectedIndex;
        } else {
            return i;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    // 获得Coverflow的中点（应该是图片流视图的中点）
    private int getCenterOfCoverflow() {
        return ((getWidth() - getPaddingLeft() - getPaddingRight()) >> 1)
                + getPaddingLeft();
    }

    // 获得子view的中点
    private int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }

    // 计算 child 偏离 父控件中心的 offset 值， -1 <= offset <= 1
    protected float calculateOffsetOfCenter(View view) {
        final int pCenter = getCenterOfCoverflow();
        final int cCenter = getCenterOfView(view);
        float offset = (cCenter - pCenter) / (pCenter * 1.0f);
        offset = Math.min(offset, 1.0f);
        offset = Math.max(offset, -1.0f);
        return offset;
    }

    // @Override
    // public void setUnselectedAlpha(float unselectedAlpha) {
    // unselectedAlpha=0xff;
    // super.setUnselectedAlpha(unselectedAlpha);
    // }

    private void transformImageBitmap(View child, Matrix mt, int rotationAngle) {
        mCamera.save();
        final Matrix imageMatrix = mt;
        final int halfWidth = child.getLeft() + (child.getMeasuredWidth() >> 1);
        final int halfHeight = child.getMeasuredHeight() >> 1;
        final int rotation = Math.abs(rotationAngle);

        // Zoom on Z axis.
        mCamera.translate(0, 0, mMaxZoom);
        L.i("rotation=" + rotation);
        if (rotation < mMaxRotationAngle) {
            float zoomAmount = (float) (mMaxZoom + rotation * 1.5f);
            L.i("zoomAmount=" + zoomAmount);
            mCamera.translate(0, 0, zoomAmount);
        }
        // Rotate the camera on Y axis.
        mCamera.rotateY(rotationAngle);
        // Get the matrix from the camera, in fact, the matrix is S (scale)
        // transformation.
        mCamera.getMatrix(imageMatrix);
        // The matrix final is T2 * S * T1, first translate the center point to
        // (0, 0),
        // then scale, and then translate the center point to its original
        // point.
        // T * S * T
        imageMatrix.preTranslate(-halfWidth, -halfHeight - 15); // 还没清楚为什么要减去15
        imageMatrix.postTranslate(halfWidth, halfHeight - 15);
        mCamera.restore();
    }

    // void getTransformationMatrix(View child, float offset) {
    // final int halfWidth = child.getLeft() + (child.getMeasuredWidth() >> 1);
    // final int halfHeight = child.getMeasuredHeight() >> 1;
    //
    // mCamera.save();
    // mCamera.translate(-offset * 50, 0.0f, Math.abs(offset) * 200);
    //
    // mCamera.getMatrix(mMatrix);
    // mCamera.restore();
    // mMatrix.preTranslate(-halfWidth, -halfHeight);
    // mMatrix.postTranslate(halfWidth, halfHeight);
    // }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        // TODO Auto-generated method stub
        L.i("drawChild:" + child);
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
            transformImageBitmap(child, mt, 0);
        } else {
            // Calculate the rotation angle.
            rotationAngle = (int) (((float) (mCoveflowCenter - childCenter) / childWidth) * mMaxRotationAngle);
            // Make the angle is not bigger than maximum.
            if (Math.abs(rotationAngle) > mMaxRotationAngle) {
                rotationAngle = (rotationAngle < 0) ? -mMaxRotationAngle
                        : mMaxRotationAngle;
            }
            transformImageBitmap(child, mt, rotationAngle);
        }
        return true;
    }

}
