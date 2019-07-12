package com.example.androidlearnmiddle.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.androidlearnmiddle.EventBus.activities.eventBusActivity;
import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseFragment;
import com.example.androidlearnmiddle.mainActivity.adapter.mainAdapter;
import com.example.androidlearnmiddle.mainActivity.model.myModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabBarOneFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabBarOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabBarOneFragment extends BaseFragment{


    @BindView(R.id.main_ls)
    public ListView listView;

    private List<myModel> data;

    public static Fragment newInstance() {
        return new TabBarOneFragment();
    }

    public TabBarOneFragment() {

    }
    @Override
    public boolean needEventBus() {
        return false;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_tab_bar_one;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initData() {
        super.initData();
        data = new ArrayList<myModel>();
        data.add(new myModel("EventBus"));
    }

    @Override
    public void initView() {
        super.initView();
        listView.setAdapter(new mainAdapter(getContext(), data));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        getActivity().startActivity(new Intent(getActivity(), eventBusActivity.class));

                        break;

                }
            }
        });

    }

}