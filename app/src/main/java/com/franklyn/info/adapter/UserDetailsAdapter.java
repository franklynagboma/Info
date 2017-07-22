package com.franklyn.info.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.franklyn.info.R;
import com.franklyn.info.helper.pojo.UsersItem;

import java.util.List;

/**
 * Created by AGBOMA franklyn on 6/13/17.
 */

public class UserDetailsAdapter extends ArrayAdapter<UsersItem> {

    private List<UsersItem> usersItem;
    private Context context;
    private int layout;

    public static  class Holder{
        ImageView userImage;
        TextView usersName, usersPraise;
    }
    public UserDetailsAdapter(@NonNull Context context, List<UsersItem> usersItem) {
        super(context, R.layout.users_details, usersItem);
        this.context = context;
        this.usersItem = usersItem;
        this.layout = R.layout.users_details;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UsersItem users = usersItem.get(position);
        Holder holder;

        if(convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(layout,parent,false);

            holder.userImage = (ImageView) convertView.findViewById(R.id.user_info_Image);
            holder.usersName = (TextView) convertView.findViewById(R.id.user_names);
            holder.usersPraise = (TextView) convertView.findViewById(R.id.users_praise);

            convertView.setTag(holder);
        }
        else
            holder = (Holder)convertView.getTag();

        //set holder event action.
        return convertView;
    }
}
