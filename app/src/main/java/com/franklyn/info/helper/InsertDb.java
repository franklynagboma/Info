package com.franklyn.info.helper;

import android.content.ContentValues;
import android.content.Context;

import com.franklyn.info.db.provider.InfoContract;

/**
 * Created by AGBOMA Franklyn on 3/16/2016.
 */
public class InsertDb {

    private static Context context;


    public static void insertInfoProfile(Context context, String name, String email,
                                  String image) {

        ContentValues values = new ContentValues();
        values.put(InfoContract.InfoProfile.INFO_NAME, name);
        values.put(InfoContract.InfoProfile.INFO_EMAIL, email);
        context.getContentResolver().insert(InfoContract.InfoProfile.CONTENT_URI,values);
    }
}
