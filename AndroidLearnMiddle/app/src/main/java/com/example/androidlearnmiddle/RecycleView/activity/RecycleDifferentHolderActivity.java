package com.example.androidlearnmiddle.RecycleView.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.RecycleView.Adapter.DifferentHolderAdapter;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleDifferentHolderActivity extends BaseActivity {


    @BindView(R.id.rv_differentholder)
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_different_holder);

        ButterKnife.bind(this);
        initNavBar("展示不同的ViewHolder");

        initView();

    }

    private void initView() {

        LinearLayoutManager manager = new LinearLayoutManager(RecycleDifferentHolderActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new DifferentHolderAdapter(RecycleDifferentHolderActivity.this, new DifferentHolderAdapter.OnItemClick() {
            @Override
            public void onClikc(int pos) {
                Toast.makeText(RecycleDifferentHolderActivity.this, "你选中了第"+pos+"个" , Toast.LENGTH_SHORT).show();

            }
        }));
    }
}
