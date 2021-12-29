package com.example.courthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class legalaid extends AppCompatActivity {
    TextView linkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legalaid);

        linkTextView = findViewById(R.id.activity_main_hyperlink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());


        Button changequestionnaireBTN = findViewById((R.id.button2));
        changequestionnaireBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changequestionnaire();}
        });
    }
    //start the questionnaire
    private void changequestionnaire() {
        Intent intent = new Intent(this,Questionnaire.class);
        startActivity(intent);
    }
}