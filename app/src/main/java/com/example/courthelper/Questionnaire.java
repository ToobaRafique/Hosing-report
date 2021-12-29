package com.example.courthelper;


import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;



import android.os.Bundle;
public class Questionnaire extends AppCompatActivity {
    private static final int STORAGE_CODE = 1000;
    //declaring views
    EditText TextEt;
    EditText textBenefits;
    EditText textIssue;
    EditText textSavings;
    EditText textRent;
    EditText textPeople;
    EditText textTime;
    EditText textADisrepair;

    Button mSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        Button changetolawyersinfoBTN = findViewById((R.id.contactBtn));
        changetolawyersinfoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changetolawyersinfo();
            }
        });
    }

    private void changetolawyersinfo() {
        Intent intent = new Intent(this,Lawyersinfo.class);
        startActivity(intent);
        //initializing views (activity_main.xml)
        TextEt = findViewById(R.id.textEt);
        textBenefits = findViewById(R.id.textBenefits);
        textIssue = findViewById(R.id.textIssue);
        textSavings = findViewById(R.id.textSavings);
        textRent = findViewById(R.id.textRent);
        textPeople = findViewById(R.id.textPeople);
        textTime = findViewById(R.id.textTime);
        textADisrepair = findViewById(R.id.textADisrepair);

        mSaveBtn = findViewById(R.id.saveBtn);
        //handle button click
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we need to handle runtime permission for devices with marshmallow and above
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    //system OS >= Marshmallow, check if permission is enabled or not
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED) {
                        //permission was not granted, request it
                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permissions, STORAGE_CODE);
                    } else {
                        //permission already granted, call save pdf method
                        savePdf();
                    }
                } else {
                    //system OS < Marshmallow, call save pdf method
                    savePdf();
                }
            }
        });
    }

    private void savePdf() {
        //create object of Document class
        Document mDoc = new Document();
        //pdf file name
        String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());
        //pdf file path
        String mFilePath = Environment.getExternalStorageDirectory() + "/" + mFileName + ".pdf";

        try {
            //create instance of PdfWriter class
            PdfWriter.getInstance(mDoc, new FileOutputStream(mFilePath));
            //open the document for writing
            mDoc.open();
            //get text from EditText i.e. mTextEt
            String mText = TextEt.getText().toString();

            //add paragraph to the document
            mDoc.add(new Paragraph(mText));

            String Benefits = textBenefits.getText().toString();
            mDoc.add(new Paragraph(Benefits));

            String Issue = textIssue.getText().toString();
            mDoc.add(new Paragraph(Issue));

            String Saving = textSavings.getText().toString();
            mDoc.add(new Paragraph(Saving));

            String Rent = textRent.getText().toString();
            mDoc.add(new Paragraph(Rent));

            String People = textPeople.getText().toString();
            mDoc.add(new Paragraph(People));

            String Time = textTime.getText().toString();
            mDoc.add(new Paragraph(Time));

            String ADisrepair = textADisrepair.getText().toString();
            mDoc.add(new Paragraph(ADisrepair));


            //add author of the document (optional)
            mDoc.addAuthor("Tooba");

            //close the document
            mDoc.close();
            //show message that file is saved, it will show file name and file path too
            Toast.makeText(this, mFileName + ".pdf\nis saved to\n" + mFilePath, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            //if any thing goes wrong causing exception, get and show exception message
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    //handle permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission was granted from popup, call savepdf method
                    savePdf();
                } else {
                    //permission was denied from popup, show error message
                    Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}