package com.wd.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.wd.demo.R;

public class RecyclerAdapter2 extends
        RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {

    private Context mContext;
    private int mSelect = -1;

    public RecyclerAdapter2(Context c) {
        mContext = c;
    }

    /**
     * 设置当前选中
     */
    public void setSelect(int i) {
        this.mSelect = i;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_item,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mItemImg.setImageResource(R.drawable.defulat_covel);
    }

    public interface HomeItemClickLinstener {
        void onItemClick(int position);
    }

    private HomeItemClickLinstener mItemLinstener;

    public void setHomeItemClickLinstener(HomeItemClickLinstener clickLinstener) {
        this.mItemLinstener = clickLinstener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mItemImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemImg = (ImageView) itemView.findViewById(R.id.item_img);

        }
    }
}
