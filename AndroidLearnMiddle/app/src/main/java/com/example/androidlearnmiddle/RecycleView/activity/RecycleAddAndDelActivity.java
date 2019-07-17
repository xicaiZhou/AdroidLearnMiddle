package com.example.androidlearnmiddle.RecycleView.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.RecycleView.Adapter.AddAndDelAdapter;
import com.example.androidlearnmiddle.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecycleAddAndDelActivity extends BaseActivity {


    @BindView(R.id.rv_addAndDel)
    public RecyclerView recyclerView;

    public List<String> data;

    public AddAndDelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_add_and_del);

        ButterKnife.bind(this);
        initNavBar("item的添加和删除");

        initView();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(RecycleAddAndDelActivity.this);
        recyclerView.setLayoutManager(manager);

        data = new ArrayList<>();
        data.add("第一个");

        adapter = new AddAndDelAdapter(RecycleAddAndDelActivity.this, new AddAndDelAdapter.OnItemClick() {
            @Override
            public void onClick(int pos) {

            }
        },data);
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.rv_add)
    public void add(View v){
        data.add("新加了一个");
        adapter.refresh(data);
    }
    @OnClick(R.id.rv_del)
    public void del(View v){
        if (data.size() == 0) {
            Toast.makeText(RecycleAddAndDelActivity.this, "没有数据了~~要不去先添加一个吧", Toast.LENGTH_SHORT).show();
            return;
        }
        data.remove(0);
        adapter.refresh(data);
    }


}
