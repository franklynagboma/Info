package com.franklyn.info.ui.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.franklyn.info.R;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.animation.Animator;
import android.widget.RelativeLayout;

/**
 * Created by AGBOMA Franklyn on 3/14/2016.
 */
public class EmailOptionalFragment extends DialogFragment implements View.OnClickListener{

    private EditText editEmailName, addToEmail;
    private LinearLayout editEmail, addEmail, revEmail, revAdd;

    private RelativeLayout buttons;
    private Button buttWhich, buttCancel;

    private boolean revEmailClick;
    private boolean hindEdit = true;
    private boolean hindAdd = true;

    private String add = "add", edit = "edit";

    //public static final String

    /*public SharedPreferences email;
    public SharedPreferences.Editor profileNameEdit;*/

    public ChangeEmail changeEmail;

    public interface ChangeEmail {
        void newEmail(String email);
        void addEmail(String addEmail);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            changeEmail = (ChangeEmail) context;
        }
        catch (ClassCastException email) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View emailView = inflater.inflate(R.layout.fragment_email_option, container, false);

        initOptions(emailView);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //setCancelable(true;
        getDialog().setCanceledOnTouchOutside(true);

        return emailView;
    }

    private void initOptions(View emailView) {

        editEmail = (LinearLayout) emailView.findViewById(R.id.edit_email);
        editEmail.setOnClickListener(this);
        addEmail = (LinearLayout) emailView.findViewById(R.id.add_email);
        addEmail.setOnClickListener(this);

        revEmail = (LinearLayout) emailView.findViewById(R.id.rev_edit_email);
        revAdd = (LinearLayout) emailView.findViewById(R.id.rev_add_email);

        editEmailName = (EditText) emailView.findViewById(R.id.get_edit_email);
        addToEmail = (EditText) emailView.findViewById(R.id.get_alternative_email);

        revEmail.setVisibility(View.INVISIBLE);
        revAdd.setVisibility(View.INVISIBLE);

        buttons = (RelativeLayout) emailView.findViewById(R.id.buttons);
        buttWhich = (Button) emailView.findViewById(R.id.butt_which);
        buttCancel = (Button) emailView.findViewById(R.id.butt_cancel);

        buttWhich.setOnClickListener(this);
        buttCancel.setOnClickListener(this);

        buttons.setVisibility(View.GONE);
        buttWhich.setVisibility(View.INVISIBLE);
        buttCancel.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.edit_email:

                addEmail.setVisibility(View.INVISIBLE);

                buttons.setVisibility(View.VISIBLE);
                buttWhich.setVisibility(View.VISIBLE);
                buttWhich.setText(edit);
                buttCancel.setVisibility(View.VISIBLE);

                revEmailClick = true;
                editEmailText(v);
                break;

            case R.id.add_email:

                editEmail.setVisibility(View.INVISIBLE);

                buttons.setVisibility(View.VISIBLE);
                buttWhich.setVisibility(View.VISIBLE);
                buttWhich.setText(add);
                buttCancel.setVisibility(View.VISIBLE);

                revEmailClick = false;
                addToEmailText(v);
                break;

            case R.id.butt_which:

                if(buttWhich.getText().toString().equalsIgnoreCase(add)) {

                    if(!addToEmail.getText().toString().contains("@")
                            || !addToEmail.getText().toString().contains(".")) {
                        addToEmail.setError("Incorrect Email");
                    }
                    else {
                        getDialog().dismiss();
                        changeEmail.addEmail(addToEmail.getText().toString());
                    }
                }
                else if(buttWhich.getText().toString().equalsIgnoreCase(edit)) {

                    if(!editEmailName.getText().toString().contains("@")
                            || !editEmailName.getText().toString().contains(".")) {
                        editEmailName.setError("Incorrect Email");
                    }
                    else {
                        getDialog().dismiss();
                        changeEmail.newEmail(editEmailName.getText().toString());
                    }
                }

                break;

            case R.id.butt_cancel:

                getDialog().dismiss();

                break;
        }
    }

    private void editEmailText(View v) {

        int cX = (revEmail.getLeft()) + (revEmail.getRight());
        int cY = revEmail.getTop();
        int radius = Math.max(revEmail.getWidth(), revEmail.getHeight());


        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            lowerVersion(cX, cY, radius);
        }
        else {
            higherVersion(cX, cY, radius);
        }
    }

    private void addToEmailText(View v) {

        int cX = (revAdd.getLeft()) + (revAdd.getRight());
        int cY = revAdd.getTop();
        int radius = Math.max(revAdd.getWidth(), revAdd.getHeight());


        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            lowerVersion(cX, cY, radius);
        }
        else {
            higherVersion(cX, cY, radius);
        }
    }


    public void lowerVersion(int cX, int cY, int radius){

        if(revEmailClick) {

            final SupportAnimator animator = ViewAnimationUtils.createCircularReveal(revEmail, cX, cY, 0, radius);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(450);

            SupportAnimator animator_reverse = animator.reverse();

            if(hindEdit){

                revEmail.setVisibility(View.VISIBLE);
                animator.start();
                hindEdit = false;
            }
            else {
                animator_reverse.addListener( new SupportAnimator.AnimatorListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {

                        revEmail.setVisibility(View.INVISIBLE);

                        addEmail.setVisibility(View.VISIBLE);

                        buttons.setVisibility(View.GONE);
                        buttWhich.setVisibility(View.INVISIBLE);
                        buttCancel.setVisibility(View.INVISIBLE);

                        hindEdit = true;
                    }

                    @Override
                    public void onAnimationCancel() {

                    }

                    @Override
                    public void onAnimationRepeat() {

                    }
                });

                animator_reverse.start();
            }

        }
        else {

            SupportAnimator animator = ViewAnimationUtils.createCircularReveal(revAdd, cX, cY, 0, radius);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(450);

            SupportAnimator animator_reverse = animator.reverse();

            if(hindAdd){

                revAdd.setVisibility(View.VISIBLE);
                animator.start();
                hindAdd = false;
            }
            else {
                animator_reverse.addListener( new SupportAnimator.AnimatorListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {

                        revAdd.setVisibility(View.INVISIBLE);

                        editEmail.setVisibility(View.VISIBLE);

                        buttons.setVisibility(View.GONE);
                        buttWhich.setVisibility(View.INVISIBLE);
                        buttCancel.setVisibility(View.INVISIBLE);

                        hindAdd = true;
                    }

                    @Override
                    public void onAnimationCancel() {

                    }

                    @Override
                    public void onAnimationRepeat() {

                    }
                });

                animator_reverse.start();
            }
        }
    }

    public void higherVersion(int cX, int cY, int radius){

        if(revEmailClick) {


            Animator animator = android.view.ViewAnimationUtils.createCircularReveal(revEmail, cX, cY, 0, radius);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(500);

            //SupportAnimator animator_reverse = animator.reverse();

            if(hindEdit){

                revEmail.setVisibility(View.VISIBLE);
                animator.start();
                hindEdit = false;
            }
            else {
                //animator_reverse.addListener(new Animator.AnimatorListener(){
                animator.addListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        revEmail.setVisibility(View.INVISIBLE);

                        addEmail.setVisibility(View.VISIBLE);

                        buttons.setVisibility(View.GONE);
                        buttWhich.setVisibility(View.INVISIBLE);
                        buttCancel.setVisibility(View.INVISIBLE);

                        hindEdit = true;
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                animator.start();
                //animator_reverse.start();
            }
        }
        else {

            Animator animator = android.view.ViewAnimationUtils.createCircularReveal(revAdd, cX, cY, 0, radius);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(500);

            //SupportAnimator animator_reverse = animator.reverse();

            if(hindAdd){

                revAdd.setVisibility(View.VISIBLE);
                animator.start();
                hindAdd = false;
            }
            else {
                //animator_reverse.addListener(new Animator.AnimatorListener(){
                animator.addListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        revAdd.setVisibility(View.INVISIBLE);

                        editEmail.setVisibility(View.VISIBLE);

                        buttons.setVisibility(View.GONE);
                        buttWhich.setVisibility(View.INVISIBLE);
                        buttCancel.setVisibility(View.INVISIBLE);

                        hindAdd = true;
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                animator.start();
                //animator_reverse.start();
            }
        }
    }
}
