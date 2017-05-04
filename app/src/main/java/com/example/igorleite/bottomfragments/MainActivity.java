package com.example.igorleite.bottomfragments;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.igorleite.bottomfragments.fragments.BaseFragment;
import com.example.igorleite.bottomfragments.fragments.RecentFragment;
import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements BaseFragment.FragmentNavigation, FragNavController.TransactionListener, FragNavController.RootFragmentListener{

    private final int RECENT = FragNavController.TAB1;
    private final int FAVORITES = FragNavController.TAB2;
    private BottomBar bottomBar;

    private FragNavController fragNavController;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = (BottomBar)findViewById(R.id.bottomBar);
        textView = (TextView)findViewById(R.id.textView);
        bottomBar.selectTabAtPosition(FAVORITES);
        fragNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.container)
                .transactionListener(this)
                .rootFragmentListener(this, 2)
                .build();
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.bb_menu_recents:
                        if(fragNavController.getCurrentFrag() instanceof RecentFragment) {
                            RecentFragment r = (RecentFragment)fragNavController.getCurrentFrag();
                            r.setText("mudouuuu");
                        } else {
                            Toast.makeText(MainActivity.this, "Recents", Toast.LENGTH_SHORT).show();
                        }


                        break;
                }
            }
        });
        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                fragNavController.clearStack();
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(!fragNavController.isRootFragment()){
            fragNavController.popFragment();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {

    }

    @Override
    public Fragment getRootFragment(int i) {
        switch (i){
            case RECENT:
                return RecentFragment.newInstance(0);
            case FAVORITES:

        }
        throw new IllegalStateException("need to send an index that we know");
    }

    @Override
    public void onTabTransaction(Fragment fragment, int i) {

    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {

    }
}
