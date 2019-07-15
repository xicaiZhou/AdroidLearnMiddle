package com.example.androidlearnmiddle.RecycleView.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.RecycleView.Adapter.grideAdapter;
import com.example.androidlearnmiddle.RecycleView.view.GridSpaceItemDecoration;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleGrideActivity extends BaseActivity {

    @BindView(R.id.rv_gride)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_gride);

        ButterKnife.bind(this);
        initNavBar("RecycleView网格");
        initView();
    }

    private void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(RecycleGrideActivity.this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new grideAdapter(RecycleGrideActivity.this, new grideAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecycleGrideActivity.this, "你选中了第"+pos+"个" , Toast.LENGTH_SHORT).show();
            }
        }));

        recyclerView.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelOffset(R.dimen.divDerHeight)));

    }
}
