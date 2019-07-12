package com.example.androidlearnmiddle.EventBus.activities;

import android.content.Intent;
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

public class eventBusActivity extends BaseActivity {

    @BindView(R.id.eventbus_result)
    public TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);

        ButterKnife.bind(this);

        initNavBar("EventBus");


        /***消息发送界面的步骤***/
        //跳转到消息发送界面的步骤1、注册通知
        EventBus.getDefault().register(this);

    }

    @OnClick(R.id.eventBus_post)
    public void post(){
        /***粘性消息发送界面的步骤***/
        //粘性消息发送界面的步骤1.创建event类（MessageStickyEvent）
        //粘性消息发送界面的步骤2.发送粘性信息
        EventBus.getDefault().postSticky(new MessageStickyEvent("粘性数据"));
        startActivity(new Intent(eventBusActivity.this, eventBusSendActivity.class));

    }
    @OnClick(R.id.eventBus_push)
    public void push(){

        startActivity(new Intent(eventBusActivity.this, eventBusSendActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //跳转到消息发送界面的步骤2.解注册
        EventBus.getDefault().unregister(this);

        //跳转到消息发送界面的步骤3.创建对用event(MessageEvent)
    }
    //跳转到消息发送界面的步骤4.接受
    @Subscribe
    public void MessageEventBus(MessageEvent event){

        resultTV.setText(event.MSG);
    }

}
