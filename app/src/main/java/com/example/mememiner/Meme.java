package com.example.mememiner;

import android.media.Image;

public class Meme {
    protected String name, discription;
    protected Image image;

    public Meme(int rarity){

    }

    public Image getImage(){
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }
}
