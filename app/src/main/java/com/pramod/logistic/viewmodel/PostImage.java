package com.pramod.logistic.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class PostImage {
    private String imageUrl;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @BindingAdapter("imageFromUrl")
    public static void loadimage(ImageView imageView, String imageUrl){
        Glide.with(imageView).load(imageUrl).into(imageView);
    }

}
