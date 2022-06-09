package com.wd.demo.widget.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ViewC extends View {

    public ViewC(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dispatch", "ViewC onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("dispatch", "ViewC onTouchEvent UP");
                break;
            default:
                break;
        }
//		return super.onTouchEvent(event);
        return true;
    }


}
