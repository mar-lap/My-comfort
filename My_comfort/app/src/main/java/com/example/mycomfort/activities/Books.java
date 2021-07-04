package com.example.mycomfort.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mycomfort.R;

import java.io.IOException;
import java.io.InputStream;

public class Books extends AppCompatActivity {
    TextView firstBook;
    TextView secondBook;
    TextView thirdBook;
    TextView forthBook;
    TextView fifthBook;
    TextView sixthBook;
    TextView seventhBook;
    TextView eighthBook;
    TextView ninthBook;

    String firstText = "Почему он это делает.txt";
    String secondText = "Техники когнитивной психотерапии.txt";
    String thirdText = "Лекарство от нервов.txt";
    String forthText = "Свобода от тревоги.txt";
    String fifthText = "Тайная опора.txt";
    String sixthText = "Страх близости.txt";
    String seventhText = "Компас эмоций.txt";
    String eighthText = "Сила спокойствия.txt";
    String ninthText = "Искусство ясно мыслить.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books);

        setHomeButton();
        init();
    }

    void init() {
        firstBook = findViewById(R.id.firstBook);
        secondBook = findViewById(R.id.secondBook);
        thirdBook = findViewById(R.id.thirdBook);
        forthBook = findViewById(R.id.forthBook);
        fifthBook = findViewById(R.id.fifthBook);
        sixthBook = findViewById(R.id.sixthBook);
        seventhBook = findViewById(R.id.seventhBook);
        eighthBook = findViewById(R.id.eighthBook);
        ninthBook = findViewById(R.id.ninthBook);

        byte[] buffer = null;
        InputStream is;
        try {
            is = getAssets().open(firstText);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            String textFile = new String(buffer);
            firstBook.setText(textFile);

            is = getAssets().open(secondText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            secondBook.setText(textFile);

            is = getAssets().open(thirdText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            thirdBook.setText(textFile);

            is = getAssets().open(forthText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            forthBook.setText(textFile);

            is = getAssets().open(fifthText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            fifthBook.setText(textFile);

            is = getAssets().open(sixthText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            sixthBook.setText(textFile);

            is = getAssets().open(seventhText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            seventhBook.setText(textFile);

            is = getAssets().open(eighthText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            eighthBook.setText(textFile);

            is = getAssets().open(ninthText);
            size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            textFile = new String(buffer);
            ninthBook.setText(textFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
