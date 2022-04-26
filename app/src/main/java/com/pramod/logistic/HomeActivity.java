package com.pramod.logistic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pramod.logistic.activity.LoginActivity;
import com.pramod.logistic.databinding.ActivityHomeBinding;
import com.pramod.logistic.viewmodel.HomeViewModel;
import com.pramod.logistic.viewmodel.HomeViewModelFactory;
import com.pramod.logistic.viewmodel.PostImage;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding activityHomeBinding;
    private PostImage postImage;
    private HomeViewModel homeViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        getSupportActionBar().hide();
        postImage = new  PostImage();
        postImage.setImageUrl("https://via.placeholder.com/300.png");
        activityHomeBinding.setPostImage(postImage);


        Thread t = new Thread() {
            public void run() {

                try {

                    sleep(1000);

                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        t.start();
    }

}
