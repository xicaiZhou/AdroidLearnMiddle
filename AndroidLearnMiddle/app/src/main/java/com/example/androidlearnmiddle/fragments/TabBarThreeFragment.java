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
 * {@link TabBarThreeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabBarThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabBarThreeFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new TabBarThreeFragment();
    }

    public TabBarThreeFragment() {

    }
    @Override
    public boolean needEventBus() {
        return false;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_tab_bar_three;
    }
}
