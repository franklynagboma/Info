package com.franklyn.info.ui.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.franklyn.info.R;
import com.franklyn.info.app.AppController;
import com.franklyn.info.ui.fragments.CompleteSignUpFragment;
import com.franklyn.info.ui.fragments.EmailOptionalFragment;
import com.franklyn.info.ui.fragments.InfoContactsFragment;
import com.franklyn.info.ui.fragments.InfoUserFragment;
import com.franklyn.info.ui.fragments.LoginFragment;
import com.franklyn.info.ui.fragments.RegistrationFragment;
import com.franklyn.info.ui.fragments.SignUpFragment;

/**
 * Created by AGBOMA Franklyn on 3/7/2016.
 */
public class Info extends AppCompatActivity
        implements EmailOptionalFragment.ChangeEmail,
                    LoginFragment.logIn, CompleteSignUpFragment.LoadItems,
                    RegistrationFragment.Registered
                    /*InfoContactsFragment.LoaderFragment*/{

    private String logTag = Info.class.getSimpleName();
    private Toolbar toolbar;
    private FrameLayout header;


    //Shared preferences
    private SharedPreferences pref;
    private SharedPreferences.Editor prefEditor;

    private final String PREF_KEY = "pre";
    private final String EMAIL_KEY = "email_pre";
    private final String PASSWORD_KEY = "user_name_pre";

    public static String getUserNamePre = "";
    public static String getEmailPre = "";
    public static String getPasswordPre = "";
    //End shared preferences

    public static final String NAME ="name";
    public static final String EMAIL = "email";
    public static final String NEW_EMAIL = "new_email";
    public static final String ADD_EMAIL = "add_email";
    public static final String IMAGE = "image";
    public static final String HEADER_NAME ="header_name";
    public static final String BUTTON_GOOGLE = "google_sign_in";
    public static final String BUTTON_INFO = "info_sign_up";

    public static final String FILL = "fill";
    public static final String REG = "reg";
    private final String LOG_IN = "log_in";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        header = (FrameLayout) findViewById(R.id.header_container);


        //get shared preference storage
        pref = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
        AppController.EMAIL_PRE = pref.getString(EMAIL_KEY, "");
        AppController.PASSWORD_PRE = pref.getString(PASSWORD_KEY, "");


     /*   toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }*/

        if(getResources().getConfiguration().smallestScreenWidthDp <= 600) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        //user register
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.info_container, new CompleteSignUpFragment())
                .commit();*/

        //user login 1
        /*header.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.info_container, new InfoLoginFragment())
                .commit();*/

        //user login 2
        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.info_container, new LoginFragment(), LOG_IN)
                .commit();*/
        getSupportFragmentManager().beginTransaction()
                .add(R.id.info_container, new SignUpFragment(), FILL)
                .commit();

        //contacts list
        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.info_container, new InfoContactsFragment())
                .commit();*/

        //user profile
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.header_container, new UserHeaderFragment())
                .commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.info_container, new InfoUserFragment())
                .commit();*/
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if(getSupportFragmentManager().findFragmentByTag(REG) != null
                && getSupportFragmentManager().findFragmentByTag(REG).isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new LoginFragment(), LOG_IN).commit();

        else if(getSupportFragmentManager().findFragmentByTag(FILL) != null
                && getSupportFragmentManager().findFragmentByTag(FILL).isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new LoginFragment(), LOG_IN).commit();

        else
            this.finish();
    }

    /*@Override
    public void clickedOn(String which, String name, String email, String image) {

        if(which.equalsIgnoreCase("google sign in")) {

            Bundle setBundle = new Bundle();
            setBundle.putString(BUTTON_GOOGLE, which);
            setBundle.putString(BUTTON_INFO,"");
            setBundle.putString(HEADER_NAME, name);
            setBundle.putString(IMAGE, image);
            setBundle.putString(EMAIL, email);

            CompleteSignUpFragment completeSignUpFragment = new CompleteSignUpFragment();
            completeSignUpFragment.setArguments(setBundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, completeSignUpFragment)
                    .commit();
             *//*InsertDb.insertInfoProfile(getApplicationContext(), name, email,image);


            header.setVisibility(View.VISIBLE);
            Bundle bundleHeader = new Bundle();
            bundleHeader.putString(HEADER_NAME, name);
            bundleHeader.putString(IMAGE, image);


            Bundle bundleInfo =  new Bundle();
            bundleInfo.putString(NAME, name);
            bundleInfo.putString(EMAIL, email);
            bundleInfo.putString(NEW_EMAIL, "");
            bundleInfo.putString(ADD_EMAIL, "");


            UserHeaderFragment userHeaderFragment = new UserHeaderFragment();
            userHeaderFragment.setArguments(bundleHeader);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.header_container, userHeaderFragment)
                    .commit();

            InfoUserFragment infoUserFragment = new InfoUserFragment();
            infoUserFragment.setArguments(bundleInfo);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, infoUserFragment)
                    .commit();*//*
        }

        else if(which.equalsIgnoreCase("info sign up")) {

            Bundle setBundle = new Bundle();
            setBundle.putString(BUTTON_GOOGLE, "");
            setBundle.putString(BUTTON_INFO,which);
            setBundle.putString(HEADER_NAME, name);
            setBundle.putString(IMAGE, image);
            setBundle.putString(EMAIL, email);

            CompleteSignUpFragment completeSignUpFragment = new CompleteSignUpFragment();
            completeSignUpFragment.setArguments(setBundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, completeSignUpFragment)
                    .commit();

            *//*getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new InfoSignUpFragment())
                    .commit();*//*
        }
    }*/

    @Override
    public void register(String getText) {
        if( !getText.isEmpty()) {

            /*getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new CompleteSignUpFragment(), REG)
                    .commit();*/

            /*getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new SignUpFragment(), FILL)
                    .commit();*/

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new RegistrationFragment(), REG)
                    .commit();
        }
    }

    @Override
    public void filledCompleted(String type, String email, String password) {

        if(null != email){

            getEmailPre = email;
            getPasswordPre = password;
        }

        prefEditor = pref.edit();
        prefEditor.putString(EMAIL_KEY, email);
        prefEditor.putString(PASSWORD_KEY, password);
        prefEditor.apply();

        if(type.equals(RegistrationFragment.SAVED))
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new LoginFragment(), LOG_IN)
                    .commit();

        if(type.equals(RegistrationFragment.SAVED_FILL))
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new SignUpFragment(), FILL)
                    .commit();
    }

    @Override
    public void show(String save) {
        if(!save.isEmpty()) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new InfoContactsFragment())
                    .commit();
        }
    }

    /*@Override
    public void reload(String reload) {
        if(!reload.isEmpty()) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new InfoContactsFragment())
                    .commit();
        }
    }*/

    @Override
    public void newEmail(String email) {

        header.setVisibility(View.VISIBLE);
        Log.e(logTag, "New Email: " + email);

        if(!email.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString(NAME, "");
            bundle.putString(EMAIL, "");
            bundle.putString(ADD_EMAIL, "");
            bundle.putString(NEW_EMAIL, email);

            InfoUserFragment infoUserFragment = new InfoUserFragment();
            infoUserFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, infoUserFragment)
                    .commit();
        }
    }

    @Override
    public void addEmail(String addEmail) {

        header.setVisibility(View.VISIBLE);
        Log.e(logTag, "Added Email: " + addEmail);

        if(!addEmail.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString(NAME, "");
            bundle.putString(EMAIL, "");
            bundle.putString(NEW_EMAIL, "");
            bundle.putString(ADD_EMAIL, addEmail);

            InfoUserFragment infoUserFragment = new InfoUserFragment();
            infoUserFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, infoUserFragment)
                    .commit();
        }
    }

    public static void snackBar(View v,String text) {
        if(v != null) {
            Snackbar.make(v, text, Snackbar.LENGTH_SHORT).show();
        }
    }
}
