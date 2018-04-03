package com.example.majedibrahim.synonymfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EnterValue extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_value);
    }

    public void onSubmitClick(View view)
    {

        if(view.getId() == R.id.submitBtn)
        {
            EditText word = (EditText)findViewById(R.id.entWrd);
            EditText synonym = (EditText)findViewById(R.id.entSyn);

            String wordStr = word.getText().toString();
            String synonymStr = synonym.getText().toString();

            if(wordStr.equals(synonymStr))
            {
                //popup message
                Toast syn = Toast.makeText(EnterValue.this , "Words are the same" , Toast.LENGTH_SHORT);
                syn.show();
            }
            else
            {
                // store in database
                contact c = new contact();
                c.setWord(wordStr);
                c.setSynonym(synonymStr);

                helper.insertWord(c);
            }

        }
    }
}
