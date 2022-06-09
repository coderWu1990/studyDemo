package com.wd.demo.widget.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.wd.demo.R;

public class TimeWidget extends AppWidgetProvider {

    //
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.i("widget", "onEnabled");
    }

    //
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("widget", "onReceive + " + intent.getAction());
        super.onReceive(context, intent);

    }

    //
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        Log.i("widget", "onUpdate");
        ComponentName thisWidget = new ComponentName(context, TimeWidget.class);// ��������
        RemoteViews views = new RemoteViews(context.getPackageName(),
                R.layout.widget_ui);

        appWidgetManager = AppWidgetManager.getInstance(context);

        appWidgetManager.updateAppWidget(thisWidget, views);

    }

    //
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.i("widget", "onDeleted");
        super.onDeleted(context, appWidgetIds);
    }

    //
    @Override
    public void onDisabled(Context context) {
        Log.i("widget", "onDisabled");
        super.onDisabled(context);
    }
}
