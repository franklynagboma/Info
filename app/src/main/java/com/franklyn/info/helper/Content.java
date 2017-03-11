package com.franklyn.info.helper;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGBOMA franklyn on 5/17/16.
 */
public class Content {

/*
    public static final String ID = "id";
    public static final String ROW_TITLE = "row_title";
    public static final String ROW_COUNTS = "row_counts";
    public static final String ROW_TIME = "row_time";
    public static final String ROW_TABLE = "row_table";

     private String lastRowId,lastRowTitle, lastRowCount,
            lastRowTime, lastRowTableName;

    public void lastRow(Context context) {

        *//**
         * projection = DB projection is any else = null
         * sort = DB sort order is any else = null
         *//*

        *//**
         * get all last row item
         *//*
        try {

            Cursor cursor = context.getContentResolver()
                    .query(uri, null, null, null,null);

            if (cursor != null) {
                cursor.moveToFirst();
                do {

                    *//**
                     * This will return the last item of the DB
                     *//*
                    lastRowId = cursor.getString(cursor.getColumnIndex(ROW_ID));
                    lastRowTitle = cursor.getString(cursor.getColumnIndex(TITLE));
                    lastRowCount = cursor.getString(cursor.getColumnIndex(COUNTS));
                    lastRowTime = cursor.getString(cursor.getColumnIndex(TIME));
                    lastRowTableName = cursor.getString(cursor.getColumnIndex(TABLE_NAME));

                } while (cursor.moveToNext());
            }

            Intent viewnote = new Intent(Firstpage.this, CounterActivity.class);
            viewnote.putExtra(ID, lastRowId);
            viewnote.putExtra(ROW_TITLE, lastRowTitle);
            viewnote.putExtra(ROW_COUNTS, lastRowCount);
            viewnote.putExtra(ROW_TIME, lastRowTime);
            viewnote.putExtra(ROW_TABLE, lastRowTableName);
            startActivity(viewnote);

            long i = Long.valueOf("a");


            cursor.close();
        } catch (Exception i) {
            i.printStackTrace();
        }
    }*/

}
