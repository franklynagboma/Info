package com.franklyn.info.db.provider;


import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Created by AGBOMA Franklyn on 3/9/2016.
 */
public class InfoContract {

    //Authority
    public static final String AUTHORITY = "com.franklyn.info.db.provider";

    //Base uri
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+AUTHORITY);

    //Path
    public static final String PATH_INFO_PROFILE = "infoprofile";


    //Column Interface InfoProfile
    public interface InfoProfileColumn {

        String INFO_NAME = "names";
        String INFO_GENDER = "gender";
        String INFO_PHONE_NUMBER = "phone_number";
        String INFO_COUNTRY = "country";
        String INFO_EMAIL = "email";
        String INFO_DECISION_1 = "decision_1";
        String INFO_DECISION_2 = "decision_2";
        String INFO_DECISION_3 = "decision_3";
        String INFO_DECISION_4 = "decision_4";
        String INFO_DECISION_5 = "decision_5";
        String INFO_DECISION_6 = "decision_6";
        String INFO_FORMING_1 = "forming_1";
        String INFO_FORMING_2 = "forming_2";
        String INFO_FORMING_3 = "forming_3";
        String INFO_FORMING_4 = "forming_4";
        String INFO_PERSONALITY_1 = "personality_1";
        String INFO_PERSONALITY_2 = "personality_2";
        String INFO_PERSONALITY_3 = "personality_3";
        String INFO_PERSONALITY_4 = "personality_4";
        String INFO_PERSONALITY_5 = "personality_5";
        String INFO_PERSONALITY_6 = "personality_6";
        String INFO_PERSONALITY_7 = "personality_7";
        String INFO_PERSONALITY_8 = "personality_8";
        String INFO_PERSONALITY_9 = "personality_9";
        String INFO_PERSONALITY_10 = "personality_10";
        String INFO_INFORMATION_1 = "information_1";
        String INFO_INFORMATION_2 = "information_2";
        String INFO_INFORMATION_3 = "information_3";
        String INFO_INFORMATION_4 = "information_4";
        String INFO_INFORMATION_5 = "information_5";
        String INFO_INFORMATION_6 = "information_6";
        String INFO_INFORMATION_7 = "information_7";
        String INFO_INFORMATION_8 = "information_8";
        String INFO_INFORMATION_9 = "information_9";
        String INFO_INFORMATION_10 = "information_10";

        String INFO_SUMMARY = "summary";
        String INFO_JOB_DESCRIPTION = "job_description";
        String INFO_YEARS_OF_EXPERIENCE = "years_of_experience";
        String INFO_CURRENTLY_WORKING = "currently_working";
    }



    //Table profile
    public static class InfoProfile implements InfoProfileColumn, BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_INFO_PROFILE).build();

        public static final String CONTENT_DIR_SEARCH = ContentResolver.CURSOR_DIR_BASE_TYPE
                +"/vnd." + AUTHORITY + "." + PATH_INFO_PROFILE;
        public static final String CONTENT_ITEM_SEARCH = ContentResolver.CURSOR_ITEM_BASE_TYPE
                +"/vnd." + AUTHORITY + "." + PATH_INFO_PROFILE;


        public static final String[] PROJECTIONS = {
                _ID, INFO_NAME, INFO_GENDER, INFO_PHONE_NUMBER, INFO_COUNTRY, INFO_EMAIL,
                INFO_DECISION_1, INFO_DECISION_2, INFO_DECISION_3, INFO_DECISION_4, INFO_DECISION_5,
                INFO_DECISION_6,
                INFO_FORMING_1, INFO_FORMING_2, INFO_FORMING_3, INFO_FORMING_4,
                INFO_PERSONALITY_1, INFO_PERSONALITY_2, INFO_PERSONALITY_3, INFO_PERSONALITY_4,
                INFO_PERSONALITY_5, INFO_PERSONALITY_6, INFO_PERSONALITY_7, INFO_PERSONALITY_8,
                INFO_PERSONALITY_9, INFO_PERSONALITY_10,
                INFO_INFORMATION_1, INFO_INFORMATION_2, INFO_INFORMATION_3, INFO_INFORMATION_4,
                INFO_INFORMATION_5, INFO_INFORMATION_6, INFO_INFORMATION_7, INFO_INFORMATION_8,
                INFO_INFORMATION_9, INFO_INFORMATION_10,
                INFO_SUMMARY, INFO_JOB_DESCRIPTION, INFO_YEARS_OF_EXPERIENCE, INFO_CURRENTLY_WORKING
        };

        public static final String SORT_ORDER = _ID + " ASC";

    }

}