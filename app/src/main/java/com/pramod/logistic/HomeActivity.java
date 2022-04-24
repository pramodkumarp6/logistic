package com.pramod.logistic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pramod.logistic.activity.LoginActivity;
import com.pramod.logistic.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
 private ActivityHomeBinding activityHomeBinding;
private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding  = DataBindingUtil.setContentView(this,R.layout.activity_home);
        getSupportActionBar().hide();

        Glide.with(this)
                .load("https://via.placeholder.com/300.png")
                .placeholder(R.drawable.ic_action_computer)
                .error(R.drawable.ic_action_computer)
                .into(activityHomeBinding.image);



        Thread t = new Thread() {
            public void run() {

                try {

                    sleep(1000);

                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
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
