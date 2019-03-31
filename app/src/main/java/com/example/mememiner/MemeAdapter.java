package com.example.mememiner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class MemeAdapter extends ArrayAdapter<Meme> {
    public MemeAdapter(Context context, ArrayList<Meme> memes) {
        super(context,0,memes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Meme meme = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row,parent,false);
        }
        // Lookup view for data population
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView1D);
        image.setImageBitmap(meme.getImage());
        return convertView;
    }
}
