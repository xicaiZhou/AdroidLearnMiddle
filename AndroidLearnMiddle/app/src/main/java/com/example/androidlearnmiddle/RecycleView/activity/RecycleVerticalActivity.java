package com.example.androidlearnmiddle.RecycleView.activity;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.RecycleView.Adapter.verticalAdapter;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleVerticalActivity extends BaseActivity {

    @BindView(R.id.rv_vertical)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_vertical);

        ButterKnife.bind(this);
        initNavBar("RecycleView纵向滑动");

        initView();
    }

    private void initView() {
//        RecyclerView提供了三种布局管理器：
//
//        LinerLayoutManager 以垂直或者水平列表方式展示Item
//        GridLayoutManager 以网格方式展示Item
//        StaggeredGridLayoutManager 以瀑布流方式展示Item
        recyclerView.setLayoutManager(new LinearLayoutManager(RecycleVerticalActivity.this));

        //2.创建Adapter继承自RecycleView.Adapter 并绑定
        recyclerView.setAdapter(new verticalAdapter(RecycleVerticalActivity.this, new verticalAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecycleVerticalActivity.this, "click..."+ pos, Toast.LENGTH_SHORT).show();
            }
        }));
        //4. 设置间隔样式
        recyclerView.addItemDecoration(new myDecoration());

    }

    class myDecoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.divDerHeight));

        }

    }
}
