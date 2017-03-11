package com.franklyn.info.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.franklyn.info.R;
import com.franklyn.info.helper.ContactsItems;

import java.util.List;
import java.util.Random;

/**
 * Created by AGBOMA Franklyn on 3/23/2016.
 */
public class ContactsAdapter extends BaseAdapter {

    private String logTag = ContactsAdapter.class.getSimpleName();

    private Context context;
    private List<ContactsItems> contactsItem;
    private int lastPosition = -1;
    private Random roll = new Random();
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;
    private int fourthNumber;



    private int[] colours = {
            R.color.colorAccent,
            R.color.colorDetails,
            R.color.colorNext_one,
            R.color.colorNext_two,};

    public ContactsAdapter(Context context, List<ContactsItems> contactsItem) {
        this.context = context;
        this.contactsItem = contactsItem;

        setUpColour();
    }

    @Override
    public int getCount() {
        return contactsItem.size();
    }

    @Override
    public Object getItem(int position) {
        return contactsItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactsItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View contactsView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        ContactsItems items = contactsItem.get(position);

        if(contactsView == null) {

            contactsView = layoutInflater.inflate(R.layout.info_contact_items, parent, false);

            Typeface letter = Typeface.createFromAsset(context.getAssets(),
                    "fonts/AndroidClock.ttf");
            Typeface textFace = Typeface.createFromAsset(context.getAssets(),
                    "fonts/proxima-nova-regular.ttf");


            TextView userName = (TextView) contactsView.findViewById(R.id.user_profileName);
            TextView userDeveloper = (TextView) contactsView.findViewById(R.id.developer_name);
            TextView userStatus = (TextView) contactsView.findViewById(R.id.status_name);
            TextView firstLetter = (TextView) contactsView.findViewById(R.id.first_letter);
            CardView cardContact = (CardView) contactsView.findViewById(R.id.card_contact);

            /**set item on list
             *for which image type
             * if camera or gallery images
             */

            //name, developer and status
            userName.setText(items.name);
            userDeveloper.setText(items.developer);
            userStatus.setText(items.status);

            String setText = userName.getText().toString().substring(0, 1);
            firstLetter.setText(setText);

            //set type face to text view_up
            /*userName.setTypeface(letter);
            userDeveloper.setTypeface(textFace);
            userStatus.setTypeface(textFace);
            firstLetter.setTypeface(letter);*/

            int getColour = set(setText);
            cardContact.setCardBackgroundColor(context.getResources().getColor(getColour));
            firstLetter.setTextColor(context.getResources().getColor(getColour));

            Log.e(logTag, "View " + position);
        }

        //Animate view.
        Animation animate = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.view_up : R.anim.view_down);
        contactsView.startAnimation(animate);
        lastPosition = position;

        return contactsView;
    }

    private void setUpColour() {

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
