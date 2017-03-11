package com.franklyn.info.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.franklyn.info.R;


/**
 * Created by AGBOMA Franklyn on 3/11/2016.
 */
public class InfoUserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View userView = inflater.inflate(R.layout.fragment_user, container, false);

        return  userView;

    }

    /*implements View.OnClickListener,
        LoaderManager.LoaderCallbacks<Cursor>{


    private String logTag = InfoUserFragment.class.getSimpleName();

    public static TextView userEmail, userName, userMobile,
    userCountry, userSkills, userOccupation, userSchool,
    userCompany, userWorked, userDescription, userLinked,
    userFacebook, userTwitter, userPlayStore;

    private TextView school, company;

    private LinearLayout edit;
    private RelativeLayout sendEmail;


    //shareperference
    public SharedPreferences profileName, email;
    public SharedPreferences.Editor emailEdit;

    //keys
    public static final String EMAIL = "email";

    //String details
    private String pName, eEmail;
    private static final String ALT = "Alt: ";
    private String add;

    String tname = "", temail = "", tnewEmail = "", taddEmail = "";

    private SimpleCursorAdapter cursorAdapter;

    String[] column = {
            InfoContract.InfoProfileColumn.INFO_NAME,
            InfoContract.InfoProfileColumn.INFO_EMAIL,
            InfoContract.InfoProfileColumn.INFO_PHONE_NUMBER,
            InfoContract.InfoProfileColumn.INFO_COUNTRY,
            InfoContract.InfoProfileColumn.INFO_SKILLS,
            InfoContract.InfoProfileColumn.INFO_OCCUPATION,
            InfoContract.InfoProfileColumn.INFO_OCCUPATION_SCHOOL,
            InfoContract.InfoProfileColumn.INFO_OCCUPATION_COMPANY,
            InfoContract.InfoProfileColumn.INFO_WORK_EXPERIENCE,
            InfoContract.InfoProfileColumn.INFO_BRIFE_DESCRIPTION,
            InfoContract.InfoProfileColumn.INFO_LINKEDIN,
            InfoContract.InfoProfileColumn.INFO_FACEBOOK,
            InfoContract.InfoProfileColumn.INFO_TWITTER,
            InfoContract.InfoProfileColumn.INFO_PLAY_STORE
    };

    int[] resources = {
            R.id.about_name,
            R.id.user_profileEmail,
            R.id.user_mobile,
            R.id.country_name,
            R.id.skills_names,
            R.id.occupation_name,
            R.id.school_name,
            R.id.company_name,
            R.id.worked_name,
            R.id.user_about,
            R.id.linkedin,
            R.id.facebook,
            R.id.twitter,
            R.id.google_play
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View userView = inflater.inflate(R.layout.fragment_user, container, false);

        setPreference();

        Bundle bundle = getArguments();
        if(bundle != null) {
            checkBundle(bundle);
        }

        init(userView);

        return  userView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new CursorLoader(
                getActivity(),
                InfoContract.InfoProfile.CONTENT_URI,
                InfoContract.InfoProfile.PROJECTIONS,
                null,
                null,
                InfoContract.InfoProfile.SORT_ORDER
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if(data != null) {
            setUpUI(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }


    private void setPreference()  {

        profileName = getActivity()
                .getSharedPreferences(UserHeaderFragment.NAME, Context.MODE_PRIVATE);
        email = getActivity()
                .getSharedPreferences(EMAIL, Context.MODE_PRIVATE);


        pName = profileName.getString(UserHeaderFragment.NAME, "");
        eEmail = email.getString(EMAIL, "");
    }

    private void checkBundle(Bundle bundle) {

        tname = bundle.getString(Info.NAME);
        temail = bundle.getString(Info.EMAIL);
        tnewEmail = bundle.getString(Info.NEW_EMAIL);
        taddEmail = bundle.getString(Info.ADD_EMAIL);

        Log.e(logTag, "Bundle:\n "
                + tname + "\n"
                + temail + "\n"
                + tnewEmail);

        *//** checking which string has the email name
         * to save.
         *//*

        if(!tnewEmail.isEmpty()) {

            emailEdit = email.edit();
            emailEdit.putString(EMAIL, tnewEmail);
            emailEdit.apply();

            Log.e(logTag, "tnewEmail:\n " + tnewEmail);
        }
        else if(!taddEmail.isEmpty()) {

            add = eEmail + "\n\n" + ALT+taddEmail;
            emailEdit = email.edit();
            emailEdit.putString(EMAIL, add);
            emailEdit.apply();

            Log.e(logTag, "taddEmail:\n "
                    + taddEmail + "\n add:"
                    + add);
        }
        else {

            //save user details
            emailEdit = email.edit();
            emailEdit.putString(EMAIL, temail);
            emailEdit.apply();

            Log.e(logTag, "SharePreference:\n " + eEmail);
        }


    }

    private void init(View userView) {

        *//*cursorAdapter = new SimpleCursorAdapter(
                getActivity(),
                R.layout.fragment_user,
                null,
                column,
                resources,
                0);*//*

        userEmail = (TextView) userView.findViewById(R.id.user_profileEmail);
        userMobile = (TextView) userView.findViewById(R.id.user_mobile);
        userCountry = (TextView) userView.findViewById(R.id.country_name);
        userSkills = (TextView) userView.findViewById(R.id.skills_names);
        userOccupation = (TextView) userView.findViewById(R.id.occupation_name);
        userSchool = (TextView) userView.findViewById(R.id.school_name);
        userCompany = (TextView) userView.findViewById(R.id.company_name);
        userName = (TextView) userView.findViewById(R.id.about_name);
        userWorked = (TextView) userView.findViewById(R.id.worked_name);
        userDescription = (TextView) userView.findViewById(R.id.user_about);
        userLinked = (TextView) userView.findViewById(R.id.linkedin);
        userFacebook = (TextView) userView.findViewById(R.id.facebook);
        userTwitter = (TextView) userView.findViewById(R.id.twitter);
        userPlayStore = (TextView) userView.findViewById(R.id.google_play);

        school = (TextView) userView.findViewById(R.id.school);
        company = (TextView) userView.findViewById(R.id.company);

        edit = (LinearLayout) userView.findViewById(R.id.edit);
        sendEmail = (RelativeLayout) userView.findViewById(R.id.send_email_layout);

        if(tname.isEmpty() && temail.isEmpty()) {

            *//** From the recall of the fragment,
             * email might have being changed
             *//*
            if(!tnewEmail.isEmpty()) {

                userEmail.setText(tnewEmail);
            }
            else if(!taddEmail.isEmpty()) {

                userEmail.setText(add);
            }
            else {

                userEmail.setText(eEmail);
            }

            //set name to about
            userName.setText(pName);

        }
        else {

            userEmail.setText(temail);

            userName.setText(tname);

        }

       // clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        //set onclick
        edit.setOnClickListener(this);
        sendEmail.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.edit:

                new EmailOptionalFragment().show(
                        getActivity().getSupportFragmentManager(), "dialog_fragment");
                break;

            case R.id.send_email_layout:

                new SendEmailFragment().show(
                        getActivity().getSupportFragmentManager(), "send_email_fragment");

                break;
        }

    }


    private void setUpUI(Cursor data) {

        if(getActivity() == null) {
            return;
        }
        else {
            if(data.moveToFirst()){

                String uEmail = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_EMAIL));
                String uName = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_NAME));
                String uMobile = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_PHONE_NUMBER));
                String uCountry = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_COUNTRY));
                String uSkills = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_SKILLS));
                String uOccupation = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_OCCUPATION));
                String uSchool = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_OCCUPATION_SCHOOL));
                String uCompany = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_OCCUPATION_COMPANY));
                String uWorked = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_WORK_EXPERIENCE));
                String uDescription = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_BRIFE_DESCRIPTION));
                String uLinkedIn = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_LINKEDIN));
                String uFaceBook = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_FACEBOOK));
                String uTwitter = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_TWITTER));
                String uGooglePlayStore = data.getString(
                        data.getColumnIndex(InfoContract.InfoProfile.INFO_PLAY_STORE));


                //set String text
                userEmail.setText(uEmail);
                userName.setText(uName);
                userMobile.setText(uMobile);
                userCountry.setText(uCountry);
                userSkills.setText(uSkills);
                userOccupation.setText(uOccupation);

                if(uOccupation.equalsIgnoreCase("school")) {

                    company.setVisibility(View.GONE);
                    userCompany.setVisibility(View.GONE);
                    userSchool.setText(uSchool);

                }
                else {

                    school.setVisibility(View.GONE);
                    userSchool.setVisibility(View.GONE);
                    userCompany.setText(uCompany);
                }

                userWorked.setText(uWorked);
                userDescription.setText(uDescription);
                userLinked.setText(uLinkedIn);
                userFacebook.setText(uFaceBook);
                userTwitter.setText(uTwitter);
                userPlayStore.setText(uGooglePlayStore);

            }
        }
    }


    public void setProfileImage(CircularImageView imageView, String url) {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache(){

            private final LruCache<String, Bitmap> get = new LruCache<>(10);

            @Override
            public Bitmap getBitmap(String s) {
                return get.get(s);
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {
                get.put(s, bitmap);
            }
        }
        );

        imageView.setImageUrl(url, imageLoader);
    }*/
}
