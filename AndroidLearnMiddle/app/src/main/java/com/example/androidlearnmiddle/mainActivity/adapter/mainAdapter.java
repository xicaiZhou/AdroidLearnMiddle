package com.example.androidlearnmiddle.mainActivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.fragments.TabBarOneFragment;
import com.example.androidlearnmiddle.mainActivity.model.myModel;

import java.util.ArrayList;
import java.util.List;

public class mainAdapter extends BaseAdapter {


    private Context context;
    private List<myModel> data;


    public mainAdapter(Context context, List<myModel> data) {
        this.context = context;
        this.data = data;
    }

    public mainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return data == null? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder{
        TextView title;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.main_listview_item, viewGroup, false);
            holder = new ViewHolder();
            holder.title = view.findViewById(R.id.main_item_title);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.title.setText(data.get(i).getTitleText());

        return view;
    }
}
