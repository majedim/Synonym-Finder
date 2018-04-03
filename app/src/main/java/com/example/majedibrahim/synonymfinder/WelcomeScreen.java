package com.example.majedibrahim.synonymfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class WelcomeScreen extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

public void onFindSynClick(View view){

    if(view.getId() == R.id.findSynBt)
    {
        EditText word1 = (EditText)findViewById(R.id.entWrd1);
        String word1Str = word1.getText().toString();

        String Synonym = helper.searchSyn(word1Str);

        Intent i = new Intent(this, Results.class);
        i.putExtra("Synonum" , Synonym);
        startActivity(i);

    }
}
public void onClick(View view) {
    Intent i = new Intent(this , EnterValue.class);
            startActivity(i);
}
}
