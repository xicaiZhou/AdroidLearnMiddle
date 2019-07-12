package com.example.androidlearnmiddle.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidlearnmiddle.R;
import com.example.androidlearnmiddle.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabBarTwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabBarTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabBarTwoFragment extends BaseFragment {
    public static Fragment newInstance() {
        return new TabBarTwoFragment();
    }

    public TabBarTwoFragment() {

    }
    @Override
    public boolean needEventBus() {
        return false;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_tab_bar_two;
    }
}
