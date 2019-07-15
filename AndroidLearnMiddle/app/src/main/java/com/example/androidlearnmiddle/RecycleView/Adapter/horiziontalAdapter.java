package com.example.androidlearnmiddle.RecycleView.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidlearnmiddle.R;

public class horiziontalAdapter extends RecyclerView.Adapter<horiziontalAdapter.horiziontalViewHolder> {

    private Context context;

    private OnItemClickListener listener;

    public horiziontalAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public horiziontalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new horiziontalViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_rv_horiziontal,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull horiziontalViewHolder viewHolder, final int i) {

        viewHolder.tv.setText("横向滑动也可以了！" + i);

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

    static class horiziontalViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public horiziontalViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.rv_horizontal_tv);
        }
    }

    public interface OnItemClickListener{

        void onClick(int pos);
    }
}
