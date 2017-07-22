package com.franklyn.info.ui.activities;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.franklyn.info.R;
import com.franklyn.info.ui.fragments.LoginFragment;
import com.franklyn.info.ui.fragments.UserDetailsFragment;
import com.franklyn.info.ui.fragments.UsersFragment;

public class InfoDetailActivity extends AppCompatActivity {

    private final String LOG_TAG = InfoDetailActivity.class.getSimpleName();
    public static final String USERS_DETAILS = "users_details";
    public static final String USERS = "users";
    private int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_detail);
        //screen orientation
        orientation = getResources().getConfiguration().screenWidthDp;
        if(orientation < 600)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        else
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        if(savedInstanceState == null) {
            /*getSupportFragmentManager().beginTransaction()
                    .add(R.id.details_container,new UserDetailsFragment(), USERS_DETAILS)
                    .commit();*/
            UsersFragment usersFragment = new UsersFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(USERS, orientation);
            usersFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.details_container,usersFragment, USERS)
                    .commit();
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //present view to the user.
        Log.e(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //called from onStop
        Log.e(LOG_TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG_TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        /*if(getSupportFragmentManager().findFragmentByTag(REG) != null
                && getSupportFragmentManager().findFragmentByTag(REG).isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new LoginFragment(), LOG_IN).commit();

        else if(getSupportFragmentManager().findFragmentByTag(FILL) != null
                && getSupportFragmentManager().findFragmentByTag(FILL).isVisible())
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.info_container, new LoginFragment(), LOG_IN).commit();

        else
            this.finish();*/
    }
}
