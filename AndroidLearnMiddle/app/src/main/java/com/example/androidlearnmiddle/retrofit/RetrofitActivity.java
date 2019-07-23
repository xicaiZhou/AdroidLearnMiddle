package com.example.androidlearnmiddle.retrofit;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;
import com.example.androidlearnmiddle.retrofit.NetWorking.ApiClient;
import com.example.androidlearnmiddle.retrofit.NetWorking.ApiResponse;
import com.example.androidlearnmiddle.retrofit.NetWorking.HttpObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RetrofitActivity extends BaseActivity {

    @BindView(R.id.retrofit_tv)
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ButterKnife.bind(this);
        initNavBar("当前最流行的网络请求Retrofit");

        initData();

    }

    private void initData() {
        ApiClient.api()
                .cook("905662f7548853b1c3c713219dd85345")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpObserver() {
                    @Override
                    public void onResult(boolean ret, ApiResponse apiResponse) {

                        if (ret){
                            textView.setText("请求到了"+apiResponse.getResult());
                        }else {
                            textView.setText("没请求道！");

                        }
                    }
                });
    }
}
