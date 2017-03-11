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
            + InfoContract.InfoProfile.INFO_NAME + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_EMAIL + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_GENDER + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_IMAGE + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_WHICH_IMAGE + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_PHONE_NUMBER + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_COUNTRY + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_SKILLS + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_OCCUPATION + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_OCCUPATION_NAME + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_WORK_EXPERIENCE + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_LINKEDIN + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_FACEBOOK + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_TWITTER + " VARCHAR NOT NULL, "
            + InfoContract.InfoProfile.INFO_PLAY_STORE + " VARCHAR NOT NULL"
            + ")" ;


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
