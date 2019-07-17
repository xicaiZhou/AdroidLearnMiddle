package com.example.androidlearnmiddle.RecycleView.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.androidlearnmiddle.R;

public class staggerAdapter extends RecyclerView.Adapter<staggerAdapter.staggeredViewHolder> {


    private Context context;
    private  OnItemClick onItemClick;

    public staggerAdapter(Context context, OnItemClick onItemClick) {
        this.context = context;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public staggeredViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new staggeredViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_rv_staggered, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull staggeredViewHolder viewHolder, final int i) {
        if (i % 2== 0){
            viewHolder.im.setImageResource(R.drawable.staggeredone);
        }else {
            viewHolder.im.setImageResource(R.drawable.staggeredtwo);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(i);

            }
        });
    }



    @Override
    public int getItemCount() {
        return 20;
    }

    static class staggeredViewHolder extends RecyclerView.ViewHolder{

        private ImageView im;
        public staggeredViewHolder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.staggered_im);
        }
    }

    public interface OnItemClick{

        void onClick(int pos);
    }
}
