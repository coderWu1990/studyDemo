package com.wd.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wd.demo.R;

import java.util.ArrayList;
import java.util.List;


/*
 ① 创建一个继承RecyclerView.Adapter<VH>的Adapter类
 ② 创建一个继承RecyclerView.ViewHolder的静态内部类
 ③ 在Adapter中实现3个方法：
 onCreateViewHolder()
 onBindViewHolder()
 getItemCount()
 */
public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<String> list = new ArrayList<String>();
    private View inflater;

    // 构造方法，传入数据
    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建ViewHolder，返回每一项的布局
        inflater = LayoutInflater.from(context).inflate(R.layout.item_main,
                parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 将数据和控件绑定
        holder.tex.setText(list.get(position));
        // holder.img.

    }

    @Override
    public int getItemCount() {
        // 返回Item总条数
        return 9;
    }

    // 内部类，绑定控件
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tex;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            tex = (TextView) itemView.findViewById(R.id.tex);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
