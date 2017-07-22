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

public class FormingFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{

    @SuppressLint("ValidFragment")
    public FormingFragment() {
    }

    private final String LOG_TAG = FormingFragment.class.getSimpleName();

    private RadioGroup g1,g2,g3,g4;
    private AppCompatRadioButton A1,A2,A3,A4, B1,B2,B3,B4;
    private int v1 = -1,v2 = -1,v3 = -1,v4 = -1;

    public static boolean formingBoolean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View forming = inflater.inflate(R.layout.fragment_forming, container, false);
        init(forming);
        return forming;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (group.getId()) {
            case R.id.rgForm1:
                v1 = g1.getCheckedRadioButtonId();
                break;
            case R.id.rgForm2:
                v2 = g2.getCheckedRadioButtonId();
                break;
            case R.id.rgForm3:
                v3 = g3.getCheckedRadioButtonId();
                break;
            case R.id.rgForm4:
                v4 = g4.getCheckedRadioButtonId();
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
                    if(v1 != -1 && v2 != -1 && v3 != -1 && v4 != -1) {

                        if(v1 == R.id.rbForm1A) {
                            AppController.FORMING1 = A1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING1);
                        }
                        else {
                            AppController.FORMING1 = B1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING1);
                        }

                        if(v2 == R.id.rbForm2A) {
                            AppController.FORMING2 = A2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING2);
                        }
                        else {
                            AppController.FORMING2 = B2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING2);
                        }

                        if(v3 == R.id.rbForm3A) {
                            AppController.FORMING3 = A3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING3);
                        }
                        else {
                            AppController.FORMING3 = B3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING3);
                        }

                        if(v4 == R.id.rbForm4A) {
                            AppController.FORMING4 = A4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING4);
                        }
                        else {
                            AppController.FORMING4 = B4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.FORMING4);
                        }

                        formingBoolean = true;
                    }
                    else {
                        formingBoolean = false;
                        Toast.makeText(getActivity(), "Answer forming questionnaire",
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

    private void init(View forming) {

        g1 = (RadioGroup) forming.findViewById(R.id.rgForm1);
        A1 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm1A);
        B1 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm1B);
        g1.setOnCheckedChangeListener(this);

        g2 = (RadioGroup) forming.findViewById(R.id.rgForm2);
        A2 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm2A);
        B2 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm2B);
        g2.setOnCheckedChangeListener(this);

        g3 = (RadioGroup) forming.findViewById(R.id.rgForm3);
        A3 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm3A);
        B3 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm3B);
        g3.setOnCheckedChangeListener(this);

        g4 = (RadioGroup) forming.findViewById(R.id.rgForm4);
        A4 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm4A);
        B4 = (AppCompatRadioButton) forming.findViewById(R.id.rbForm4B);
        g4.setOnCheckedChangeListener(this);
    }
}
