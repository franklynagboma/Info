package com.franklyn.info.ui.fragments.pagers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.franklyn.info.R;
import com.franklyn.info.app.AppController;
import com.franklyn.info.helper.io.TextChecker;
import com.franklyn.info.ui.activities.InfoCredentialsActivity;

/**
 * Created by AGBOMA franklyn on 7/8/16.
 */

public class ContactPagerFragment extends Fragment {

    @SuppressLint("ValidFragment")
    public ContactPagerFragment() {
    }

    private final String LOG_TAG = ContactPagerFragment.class.getSimpleName();

    private EditText mobileNumber, emailAddress, altEmailAddress;
    private AutoCompleteTextView countryName;
    private ArrayAdapter<String> autoTextAdapter;

    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String COUNTRY_NAME = "country_name";
    public static final String EMAIL_ADDRESS = "email_address";
    public static final String ALT_EMAIL_ADDRESS = "alt_email_address";

    public static boolean contactBoolean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View contact = inflater.inflate(R.layout.fragment_contact_pager, container, false);

        initialize(contact);
        eventHandler(contact);

        return contact;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(this.isVisible()) {
            if(!isVisibleToUser) {
                try {

                    if(TextUtils.isEmpty(countryName.getText().toString())
                            || TextUtils.isEmpty(mobileNumber.getText().toString())
                            || TextUtils.isEmpty(emailAddress.getText().toString())
                            || TextUtils.isEmpty(altEmailAddress.getText().toString()) ) {

                        Toast.makeText(getActivity(), "Contact Information, incompletely",
                                Toast.LENGTH_SHORT).show();
                        contactBoolean = false;
                    }
                    else
                        contactBoolean = true;
                }
                catch (Exception i){
                    i.printStackTrace();
                    Log.e(LOG_TAG, i.getMessage());
                }
            }
        }
    }

    private void initialize(View init) {

        /*((TextView) init.findViewById(R.id.text_country_code))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));
        ((TextView) init.findViewById(R.id.text_email_name))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));
        ((TextView) init.findViewById(R.id.text_alt_name))
                .setTypeface(AppController.getInstance().getProximaFace(getActivity()));*/

        //countryCode.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));
        mobileNumber = (EditText) init.findViewById(R.id.mobile_number);
        //mobileNumber.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));
        emailAddress = (EditText) init.findViewById(R.id.email_name);
        emailAddress.setText(!InfoCredentialsActivity.getEmailPre.equals("")
                ? InfoCredentialsActivity.getEmailPre : AppController.EMAIL_PRE);
        Log.e(LOG_TAG, "Email saved " + AppController.EMAIL_PRE);
        //emailAddress.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));
        altEmailAddress = (EditText) init.findViewById(R.id.alt_name);
        //altEmailAddress.setTypeface(AppController.getInstance().getRalewayBoldFace(getActivity()));

        countryName = (AutoCompleteTextView) init.findViewById(R.id.country_name);
        autoTextAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.spinner_text,
                AppController.countryList);

        countryName.setAdapter(autoTextAdapter);
        countryName.setThreshold(1);

    }

    private void eventHandler(View event) {

        countryName.addTextChangedListener(new TextChecker(getActivity(),COUNTRY_NAME));
        mobileNumber.addTextChangedListener(new TextChecker(getActivity(),MOBILE_NUMBER));
        emailAddress.addTextChangedListener(new TextChecker(getActivity(),EMAIL_ADDRESS));
        altEmailAddress.addTextChangedListener(new TextChecker(getActivity(),ALT_EMAIL_ADDRESS));
    }
}
