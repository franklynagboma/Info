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

        String INFO_NAME = "account_name";
        String INFO_EMAIL = "email_name";
        String INFO_GENDER = "gender";
        String INFO_WHICH_IMAGE = "which_image";
        String INFO_IMAGE = "image";
        String INFO_PHONE_NUMBER = "phone_number";
        String INFO_COUNTRY = "country_name";
        String INFO_SKILLS = "skills";
        String INFO_OCCUPATION = "occupation";
        String INFO_OCCUPATION_NAME = "occupation_name";
        String INFO_WORK_EXPERIENCE = "work_experience";
        String INFO_LINKEDIN = "linkedin_account";
        String INFO_FACEBOOK = "facebook_account";
        String INFO_TWITTER = "twitter_account";
        String INFO_PLAY_STORE = "play_store_account";
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
                _ID, INFO_NAME, INFO_EMAIL, INFO_GENDER, INFO_IMAGE,INFO_WHICH_IMAGE,
                INFO_PHONE_NUMBER, INFO_COUNTRY, INFO_SKILLS, INFO_OCCUPATION,
                INFO_OCCUPATION_NAME, INFO_WORK_EXPERIENCE, INFO_LINKEDIN,
                INFO_FACEBOOK, INFO_TWITTER, INFO_PLAY_STORE
        };

        public static final String SORT_ORDER = _ID + " ASC";

    }

}