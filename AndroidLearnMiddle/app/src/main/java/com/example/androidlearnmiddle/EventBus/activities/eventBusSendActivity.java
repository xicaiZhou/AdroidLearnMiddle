package com.example.androidlearnmiddle.EventBus.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidlearnmiddle.EventBus.events.MessageEvent;
import com.example.androidlearnmiddle.EventBus.events.MessageStickyEvent;
import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class eventBusSendActivity extends BaseActivity {


    @BindView(R.id.eventbus_result_sticky)
    public TextView result_sticky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.eventBus_post_sticky)
    public void post(){
        //粘性消息发送界面的步骤4、注册
        //*****注意只能注册一次，否则crash！
        EventBus.getDefault().register(eventBusSendActivity.this);
    }
    //粘性消息发送界面的步骤3、接受数据方法
    //******必须要写sticky = true
    @Subscribe(sticky = true)
    public void MessageStickyEvent(MessageStickyEvent event){
        result_sticky.setText(event.msg)   ;
    }

    @OnClick(R.id.eventBus_push_sticky)
    public void push(){
        EventBus.getDefault().post(new MessageEvent("还可以哦！"));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
