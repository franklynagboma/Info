package com.franklyn.info.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.franklyn.info.util.CountryFile;

import java.util.ArrayList;


/**
 * Created by AGBOMA franklyn on 7/9/16.
 */

public class AppController extends Application{

    private static AppController instance;

    public static ArrayList<String> countryList;

    //registration
    public static String EMAIL_PRE = "";
    public static String PASSWORD_PRE = "";

    //personal
    public static String FIRST_NAME = "";
    public static String LAST_NAME = "";
    public static String OTHER_NAMES = "";
    public static String GENDER = "";
    //contact
    public static String MOBILE_NUMBER = "";
    public static String COUNTRY_NAME = "";
    public static String EMAIL_ADDRESS = "";
    public static String ALT_EMAIL_ADDRESS = "";
    //decisionFragment
    public static String DECISION1 = "";
    public static String DECISION2 = "";
    public static String DECISION3 = "";
    public static String DECISION4 = "";
    public static String DECISION5 = "";
    public static String DECISION6 = "";
    //formingFragment
    public static String FORMING1 = "";
    public static String FORMING2 = "";
    public static String FORMING3 = "";
    public static String FORMING4 = "";
    //information
    public static String INFORMATION1 = "";
    public static String INFORMATION2 = "";
    public static String INFORMATION3 = "";
    public static String INFORMATION4 = "";
    public static String INFORMATION5 = "";
    public static String INFORMATION6 = "";
    public static String INFORMATION7 = "";
    public static String INFORMATION8 = "";
    public static String INFORMATION9 = "";
    public static String INFORMATION10 = "";
    //personality
    public static String PERSONALITY1 = "";
    public static String PERSONALITY2 = "";
    public static String PERSONALITY3 = "";
    public static String PERSONALITY4 = "";
    public static String PERSONALITY5 = "";
    public static String PERSONALITY6 = "";
    public static String PERSONALITY7 = "";
    public static String PERSONALITY8 = "";
    public static String PERSONALITY9 = "";
    public static String PERSONALITY10 = "";
    //Details
    public static String SUMMARY = "";
    public static String JOB = "";
    public static String YEAR_EXP = "";
    public static String CURRENTLY = "";
    //skills and experience
    public static String PRO_LANG = "";
    public static ArrayList<String> LIST_PRO_LANG = new ArrayList<>();
    public static String OCCUPATION_NAME = "";
    public static String WORK_EXPERIENCE = "";
    public static String DEVELOPER = "";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        countryList = new ArrayList<>();
        CountryFile.getCountryList(this);
    }

    public static synchronized AppController getInstance() {
        return instance;
    }

    /*public Typeface getProximaFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(),
                "fonts/proxima-nova-regular.tff");
    }
    public Typeface getDroidSanFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(),
                "fonts/droidserif-bold.tff");
    }
    public Typeface getAndroidFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(),
                "fonts/androidclock.tff");
    }
    public Typeface getRalewayBoldFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(),
                "fonts/raleway-bold.tff");
    }
    public Typeface getRalewayHeavy(Context context) {
        return Typeface.createFromAsset(context.getAssets(),
                "fonts/raleway-heavy.tff");
    }*/
}
