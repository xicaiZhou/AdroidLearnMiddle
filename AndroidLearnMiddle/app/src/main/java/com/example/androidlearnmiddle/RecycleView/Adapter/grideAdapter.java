package com.example.androidlearnmiddle.RecycleView.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidlearnmiddle.R;

public class grideAdapter extends RecyclerView.Adapter<grideAdapter.grideViewHolder> {

    private Context context;
    private OnItemClickListener listener;

    public grideAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public grideViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new grideViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_rv_gride, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull grideViewHolder viewHolder, final int i) {

        if (i == 2){ viewHolder.tv.setText("这是第二个这是第二个这是第二个这是第二个这是第二个这是第二个这是第二个");}
        else{viewHolder.tv.setText("222211231");}

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class grideViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public grideViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.rv_gride_tv);
        }
    }

    public interface OnItemClickListener{

        void onClick(int pos);
    }

}
