package com.franklyn.info.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.franklyn.info.R;

/**
 * Created by AGBOMA franklyn on 6/13/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.LayoutViewHolder>{

    private final String LOG_TAG = UsersAdapter.class.getSimpleName();
    private Context context;

    public UsersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public LayoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(context).inflate(R.layout.users_items, parent, false);
        return new LayoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LayoutViewHolder holder, int position) {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform action with position as argument
            }
        };
        holder.userClick.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {

        //return ArrayList of items size.
        return 0;
    }

    class LayoutViewHolder extends RecyclerView.ViewHolder {

        protected LinearLayout userClick;
        protected ImageView userImage;
        protected TextView userName, userPraise, userCountry;

        public LayoutViewHolder(View view) {
            super(view);

            this.userClick = (LinearLayout) view.findViewById(R.id.user_item_click);
            this.userImage = (ImageView) view.findViewById(R.id.user_info_Image);
            this.userName = (TextView) view.findViewById(R.id.user_names);
            this.userPraise = (TextView) view.findViewById(R.id.users_praise);
            this.userCountry = (TextView) view.findViewById(R.id.users_country);
        }

    }
}
