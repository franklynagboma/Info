package com.franklyn.info.ui.fragments.pagers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.franklyn.info.R;

/**
 * Created by AGBOMA franklyn on 7/8/16.
 */

public class SocialConnectionsPagerFragment extends Fragment{


    @SuppressLint("ValidFragment")
    public SocialConnectionsPagerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View social = inflater.inflate(R.layout.fragment_social_cont_pager, container, false);
        return social;
    }
}
