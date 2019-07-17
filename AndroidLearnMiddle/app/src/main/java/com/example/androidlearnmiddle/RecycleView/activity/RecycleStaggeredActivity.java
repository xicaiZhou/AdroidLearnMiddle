package com.example.androidlearnmiddle.RecycleView.activity;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.RecycleView.Adapter.staggerAdapter;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleStaggeredActivity extends BaseActivity {

    @BindView(R.id.rv_staggered)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_staggered);

        ButterKnife.bind(this);
        initNavBar("RecycleView瀑布流");


        initView();

    }

    private void initView() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new staggerAdapter(RecycleStaggeredActivity.this, new staggerAdapter.OnItemClick() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecycleStaggeredActivity.this, "click..."+ pos, Toast.LENGTH_SHORT).show();
            }
        }));

        recyclerView.addItemDecoration(new myDecoration());
    }

    class myDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int offsets = getResources().getDimensionPixelOffset(R.dimen.divDerHeight);
            outRect.set(offsets,offsets,offsets,offsets);
        }
    }
}
