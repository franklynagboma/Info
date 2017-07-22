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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.franklyn.info.R;
import com.franklyn.info.app.AppController;

/**
 * Created by AGBOMA franklyn on 2/26/17.
 */

public class DecisionFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{

    @SuppressLint("ValidFragment")
    public DecisionFragment() {
    }

    private final String LOG_TAG = DecisionFragment.class.getSimpleName();

    private RadioGroup g1,g2,g3,g4,g5,g6;
    private AppCompatRadioButton A1,A2,A3,A4,A5,A6, B1,B2,B3,B4,B5,B6;
    private int v1 = -1,v2 = -1,v3 = -1,v4 = -1,v5 = -1,v6 = -1;

    public static boolean decisionBoolean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dec = inflater.inflate(R.layout.fragment_decision, container, false);
        init(dec);
        return dec;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (group.getId()) {
            case R.id.rgDecision1:
                v1 = g1.getCheckedRadioButtonId();
                break;
            case R.id.rgDecision2:
                v2 = g2.getCheckedRadioButtonId();
                break;
            case R.id.rgDecision3:
                v3 = g3.getCheckedRadioButtonId();
                break;
            case R.id.rgDecision4:
                v4 = g4.getCheckedRadioButtonId();
                break;
            case R.id.rgDecision5:
                v5 = g5.getCheckedRadioButtonId();
                break;
            case R.id.rgDecision6:
                v6 = g6.getCheckedRadioButtonId();
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
                    if(v1 != -1 && v2 != -1 && v3 != -1 && v4 != -1 && v5 != -1 && v6 != -1) {

                        if(v1 == R.id.rbDecision1A) {
                            AppController.DECISION1 = A1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION1);
                        }
                        else {
                            AppController.DECISION1 = B1.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION1);
                        }

                        if(v2 == R.id.rbDecision2A) {
                            AppController.DECISION2 = A2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION2);
                        }
                        else {
                            AppController.DECISION2 = B2.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION2);
                        }

                        if(v3 == R.id.rbDecision3A) {
                            AppController.DECISION3 = A3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION3);
                        }
                        else {
                            AppController.DECISION3 = B3.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION3);
                        }

                        if(v4 == R.id.rbDecision4A) {
                            AppController.DECISION4 = A4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION4);
                        }
                        else {
                            AppController.DECISION4 = B4.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION4);
                        }

                        if(v5 == R.id.rbDecision5A) {
                            AppController.DECISION5 = A5.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION5);
                        }
                        else {
                            AppController.DECISION5 = B5.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION5);
                        }

                        if(v6 == R.id.rbDecision6A) {
                            AppController.DECISION6 = A6.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION6);
                        }
                        else {
                            AppController.DECISION6 = B6.getText().toString().trim();
                            Log.e(LOG_TAG, AppController.DECISION6);
                        }
                        decisionBoolean = true;
                    }
                    else {
                        decisionBoolean = false;
                        Toast.makeText(getActivity(), "Answer decision questionnaire",
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

    private void init(View dec) {

        g1 = (RadioGroup) dec.findViewById(R.id.rgDecision1);
        A1 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision1A);
        B1 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision1B);
        g1.setOnCheckedChangeListener(this);

        g2 = (RadioGroup) dec.findViewById(R.id.rgDecision2);
        A2 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision2A);
        B2 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision2B);
        g2.setOnCheckedChangeListener(this);

        g3 = (RadioGroup) dec.findViewById(R.id.rgDecision3);
        A3 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision3A);
        B3 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision3B);
        g3.setOnCheckedChangeListener(this);

        g4 = (RadioGroup) dec.findViewById(R.id.rgDecision4);
        A4 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision4A);
        B4 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision4B);
        g4.setOnCheckedChangeListener(this);

        g5 = (RadioGroup) dec.findViewById(R.id.rgDecision5);
        A5 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision5A);
        B5 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision5B);
        g5.setOnCheckedChangeListener(this);

        g6 = (RadioGroup) dec.findViewById(R.id.rgDecision6);
        A6 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision6A);
        B6 = (AppCompatRadioButton) dec.findViewById(R.id.rbDecision6B);
        g6.setOnCheckedChangeListener(this);

    }
}
