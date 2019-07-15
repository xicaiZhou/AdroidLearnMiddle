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
import com.example.androidlearnmiddle.RecycleView.Adapter.horiziontalAdapter;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleHorizontalActivity extends BaseActivity {

    @BindView(R.id.rv_horizontal)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_horizontal);
        initNavBar("RecycleView横向滑动");

        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecycleHorizontalActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new horiziontalAdapter(RecycleHorizontalActivity.this, new horiziontalAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecycleHorizontalActivity.this, "你点击了第"+pos+"个", Toast.LENGTH_SHORT).show();
            }
        }));

        recyclerView.addItemDecoration(new myItemDecoration());
    }

    class myItemDecoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.divDerHeight),0);
        }
    }




}
