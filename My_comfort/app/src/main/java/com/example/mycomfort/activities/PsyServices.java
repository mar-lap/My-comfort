package com.example.mycomfort.activities;

import com.example.mycomfort.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class PsyServices extends AppCompatActivity {
    private final static String serviceFile1 = "МЧС.txt";
    private final static String serviceFile2 = "Ярославна.txt";
    private final static String serviceFile3 = "Линия надежды.txt";
    private final static String serviceFile4 = "ВШЭ.txt";
    private final static String serviceFile5 = "Psysovet.txt";
    private final static String serviceFile6 = "Мырядом2020.txt";
    private final static String serviceFile7 = "b17.txt";
    private final static String serviceFile8 = "Помогая другим.txt";
    private final static String serviceFile9 = "Насилиюнет.txt";


    TextView textViewService1;
    TextView textViewService2;
    TextView textViewService3;
    TextView textViewService4;
    TextView textViewService5;
    TextView textViewService6;
    TextView textViewService7;
    TextView textViewService8;
    TextView textViewService9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.psy_services);

        init();
        setHomeButton();
        getText();
    }

    public void setHomeButton() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {
        textViewService1 = findViewById(R.id.textViewService1);
        textViewService2 = findViewById(R.id.textViewService2);
        textViewService3 = findViewById(R.id.textViewService3);
        textViewService4 = findViewById(R.id.textViewService4);
        textViewService5 = findViewById(R.id.textViewService5);
        textViewService6 = findViewById(R.id.textViewService6);
        textViewService7 = findViewById(R.id.textViewService7);
        textViewService8 = findViewById(R.id.textViewService8);
        textViewService9 = findViewById(R.id.textViewService9);
    }

    void getText(){
        byte[] buffer = null;
        InputStream is;
        try {
            is = getAssets().open(serviceFile1);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            String textFile = new String(buffer);
            textViewService1.setText(textFile);

            is = getAssets().open(serviceFile2);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService2.setText(textFile);

            is = getAssets().open(serviceFile3);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService3.setText(textFile);

            is = getAssets().open(serviceFile4);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService4.setText(textFile);

            is = getAssets().open(serviceFile5);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService5.setText(textFile);

            is = getAssets().open(serviceFile6);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService6.setText(textFile);

            is = getAssets().open(serviceFile7);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService7.setText(textFile);

            is = getAssets().open(serviceFile8);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService8.setText(textFile);

            is = getAssets().open(serviceFile9);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            textViewService9.setText(textFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
