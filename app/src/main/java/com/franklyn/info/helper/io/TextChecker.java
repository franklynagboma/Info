package com.franklyn.info.helper.io;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.franklyn.info.app.AppController;
import com.franklyn.info.ui.fragments.pagers.ContactPagerFragment;
import com.franklyn.info.ui.fragments.pagers.PersonalPagerFragment;
import com.franklyn.info.ui.fragments.pagers.quetionaire.DetailsFragment;

/**
 * Created by AGBOMA franklyn on 7/9/16.
 */

public class TextChecker implements TextWatcher {

    private final String LOG_TAG = TextChecker.class.getSimpleName();

    private Context context;
    private TextInputLayout inputLayout;
    private String editText;
    private View view;

    private String workExpOne = "";
    private String workExpTwo = "";
    private String workExpThree = "";
    private String workExpFour = "";
    private String workExpFive = "";

    public TextChecker(){}

    public TextChecker(Context context, TextInputLayout inputLayout, String editText) {
        this.context = context;
        this.inputLayout = inputLayout;
        this.editText = editText;
    }

    public TextChecker(Context context, String editText) {
        this.context = context;
        this.editText = editText;
    }

    public TextChecker(View view, String editText) {
        this.view = view;
        this.editText = editText;
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        //get user inputs on AppController.

        //personal
        if(editText.equalsIgnoreCase(PersonalPagerFragment.FIRST_NAME)) {
            AppController.FIRST_NAME = charSequence.toString().trim();
            Log.e(LOG_TAG, "First Name= " + AppController.FIRST_NAME);
        }
        if(editText.equalsIgnoreCase(PersonalPagerFragment.LAST_NAME)) {
            AppController.LAST_NAME = charSequence.toString().trim();
            Log.e(LOG_TAG, "Last Name= " + AppController.LAST_NAME);
        }
        if(editText.equalsIgnoreCase(PersonalPagerFragment.OTHER_NAMES)) {
            AppController.OTHER_NAMES = charSequence.toString().trim();
            Log.e(LOG_TAG, "OtherS Names= " + AppController.OTHER_NAMES);
        }

        //contact
        if(editText.equalsIgnoreCase(ContactPagerFragment.MOBILE_NUMBER)) {
            AppController.MOBILE_NUMBER = charSequence.toString().trim();
            Log.e(LOG_TAG, "Mobile= " + AppController.MOBILE_NUMBER);
        }
        if(editText.equalsIgnoreCase(ContactPagerFragment.COUNTRY_NAME)) {
            AppController.COUNTRY_NAME = charSequence.toString().trim();
            Log.e(LOG_TAG, "Country name= " + AppController.COUNTRY_NAME);
        }
        if(editText.equalsIgnoreCase(ContactPagerFragment.EMAIL_ADDRESS)) {
            AppController.EMAIL_ADDRESS = charSequence.toString().trim();
            Log.e(LOG_TAG, "Email= " + AppController.EMAIL_ADDRESS);
        }
        if(editText.equalsIgnoreCase(ContactPagerFragment.ALT_EMAIL_ADDRESS)) {
            AppController.ALT_EMAIL_ADDRESS = charSequence.toString().trim();
            Log.e(LOG_TAG, "Alt email= " + AppController.ALT_EMAIL_ADDRESS);
        }

        //Details
        if(editText.equalsIgnoreCase(DetailsFragment.SUMMARY)) {
            //inputLayout.setError("Not more than 300 words");
            inputLayout.setError(charSequence.toString().trim().length() + " of 300");
            if(charSequence.toString().trim().length() > 300)
                DetailsFragment.stringLength = false;
            else
                DetailsFragment.stringLength = true;

            AppController.SUMMARY = charSequence.toString().trim();
            Log.e(LOG_TAG, "Summary= " + AppController.SUMMARY);
        }
        if(editText.equalsIgnoreCase(DetailsFragment.JOB)) {
            AppController.JOB = charSequence.toString().trim();
            Log.e(LOG_TAG, "Job= " + AppController.JOB);
        }
        if(editText.equalsIgnoreCase(DetailsFragment.YEAR_EXP)) {
            AppController.YEAR_EXP = charSequence.toString().trim();
            Log.e(LOG_TAG, "Year_exp= " + AppController.YEAR_EXP);
        }

        //skills and experience
        /*if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.PRO_LANG)) {
            AppController.PRO_LANG = charSequence.toString().trim();
            Log.e(LOG_TAG, "Pro lang= " + AppController.PRO_LANG);
        }
        *//*if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.LIST_PRO_LANG)) {
            String getSequence = charSequence.toString().trim();

            if(getSequence.isEmpty())
                AppController.LIST_PRO_LANG = "";
            else {
                if(!AppController.LIST_PRO_LANG.isEmpty()){
                    AppController.LIST_PRO_LANG = AppController.LIST_PRO_LANG
                            + "/"+ getSequence;
                }
                else {
                    AppController.LIST_PRO_LANG = getSequence;
                }
            }
            Log.e(LOG_TAG, "List pro lang= " + AppController.LIST_PRO_LANG);
        }*//*
        if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.OCCUPATION_NAME)) {
            AppController.OCCUPATION_NAME = charSequence.toString().trim();
            Log.e(LOG_TAG, "Occupation= " + AppController.OCCUPATION_NAME);
        }
        if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.WORK_EXP_ONE)) {
            workExpOne = charSequence.toString().trim();
            Log.e(LOG_TAG, "workExpOne= " + workExpOne);
            getWorkExperience();
        }
        if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.WORK_EXP_TWO)) {
            workExpTwo = charSequence.toString().trim();
            Log.e(LOG_TAG, "workExpOne= " + workExpTwo);
            getWorkExperience();
        }
        if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.WORK_EXP_THREE)) {
            workExpThree = charSequence.toString().trim();
            Log.e(LOG_TAG, "workExpOne= " + workExpThree);
            getWorkExperience();
        }
        if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.WORK_EXP_FOUR)) {
            workExpFour = charSequence.toString().trim();
            Log.e(LOG_TAG, "workExpOne= " + workExpFour);
            getWorkExperience();
        }
        if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.WORK_EXP_FIVE)) {
            workExpFive = charSequence.toString().trim();
            Log.e(LOG_TAG, "workExpOne= " + workExpFive);
            getWorkExperience();
        }
        //send now view on skill and experience
        if(editText.equalsIgnoreCase(SkillsNExperiencePagerFragment.EDIT_WRITER)) {
            view.setVisibility(!charSequence.toString().isEmpty()
                    ?View.VISIBLE : View.INVISIBLE);
        }*/
     }

    /*private void getWorkExperience() {
        AppController.WORK_EXPERIENCE = workExpOne +" "+ workExpTwo
                +" "+ workExpThree +" "+workExpFour +" "+workExpFive;
        Log.e(LOG_TAG, "Work Experience= " + AppController.WORK_EXPERIENCE);
    }*/
}
