package com.franklyn.info.ui.fragments.pagers.quetionaire;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.franklyn.info.R;
import com.franklyn.info.app.AppController;

/**
 * Created by AGBOMA franklyn on 2/26/17.
 */

public class InformationPreFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{


    @SuppressLint("ValidFragment")
    public InformationPreFragment() {
    }

    private final String LOG_TAG = InformationPreFragment.class.getSimpleName();

    private RadioGroup g1,g2,g3,g4,g5,g6,g7,g8,g9,g10;
    private AppCompatRadioButton A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,
            B1,B2,B3,B4,B5,B6,B7,B8,B9,B10;
    private int v1 = -1,v2 = -1,v3 = -1,v4 = -1, v5 = -1,
            v6 = -1, v7 = -1, v8 = -1, v9 = -1, v10 = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View infoPre = inflater.inflate(R.layout.fragment_information_pre, container, false);
        init(infoPre);
        return infoPre;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (group.getId()) {
            case R.id.rgInfo1:
                v1 = g1.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo2:
                v2 = g2.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo3:
                v3 = g3.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo4:
                v4 = g4.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo5:
                v5 = g5.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo6:
                v6 = g6.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo7:
                v7 = g7.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo8:
                v8 = g8.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo9:
                v9 = g9.getCheckedRadioButtonId();
                break;
            case R.id.rgInfo10:
                v10 = g10.getCheckedRadioButtonId();
                break;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //this check for view is visible to set screen interaction
        if(this.isVisible()) {
            //is becoming invisible that is, leaving the fragment then,
            if(!isVisibleToUser) {
                try {

                    //get string from radio button
                    if(v1 != -1 && v2 != -1 && v3 != -1 && v4 != -1 && v5 != -1
                            && v6 != -1  && v7 != -1  && v8 != -1  && v9 != -1  && v10 != -1 ) {

                        if(v1 == R.id.rbInfo1A) {
                            AppController.INFORMATION1 = A1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION1);
                        }
                        else {
                            AppController.INFORMATION1 = B1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION1);
                        }

                        if(v2 == R.id.rbInfo2A) {
                            AppController.INFORMATION2 = A2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION2);
                        }
                        else {
                            AppController.INFORMATION2 = B2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION2);
                        }

                        if(v3 == R.id.rbInfo3A) {
                            AppController.INFORMATION3 = A3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION3);
                        }
                        else {
                            AppController.INFORMATION3 = B3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION3);
                        }

                        if(v4 == R.id.rbInfo4A) {
                            AppController.INFORMATION4 = A4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION4);
                        }
                        else {
                            AppController.INFORMATION4 = B4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION4);
                        }

                        if(v5 == R.id.rbInfo5A) {
                            AppController.INFORMATION5 = A5.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION5);
                        }
                        else {
                            AppController.INFORMATION5 = B5.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION5);
                        }

                        if(v6 == R.id.rbInfo6A) {
                            AppController.INFORMATION6 = A6.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION6);
                        }
                        else {
                            AppController.INFORMATION6 = B6.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION6);
                        }

                        if(v7 == R.id.rbInfo7A) {
                            AppController.INFORMATION7 = A7.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION7);
                        }
                        else {
                            AppController.INFORMATION7 = B7.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION7);
                        }

                        if(v8 == R.id.rbInfo8A) {
                            AppController.INFORMATION8 = A8.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION8);
                        }
                        else {
                            AppController.INFORMATION8 = B8.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION8);
                        }

                        if(v9 == R.id.rbInfo9A) {
                            AppController.INFORMATION9 = A9.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION9);
                        }
                        else {
                            AppController.INFORMATION9 = B9.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION9);
                        }

                        if(v10 == R.id.rbInfo10A) {
                            AppController.INFORMATION10 = A10.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION10);
                        }
                        else {
                            AppController.INFORMATION10 = B10.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.INFORMATION10);
                        }

                    }
                    else
                        Toast.makeText(getActivity(), "Answer information questionnaire",
                                Toast.LENGTH_SHORT).show();
                }
                catch (Exception i) {
                    i.printStackTrace();
                    Log.e(LOG_TAG, i.getMessage());
                }

            }
        }
    }

    private void init(View infoPre) {

        g1 = (RadioGroup) infoPre.findViewById(R.id.rgInfo1);
        A1 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo1A);
        B1 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo1B);
        g1.setOnCheckedChangeListener(this);

        g2 = (RadioGroup) infoPre.findViewById(R.id.rgInfo2);
        A2 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo2A);
        B2 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo2B);
        g2.setOnCheckedChangeListener(this);

        g3 = (RadioGroup) infoPre.findViewById(R.id.rgInfo3);
        A3 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo3A);
        B3 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo3B);
        g3.setOnCheckedChangeListener(this);

        g4 = (RadioGroup) infoPre.findViewById(R.id.rgInfo4);
        A4 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo4A);
        B4 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo4B);
        g4.setOnCheckedChangeListener(this);

        g5 = (RadioGroup) infoPre.findViewById(R.id.rgInfo5);
        A5 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo5A);
        B5 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo5B);
        g5.setOnCheckedChangeListener(this);

        g6 = (RadioGroup) infoPre.findViewById(R.id.rgInfo6);
        A6 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo6A);
        B6 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo6B);
        g6.setOnCheckedChangeListener(this);

        g7 = (RadioGroup) infoPre.findViewById(R.id.rgInfo7);
        A7 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo7A);
        B7 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo7B);
        g7.setOnCheckedChangeListener(this);

        g8 = (RadioGroup) infoPre.findViewById(R.id.rgInfo8);
        A8 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo8A);
        B8 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo8B);
        g8.setOnCheckedChangeListener(this);

        g9 = (RadioGroup) infoPre.findViewById(R.id.rgInfo9);
        A9 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo9A);
        B9 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo9B);
        g9.setOnCheckedChangeListener(this);

        g10 = (RadioGroup) infoPre.findViewById(R.id.rgInfo10);
        A10 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo10A);
        B10 = (AppCompatRadioButton) infoPre.findViewById(R.id.rbInfo10B);
        g10.setOnCheckedChangeListener(this);
    }
}
