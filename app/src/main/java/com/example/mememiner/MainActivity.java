package com.example.mememiner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Member;

public class MainActivity extends AppCompatActivity {

    Button baitButton;
    TextView words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baitButton = findViewById(R.id.bait_button);
        words = findViewById(R.id.words);

        baitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                words.setText("Tee Hee :)");
            }
        });
    }
}
