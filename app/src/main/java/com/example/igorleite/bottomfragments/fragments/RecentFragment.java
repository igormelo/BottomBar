package com.example.igorleite.bottomfragments.fragments;

import android.os.Bundle;

/**
 * Created by igor.leite on 03/05/2017.
 */

public class RecentFragment extends BaseFragment {
    public static RecentFragment newInstance(int instance){
        Bundle args = new Bundle();
        RecentFragment fragment = new RecentFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public void setText(String message) {
        textView.setText(message);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
