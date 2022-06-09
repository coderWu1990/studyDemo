package com.wd.demo.widget.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ViewGroupA extends RelativeLayout {

    public ViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dispatch", "ViewGroupA dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("dispatch", "ViewGroupA dispatchTouchEvent UP");
                break;
            default:
                break;
        }
        //return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dispatch", "ViewGroupA onInterceptTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("dispatch", "ViewGroupA onInterceptTouchEvent UP");
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
        //return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dispatch", "ViewGroupA onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("dispatch", "ViewGroupA onTouchEvent UP");
                break;
            default:
                break;
        }
        //return true;
        return super.onTouchEvent(event);
    }

}
