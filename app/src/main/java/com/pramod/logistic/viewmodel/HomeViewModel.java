package com.pramod.logistic.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private PostImage postImage;
    private Context context;
    public MutableLiveData<String>imageUrl =new MutableLiveData<>();

    public HomeViewModel(Context context, PostImage postImage) {
        this.postImage = postImage;
    }

    public void setPostImage(PostImage postImage) {
        postImage.setImageUrl("https://via.placeholder.com/300.png");
        this.postImage = postImage;

    }

    public PostImage getPostImage() {
        return postImage;
    }



}

