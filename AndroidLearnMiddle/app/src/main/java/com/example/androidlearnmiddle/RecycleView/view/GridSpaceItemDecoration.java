package com.example.androidlearnmiddle.RecycleView.view;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;
    //构造方法
    public GridSpaceItemDecoration(int space){
        mSpace = space;
    }

    //方法注释快捷键 /**加回车
    /**
     *
     * @param outRect Item的矩形边距
     * @param view  ItemView
     * @param parent RecyclerView
     * @param state  RecyclerView的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
        outRect.bottom = mSpace;


    }
}
