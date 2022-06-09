package com.wd.demo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wd.demo.R;

public class StringAdapter extends BaseAdapter {

    private Context mContext;

    public StringAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_name, null);
            holder = new ViewHolder();
            holder.tex = (TextView) convertView.findViewById(R.id.item_tex);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tex.setText("这是" + position + "项");
        return convertView;
    }

    private class ViewHolder {
        TextView tex;
    }

}
