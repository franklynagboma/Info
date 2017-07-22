package com.franklyn.info.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.franklyn.info.app.AppController;
import com.franklyn.info.db.provider.InfoContract;

/**
 * Created by AGBOMA franklyn on 6/11/17.
 */

public class LocalDb {

    private final String LOG_TAG = LocalDb.class.getSimpleName();

    private Context context;
    private boolean value;

    public LocalDb(Context context) {
        this.context = context;
    }

    String INFO_SUMMARY = "summary";
    String INFO_JOB_DESCRIPTION = "job_description";
    String INFO_YEARS_OF_EXPERIENCE = "years_of_experience";
    String INFO_CURRENTLY_WORKING = "currently_working";

    public void insertToLocalDb() {
        //place on content value
        ContentValues content = new ContentValues();
        content.put(InfoContract.InfoProfile.INFO_NAME,
                AppController.LAST_NAME.toUpperCase() +" "+ AppController.FIRST_NAME
                        +" "+ AppController.OTHER_NAMES);
        content.put(InfoContract.InfoProfile.INFO_GENDER, AppController.GENDER);
        content.put(InfoContract.InfoProfile.INFO_PHONE_NUMBER, AppController.MOBILE_NUMBER);
        content.put(InfoContract.InfoProfile.INFO_EMAIL, AppController.EMAIL_ADDRESS);
        content.put(InfoContract.InfoProfile.INFO_COUNTRY, AppController.COUNTRY_NAME);

        content.put(InfoContract.InfoProfile.INFO_DECISION_1, AppController.DECISION1);
        content.put(InfoContract.InfoProfile.INFO_DECISION_2, AppController.DECISION2);
        content.put(InfoContract.InfoProfile.INFO_DECISION_3, AppController.DECISION3);
        content.put(InfoContract.InfoProfile.INFO_DECISION_4, AppController.DECISION4);
        content.put(InfoContract.InfoProfile.INFO_DECISION_5, AppController.DECISION5);
        content.put(InfoContract.InfoProfile.INFO_DECISION_6, AppController.DECISION6);

        content.put(InfoContract.InfoProfile.INFO_FORMING_1, AppController.FORMING1);
        content.put(InfoContract.InfoProfile.INFO_FORMING_2, AppController.FORMING2);
        content.put(InfoContract.InfoProfile.INFO_FORMING_3, AppController.FORMING3);
        content.put(InfoContract.InfoProfile.INFO_FORMING_4, AppController.FORMING4);

        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_1, AppController.PERSONALITY1);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_2, AppController.PERSONALITY2);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_3, AppController.PERSONALITY3);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_4, AppController.PERSONALITY4);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_5, AppController.PERSONALITY5);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_6, AppController.PERSONALITY6);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_7, AppController.PERSONALITY7);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_8, AppController.PERSONALITY8);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_9, AppController.PERSONALITY9);
        content.put(InfoContract.InfoProfile.INFO_PERSONALITY_10, AppController.PERSONALITY10);

        content.put(InfoContract.InfoProfile.INFO_INFORMATION_1, AppController.INFORMATION1);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_2, AppController.INFORMATION2);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_3, AppController.INFORMATION3);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_4, AppController.INFORMATION4);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_5, AppController.INFORMATION5);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_6, AppController.INFORMATION6);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_7, AppController.INFORMATION7);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_8, AppController.INFORMATION8);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_9, AppController.INFORMATION9);
        content.put(InfoContract.InfoProfile.INFO_INFORMATION_10, AppController.INFORMATION10);

        content.put(InfoContract.InfoProfile.INFO_SUMMARY, AppController.SUMMARY);
        content.put(InfoContract.InfoProfile.INFO_JOB_DESCRIPTION, AppController.JOB);
        content.put(InfoContract.InfoProfile.INFO_YEARS_OF_EXPERIENCE, AppController.YEAR_EXP);
        content.put(InfoContract.InfoProfile.INFO_CURRENTLY_WORKING, AppController.CURRENTLY);

        //insert data to local db
        context.getContentResolver().insert(InfoContract.InfoProfile.CONTENT_URI, content);
        content.clear();
        value = true;
        Log.e(LOG_TAG, "saved to local");
    }
    public boolean isValue() {
        return value;
    }
}
