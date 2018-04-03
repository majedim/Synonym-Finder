package com.example.majedibrahim.synonymfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String word = getIntent().getStringExtra("Synonum");

        TextView i = (TextView)findViewById(R.id.result);
        i.setText(word);
    }




}
