package com.franklyn.info.helper;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.franklyn.info.db.provider.InfoContract;

/**
 * Created by AGBOMA Franklyn on 3/23/2016.
 */
public class dbContents {

    private static String logTag = dbContents.class.getSimpleName();

    public static SharedPreferences shared;
    public static SharedPreferences.Editor sharedEdit;
    public static final String PREFERENCE_KEY = "preference_key";
    public static final String NAME_KEY = "name";
    public static final String IMAGE_KEY = "image";
    public static final String IMAGE_TYPE = "image_type";
    private static String getName;
    private static String getImage;
    private static String getImageType;


    private static String dbId;
    private static Context context;
    private static  String dbName, dbEmail,
            dbGender, dbMobile, dbCountry,
            dbDeveloper, dbOccupation, dbOccupationName,
            dbBrief, dbFacebook, dbLinkedIn,
            dbTwitter, dbPlayStore, whichOperation;

    public dbContents(Context cont, String name, String email,
                      String gender, String mobile, String country,
                      String developer, String occupation, String occupationName,
                      String brief, String facebook, String linkedIn,
                      String twitter, String playStore, String which) {

        context = cont; dbName = name; dbEmail = email;
        dbGender = gender; dbMobile = mobile; dbCountry = country;
        dbDeveloper = developer; dbOccupation = occupation; dbOccupationName = occupationName;
        dbBrief = brief; dbFacebook = facebook; dbLinkedIn = linkedIn;
        dbTwitter = twitter; dbPlayStore = playStore; whichOperation = which;

        //check if update is required;
        dbProvider();
    }

    private static void dbProvider() {

        //Todo_ insert
        insert();
        //Todo_ update
        //update();
    }

    private static void insert(){

        /*ContentValues values = new ContentValues();

        values.put(InfoContract.InfoProfile.INFO_NAME,
                dbName);
        values.put(InfoContract.InfoProfile.INFO_EMAIL,
                dbEmail);
        values.put(InfoContract.InfoProfile.INFO_GENDER,
                dbGender);
        values.put(InfoContract.InfoProfile.INFO_IMAGE,
                GalleryCamera.getImage());
        values.put(InfoContract.InfoProfile.INFO_WHICH_IMAGE,
                whichOperation);
        values.put(InfoContract.InfoProfile.INFO_PHONE_NUMBER,
                dbMobile);
        values.put(InfoContract.InfoProfile.INFO_COUNTRY,
                dbCountry);
        values.put(InfoContract.InfoProfile.INFO_SKILLS,
                dbDeveloper);
        values.put(InfoContract.InfoProfile.INFO_OCCUPATION,
                dbOccupation);
        values.put(InfoContract.InfoProfile.INFO_OCCUPATION_NAME,
                dbOccupationName);
        values.put(InfoContract.InfoProfile.INFO_WORK_EXPERIENCE,
                dbBrief);
        values.put(InfoContract.InfoProfile.INFO_LINKEDIN,
                dbLinkedIn);
        values.put(InfoContract.InfoProfile.INFO_FACEBOOK,
                dbFacebook);
        values.put(InfoContract.InfoProfile.INFO_TWITTER,
                dbTwitter);
        values.put(InfoContract.InfoProfile.INFO_PLAY_STORE,
                dbPlayStore);

        context.getContentResolver()
                .insert(InfoContract.InfoProfile.CONTENT_URI, values);

        //clear values for next Table
        values.clear();

        //shared preference
        shared = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        getName = shared.getString(NAME_KEY, "");
        getImage = shared.getString(IMAGE_KEY, "");
        getImageType = shared.getString(IMAGE_TYPE, "");

        sharedEdit = shared.edit();
        sharedEdit.putString(NAME_KEY, dbName);
        sharedEdit.putString(IMAGE_KEY, GalleryCamera.getImage());
        sharedEdit.putString(IMAGE_TYPE, whichOperation);
        sharedEdit.apply();

        Log.e(logTag, "saved on DB");*/
    }


    private static void update() {
    }

}
