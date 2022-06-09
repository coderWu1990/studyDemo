package com.wd.demo.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.wd.demo.util.L;

/**
 * 继承RecyclerView重写{@link #getChildDrawingOrder(int, int)}对Item的绘制顺序进行控制
 */

public class RecyclerCoverFlow extends RecyclerView {

    /**
     * 按下的X轴坐标
     */
    private float mDownX;
    /**
     * 自定义的布局管理器
     */
    private CoverFlowLayoutManger mFlowLayoutManger;
    /**
     * 3D旋转需要的
     */
    private Camera mCamera = new Camera();
    /**
     * 3D旋转需要的
     */
    private Matrix mMatrix = new Matrix();
    /**
     * 最大旋转的角度
     */
    private int mMaxRotationAngle = 30;
    /**
     * Z轴最大缩放（这个项目不缩放）
     */
    private int mMaxZoom = 0;// -60
    /**
     * 图片流视图的中点
     */
    private int mCoveflowCenter = 0;

    public RecyclerCoverFlow(Context context) {
        super(context);
        init();
    }

    public RecyclerCoverFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RecyclerCoverFlow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mFlowLayoutManger = new CoverFlowLayoutManger();
        setLayoutManager(mFlowLayoutManger);
        setChildrenDrawingOrderEnabled(true); // 开启重新排序
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        if (!(layout instanceof CoverFlowLayoutManger)) {
            throw new IllegalArgumentException(
                    "The layout manager must be CoverFlowLayoutManger");
        }
        super.setLayoutManager(layout);
    }

    /***
     * 计算正在显示的所有Item的中间位置
     */
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        int center = getCoverFlowLayout().getCenterPosition()
                - getCoverFlowLayout().getFirstVisiblePosition();
        if (center < 0)
            center = 0;
        else if (center > childCount)
            center = childCount;
        int order;
        if (i == center) {
            order = childCount - 1;
        } else if (i > center) {
            order = center + childCount - 1 - i;
        } else {
            order = i;
        }
        return order;
    }

    /**
     * 获取LayoutManger，并强制转换为CoverFlowLayoutManger
     */
    public CoverFlowLayoutManger getCoverFlowLayout() {
        return mFlowLayoutManger;
    }

    /**
     * 获取被选中的Item位置
     */
    public int getSelectedPos() {
        return getCoverFlowLayout().getSelectedPos();
    }

    /**
     * 设置选中监听
     *
     * @param l 监听接口
     */
    public void setOnItemSelectedListener(CoverFlowLayoutManger.OnSelected l) {
        getCoverFlowLayout().setOnSelectedListener(l);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = ev.getX();
                getParent().requestDisallowInterceptTouchEvent(true); // 设置父类不拦截滑动事件
                break;
            case MotionEvent.ACTION_MOVE:
                if ((ev.getX() > mDownX && getCoverFlowLayout().getCenterPosition() == 0)
                        || (ev.getX() < mDownX && getCoverFlowLayout()
                        .getCenterPosition() == getCoverFlowLayout()
                        .getItemCount() - 1)) {
                    // 如果是滑动到了最前和最后，开放父类滑动事件拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    // 滑动到中间，设置父类不拦截滑动事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
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
        L.i("transformImageBitmap" + rotationAngle + "<>" + child.getLeft()
                + "<>" + child.getMeasuredWidth());
        mCamera.save();
        final int width = child.getMeasuredWidth();
        final int halfHeight = child.getMeasuredHeight() >> 1;
        //final int rotation = Math.abs(rotationAngle);

        // Rotate the camera on Y axis.
        mCamera.rotateY(rotationAngle);
        // Get the matrix from the camera, in fact, the matrix is S (scale)
        mCamera.getMatrix(mMatrix);

        // 确定旋转中心点，旋转中心为(0,height/2)
        if (rotationAngle > 0) {
            mMatrix.preTranslate(-child.getLeft(), -halfHeight);
            mMatrix.postTranslate(child.getLeft(), halfHeight);
        } else if (rotationAngle < 0) {
            mMatrix.preTranslate(-child.getLeft() - width, -halfHeight);
            mMatrix.postTranslate(child.getLeft() + width, halfHeight);
        }
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
