package com.franklyn.info.ui.fragments.pagers.quetionaire;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.franklyn.info.R;
import com.franklyn.info.app.AppController;
import com.franklyn.info.helper.io.TextChecker;

/**
 * Created by AGBOMA franklyn on 6/4/17.
 */

public class DetailsFragment extends Fragment{

    private final String LOG_TAG = DetailsFragment.class.getSimpleName();

    private TextInputLayout summary_holder, job_holder, year_holder;
    private EditText summary, job, year_exp;
    private RadioGroup currently;
    private AppCompatRadioButton yes, no;
    private FloatingActionButton sendResponse;
    private int r1 = -1;
    public static boolean stringLength = true;

    public final static String SUMMARY = "summary";
    public final static String JOB = "job";
    public final static String YEAR_EXP = "year_exp";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View details = inflater.inflate(R.layout.fragment_details, container, false);

        init (details);
        return details;
    }

    private void init (View details) {

        summary_holder = (TextInputLayout) details.findViewById(R.id.summary_holder);
        job_holder = (TextInputLayout) details.findViewById(R.id.job_holder);
        year_holder = (TextInputLayout) details.findViewById(R.id.years_holder);
        summary = (EditText) details.findViewById(R.id.summary_content);
        summary.addTextChangedListener(new TextChecker(getActivity(),summary_holder, SUMMARY));
        job = (EditText) details.findViewById(R.id.job_content);
        job.addTextChangedListener(new TextChecker(getActivity(),job_holder, JOB));
        year_exp = (EditText) details.findViewById(R.id.years_content);
        year_exp.addTextChangedListener(new TextChecker(getActivity(),year_holder, YEAR_EXP));
        currently = (RadioGroup) details.findViewById(R.id.radio_currently);
        yes = (AppCompatRadioButton) details.findViewById(R.id.radio_yes);
        no = (AppCompatRadioButton) details.findViewById(R.id.radio_no);
        currently.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                r1 = group.getCheckedRadioButtonId();
            }
        });
        sendResponse = (FloatingActionButton) details.findViewById(R.id.send_response);
        sendResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(summary.getText().toString())
                        || TextUtils.isEmpty(job.getText().toString())
                        || TextUtils.isEmpty(year_exp.getText().toString())){
                    Toast.makeText(getActivity(), "Empty field(s)", Toast.LENGTH_SHORT).show();
                }
                else if(!stringLength)
                    summary.requestFocus();
                else {
                    if(r1 == -1)
                        Toast.makeText(getActivity(), "Currently working?",
                                Toast.LENGTH_SHORT).show();
                    else {
                        //get radio text
                        if(r1 == yes.getId())
                            AppController.CURRENTLY = yes.getText().toString().trim();
                        if(r1 == no.getId())
                            AppController.CURRENTLY = no.getText().toString().trim();

                        getAllSend();

                    }
                }
            }
        });
    }

    private void getAllSend() {
        //check if all is not empty before proceed to offline and online
        Log.e(LOG_TAG, "Send all offline and online");
    }
}
