package com.example.mememiner;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

public class Meme {
    protected String m_name, m_discription;
    protected Bitmap m_image;

    public Meme(Bitmap image, String name, String discription){
        m_image = image;
        m_name = name;
        m_discription = discription;
    }

    public Bitmap getImage(){
        return m_image;
    }

    public String getName() {
        return m_name;
    }

    public String getDiscription() {
        return m_discription;
    }
}
