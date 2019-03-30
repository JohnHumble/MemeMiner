package com.example.mememiner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // class member variables
    Button baitButton, walletButton;
    TextView words;
    RelativeLayout rl;

    ArrayList<Meme> collection;
    ArrayList<ImageView> viewers;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.rl);

        baitButton = findViewById(R.id.bait_button);
        walletButton = findViewById(R.id.view_collection);
        words = findViewById(R.id.words);

        random = new Random();

        viewers = new ArrayList<>();
        collection = new ArrayList<>();

        baitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Put logic here for when the bait button is pressed
                words.setText("Tee Hee :)");

                // add a new meme element to collection
                Meme next = getMeme();

                collection.add(next);
                addViewer(next);

                // load the skelitor as a bitmap
            }
        });

        walletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO display all of the content in the collection.
            }
        });

    }
    private void addViewer(Meme meme){
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageBitmap(meme.getImage());

        // Create layout parameters for ImageView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // Add rule to layout parameters
        // Add the ImageView below to Button
        lp.addRule(RelativeLayout.BELOW, rl.getId());

        rl.addView(imageView);

        viewers.add(imageView);
    }

    private Meme getMeme(){
        //TODO make this method give a variance of memes

        int rand = random.nextInt();

<<<<<<< HEAD
        Bitmap mem = getBase(rand%5);
=======
        doot = Grill.fryImage(doot, 10);
        doot = Grill.widenImage(doot, 3,2);
>>>>>>> ddc19bf0e1a1bc55abc0e61dce8b5f53969b0b76

        mem = Grill.fryImage(mem, rand%30);

        Meme next = new Meme(mem, "Rare","Meme");
        return next;
    }

    private Bitmap getBase(int choice){
        switch (choice){
            case 0:
                return BitmapFactory.decodeResource(getResources(),R.mipmap.doge_forground);

            case 1:
                return BitmapFactory.decodeResource(getResources(),R.mipmap.chungus_foreground);

            case 2:
                return BitmapFactory.decodeResource(getResources(),R.mipmap.chonkdog_foreground);

            case 3:
                return BitmapFactory.decodeResource(getResources(),R.mipmap.chonkcat_foreground);

            case 4:

            default:
                return BitmapFactory.decodeResource(getResources(),R.mipmap.doot_foreground);
        }
    }
}
