package com.franklyn.info.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.franklyn.info.R;
import com.franklyn.info.adapter.ExpandableAdapter;
import com.franklyn.info.list.ListChild;
import com.franklyn.info.list.ListGroup;

import java.util.ArrayList;

/**
 * Created by AGBOMA Franklyn on 3/7/2016.
 */
public class InfoFragment extends Fragment{

    private ExpandableAdapter expandableAdapter;
    private ExpandableListView eListView;
    private ArrayList<ListGroup> listGroup;
    private static final String GROUP = "group";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View infoView = inflater.inflate(R.layout.fragment_info, container, false);


        init(infoView);
        events(infoView);

        return infoView;
    }

    private void init(View infoView) {

        eListView = (ExpandableListView) infoView.findViewById(R.id.list);
        listGroup = setListGroup();
        expandableAdapter = new ExpandableAdapter(getActivity(), listGroup);
        eListView.setAdapter(expandableAdapter);
    }

    private void events(View infoView) {


    }


    private ArrayList<ListGroup> setListGroup() {

        ArrayList<ListGroup> group = new ArrayList<>();

        for(int groupCount = 0; groupCount < 10; groupCount ++) {

            ArrayList<ListChild> child = new ArrayList<>();

            group.add(new ListGroup(GROUP + " " + String.valueOf(groupCount), "Male"));
            child.add(new ListChild("Account Name: "+ GROUP));

            ListGroup.setChildItem(child);


        }


        return group;
    }
}
