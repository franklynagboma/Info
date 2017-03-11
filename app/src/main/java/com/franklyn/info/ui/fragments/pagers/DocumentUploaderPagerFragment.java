package com.franklyn.info.ui.fragments.pagers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.franklyn.info.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by AGBOMA franklyn on 7/8/16.
 */

public class DocumentUploaderPagerFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    @SuppressLint("ValidFragment")
    public DocumentUploaderPagerFragment() {
    }

    private final String LOG_TAG = DocumentUploaderPagerFragment.class.getSimpleName();

    //private Spinner fileDocument;
    //private ArrayAdapter<String> fileAdapter;
    private Button storage;
    private int RC_DOC = 200;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View resume = inflater.inflate(R.layout.fragment_docup_pager, container, false);
        init(resume);
        return resume;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void init(View resume) {

        storage = (Button) resume.findViewById(R.id.storage_button);
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/pdf");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(Intent.createChooser(intent, "Select PDF file"), RC_DOC);
            }
        });

        /*fileDocument = (Spinner) resume.findViewById(R.id.file_spinner);
        fileAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.spinner_text,
                getResources().getStringArray(R.array.file) );
        fileAdapter.setDropDownViewResource(R.layout.spinner_text);

        fileDocument.setAdapter(fileAdapter);
        fileDocument.setOnItemSelectedListener(this);*/

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_DOC)
            if(resultCode == RESULT_OK) {
                Uri getUri = data.getData();
                Log.e(LOG_TAG, getUri.getPath());
                Log.e(LOG_TAG, getUri.getLastPathSegment());
            }
    }

    public void changesDetected() {

    }
}
