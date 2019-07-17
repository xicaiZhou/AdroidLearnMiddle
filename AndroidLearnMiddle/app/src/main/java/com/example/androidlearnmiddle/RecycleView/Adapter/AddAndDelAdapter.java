package com.example.androidlearnmiddle.RecycleView.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidlearnmiddle.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddAndDelAdapter extends RecyclerView.Adapter {

    private Context context;
    private OnItemClick onItemClick;

    private List<String> data;

    public AddAndDelAdapter(Context context, OnItemClick onItemClick, List<String> data) {
        this.context = context;
        this.onItemClick = onItemClick;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AddAndDelAdapter.addAndDelViewHolder(LayoutInflater.from(context).inflate(R.layout.layou_rv_vertical,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        ((addAndDelViewHolder)viewHolder).tv.setText(data.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class addAndDelViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public addAndDelViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.rv_vertical_tv);
        }
    }

    public interface OnItemClick{
        void onClick(int pos);
    }

    public void refresh(List<String> data){
        this.data = data;
        notifyDataSetChanged();
    }
}
