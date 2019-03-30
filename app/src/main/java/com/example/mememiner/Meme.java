package com.example.mememiner;

import android.media.Image;

public class Meme {
    protected String name, discription;
    protected int image;

    public Meme(){
        image = R.mipmap.doot_foreground;
    }

    public int getImage(){
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }
}
