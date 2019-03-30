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

import java.io.InputStream;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // class member variables
    Button baitButton, walletButton;
    TextView words;
    ImageView imageView;

    ArrayList<Meme> collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baitButton = findViewById(R.id.bait_button);
        walletButton = findViewById(R.id.view_collection);
        words = findViewById(R.id.words);
        imageView = findViewById(R.id.imageView);

        collection = new ArrayList<>();

        baitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Put logic here for when the bait button is pressed
                words.setText("Tee Hee :)");

                // add a new meme element to collection
                Meme next = new Meme();

                collection.add(next);

                // load the skelitor as a bitmap
                Bitmap doot = BitmapFactory.decodeResource(getResources(),R.mipmap.doot_foreground);

                doot = Grill.fryImage(doot, 10);

                imageView.setImageBitmap(doot);

              //  imageView.setImageResource(collection.get(0).image);
            }
        });

        walletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO display all of the content in the collection.
            }
        });



    }

    private Bitmap getImage(){
        //TODO put your logic here to get the image
    }
}
