package com.example.courthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Lawyersinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyersinfo);



        TextView email = (TextView)  findViewById(R.id.textViewEmail);
        email.setText(Html.fromHtml("<a href=\"info@wainwrightcummins.co.uk\">Email: info@wainwrightcummins.co.uk</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());


        TextView email2 = (TextView)  findViewById(R.id.textViewEmail2);
        email2.setText(Html.fromHtml("<a href=\"info@anthonygold.co.uk\">Email: info@anthonygold.co.uk</a>"));
        email2.setMovementMethod(LinkMovementMethod.getInstance());


        TextView email3 = (TextView)  findViewById(R.id.textViewEmail3);
        email3.setText(Html.fromHtml("<a href=\"info@hansenpalomaresco.co.uk\">Email: info@hansenpalomaresco.co.uk</a>"));
        email3.setMovementMethod(LinkMovementMethod.getInstance());



        TextView email4 = (TextView)  findViewById(R.id.textViewEmail4);
        email4.setText(Html.fromHtml("<a href=\"mail@dpglaw.co.uk\">Email: mail@dpglaw.co.uk</a>"));
        email4.setMovementMethod(LinkMovementMethod.getInstance());


        TextView email6= (TextView)  findViewById(R.id.textViewEmail6);
        email6.setText(Html.fromHtml("<a href=\"info@lawstop.co.uk\">Email: info@lawstop.co.uk</a>"));
        email6.setMovementMethod(LinkMovementMethod.getInstance());







    }
}