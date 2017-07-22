package com.franklyn.info.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.franklyn.info.R;
import com.franklyn.info.adapter.UsersAdapter;
import com.franklyn.info.ui.activities.InfoDetailActivity;

/**
 * Created by AGBOMA franklyn on 6/13/17.
 */

public class UsersFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vUsers = inflater.inflate(R.layout.users_layout, container, false);
        init(vUsers);
        return vUsers;
    }

    private void init(View vUsers) {
        recyclerView = (RecyclerView) vUsers.findViewById(R.id.recycler);
        if(getArguments().getInt(InfoDetailActivity.USERS) <600)
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        else
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recyclerView.setAdapter(new UsersAdapter(getActivity()));
    }
}
