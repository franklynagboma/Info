package com.franklyn.info.ui.fragments.pagers;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.franklyn.info.R;
import com.franklyn.info.app.AppController;
import com.franklyn.info.helper.io.TextChecker;

import org.w3c.dom.Text;

/**
 * Created by AGBOMA franklyn on 7/8/16.
 */

public class PersonalPagerFragment extends Fragment {


    @SuppressLint("ValidFragment")
    public PersonalPagerFragment() {
    }


    private final String LOG_TAG = PersonalPagerFragment.class.getSimpleName();

    private EditText firstName, lastName, otherNames;
    private RadioGroup gender;

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String OTHER_NAMES = "other_names";

    public static boolean personalBoolean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View personal = inflater.inflate(R.layout.fragment_personal_pager, container, false);

        initialize(personal);
        eventHandler(personal);

        return personal;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(this.isVisible()) {
            if(!isVisibleToUser) {
                try {

                    if(TextUtils.isEmpty(firstName.getText().toString())
                            || TextUtils.isEmpty(lastName.getText().toString())
                            || TextUtils.isEmpty(otherNames.getText().toString())
                            || gender.getCheckedRadioButtonId() == -1) {

                        Toast.makeText(getActivity(), "Personal Information, incompletely",
                                Toast.LENGTH_SHORT).show();
                        personalBoolean = false;
                    }
                    else
                        personalBoolean = true;
                }
                catch (Exception i){
                    i.printStackTrace();
                    Log.e(LOG_TAG, i.getMessage());
                }
            }
        }
    }

    private void initialize(View init) {

        /*((TextView) init.findViewById(R.id.text_first_name))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));
        ((TextView) init.findViewById(R.id.text_last_name))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));
        ((TextView) init.findViewById(R.id.text_other_names))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));
        ((TextView) init.findViewById(R.id.text_nok))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));
        ((TextView) init.findViewById(R.id.text_gender_name))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));*/

        firstName = (EditText) init.findViewById(R.id.first_name);
        //firstName.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));
        lastName = (EditText) init.findViewById(R.id.last_name);
        //lastName.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));
        otherNames = (EditText) init.findViewById(R.id.other_names);
        //otherNames.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));

        gender = (RadioGroup) init.findViewById(R.id.radio_gender);

    }

    private void eventHandler(View event) {

        firstName.addTextChangedListener(new TextChecker(getActivity(), FIRST_NAME));
        lastName.addTextChangedListener(new TextChecker(getActivity(), LAST_NAME));
        otherNames.addTextChangedListener(new TextChecker(getActivity(), OTHER_NAMES));

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                AppCompatRadioButton radioMale = (AppCompatRadioButton)
                        radioGroup.findViewById(R.id.radio_male);
                AppCompatRadioButton radioFemale = (AppCompatRadioButton)
                        radioGroup.findViewById(R.id.radio_female);

                if(radioMale.isChecked()) {
                    AppController.GENDER = radioMale.getText().toString();
                }
                if(radioFemale.isChecked()) {
                    AppController.GENDER = radioFemale.getText().toString();
                }
            }
        });
    }
}
