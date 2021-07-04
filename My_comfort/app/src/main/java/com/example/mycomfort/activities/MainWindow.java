package com.example.mycomfort.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycomfort.R;


public class MainWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);
    }

    public void onTheoryClicked(View view) {
        Intent intent = new Intent (this, TheoryList.class);
        startActivity(intent);
    }

    public void onPracticeClicked(View view) {
        Intent intent = new Intent (this, PracticeList.class);
        startActivity(intent);
    }

    public void onServicesClicked(View view) {
        Intent intent = new Intent (this, PsyServices.class);
        startActivity(intent);
    }

    public void onBooksClicked(View view) {
        Intent intent = new Intent(this, Books.class);
        startActivity(intent);
    }
}
