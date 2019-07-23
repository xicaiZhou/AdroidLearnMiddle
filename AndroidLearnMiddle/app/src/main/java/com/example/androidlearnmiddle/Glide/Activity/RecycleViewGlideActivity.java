package com.example.androidlearnmiddle.Glide.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidlearnmiddle.Glide.Adapter.GlideAdapter;
import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewGlideActivity extends BaseActivity {

    @BindView(R.id.glide_recycleview)
    RecyclerView glideRecycleview;


    public String[] stringData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_glide);
        ButterKnife.bind(this);
        initNavBar("RecycleView中使用Glide加载图片");
        initData();
        initView();
    }

    private void initData() {
        stringData = new String[]{"http://img1.imgtn.bdimg.com/it/u=3335121101,2814576492&fm=26&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=1844453092,3739620834&fm=26&gp=0.jpg",
                "http://img3.imgtn.bdimg.com/it/u=2324566899,3353924038&fm=26&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=2984351434,1215877268&fm=26&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=1261751378,3268020697&fm=26&gp=0.jpg",
                "http://img2.imgtn.bdimg.com/it/u=2562372298,495845374&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=307324590,2500914562&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=1790753591,434494595&fm=26&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=1779551219,3508702121&fm=26&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=3836042910,2231747751&fm=26&gp=0.jpg",
                "http://img2.imgtn.bdimg.com/it/u=1342650959,330541917&fm=26&gp=0.jpg"
        };


    }

    private void initView() {
        glideRecycleview.setLayoutManager(new LinearLayoutManager(this));
        glideRecycleview.setAdapter(new GlideAdapter(this,stringData));
    }
}
