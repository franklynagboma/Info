package com.franklyn.info.ui.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.franklyn.info.R;
import com.franklyn.info.adapter.CustomAdapter;
import com.franklyn.info.db.provider.InfoContract;


/**
 * Created by AGBOMA Franklyn on 3/9/2016.
 */
public class InfoContactsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private String logTag = InfoContactsFragment.class.getSimpleName();


    public static BaseAdapter baseAdapter;
    private static ListView listView;
    private ImageView image;
    private TextView name, developer, status, contactSize;

    private String[] column = {
            InfoContract.InfoProfile.INFO_NAME,
            InfoContract.InfoProfile.INFO_SKILLS,
            InfoContract.InfoProfile.INFO_GENDER };

    private CustomAdapter customAdapter;
    public static long lastPosition;

    /*public LoaderFragment reloadFragment;

    public interface LoaderFragment {
        void reload(String reload);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            reloadFragment = (LoaderFragment) context;
        }catch (ClassCastException i) {
            throw new ClassCastException(context.toString());
        }
    }*/

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
        View contacts = inflater.inflate(R.layout.fragment_info_contacts, container, false);


        listView = (ListView) contacts.findViewById(R.id.info_contacts_list);
        image = (ImageView) contacts.findViewById(R.id.user_profileImage);
        name = (TextView) contacts.findViewById(R.id.user_profileName);
        /*developer = (TextView) contacts.findViewById(R.id.developer_name);
        status = (TextView) contacts.findViewById(R.id.status_name);*/
        contactSize = (TextView) contacts.findViewById(R.id.contact_number);

        lastPosition = 0;

        customAdapter = new CustomAdapter(
                getActivity(),
                R.layout.info_contact_items,
                null,
                column,
                new int[]{R.id.user_profileName,R.id.developer_name,R.id.status_name},
                name,
                image,
                0);

        listView.setAdapter(customAdapter);

        return contacts;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                getActivity(),
                InfoContract.InfoProfile.CONTENT_URI,
                InfoContract.InfoProfile.PROJECTIONS,
                null,
                null,
                InfoContract.InfoProfile.SORT_ORDER );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if (data.moveToFirst()) {

            customAdapter.swapCursor(data);
            lastPosition = data.getCount();
            contactSize.setText(String.valueOf( (lastPosition - 1) ));
            Log.e(logTag, "List size " + (lastPosition - 1) );

            /*if(data.getPosition() == 0){

                Log.e(logTag, " data position "+data.getPosition());

                String getWhichOperation = data.getString(
                        data.getColumnIndex(
                                InfoContract.InfoProfile.INFO_WHICH_IMAGE));

                if(getWhichOperation.equalsIgnoreCase("camera")){
                    GalleryCamera.capture(image,
                            Uri.parse(data.getString(
                                    data.getColumnIndex(
                                            InfoContract.InfoProfile.INFO_IMAGE))));
                }
                else if(getWhichOperation.equalsIgnoreCase("gallery")){
                    GalleryCamera.gallery(getActivity(),image,
                            Uri.parse(data.getString(
                                    data.getColumnIndex(
                                            InfoContract.InfoProfile.INFO_IMAGE))));
                }


                name.setText(data.getString(
                        data.getColumnIndex(
                                InfoContract.InfoProfile.INFO_NAME)));

                developer.setText(data.getString(
                data.getColumnIndex(
                        InfoContract.InfoProfile.INFO_SKILLS)));

                status.setText(data.getString(
                        data.getColumnIndex(
                                InfoContract.InfoProfile.INFO_GENDER)));
            }

            else {

                Log.e(logTag, " data position " + data.getPosition());

                //testing multiply data
                customAdapter.swapCursor(data);
            }
            //customAdapter.swapCursor(data);
            do {
                if(data.getPosition() == 0){

                    Log.e(logTag, " data position "+data.getPosition());

                    String getWhichOperation = data.getString(
                            data.getColumnIndex(
                                    InfoContract.InfoProfile.INFO_WHICH_IMAGE));

                    if(getWhichOperation.equalsIgnoreCase("camera")){
                        GalleryCamera.capture(image,
                                Uri.parse(data.getString(
                                        data.getColumnIndex(
                                                InfoContract.InfoProfile.INFO_IMAGE))));
                    }
                    else if(getWhichOperation.equalsIgnoreCase("gallery")){
                        GalleryCamera.gallery(getActivity(),image,
                                Uri.parse(data.getString(
                                        data.getColumnIndex(
                                                InfoContract.InfoProfile.INFO_IMAGE))));
                    }


                    name.setText(data.getString(
                            data.getColumnIndex(
                                    InfoContract.InfoProfile.INFO_NAME)));

                    developer.setText(data.getString(
                            data.getColumnIndex(
                                    InfoContract.InfoProfile.INFO_SKILLS)));

                    status.setText(data.getString(
                            data.getColumnIndex(
                                    InfoContract.InfoProfile.INFO_GENDER)));
                }

                else {

                    Log.e(logTag, " data position " + data.getPosition());

                    //testing multiply data
                    ContactsItems.add(
                            data.getString(data.getColumnIndex(InfoContract.InfoProfile.INFO_NAME)),
                            data.getString(data.getColumnIndex(InfoContract.InfoProfile.INFO_SKILLS)),
                            data.getString(data.getColumnIndex(InfoContract.InfoProfile.INFO_GENDER)));
                }

            }while (data.moveToNext());


            baseAdapter = new ContactsAdapter(getActivity(), ContactsItems.getContactsList());

            listView.setAdapter(baseAdapter);

            contactSize.setText(String.valueOf(ContactsItems.getContactSize()));
            Log.e(logTag, "List size " + ContactsItems.getContactSize());

        }*/

        }
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        customAdapter.swapCursor(null);
    }
}
