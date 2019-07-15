package com.example.androidlearnmiddle.RecycleView.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidlearnmiddle.R;

public class verticalAdapter extends RecyclerView.Adapter<verticalAdapter.verticalViewHolder> {


    private Context context;

    private OnItemClickListener listener;

    public verticalAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public verticalAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public verticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new verticalViewHolder(LayoutInflater.from(context).inflate(R.layout.layou_rv_vertical,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull verticalViewHolder viewHolder, final int i) {
        viewHolder.tv.setText("成功了！");

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

    //3.创建viewHolder
     class verticalViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        public verticalViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.rv_vertical_tv);

        }
    }

    public interface OnItemClickListener{

        void onClick(int pos);
    }
}
