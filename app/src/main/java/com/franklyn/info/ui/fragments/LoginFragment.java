package com.franklyn.info.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.franklyn.info.R;
import com.franklyn.info.ui.activities.InfoCredentialsActivity;

/**
 * Created by AGBOMA Franklyn on 3/18/2016.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    //log class
    private String logTag = LoginFragment.class.getSimpleName();
    private View loginView;

    private InputMethodManager inputManager;

    //private AppCompatEditText userKey;
    private EditText userEmail, userKey;
    private TextInputLayout emailInput, keyInput;
    private CardView emailCard, keyCard;

    private Button loginButton;
    private CircularProgressButton loginProgress;
    private LinearLayout infoSignUp;


    public logIn notReg;

    public interface logIn {
        void register(String getText);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            notReg = (logIn) context;
        }catch (ClassCastException i) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loginView = inflater.inflate(R.layout.fragment_login, container, false);

        //initialize resources
        initializeView();
        //set views listener
        setViewsListener();

        return loginView;
    }

    private void initializeView() {

        inputManager = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);


        emailCard = (CardView) loginView.findViewById(R.id.email_card);
        keyCard = (CardView) loginView.findViewById(R.id.key_card);

        emailInput = (TextInputLayout) loginView.findViewById(R.id.email);
        keyInput = (TextInputLayout) loginView.findViewById(R.id.key);



        userKey = (EditText) loginView.findViewById(R.id.user_key);
        //userKey.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));

        userEmail = (EditText) loginView.findViewById(R.id.user_email);
        //userEmail.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));

        //login's buttons
        loginButton = (Button) loginView.findViewById(R.id.login_button);
        //loginButton.setTypeface(AppController.getInstance().getAndroidFace(getActivity()));

        loginProgress = (CircularProgressButton) loginView.findViewById(R.id.login_progress);
        loginProgress.setVisibility(View.GONE);

        infoSignUp = (LinearLayout) loginView.findViewById(R.id.info_signup);

    }

    private void setViewsListener() {


        userEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    keyInput.setBackgroundResource(R.color.white_light);
                    emailInput.setBackgroundResource(R.color.white);
                    emailInput.animate();
                    inputManager.showSoftInput(userEmail, InputMethodManager.SHOW_IMPLICIT);

                    //set elevation for edit text true and others false.
                    emailCard.setCardElevation(10f);
                    emailCard.setRadius(1f);
                    keyCard.setCardElevation(0f);
                    keyCard.setRadius(0f);
                } else {
                    inputManager.hideSoftInputFromWindow(userEmail.getWindowToken(), 0);
                }
            }
        });


        userKey.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    emailInput.setBackgroundResource(R.color.white_light);
                    keyInput.setBackgroundResource(R.color.white);
                    keyInput.animate();
                    inputManager.showSoftInput(userKey, InputMethodManager.SHOW_IMPLICIT);

                    //set elevation for edit text true and others false.
                    keyCard.setCardElevation(10f);
                    keyCard.setRadius(1f);
                    emailCard.setCardElevation(0f);
                    emailCard.setRadius(0f);
                } else {
                    inputManager.hideSoftInputFromWindow(userKey.getWindowToken(), 0);
                }
            }
        });

        //set Send to userKey
        userKey.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean send = false;

                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Log.e(logTag, "Send Login Details");

                    inputManager.showSoftInput(userKey, InputMethodManager.HIDE_IMPLICIT_ONLY);
                    checkTextField();
                    send = true;
                }
                return send;
            }
        });


        loginButton.setOnClickListener(this);
        infoSignUp.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                checkTextField();
                break;
            case R.id.info_signup:
                notReg.register(InfoCredentialsActivity.FILL);
                break;
        }
    }

    private void checkTextField() {

        if(TextUtils.isEmpty(userEmail.getText().toString())) {
            InfoCredentialsActivity.snackBar(loginView, "Email field is empty");
            userEmail.setError("Input Email");
            userEmail.requestFocus();

        }
        if(TextUtils.isEmpty(userKey.getText().toString())) {
            InfoCredentialsActivity.snackBar(loginView, "InfoCredentialsActivity key field is empty");
            userKey.setError("Input InfoCredentialsActivity key");
            userKey.requestFocus();
        }
        if(TextUtils.isEmpty(userEmail.getText().toString())
                && TextUtils.isEmpty(userKey.getText().toString())) {

            InfoCredentialsActivity.snackBar(loginView,"Fields cannot be empty");
            userEmail.requestFocus();
        }

        if(!TextUtils.isEmpty(userEmail.getText().toString())
                && !TextUtils.isEmpty(userKey.getText().toString())) {

            if( !userEmail.getText().toString().contains("@")
                    || !userEmail.getText().toString().contains(".")){

                userEmail.setError("Invalid email");
                userEmail.requestFocus();
            }

            else if( !userKey.getText().toString().contains("INFO")
                    || !userKey.getText().toString().contains("AAF")) {

                userKey.setError("Invalid key");
                userKey.requestFocus();
            }

            else {
                runProgressButton();
            }
        }


    }

    private void runProgressButton() {

        //other widgets not operational
        loginButton.setVisibility(View.GONE);
        userEmail.setEnabled(false);
        userKey.setEnabled(false);


        //progress operational
        loginProgress.setVisibility(View.VISIBLE);
        loginProgress.setIndeterminateProgressMode(true);
        loginProgress.setProgress(50);

        Log.e(logTag, "Login");

        //sleep for 8 sec.
        Thread spendTime = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for(int time =0; time <8; time ++) {

                        Thread.sleep(1000);
                        Log.e(logTag, "time: "+String.valueOf(time)+" sec\n");
                    }
                }
                catch (Exception i){
                    i.printStackTrace();
                    Log.e(logTag, String.valueOf(i));
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        stopProgressButton();
                    }
                });
            }
        }); spendTime.start();

    }

    private void stopProgressButton() {

        Log.e(logTag, "No data found");
        InfoCredentialsActivity.snackBar(loginView, "No data found");
        //progress operational
        loginProgress.setProgress(0);
        loginProgress.setIndeterminateProgressMode(false);
        loginProgress.setVisibility(View.GONE);

        //other widgets not operational
        loginButton.setVisibility(View.VISIBLE);
        userEmail.setEnabled(true);
        userKey.setEnabled(true);

    }

}
