package com.franklyn.info.ui.fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.franklyn.info.R;
import com.franklyn.info.helper.TextWriter;
import com.franklyn.info.ui.activities.Info;
import com.franklyn.info.ui.view.CircularImageView;

/**
 * Created by AGBOMA Franklyn on 3/15/2016.
 */
public class UserHeaderFragment {/*extends Fragment implements View.OnClickListener{

    private String logTag = UserHeaderFragment.class.getSimpleName();

    private CircularImageView userImage;
    private TextWriter userName;
    private ImageView userMenu;
    private ClipboardManager clipboardManager;



    //shareperference
    public SharedPreferences profileName, imageUrl;
    public SharedPreferences.Editor profileNameEdit, imageUrlEdit;

    //keys
    public static final String NAME = "profile_name";
    public static final String IMAGE_URL = "image_url";

    //String details
    private String pName, iImageUril;

    String tname = "",timageUril = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View headerView = inflater.inflate(R.layout.fragment_user_header, container, false);

        setPreference();

        Bundle bundle = getArguments();
        if(bundle != null) {
            checkBundle(bundle);
        }

        init(headerView);


        return headerView;
    }

    private void setPreference()  {

        profileName = getActivity()
                .getSharedPreferences(NAME, Context.MODE_PRIVATE);
        imageUrl = getActivity()
                .getSharedPreferences(IMAGE_URL, Context.MODE_PRIVATE);


        pName = profileName.getString(NAME, "");
        iImageUril = imageUrl.getString(IMAGE_URL, "");
    }

    private void checkBundle(Bundle bundle) {

        tname = bundle.getString(Info.HEADER_NAME);
        timageUril = bundle.getString(Info.IMAGE);

        Log.e(logTag, "Bundle:\n "
                + tname + "\n" + timageUril + "\n");

        *//** checking which string has the email name
         * to save.
         *//*
        //save user details
        profileNameEdit = profileName.edit();
        profileNameEdit.putString(NAME, tname);
        profileNameEdit.apply();

        if(timageUril != null) {

            imageUrlEdit = imageUrl.edit();
            imageUrlEdit.putString(IMAGE_URL, timageUril);
            imageUrlEdit.apply();
        }

        Log.e(logTag, "SharePreference:\n " + pName+ "\n" + iImageUril);

    }

    private void init(View userView) {

        userName = (TextWriter) userView.findViewById(R.id.user_profileName);
        userImage = (CircularImageView) userView.findViewById(R.id.user_profileImage);

        Log.e(logTag, "SharePreference in init:\n " + pName+ "\n" + iImageUril);

        if(tname.isEmpty() && timageUril.isEmpty()) {

            Log.e(logTag, "Checking... " + tname+ "\n" + timageUril);
            //use TextWriter
            userName.setCharacterDelay(100);
            userName.animateText(pName);


            if(iImageUril != null) {
                setProfileImage(userImage, iImageUril);
            }
        }
        else {

            userName.setCharacterDelay(200);
            userName.animateText(tname);

            if(timageUril != null){
                setProfileImage(userImage, timageUril);
            }
        }

        clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        userMenu = (ImageView) userView.findViewById(R.id.user_menu);
        //set onclick to overflow
        userMenu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.user_menu:
                //set pop up menu onclick
                menuClicked(v);
                break;
        }
    }

    private void menuClicked(View v) {

        Log.e(logTag, "Menu Clicked");

        PopupMenu popupUserMenu = new PopupMenu(getActivity(), v);
        popupUserMenu.getMenuInflater().inflate(R.menu.user_menu, popupUserMenu.getMenu());

        popupUserMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                ClipData getClipData;

                switch (item.getItemId()) {

                    case R.id.copy_name:

                        getClipData = ClipData.newPlainText(
                                "name",
                                userName.getText().toString());

                        clipboardManager.setPrimaryClip(getClipData);
                        Log.e(logTag, "copy name " + getClipData);

                        break;

                    case R.id.copy_email:

                        getClipData = ClipData.newPlainText(
                                "email",
                                InfoUserFragment.userEmail.getText().toString());

                        clipboardManager.setPrimaryClip(getClipData);
                        Log.e(logTag, "copy emails " + getClipData);

                        break;
                    case R.id.copy_mobile:

                        getClipData = ClipData.newPlainText(
                                "mobile",
                                InfoUserFragment.userMobile.getText().toString());

                        clipboardManager.setPrimaryClip(getClipData);
                        Log.e(logTag, "copy mobile " + getClipData);

                        break;

                    case R.id.refresh:
                        Log.e(logTag, "refresh");
                        break;

                    case R.id.send_info:
                        Log.e(logTag, "send info");
                        break;
                }
                return true;
            }
        }); popupUserMenu.show();
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
