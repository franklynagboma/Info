package com.franklyn.info.ui.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.franklyn.info.R;

/**
 * Created by AGBOMA Franklyn on 3/15/2016.
 */
public class SendEmailFragment {/* extends DialogFragment
        implements View.OnClickListener{

    private String logTag = SendEmailFragment.class.getSimpleName();

    private EditText sentTo, copyTo, subject, message;
    private Button send, cancel;

    public SharedPreferences email;
    private String eEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View sendView = inflater.inflate(R.layout.fragment_send_email, container, false);

        initSend(sendView);

        *//**
         * Note, to use DialogFragment,
         * The host layout must be RelativeLayout.
         *//*
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);

        return sendView;
    }

    private void initSend(View sendView) {

        email = getActivity()
                .getSharedPreferences(InfoUserFragment.EMAIL, Context.MODE_PRIVATE);

        eEmail = email.getString(InfoUserFragment.EMAIL, "");

        sentTo = (EditText) sendView.findViewById(R.id.send_to);
        copyTo = (EditText) sendView.findViewById(R.id.copy_to);
        subject = (EditText) sendView.findViewById(R.id.subject);
        message = (EditText) sendView.findViewById(R.id.message);

        cancel = (Button) sendView.findViewById(R.id.cancel);
        send = (Button) sendView.findViewById(R.id.send);

        sentTo.setText(eEmail);

        cancel.setOnClickListener(this);
        send.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.send:
                sendMail();
                break;

            case R.id.cancel:
                getDialog().dismiss();
                break;
        }
    }

    private void sendMail() {

        String[] To = {sentTo.getText().toString()};
        String[] Cc = {copyTo.getText().toString()};

        //email intents
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, To);
        emailIntent.putExtra(Intent.EXTRA_CC, Cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail with"));
            //getActivity().finish();
            Log.e(logTag, "Sent mail");
            Toast.makeText(getActivity(), "Email Sent", Toast.LENGTH_SHORT).show();
        }
        catch (ActivityNotFoundException ex) {
            ex.printStackTrace();
            Log.e(logTag, "Sending failed: " + ex.toString());
        }
    }*/
}
