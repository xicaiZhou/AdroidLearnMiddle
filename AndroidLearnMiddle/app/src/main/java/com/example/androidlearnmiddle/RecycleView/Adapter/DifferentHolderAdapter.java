package com.example.androidlearnmiddle.RecycleView.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidlearnmiddle.R;

public class DifferentHolderAdapter extends RecyclerView.Adapter {

    private Context context;
    private OnItemClick onItemClick;

    public DifferentHolderAdapter(Context context, OnItemClick onItemClick) {
        this.context = context;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i % 2 == 0){
             return new DifferentHolerOne(LayoutInflater.from(context).inflate(R.layout.layou_rv_vertical,viewGroup,false));
        }else {
            return new DifferentHolerTwo(LayoutInflater.from(context).inflate(R.layout.layout_different_holder,viewGroup,false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0? 0:1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (i % 2 == 0){
            ((DifferentHolerOne)viewHolder).tv.setText("asdasda");
        }else {
            ((DifferentHolerTwo)viewHolder).tv.setText("asdasda");
            ((DifferentHolerTwo)viewHolder).im.setImageResource(R.mipmap.ic_launcher);

        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class DifferentHolerOne extends RecyclerView.ViewHolder{

        private TextView tv;
        public DifferentHolerOne(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.rv_vertical_tv);
        }
    }
    static class DifferentHolerTwo extends RecyclerView.ViewHolder{
        private TextView tv;
        private ImageView im;
        public DifferentHolerTwo(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_different);
            im = itemView.findViewById(R.id.im_different);
        }
    }

    public interface OnItemClick{
        void onClikc(int pos);
    }
}
