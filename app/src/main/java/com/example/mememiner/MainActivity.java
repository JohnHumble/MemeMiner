package com.example.mememiner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // class member variables
    Button baitButton;
    TextView words;
    ImageView imageView;

    ArrayList<Meme> collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baitButton = findViewById(R.id.bait_button);
        words = findViewById(R.id.words);
        imageView = findViewById(R.id.imageView);

        collection = new ArrayList<>();

        baitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Put logic here for when the bait button is pressed
                words.setText("Tee Hee :)");

                // draw the skeletor in the square

                imageView.setImageResource(R.mipmap.doot_foreground);
            }
        });


    }
}
