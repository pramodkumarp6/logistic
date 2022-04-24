package com.pramod.logistic.dash.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.logistic.R;
import com.pramod.logistic.adapter.UserDetailsAdapter;
import com.pramod.logistic.databinding.FragmentSlideshowBinding;

import java.util.List;


public class UserDetailsFragment extends Fragment {
    private FragmentSlideshowBinding binding;
    private UserDetailsAdapter userDetailsAdapter;
    private List<Users> users;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        UserDetailsViewModel slideshowViewModel = new ViewModelProvider(this).get(UserDetailsViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_slideshow, container, false);
        View view = binding.getRoot();

        binding.reclyer.setLayoutManager(new LinearLayoutManager(getContext()));
        userDetailsAdapter = new UserDetailsAdapter(getActivity(), users);




        slideshowViewModel.getUserDetails().observe(getViewLifecycleOwner(), new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                if (!userResponse.isError()) {
                    List<Users> users = userResponse.getUserList();
                    userDetailsAdapter.setUser(users);
                    binding.reclyer.setAdapter(userDetailsAdapter);
                    userDetailsAdapter.notifyDataSetChanged();

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("MainActivity", gson.toJson(users));
                }

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}