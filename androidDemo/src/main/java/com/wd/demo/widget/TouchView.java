package com.wd.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchView extends View {

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean isdown = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();
        // Log.i("wd", "onTouchEvent x="+x+" y="+y+" action="+action);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.i("wd", "ACTION_DOWN x=" + x + " y=" + y);
                isdown = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (x < 0) {
                    if (isdown) {
                        Log.i("wd", "ACTION_UP x=" + 0 + " y=" + y);
                        isdown = false;
                    }
                }
                if (y < 0) {
                    if (isdown) {
                        Log.i("wd", "ACTION_UP x=" + x + " y=" + 0);
                        isdown = false;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isdown) {
                    Log.i("wd", "ACTION_UP x=" + x + " y=" + y);
                    isdown = false;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                if (isdown) {
                    Log.i("wd", "ACTION_UP x=" + x + " y=" + y);
                    isdown = false;
                }
                break;

            default:
                break;
        }
        return true;
    }

}
