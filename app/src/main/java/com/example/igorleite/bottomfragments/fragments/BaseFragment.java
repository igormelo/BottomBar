package com.example.igorleite.bottomfragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.igorleite.bottomfragments.R;

/**
 * Created by igor.leite on 03/05/2017.
 */

public class BaseFragment extends Fragment {
    public static final String ARGS_INSTANCE = "com.ncapdevi.sample.argsInstance";
    FragmentNavigation mFragmentNavigation;
    TextView textView;
    int mInt = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args!=null){
            mInt = args.getInt(ARGS_INSTANCE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        textView = (TextView)view.findViewById(R.id.textView);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentNavigation){
            mFragmentNavigation = (FragmentNavigation) context;
        }
    }

    public interface FragmentNavigation{
        public void pushFragment(Fragment fragment);
    }
}
