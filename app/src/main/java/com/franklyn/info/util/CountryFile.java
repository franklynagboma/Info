package com.franklyn.info.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.franklyn.info.app.AppController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by AGBOMA franklyn on 2/25/17.
 */

public class CountryFile {

    private static final String LOG_TAG = CountryFile.class.getSimpleName();

    public CountryFile() {
    }

    public static void getCountryList(Context context) {

        AssetManager assetManager = context.getAssets();
        InputStream  inputStream;

        try {
            inputStream = assetManager.open("country_list/country.txt");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream));

            String country;
            while ( (country = bufferedReader.readLine()) != null) {
                AppController.countryList.add(country);
                Log.e(LOG_TAG, "country " + country + " added");
            }
            inputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
            Log.e(LOG_TAG, "file not found");
        }


    }
}
