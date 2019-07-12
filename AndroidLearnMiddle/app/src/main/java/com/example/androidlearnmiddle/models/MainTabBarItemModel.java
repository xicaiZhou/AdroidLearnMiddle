package com.example.androidlearnmiddle.models;

import com.flyco.tablayout.listener.CustomTabEntity;

public class MainTabBarItemModel implements CustomTabEntity {

    private String title;
    private int icon;

    public MainTabBarItemModel(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return icon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
