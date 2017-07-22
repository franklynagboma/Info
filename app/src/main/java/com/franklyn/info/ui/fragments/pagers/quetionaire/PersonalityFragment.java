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

public class PersonalityFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{

    @SuppressLint("ValidFragment")
    public PersonalityFragment() {
    }


    private final String LOG_TAG = PersonalityFragment.class.getSimpleName();

    private RadioGroup g1,g2,g3,g4,g5,g6,g7,g8,g9,g10;
    private AppCompatRadioButton A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,
            B1,B2,B3,B4,B5,B6,B7,B8,B9,B10;
    private int v1 = -1,v2 = -1,v3 = -1,v4 = -1, v5 = -1,
            v6 = -1, v7 = -1, v8 = -1, v9 = -1, v10 = -1;

    public static boolean personalityBoolean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View person = inflater.inflate(R.layout.fragment_personality, container, false);
        init (person);
        return person;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (group.getId()) {
            case R.id.rgPersonality1:
                v1 = g1.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality2:
                v2 = g2.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality3:
                v3 = g3.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality4:
                v4 = g4.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality5:
                v5 = g5.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality6:
                v6 = g6.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality7:
                v7 = g7.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality8:
                v8 = g8.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality9:
                v9 = g9.getCheckedRadioButtonId();
                break;
            case R.id.rgPersonality10:
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

                        if(v1 == R.id.rbPersonality1A) {
                            AppController.PERSONALITY1 = A1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY1);
                        }
                        else {
                            AppController.PERSONALITY1 = B1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY1);
                        }

                        if(v2 == R.id.rbPersonality2A) {
                            AppController.PERSONALITY2 = A2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY2);
                        }
                        else {
                            AppController.PERSONALITY2 = B2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY2);
                        }

                        if(v3 == R.id.rbPersonality3A) {
                            AppController.PERSONALITY3 = A3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY3);
                        }
                        else {
                            AppController.PERSONALITY3 = B3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY3);
                        }

                        if(v4 == R.id.rbPersonality4A) {
                            AppController.PERSONALITY4 = A4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY4);
                        }
                        else {
                            AppController.PERSONALITY4 = B4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY4);
                        }

                        if(v5 == R.id.rbPersonality5A) {
                            AppController.PERSONALITY5 = A5.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY5);
                        }
                        else {
                            AppController.PERSONALITY5 = B5.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY5);
                        }

                        if(v6 == R.id.rbPersonality6A) {
                            AppController.PERSONALITY6 = A6.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY6);
                        }
                        else {
                            AppController.PERSONALITY6 = B6.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY6);
                        }

                        if(v7 == R.id.rbPersonality7A) {
                            AppController.PERSONALITY7 = A7.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY7);
                        }
                        else {
                            AppController.PERSONALITY7 = B7.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY7);
                        }

                        if(v8 == R.id.rbPersonality8A) {
                            AppController.PERSONALITY8 = A8.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY8);
                        }
                        else {
                            AppController.PERSONALITY8 = B8.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY8);
                        }

                        if(v9 == R.id.rbPersonality9A) {
                            AppController.PERSONALITY9 = A9.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY9);
                        }
                        else {
                            AppController.PERSONALITY9 = B9.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY9);
                        }

                        if(v10 == R.id.rbPersonality10A) {
                            AppController.PERSONALITY10 = A10.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY10);
                        }
                        else {
                            AppController.PERSONALITY10 = B10.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.PERSONALITY10);
                        }

                        personalityBoolean = true;
                    }
                    else {
                        personalityBoolean = false;
                        Toast.makeText(getActivity(), "Answer personality questionnaire",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception i) {
                    i.printStackTrace();
                    Log.e(LOG_TAG, i.getMessage());
                }

            }
        }
    }

    private void init(View person) {

        g1 = (RadioGroup) person.findViewById(R.id.rgPersonality1);
        A1 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality1A);
        B1 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality1B);
        g1.setOnCheckedChangeListener(this);

        g2 = (RadioGroup) person.findViewById(R.id.rgPersonality2);
        A2 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality2A);
        B2 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality2B);
        g2.setOnCheckedChangeListener(this);

        g3 = (RadioGroup) person.findViewById(R.id.rgPersonality3);
        A3 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality3A);
        B3 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality3B);
        g3.setOnCheckedChangeListener(this);

        g4 = (RadioGroup) person.findViewById(R.id.rgPersonality4);
        A4 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality4A);
        B4 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality4B);
        g4.setOnCheckedChangeListener(this);

        g5 = (RadioGroup) person.findViewById(R.id.rgPersonality5);
        A5 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality5A);
        B5 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality5B);
        g5.setOnCheckedChangeListener(this);

        g6 = (RadioGroup) person.findViewById(R.id.rgPersonality6);
        A6 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality6A);
        B6 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality6B);
        g6.setOnCheckedChangeListener(this);

        g7 = (RadioGroup) person.findViewById(R.id.rgPersonality7);
        A7 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality7A);
        B7 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality7B);
        g7.setOnCheckedChangeListener(this);

        g8 = (RadioGroup) person.findViewById(R.id.rgPersonality8);
        A8 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality8A);
        B8 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality8B);
        g8.setOnCheckedChangeListener(this);

        g9 = (RadioGroup) person.findViewById(R.id.rgPersonality9);
        A9 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality9A);
        B9 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality9B);
        g9.setOnCheckedChangeListener(this);

        g10 = (RadioGroup) person.findViewById(R.id.rgPersonality10);
        A10 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality10A);
        B10 = (AppCompatRadioButton) person.findViewById(R.id.rbPersonality10B);
        g10.setOnCheckedChangeListener(this);

    }
}
