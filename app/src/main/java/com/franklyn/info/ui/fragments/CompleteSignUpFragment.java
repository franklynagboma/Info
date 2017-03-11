package com.franklyn.info.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.daimajia.easing.linear.Linear;
import com.franklyn.info.R;
import com.franklyn.info.adapter.PlaceAutocompleteAdapter;
import com.franklyn.info.db.AndroidDatabaseManager;
import com.franklyn.info.helper.GalleryCamera;
import com.franklyn.info.helper.dbContents;
import com.franklyn.info.ui.activities.Info;
import com.franklyn.info.ui.view.CircularImageView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/**
 * Created by AGBOMA Franklyn on 3/16/2016.
 */
public class CompleteSignUpFragment extends Fragment
        implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener,
                GoogleApiClient.OnConnectionFailedListener, View.OnClickListener{

    private String logTag = CompleteSignUpFragment.class.getSimpleName();

    private AutoCompleteTextView  selectCountry;
    private Spinner selectOccupation, selectGender;
    private String[] occupationArr = null;
    private String[] genderArr = null;
    private ArrayAdapter<String> occupationAdp, genderAdp;
    private String which = "", getFullItem, getGender;
    private String none = "", getRadioString = "";
    private EditText writeOccupation, userSkill, mobileNumber, brief,
            facebook, linkedIn, twitter, playStore, userName, userEmail,
            occupationPlace;


    private TextInputLayout textWhichOccupation;
    private RelativeLayout whichLayout, radioEdit;
    private LinearLayout layoutWrite;
    private RadioGroup radioGroup;
    private Button saveButton;

    private ImageView gallery, camera, userProfileImage, returnView;

    private PlaceAutocompleteAdapter placeAdapter;
    private GoogleApiClient googleApiClient;
    public static final LatLngBounds BOUNDS_LATLNG = new LatLngBounds(
            new LatLng(-34.041458, 150.790100), new LatLng(-33.682247, 151.383362));

    public LoadItems showItem;

    public interface LoadItems{
        void show(String save);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            showItem = (LoadItems) context;
        }catch (ClassCastException i){
            throw new ClassCastException(context.toString());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View completeView = inflater.inflate(R.layout.fragment_complete_signup, container, false);

        /**
         * get View reference to which login button was pressed
         */

       /* Bundle getBundle = getArguments();
        if(getBundle != null) {
            checkBundle(getBundle, completeView);
        }*/

        completeView.findViewById(R.id.db)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), AndroidDatabaseManager.class));
                    }
                });
        init(completeView);


        return completeView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == GalleryCamera.CAMERA_CODE) {
            if(resultCode == getActivity().RESULT_OK) {
                //SUCCESSFUL
                which = "camera";
                GalleryCamera.capture(userProfileImage, null);
            }
            else if(resultCode == getActivity().RESULT_CANCELED){

            }
            else {
                Toast.makeText(getActivity(),
                        "Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }
        }

        if(requestCode == GalleryCamera.GALLERY_CODE
                && resultCode == getActivity().RESULT_OK
                && data != null) {

            if(data.getData() != null) {
                //SUCCESSFUL
                which = "gallery";
                Uri uri = data.getData();
                GalleryCamera.gallery(getActivity(),userProfileImage, uri);
            }
        }
    }

    /*private void checkBundle(Bundle bundle) {

        getName = bundle.getString(Info.NAME);
        getEmail = bundle.getString(Info.EMAIL);
        getImage = bundle.getString(Info.IMAGE);
        getWhichI = bundle.getString(Info.BUTTON_INFO);

    }*/

    private void init(View completeView) {

        selectCountry = (AutoCompleteTextView) completeView.findViewById(R.id.spin_country_name);
        selectOccupation = (Spinner) completeView.findViewById(R.id.spin_occupation_name);
        selectGender = (Spinner) completeView.findViewById(R.id.spin_gender_name);
        textWhichOccupation = (TextInputLayout) completeView.findViewById(R.id.which_occupation);
        whichLayout = (RelativeLayout) completeView.findViewById(R.id.which_layout);
        whichLayout.setVisibility(View.INVISIBLE);
        layoutWrite = (LinearLayout) completeView.findViewById(R.id.layout_write_occupation);
        writeOccupation = (EditText) completeView.findViewById(R.id.write_occupation);
        layoutWrite.setVisibility(View.GONE);
        returnView = (ImageView) completeView.findViewById(R.id.ic_return);
        radioEdit = (RelativeLayout) completeView.findViewById(R.id.radio_edit);
        radioEdit.setVisibility(View.INVISIBLE);

        userProfileImage = (ImageView) completeView.findViewById(R.id.user_profileImage);
        gallery = (ImageView) completeView.findViewById(R.id.gallery);
        camera = (ImageView) completeView.findViewById(R.id.camera);
        camera.setVisibility(GalleryCamera.ifCameraPresent(
                getActivity()) ?
                View.VISIBLE : View.GONE);

        userName = (EditText) completeView.findViewById(R.id.user_name);
        userEmail = (EditText) completeView.findViewById(R.id.user_email);
        occupationPlace = (EditText) completeView.findViewById(R.id.occupation_place);
        userSkill = (EditText) completeView.findViewById(R.id.user_skill);
        userSkill.setText("Not a developer.");
        mobileNumber = (EditText) completeView.findViewById(R.id.user_mobile);
        brief = (EditText) completeView.findViewById(R.id.brief);
        facebook = (EditText) completeView.findViewById(R.id.facebook);
        linkedIn = (EditText) completeView.findViewById(R.id.linkedin);
        twitter = (EditText) completeView.findViewById(R.id.twitter);
        playStore = (EditText) completeView.findViewById(R.id.google_play);

        saveButton = (Button) completeView.findViewById(R.id.save);
        saveButton.setOnClickListener(this);

        camera.setOnClickListener(this);
        gallery.setOnClickListener(this);
        returnView.setOnClickListener(this);


        radioGroup = (RadioGroup) completeView.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton yes = (RadioButton) group.findViewById(R.id.yes);
                RadioButton no = (RadioButton) group.findViewById(R.id.no);
                //check for button checked
                if (yes.isChecked()) {
                    String radioText = yes.getText().toString();
                    checked(radioText);
                } else if (no.isChecked()) {
                    String radioText = no.getText().toString();
                    checked(radioText);
                }
            }
        });

        brief.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    InputMethodManager input = (InputMethodManager)
                            getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                    input.showSoftInput(brief, InputMethodManager.SHOW_IMPLICIT);
                }

            }
        });

        //set select country
        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(getActivity(),this)
                .build();

        placeAdapter = new PlaceAutocompleteAdapter(
                getActivity(),
                googleApiClient,
                BOUNDS_LATLNG,
                null);

        selectCountry.setAdapter(placeAdapter);

        selectCountry.setOnItemClickListener(this);

        if(occupationArr == null) {
            occupationArr = getResources().getStringArray(R.array.occupation);
        }
        if(genderArr == null) {
            genderArr = getResources().getStringArray(R.array.gender);
        }

        //select occupation spinner adapter
        occupationAdp = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                occupationArr);

        occupationAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set spinner to adapter
        selectOccupation.setAdapter(occupationAdp);

        //select gender spinner adapter
        genderAdp = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                genderArr);

        genderAdp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set spinner to adapter
        selectGender.setAdapter(genderAdp);

        selectOccupation.setOnItemSelectedListener(this);
        selectGender.setOnItemSelectedListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(googleApiClient != null && googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.save:

                saveInfo(v);
                break;

            case R.id.camera:

                startActivityForResult(GalleryCamera.getCameraIntent(),
                        GalleryCamera.CAMERA_CODE);
                break;

            case R.id.gallery:

                startActivityForResult(GalleryCamera.getGalleryIntent(),
                        GalleryCamera.GALLERY_CODE);
                break;

            case R.id.ic_return:

                layoutWrite.setVisibility(View.GONE);
                selectOccupation.setVisibility(View.VISIBLE);
                /*whichLayout.setVisibility(View.INVISIBLE);
                writeOccupation.setText("Not specified");
                occupationPlace.setText("Not specified");*/
                //textWhichOccupation.setHint("Place of event");
                selectOccupation.setAdapter(occupationAdp);


                break;
        }
    }

    private void checked(String checked) {

        radioEdit.setVisibility(checked.equalsIgnoreCase("yes")?
                View.VISIBLE : View.INVISIBLE);
        getRadioString = checked;

        if(getRadioString.equalsIgnoreCase("yes")
                && !userSkill.getText().toString().isEmpty()) {
            userSkill.getText().clear();
        }
        else {
            userSkill.setText("Not a developer");
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final AutocompletePrediction getComplete = placeAdapter.getItem(position);

        final CharSequence fullItem = getComplete.getFullText(null);

        getFullItem = fullItem.toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String get;

        switch (parent.getId()) {

            case R.id.spin_occupation_name:

                get = parent.getItemAtPosition(position).toString();
                if(get.equalsIgnoreCase("none")){
                    Log.e(logTag, "spinner "+ get);
                    none = get;
                    whichLayout.setVisibility(View.INVISIBLE);
                    writeOccupation.setText("Not specified");
                    occupationPlace.setText("Not specified");
                }
                else if(get.equalsIgnoreCase(occupationArr[7])) {
                    Log.e(logTag, "spinner "+ get);
                    none = get;
                    selectOccupation.setVisibility(View.GONE);
                    textWhichOccupation.setHint("Place of event");
                    layoutWrite.setVisibility(View.VISIBLE);
                    whichLayout.setVisibility(View.VISIBLE);
                    writeOccupation.setText("");
                    occupationPlace.setText("");

                    /*if(getItem.equalsIgnoreCase("student")) {
                        textWhichOccupation.setHint("Occupation ame");
                        whichLayout.setVisibility(View.VISIBLE);
                    }
                    else {
                        textWhichOccupation.setHint("Occupation name");
                        whichLayout.setVisibility(View.VISIBLE);
                    }*/
                }
                else {
                    if(get.equalsIgnoreCase("student")) {

                        Log.e(logTag, "spinner "+ get);
                        none = get;
                        textWhichOccupation.setHint("School name");
                        whichLayout.setVisibility(View.VISIBLE);
                        occupationPlace.setText("");

                    }
                    else {

                        Log.e(logTag, "spinner "+ get);
                        none = get;
                        textWhichOccupation.setHint("Company name");
                        whichLayout.setVisibility(View.VISIBLE);
                        occupationPlace.setText("");
                    }
                }
                break;

            case R.id.spin_gender_name:

                get = parent.getItemAtPosition(position).toString();
                getGender = get;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }



    private void saveInfo(View v) {

        if(userName.getText().toString().isEmpty()
                || userEmail.getText().toString().isEmpty()
                || mobileNumber.getText().toString().isEmpty()
                || brief.getText().toString().isEmpty()
                || facebook.getText().toString().isEmpty()
                || linkedIn.getText().toString().isEmpty()
                || twitter.getText().toString().isEmpty()
                || playStore.getText().toString().isEmpty()
                || selectCountry.getText().toString().isEmpty()
                || occupationPlace.getText().toString().isEmpty()
                || writeOccupation.getText().toString().isEmpty()
                || userSkill.getText().toString().isEmpty() ) {


            Toast.makeText(getActivity(),
                    "Field must not be empty", Toast.LENGTH_SHORT)
                    .show();
        }

        else {

            if(which.isEmpty()) {
                Toast.makeText(getActivity(), "select profile image", Toast.LENGTH_SHORT)
                        .show();
            }

            else if(!userEmail.getText().toString().contains("@")
                    || !userEmail.getText().toString().contains(".")) {
                userEmail.setError("Incorrect Email");
            }
            else if (!mobileNumber.getText().toString().contains("+")) {
                mobileNumber.setError("Input code with +");
            }
            else {
                Log.e(logTag,"saved");
                if(none.equalsIgnoreCase("none")){
                    none = writeOccupation.getText().toString();
                }
                if(none.equalsIgnoreCase(occupationArr[7])) {
                    none = writeOccupation.getText().toString();
                }

                if(getFullItem == null){
                    getFullItem = "Not specified.";
                }

                Log.e(logTag, "Brief " + brief.getText().toString());
                Log.e(logTag, "Saving items\n"
                        +"Name "+userName.getText().toString()+"\n"
                        +"Email "+userEmail.getText().toString()+"\n"
                        +"Gender "+getGender+"\n" +"Mobile "+mobileNumber.getText().toString()+"\n"
                        +"Country "+getFullItem +"\n"+"Developer "+userSkill.getText().toString()+"\n"
                        +"Occupation "+none+"\n" +"Occupation place "+occupationPlace.getText().toString()+"\n"
                        +"Brief "+brief.getText().toString()+"\n"+"Facebook "+facebook.getText().toString()+"\n"
                        +"LinkedIn "+linkedIn.getText().toString()+"\n" +"Twitter "+twitter.getText().toString()+"\n"
                        +"Play store "+playStore.getText().toString()+"\n" +"Which operation "+which+"\n");



                new dbContents(getActivity(),userName.getText().toString(),
                        userEmail.getText().toString(), getGender,
                        mobileNumber.getText().toString(),getFullItem,
                        userSkill.getText().toString(),none,
                        occupationPlace.getText().toString(),brief.getText().toString(),
                        facebook.getText().toString(),linkedIn.getText().toString(),
                        twitter.getText().toString(),playStore.getText().toString(), which);

                Log.e(logTag, "Saved");
                showItem.show("saved");
            }
        }

    }
}
