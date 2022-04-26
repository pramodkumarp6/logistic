package com.pramod.logistic.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pramod.logistic.dash.ui.slideshow.Users;
import com.pramod.logistic.databinding.RowLayoutBinding;


import java.util.List;

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsAdapter.MyViewHolder> {
    ;
    private Context context;
    private List<Users> users;

    public UserDetailsAdapter(Context context, List<Users> users) {
        this.context = context;
        this.users = users;
    }



    public void setUser(List<Users> users) {
        this.users = users;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowLayoutBinding rowLayoutBinding = RowLayoutBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(rowLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.rowLayoutBinding.setUsers(users.get(position));

    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowLayoutBinding rowLayoutBinding;


        public MyViewHolder(@NonNull RowLayoutBinding rowLayoutBinding) {
            super(rowLayoutBinding.getRoot());
            this.rowLayoutBinding = rowLayoutBinding;
        }



    }


}

