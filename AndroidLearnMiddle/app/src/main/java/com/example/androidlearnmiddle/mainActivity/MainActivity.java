package com.example.androidlearnmiddle.mainActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseActivity;
import com.example.androidlearnmiddle.fragments.TabBarOneFragment;
import com.example.androidlearnmiddle.fragments.TabBarThreeFragment;
import com.example.androidlearnmiddle.fragments.TabBarTwoFragment;
import com.example.androidlearnmiddle.mainActivity.model.myModel;
import com.example.androidlearnmiddle.models.MainTabBarItemModel;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab_bottom_bar)
    public CommonTabLayout tabBottomBar;

    private List<myModel> data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initNavBar("Android进阶");
        configTab();
        configFragments(savedInstanceState);

    }
    private void configFragments(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Fragment fragment0 = TabBarOneFragment.newInstance();
            Fragment fragment1 = TabBarTwoFragment.newInstance();
            Fragment fragment2 = TabBarThreeFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, fragment1, "fragment_tab_1").hide(fragment1);
            transaction.add(R.id.fragment_container, fragment2, "fragment_tab_2").hide(fragment2);
            transaction.add(R.id.fragment_container, fragment0, "fragment_tab_0").show(fragment0);
            transaction.commitAllowingStateLoss();
        } else {
            Fragment fragment0 = getSupportFragmentManager().findFragmentByTag("fragment_tab_0");
            Fragment fragment1 = getSupportFragmentManager().findFragmentByTag("fragment_tab_1");
            Fragment fragment2 = getSupportFragmentManager().findFragmentByTag("fragment_tab_2");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragment1);
            transaction.hide(fragment2);
            transaction.show(fragment0);
            transaction.commitAllowingStateLoss();
        }
    }

    private void configTab() {
        ArrayList<CustomTabEntity> tabList = new ArrayList<CustomTabEntity>();
        tabList.add(new MainTabBarItemModel("常用框架", R.drawable.ic_home));
        tabList.add(new MainTabBarItemModel("第三方", R.drawable.ic_query));
        tabList.add(new MainTabBarItemModel("其他", R.drawable.ic_person));
        tabBottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelect(int position) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                for (int i = 0; i < 3; i++) {
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("fragment_tab_" + i);
                    if (i == position) {
                        transaction.show(fragment);
                    } else {
                        transaction.hide(fragment);
                    }
                }
                transaction.commitAllowingStateLoss();

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        tabBottomBar.setTabData(tabList);
    }


}
