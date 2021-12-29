package com.example.courthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changelegalaidBTN = findViewById((R.id.button));
        changelegalaidBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                changelegalaid();}
        });
    }

    private void changelegalaid() {
        Intent intent = new Intent(this,legalaid.class);
        startActivity(intent);
    }
}
