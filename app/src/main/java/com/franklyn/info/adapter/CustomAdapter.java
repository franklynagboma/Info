package com.franklyn.info.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.franklyn.info.R;
import com.franklyn.info.helper.GalleryCamera;
import com.franklyn.info.helper.dbContents;
import com.franklyn.info.ui.fragments.InfoContactsFragment;

import java.util.Random;

/**
 * Created by AGBOMA Franklyn on 3/28/2016.
 */
public class CustomAdapter extends SimpleCursorAdapter{

    private String logTag = CustomAdapter.class.getSimpleName();

    private int[] colours = {
            R.color.colorAccent,
            R.color.colorDetails,
            R.color.colorNext_one,
            R.color.colorNext_two,};

    private Random roll = new Random();
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;
    private int fourthNumber;

    public static SharedPreferences shared;
    private static String getName;
    private static String getImage;
    private static String getImageType;


    private Context context;
    private int lastPosition = -1;
    private static int[] getTo;
    private static String[] getForm;
    private TextView nName;
    private ImageView nImage;


    public CustomAdapter(Context context, int layout, Cursor cursor, String[] form,
                         int[] to, TextView name, ImageView image, int flags){

        super(context, layout, cursor, form, to, flags);

        getTo = to;
        getForm = form;
        nName = name;
        nImage = image;
        this.context = context;

        setUpColourIndex();
    }

/*    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);

        int toCount = getTo.length;

        for (int count =0; count <toCount; count ++) {
            final View getView = view.findViewById(getTo[count]);

            if(getView != null){

                String getName = cursor.getString(
                        cursor.getColumnIndex(InfoContract.InfoProfile.INFO_NAME));

                String getSkills = cursor.getString(
                        cursor.getColumnIndex(InfoContract.InfoProfile.INFO_SKILLS));

                String getGender = cursor.getString(
                        cursor.getColumnIndex(InfoContract.InfoProfile.INFO_GENDER));
            }
        }

    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        TextView userName = (TextView) view.findViewById(R.id.user_profileName);
        TextView userDeveloper = (TextView) view.findViewById(R.id.developer_name);
        TextView userStatus = (TextView) view.findViewById(R.id.status_name);
        TextView firstLetter = (TextView) view.findViewById(R.id.first_letter);
        CardView cardContact = (CardView) view.findViewById(R.id.card_contact);

        Typeface letter = Typeface.createFromAsset(context.getAssets(),
                "fonts/AndroidClock.ttf");
        Typeface textFace = Typeface.createFromAsset(context.getAssets(),
                "fonts/proxima-nova-regular.ttf");


        String setText = userName.getText().toString().substring(0, 1);
        firstLetter.setText(setText);

        //set type face to text view_up
        userName.setTypeface(letter);
        userDeveloper.setTypeface(textFace);
        userStatus.setTypeface(textFace);
        firstLetter.setTypeface(letter);

        int getColour = set(setText);
        cardContact.setCardBackgroundColor(context.getResources().getColor(getColour));
        firstLetter.setTextColor(context.getResources().getColor(getColour));

        if(position == 0 ){

            //User Image view.

            // it also works the same
            nName.setText(userName.getText().toString());
            nName.setTypeface(letter);

            /**
             *user a method to save this value
             * and get value from InfoContactsFragment
             */

            /*if(!getName.isEmpty()) {

                nName.setText(getName);
                nName.setTypeface(letter);
            }*/

            if( !getImage.isEmpty()
                    && !getImageType.isEmpty()) {

                /*nName.setText(getName);
                nName.setTypeface(letter);*/
                if(getImageType.equalsIgnoreCase("camera")){
                    GalleryCamera.capture(nImage, Uri.parse(getImage));
                }
                else if(getImageType.equalsIgnoreCase("gallery")){
                    GalleryCamera.gallery(context,nImage, Uri.parse(getImage));
                }
            }
            else {

                nImage.setImageResource(R.drawable.ic_profile_picture);
            }

            cardContact.setVisibility(View.GONE);
            /*Log.e(logTag, "card Position " + InfoContactsFragment.lastPosition
                    + " Gone.\n" + "Name " + getName);*/

        }

        //Animate view.
        Animation animate = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.view_up : R.anim.view_down);
        view.startAnimation(animate);
        lastPosition = position;

        return view;
    }

    private void setUpColourIndex() {

        //get shared preferences
        shared = context.getSharedPreferences(
                dbContents.PREFERENCE_KEY, Context.MODE_PRIVATE);
        getName = shared.getString(dbContents.NAME_KEY, "");
        getImage = shared.getString(dbContents.IMAGE_KEY, "");
        getImageType = shared.getString(dbContents.IMAGE_TYPE, "");

        //colour index
        firstNumber = roll.nextInt(4);
        secondNumber = roll.nextInt(4);
        thirdNumber = roll.nextInt(4);
        fourthNumber = roll.nextInt(4);

        Log.e(logTag, "first " + String .valueOf(firstNumber));

        //checking same values
        while (secondNumber == firstNumber) {
            Log.e(logTag, "second = first" + String .valueOf(secondNumber));
            secondNumber = roll.nextInt(4);
        }
        Log.e(logTag, "second != first " + String .valueOf(secondNumber));

        while (thirdNumber == secondNumber || thirdNumber == firstNumber) {
            Log.e(logTag, "third = others " + String .valueOf(thirdNumber));
            thirdNumber = roll.nextInt(4);
        }
        Log.e(logTag, "third != others " + String.valueOf(thirdNumber));

        while (fourthNumber == thirdNumber ||
                fourthNumber == secondNumber || fourthNumber == firstNumber) {
            Log.e(logTag, "four = others " + String .valueOf(fourthNumber));
            fourthNumber = roll.nextInt(4);
        }
        Log.e(logTag, "four != others " + String .valueOf(fourthNumber));

    }

    private int set(String setText) {

        int getColour = 0;
        if(setText.equalsIgnoreCase("a")
                || setText.equalsIgnoreCase("e")
                || setText.equalsIgnoreCase("j")
                || setText.equalsIgnoreCase("o")
                || setText.equalsIgnoreCase("t")
                || setText.equalsIgnoreCase("y")){

            Log.e(logTag, setText + " letter change " + String.valueOf(firstNumber));
            getColour = colours[firstNumber];

        }
        else if(setText.equalsIgnoreCase("b")
                || setText.equalsIgnoreCase("f")
                || setText.equalsIgnoreCase("k")
                || setText.equalsIgnoreCase("p")
                || setText.equalsIgnoreCase("u")
                || setText.equalsIgnoreCase("z")){

            Log.e(logTag, setText + " letter change " + String.valueOf(secondNumber));
            getColour = colours[secondNumber];

        }
        else if(setText.equalsIgnoreCase("c")
                || setText.equalsIgnoreCase("g")
                || setText.equalsIgnoreCase("m")
                || setText.equalsIgnoreCase("q")
                || setText.equalsIgnoreCase("v")
                || setText.equalsIgnoreCase("x")){

            Log.e(logTag, setText + " letter change " + String.valueOf(thirdNumber));
            getColour = colours[thirdNumber];
        }
        else {

            Log.e(logTag, setText + " letter change " + String.valueOf(fourthNumber));
            getColour = colours[fourthNumber];
        }
        return getColour;
    }
}
