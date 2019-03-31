package com.example.mememiner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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
    ListView memeView;

    ArrayList<Meme> collection;
    MemeAdapter adapter;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memeView = (ListView) findViewById(R.id.list_view_id);

        collection = new ArrayList<>();
        adapter = new MemeAdapter(this,collection);

        baitButton = findViewById(R.id.bait_button);
        walletButton = findViewById(R.id.view_collection);
        words = findViewById(R.id.words);

        random = new Random();

        memeView.setAdapter(adapter);


        baitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Put logic here for when the bait button is pressed
                words.setText("Tee Hee :)");

                // add a new meme element to collection
                Meme next = getMeme();

                adapter.add(next);
            }
        });

        walletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO display all of the content in the collection.
            }
        });

    }
    private void addViewer(Meme meme, ArrayList<ImageView> viewers){
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageBitmap(meme.getImage());

        // Create layout parameters for ImageView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // Add rule to layout parameters
        // Add the ImageView below to Button
       // lp.addRule(RelativeLayout.BELOW, rl.getId());

        //rl.addView(imageView);

        viewers.add(imageView);
    }
    final int MAX = 1024;
    private Meme getMeme(){
        //TODO make this method give a variance of memes

        int rand = random.nextInt(MAX);

        Bitmap mem = getBase(rand);

        int ranfry = random.nextInt(MAX);
        if (ranfry < MAX/2) {
            mem = Grill.fryImage(mem, Math.max(10, ranfry % 20), this);
        }

        Meme next = new Meme(mem, "Rare","Meme");
        return next;
    }

    private Bitmap getBase(int choice){


        if (choice < MAX / 128){
            return BitmapFactory.decodeResource(getResources(),R.mipmap.chonkcat_foreground);
        }

        if (choice < MAX / 32) {
            return BitmapFactory.decodeResource(getResources(),R.mipmap.chonkdog_foreground);
        }

        if (choice < MAX / 16) {
            return BitmapFactory.decodeResource(getResources(),R.mipmap.yee_foreground);
        }


        if (choice < MAX / 8){
            return BitmapFactory.decodeResource(getResources(),R.mipmap.chungus_foreground);
        }

        if (choice < MAX / 4){
            return BitmapFactory.decodeResource(getResources(),R.mipmap.pa_foreground);
        }

        if (choice < MAX / 2){
            return BitmapFactory.decodeResource(getResources(),R.mipmap.doge_forground);
        }

        return BitmapFactory.decodeResource(getResources(),R.mipmap.doot_foreground);
    }
}
