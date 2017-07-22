package com.franklyn.info.db.provider;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by AGBOMA Franklyn on 3/9/2016.
 */
public class InfoHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 2;
    private Context context;


    public InfoHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //InfoProfile Table
    public interface InfoProfileTable {
        String INFO_PROFILE_TABLE = "info_profile_table";
    }


    private static final String SQL_INFO_PROFILE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + InfoProfileTable.INFO_PROFILE_TABLE + "("
            + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + InfoContract.InfoProfile.INFO_NAME + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_EMAIL + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_GENDER + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PHONE_NUMBER + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_COUNTRY + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_DECISION_1 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_DECISION_2 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_DECISION_3 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_DECISION_4 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_DECISION_5 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_DECISION_6 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_FORMING_1 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_FORMING_2 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_FORMING_3 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_FORMING_4 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_1 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_2 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_3 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_4 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_5 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_6 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_7 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_8 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_9 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_PERSONALITY_10 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_1 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_2 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_3 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_4 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_5 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_6 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_7 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_8 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_9 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_INFORMATION_10 + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_SUMMARY + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_JOB_DESCRIPTION + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_YEARS_OF_EXPERIENCE + " TEXT NOT NULL, "
            + InfoContract.InfoProfile.INFO_CURRENTLY_WORKING + " TEXT NOT NULL"
            + ")";


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_INFO_PROFILE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ");
        onCreate(db);
    }

    public static void deleteDataBase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }



    //Check DB
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"mesage"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }


    }

}
