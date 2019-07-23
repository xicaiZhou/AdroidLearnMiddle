package com.example.androidlearnmiddle.Glide.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseGlideActivity extends BaseActivity {

    @BindView(R.id.title_navbar)
    TextView titleNavbar;
    @BindView(R.id.tv_baseGlide_1)
    TextView tvBaseGlide1;
    @BindView(R.id.Iv_baseGlide_1)
    ImageView IvBaseGlide1;
    @BindView(R.id.tv_baseGlide_2)
    TextView tvBaseGlide2;
    @BindView(R.id.Iv_baseGlide_2)
    ImageView IvBaseGlide2;
    @BindView(R.id.tv_baseGlide_3)
    TextView tvBaseGlide3;
    @BindView(R.id.Iv_baseGlide_3)
    ImageView IvBaseGlide3;
    @BindView(R.id.tv_baseGlide_4)
    TextView tvBaseGlide4;
    @BindView(R.id.Iv_baseGlide_4)
    ImageView IvBaseGlide4;
    @BindView(R.id.tv_baseGlide_5)
    TextView tvBaseGlide5;
    @BindView(R.id.Iv_baseGlide_5)
    ImageView IvBaseGlide5;
    @BindView(R.id.tv_baseGlide_6)
    TextView tvBaseGlide6;
    @BindView(R.id.Iv_baseGlide_6)
    ImageView IvBaseGlide6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_glide);
        ButterKnife.bind(this);


        initNavBar("Glide基本使用");
        initdata();
    }

    private void initdata() {

        tvBaseGlide1.setText("加载网络图片");
        Glide.with(this).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1785199001,3375299815&fm=27&gp=0.jpg").into(IvBaseGlide1);

        tvBaseGlide2.setText("加载资源图片");
        Glide.with(this).load(R.mipmap.ic_launcher).into(IvBaseGlide2);

        tvBaseGlide3.setText("加载本地SD卡图片");// /storage/emulated/0/zzz.jpeg
        String path = Environment.getExternalStorageDirectory()+"/zzz.jpeg";
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Glide.with(this).load(uri).into(IvBaseGlide3);

        tvBaseGlide4.setText("加载网络gif图片");
        Glide.with(this).load("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2239880928,283080147&fm=26&gp=0.jpg").placeholder(R.mipmap.ic_launcher).into(IvBaseGlide4);

        tvBaseGlide5.setText("加载小视频快照");
        String path1 = Environment.getExternalStorageDirectory()+"/1563753814797200.mp4";
        File file1 = new File(path);
        Uri uri1 = Uri.fromFile(file);
        Glide.with(this).load(uri1).into(IvBaseGlide5);

        tvBaseGlide6.setText("设置缩略图比例，然后先加载缩略图在加载原图");
        Glide.with(this).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1785199001,3375299815&fm=27&gp=0.jpg").thumbnail(0.1f).centerCrop().placeholder(R.mipmap.ic_launcher).into(IvBaseGlide6);

    }

}
