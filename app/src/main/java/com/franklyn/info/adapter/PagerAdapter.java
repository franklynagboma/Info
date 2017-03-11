package com.franklyn.info.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.franklyn.info.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGBOMA franklyn on 7/8/16.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private final String LOG_TAG = PagerAdapter.class.getSimpleName();

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitle = new ArrayList<>();

    public PagerAdapter(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }

    public void addFragment(String title, Fragment fragment) {
        fragmentTitle.add(title);
        fragmentList.add(fragment);
        Log.e(LOG_TAG, "Fragment added");
    }

}
