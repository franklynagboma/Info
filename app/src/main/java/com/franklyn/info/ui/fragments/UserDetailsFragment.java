package com.franklyn.info.ui.fragments;

import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.franklyn.info.R;
import com.franklyn.info.db.provider.InfoContract;

/**
 * Created by AGBOMA franklyn on 6/11/17.
 */

public class UserDetailsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private final String LOG_TAG = UserDetailsFragment.class.getSimpleName();

    private ImageView viewImage, editInfoProfile;
    private LinearLayout layoutUserCall, layoutUserMail;
    private TextView userName, userTitle, userCountry, userSummary, userCall, userMobile;
    private TextView personality1, personality2, personality3, personality4, personality5,
            personality6, personality7, personality8, personality9, personality10;
    private TextView decision1, decision2, decision3, decision4, decision5, decision6;
    private TextView forming1, forming2, forming3, forming4;
    private TextView information1, information2, information3, information4, information5,
            information6, information7, information8, information9, information10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View users = inflater.inflate(R.layout.fragment_userdetails, container, false);

        init(users);
        return users;
    }

    private void init(View users) {
        //textView1.setPaintFlags(textView1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        // Personality preference
        TextView textView1 =  (TextView) users.findViewById(R.id.personality_text);
        textView1.setPaintFlags(textView1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        personality1 = (TextView) users.findViewById(R.id.personality_1);
        personality2 = (TextView) users.findViewById(R.id.personality_2);
        personality3 = (TextView) users.findViewById(R.id.personality_3);
        personality4 = (TextView) users.findViewById(R.id.personality_4);
        personality5 = (TextView) users.findViewById(R.id.personality_5);
        personality6 = (TextView) users.findViewById(R.id.personality_6);
        personality7 = (TextView) users.findViewById(R.id.personality_7);
        personality8 = (TextView) users.findViewById(R.id.personality_8);
        personality9 = (TextView) users.findViewById(R.id.personality_9);
        personality10 = (TextView) users.findViewById(R.id.personality_10);

        // Decision preference
        TextView textView2 =  (TextView) users.findViewById(R.id.decision_text);
        textView2.setPaintFlags(textView2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        decision1 = (TextView) users.findViewById(R.id.decision_1);
        decision2 = (TextView) users.findViewById(R.id.decision_2);
        decision3 = (TextView) users.findViewById(R.id.decision_3);
        decision4 = (TextView) users.findViewById(R.id.decision_4);
        decision5 = (TextView) users.findViewById(R.id.decision_5);
        decision6 = (TextView) users.findViewById(R.id.decision_6);

        // Forming preference
        TextView textView3 =  (TextView) users.findViewById(R.id.forming_text);
        textView3.setPaintFlags(textView3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        forming1 = (TextView) users.findViewById(R.id.forming_1);
        forming2 = (TextView) users.findViewById(R.id.forming_2);
        forming3 = (TextView) users.findViewById(R.id.forming_3);
        forming4 = (TextView) users.findViewById(R.id.forming_4);

        // Information preference
        TextView textView4 =  (TextView) users.findViewById(R.id.information_text);
        textView4.setPaintFlags(textView4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        information1 = (TextView) users.findViewById(R.id.information_1);
        information2 = (TextView) users.findViewById(R.id.information_2);
        information3 = (TextView) users.findViewById(R.id.information_3);
        information4 = (TextView) users.findViewById(R.id.information_4);
        information5 = (TextView) users.findViewById(R.id.information_5);
        information6 = (TextView) users.findViewById(R.id.information_6);
        information7 = (TextView) users.findViewById(R.id.information_7);
        information8 = (TextView) users.findViewById(R.id.information_8);
        information9 = (TextView) users.findViewById(R.id.information_9);
        information10 = (TextView) users.findViewById(R.id.information_10);


        /*View.OnTouchListener touch = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(LOG_TAG, "Motion down X=" + x +" Y=" + y
                                +" Text height= " +textHeight);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(LOG_TAG, "Motion down X=" + x +" Y=" + y
                                +" Text height= " +textHeight);
                        break;
                }
                return true;
            }
        };*/

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new CursorLoader(getActivity(),
                InfoContract.InfoProfile.CONTENT_URI,
                InfoContract.InfoProfile.PROJECTIONS,
                null,
                null,
                InfoContract.InfoProfile.SORT_ORDER);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if(data.moveToFirst())
            setUpText(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void setUpText(Cursor data) {

        String getPersonality1 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_1));
        String getPersonality2 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_2));
        String getPersonality3 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_3));
        String getPersonality4 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_4));
        String getPersonality5 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_5));
        String getPersonality6 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_6));
        String getPersonality7 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_7));
        String getPersonality8 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_8));
        String getPersonality9 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_9));
        String getPersonality10 = data.getString(data.getColumnIndex(
                InfoContract.InfoProfile.INFO_PERSONALITY_10));

        personality1.setText(getResources().getString(R.string.answers, getPersonality1));
        personality2.setText(getResources().getString(R.string.answers, getPersonality2));
        personality3.setText(getResources().getString(R.string.answers, getPersonality3));
        personality4.setText(getResources().getString(R.string.answers, getPersonality4));
        personality5.setText(getResources().getString(R.string.answers, getPersonality5));
        personality6.setText(getResources().getString(R.string.answers, getPersonality6));
        personality7.setText(getResources().getString(R.string.answers, getPersonality7));
        personality8.setText(getResources().getString(R.string.answers, getPersonality8));
        personality9.setText(getResources().getString(R.string.answers, getPersonality9));
        personality10.setText(getResources().getString(R.string.answers, getPersonality10));
    }
}
