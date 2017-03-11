package com.franklyn.info.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.franklyn.info.R;

/**
 * Created by AGBOMA Franklyn on 3/11/2016.
 */
public class InfoSignUpFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View infoSignUp = inflater.inflate(R.layout.fragment_info_sign_up, container, false);

        return infoSignUp;
    }
}
