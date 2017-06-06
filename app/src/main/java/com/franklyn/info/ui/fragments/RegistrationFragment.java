package com.franklyn.info.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.franklyn.info.R;
import com.franklyn.info.ui.activities.Info;

/**
 * Created by AGBOMA franklyn on 2/24/17.
 */

public class RegistrationFragment extends Fragment implements View.OnClickListener{

    private final String LOG_TAG = RegistrationFragment.class.getSimpleName();
    public static final String SAVED = "saved";
    public static final String SAVED_FILL = "saved_fill";

    private InputMethodManager inputMethod;
    private LinearLayout saveOnly, saveAndInfo;
    private CardView eCard, pwCard, cpwCard;
    private TextInputLayout eInput, pwInput,cpwInput;
    private EditText emailReg, passwordReg, confirmPasswordReg;
    //private ImageView seePwd, seeCpwd;
    //private boolean seeP, seeCp;

    public Registered filled;

    public interface Registered {
        void filledCompleted(String type, String email, String password);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            filled = (Registered) context;
        }
        catch (ClassCastException i) {
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View regView = inflater.inflate(R.layout.fragment_registration, container, false);
        init(regView);
        setViewElevator(regView);
        return regView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.save_only:
                if(checkEditField(v)) {
                    String getEmail = emailReg.getText().toString().trim();
                    String getPassword = passwordReg.getText().toString();

                    Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
                    filled.filledCompleted(SAVED, getEmail, getPassword);
                }
                break;

            case R.id.save_and_info:
                if(checkEditField(v)) {
                    String getEmail = emailReg.getText().toString();
                    String getPassword = passwordReg.getText().toString();

                    Toast.makeText(getActivity(), "Saved and fill Info", Toast.LENGTH_SHORT).show();
                    filled.filledCompleted(SAVED_FILL, getEmail, getPassword);
                }
                break;

            /*case R.id.see_pw_reg:
                if(!seeP) {
                    passwordReg.setTransformationMethod(PasswordTransformationMethod
                            .getInstance());
                    seePwd.setImageResource(R.drawable.asterisk);
                    seeP = true;
                }
                else {
                    passwordReg.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());
                    seePwd.setImageResource(R.drawable.circular_image);
                    seeP = false;
                }
                break;
            case R.id.see_cpw_reg:
                if(!seeCp) {
                    confirmPasswordReg.setTransformationMethod(PasswordTransformationMethod
                            .getInstance());
                    seeCpwd.setImageResource(R.drawable.asterisk);
                    seeCp = true;
                }
                else {
                    confirmPasswordReg.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());
                    seeCpwd.setImageResource(R.drawable.circular_image);
                    seeCp = false;
                }
                break;*/
        }
    }
    private void init(View view) {

        inputMethod = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        saveOnly = (LinearLayout) view.findViewById(R.id.save_only);
        saveAndInfo= (LinearLayout) view.findViewById(R.id.save_and_info);
        saveOnly.setOnClickListener(this);
        saveAndInfo.setOnClickListener(this);

        eCard = (CardView) view.findViewById(R.id.email_card);
        pwCard= (CardView) view.findViewById(R.id.password_card);
        cpwCard = (CardView) view.findViewById(R.id.confirm_password_card);

        eInput = (TextInputLayout) view.findViewById(R.id.email_reg);
        pwInput = (TextInputLayout) view.findViewById(R.id.password_reg);
        cpwInput = (TextInputLayout) view.findViewById(R.id.confirm_password_reg);

        emailReg = (EditText) view.findViewById(R.id.email_edit_reg);
        passwordReg = (EditText) view.findViewById(R.id.password_edit_reg);
        confirmPasswordReg = (EditText) view.findViewById(R.id.confirm_password_edit_reg);

        /*seePwd = (ImageView) view.findViewById(R.id.see_pw_reg);
        seePwd.setOnClickListener(this);
        seeCpwd = (ImageView) view.findViewById(R.id.see_cpw_reg);
        seeCpwd.setOnClickListener(this);*/
    }

    private void setViewElevator(View view) {


        emailReg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus) {

                    pwInput.setBackgroundResource(R.color.white_light);
                    cpwInput.setBackgroundResource(R.color.white_light);

                    eInput.setBackgroundResource(R.color.white);
                    eInput.animate();
                    inputMethod.showSoftInput(emailReg, InputMethodManager.SHOW_IMPLICIT);

                    //set elevator false for others and true for this focus
                    eCard.setCardElevation(10f);
                    eCard.setRadius(1f);

                    pwCard.setCardElevation(0f);
                    pwCard.setRadius(0f);
                    cpwCard.setCardElevation(0f);
                    cpwCard.setRadius(0f);

                }
                else {
                    inputMethod.hideSoftInputFromInputMethod(emailReg.getWindowToken(), 0);
                    eInput.setBackgroundResource(R.color.white_light);
                    eCard.setCardElevation(0f);
                    eCard.setRadius(0f);
                }
            }
        });

        passwordReg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus) {

                    eInput.setBackgroundResource(R.color.white_light);
                    cpwInput.setBackgroundResource(R.color.white_light);

                    pwInput.setBackgroundResource(R.color.white);
                    pwInput.animate();
                    inputMethod.showSoftInput(passwordReg, InputMethodManager.SHOW_IMPLICIT);

                    //set elevator false for others and true for this focus
                    pwCard.setCardElevation(10f);
                    pwCard.setRadius(1f);

                    eCard.setCardElevation(0f);
                    eCard.setRadius(0f);
                    cpwCard.setCardElevation(0f);
                    cpwCard.setRadius(0f);

                }
                else {
                    inputMethod.hideSoftInputFromInputMethod(passwordReg.getWindowToken(), 0);
                    pwInput.setBackgroundResource(R.color.white_light);
                    pwCard.setCardElevation(0f);
                    pwCard.setRadius(0f);
                }
            }
        });

        confirmPasswordReg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus) {

                    eInput.setBackgroundResource(R.color.white_light);
                    pwInput.setBackgroundResource(R.color.white_light);

                    cpwInput.setBackgroundResource(R.color.white);
                    cpwInput.animate();
                    inputMethod.showSoftInput(confirmPasswordReg, InputMethodManager.SHOW_IMPLICIT);

                    //set elevator false for others and true for this focus
                    cpwCard.setCardElevation(10f);
                    cpwCard.setRadius(1f);

                    eCard.setCardElevation(0f);
                    eCard.setRadius(0f);
                    pwCard.setCardElevation(0f);
                    pwCard.setRadius(0f);

                }
                else {
                    inputMethod.hideSoftInputFromInputMethod(confirmPasswordReg.getWindowToken(), 0);
                    cpwInput.setBackgroundResource(R.color.white_light);
                    cpwCard.setCardElevation(0f);
                    cpwCard.setRadius(0f);
                }
            }
        });
    }

    private boolean checkEditField(View v) {

        String getEmail = emailReg.getText().toString();
        String getPassword = passwordReg.getText().toString();
        String getConfirmPassword = confirmPasswordReg.getText().toString();

        if(getEmail.isEmpty() && getPassword.isEmpty()
                && getConfirmPassword.isEmpty()) {
            Info.snackBar(v, "Empty fields");
            emailReg.requestFocus();
            return false;
        }
        else if(getPassword.isEmpty() && getConfirmPassword.isEmpty()) {
            Info.snackBar(v, "Empty fields");
            passwordReg.requestFocus();
            return false;
        }


        if(TextUtils.isEmpty(emailReg.getText().toString())) {
            Info.snackBar(v, "Email field is empty");
            emailReg.setError("Input email");
            emailReg.requestFocus();
            return false;
        }
        else if(!getEmail.contains("@")
                || !getEmail.contains(".") || getEmail.contains(" ")) {
            Info.snackBar(v, "Not a valid email");
            emailReg.setError("Input email");
            emailReg.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(passwordReg.getText().toString())
                || getPassword.length() < 6) {
            Info.snackBar(v, getPassword.length() <= 0 ? "Password field is empty" : "Too short");
            passwordReg.setError(getPassword.length() <= 0 ? "Input password" : "Weak");
            passwordReg.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(confirmPasswordReg.getText().toString())) {
            Info.snackBar(v, "Confirm field is empty");
            confirmPasswordReg.setError("Input password");
            confirmPasswordReg.requestFocus();
            return false;
        }
        else if(!getPassword.equals(getConfirmPassword)){
            //check if the password is equal
            Info.snackBar(v, "Passwords does not match");
            confirmPasswordReg.setError("Not match");
            confirmPasswordReg.requestFocus();
            return false;
        }

        return true;
        //return (checkCondition == 4);
    }

}
