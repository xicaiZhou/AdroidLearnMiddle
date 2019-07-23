package com.example.androidlearnmiddle.Glide.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.androidlearnmiddle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideAdapter extends RecyclerView.Adapter<GlideAdapter.viewHolder> {

    private Context context;

    public String[] stringData;

    public GlideAdapter(String[] stringData) {
        this.stringData = stringData;
    }

    public GlideAdapter(Context context, String[] stringData) {
        this.context = context;
        this.stringData = stringData;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.gilde_viewholder,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {

        Glide.with(context)
                .load(stringData[i])
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imageView);
    }

    static class viewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.gride_viewholder_im)
        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public int getItemCount() {
        return stringData.length;
    }
}
