package com.wd.demo.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.wd.demo.R;

public class T3DView extends ImageView {

    private Camera camera;
    private Matrix matrix;
    private Paint paint;

    public T3DView(Context context, AttributeSet attrs) {
        super(context, attrs);
        camera = new Camera();
        matrix = new Matrix();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        camera.save();
        camera.rotateY(30);
        camera.getMatrix(matrix);
        matrix.preTranslate(-getWidth(), -getHeight() / 2);// getWidth() / 2
        matrix.postTranslate(getWidth(), getHeight() / 2);
        canvas.concat(matrix);
        camera.restore();
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.img1, null), matrix, paint);
        // super.onDraw(canvas);
    }

}
