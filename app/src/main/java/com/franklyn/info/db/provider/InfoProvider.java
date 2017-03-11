package com.franklyn.info.db.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import com.franklyn.info.helper.SelectionBuilder;

/**
 * Created by AGBOMA Franklyn on 3/9/2016.
 */
public class InfoProvider extends ContentProvider{

    private Context context;

    private InfoHelper dbHelper;
    private SQLiteDatabase dbReader, dbWriter;

    private static final UriMatcher uriMatcher = buildUriMatcher();

    private static final int INFO_PROFILE_ID = 200;
    private static final int INFO_PROFILE_LIST = 201;


    @Override
    public boolean onCreate() {

        dbHelper = new InfoHelper(getContext());
        dbReader = dbHelper.getReadableDatabase();
        dbWriter = dbHelper.getWritableDatabase();

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        int match = uriMatcher.match(uri);
        final SelectionBuilder sBuilder = selectionBuilder(uri, match);

        switch (match) {


            case INFO_PROFILE_LIST:
                if(TextUtils.isEmpty(sortOrder))
                    sortOrder = InfoContract.InfoProfile.SORT_ORDER;
                break;
        }

        return sBuilder.where(selection, selectionArgs)
                .query(dbReader, projection, sortOrder);

    }

    @Override
    public String getType(Uri uri) {
        int match = uriMatcher.match(uri);

        switch (match) {

            case INFO_PROFILE_LIST:
                return InfoContract.InfoProfile.CONTENT_DIR_SEARCH;
            case INFO_PROFILE_ID:
                return InfoContract.InfoProfile.CONTENT_ITEM_SEARCH;

            default:
                throw new UnsupportedOperationException("uri " + match + " not available");
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int match = uriMatcher.match(uri);
        long id = 0;

        switch (match) {


            case INFO_PROFILE_LIST: {
                id = dbWriter.insert(InfoHelper.InfoProfileTable.INFO_PROFILE_TABLE, null, values);
                notify(uri);
                return getUriFold(uri, id);
            }

            default: {
                throw new UnsupportedOperationException("Unknown uri Directory: "+uri);
            }
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if(uri == InfoContract.BASE_CONTENT_URI) {

            dbHelper.close();
            InfoHelper.deleteDataBase(getContext());

            dbHelper = new InfoHelper(getContext());
            notify(uri);

            return 1;
        }

        final  SelectionBuilder sBuilder = selectionBuilder(uri,uriMatcher.match(uri));
        int delete = sBuilder.where(selection, selectionArgs)
                .delete(dbWriter);
        notify(uri);

        return delete;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        final SelectionBuilder sBuilder = selectionBuilder(uri, uriMatcher.match(uri));

        int update = sBuilder.where(selection, selectionArgs)
                .update(dbWriter, values);
        notify(uri);

        return update;
    }

    public static UriMatcher buildUriMatcher() {

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);



        matcher.addURI(InfoContract.AUTHORITY,
                InfoContract.PATH_INFO_PROFILE, INFO_PROFILE_LIST);

        matcher.addURI(InfoContract.AUTHORITY,
                InfoContract.PATH_INFO_PROFILE + "/#", INFO_PROFILE_ID);

        return matcher;
    }

    private SelectionBuilder selectionBuilder(Uri uri, int match) {

        final SelectionBuilder sBuilder = new SelectionBuilder();
        int positionArgs = 1;

        switch (match){


            case INFO_PROFILE_LIST: {
                return sBuilder.table(InfoHelper.InfoProfileTable.INFO_PROFILE_TABLE);
            }


            case INFO_PROFILE_ID: {
                final String selectionArgs = uri.getPathSegments().get(positionArgs);
                return sBuilder.table(InfoHelper.InfoProfileTable.INFO_PROFILE_TABLE)
                        .where(InfoContract.InfoProfile._ID + "=?", selectionArgs);
            }


            default: {
                throw new UnsupportedOperationException("Unknown uri found: "+ match + "= " + uri);
            }
        }
    }

    private void notify(Uri uri){

        context = getContext();
        context.getContentResolver().notifyChange(uri, null);
    }

    private static Uri getUriFold(Uri uri, long id) {

        if(id > 0) {
            Uri loadUri = ContentUris.withAppendedId(uri, id);
            return loadUri;
        }

        throw  new SQLException("Problem Appending Uri: " + uri);
    }
}
