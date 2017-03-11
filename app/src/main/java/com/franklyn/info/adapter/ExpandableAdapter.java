package com.franklyn.info.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.franklyn.info.R;
import com.franklyn.info.list.ListChild;
import com.franklyn.info.list.ListGroup;

import java.util.ArrayList;

/**
 * Created by AGBOMA Franklyn on 3/7/2016.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {

    private ArrayList<ListGroup> groups;
    private Context context;

    public ExpandableAdapter(Context context, ArrayList<ListGroup> groups) {
        this.context = context;
        this.groups = groups;
    }


    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).getChildItem().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        ArrayList<ListChild> childList = groups.get(groupPosition).getChildItem();
        return childList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View groupView, ViewGroup parent) {

        ListGroup group = (ListGroup) getGroup(groupPosition);

        if(groupView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);

            groupView = inflater.inflate(R.layout.group_item, null);
        }


        TextView name = (TextView)groupView.findViewById(R.id.name);
        TextView gender = (TextView)groupView.findViewById(R.id.gender);
        ImageView expand = (ImageView)groupView.findViewById(R.id.expand_icon);

        name.setText(group.getName());
        gender.setText(group.getGender());

        if(isExpanded) {
            expand.setImageResource(R.drawable.ic_expand);
        }
        else {
            expand.setImageResource(R.drawable.ic_collapse);
        }

        return groupView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View childView, ViewGroup parent) {

        ListChild child = (ListChild) getChild(groupPosition, childPosition);

        if(childView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);

            childView = inflater.inflate(R.layout.child_item, null);
        }

        TextView accountName = (TextView)childView.findViewById(R.id.edit_account_name);
        TextView emailName = (TextView)childView.findViewById(R.id.edit_email_name);
        TextView phoneNumber = (TextView)childView.findViewById(R.id.edit_phone_number);
        TextView statuesName = (TextView)childView.findViewById(R.id.edit_status_name);
        TextView countryName = (TextView)childView.findViewById(R.id.edit_country_name);
        TextView occupationName = (TextView)childView.findViewById(R.id.edit_occupation_name);

        accountName.setText(child.getName());

        return childView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
