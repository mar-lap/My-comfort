package com.example.mycomfort.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mycomfort.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ArticleText extends AppCompatActivity {
    private TextView articleText;
    private Button buttonPractice;
    private String practiceName = "";
    private String firstPracticeName = "Волшебная формула для разрешения ситуаций, вызывающих беспокойство";
    private String secondPracticeName = "Динамическая медитация Ошо";
    private String practice_text;
    private DatabaseReference materialDB;
    private String practiceKey = "Практика";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_text);

        setHomeButton();
        init();
        getArticleText();
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

    private void init() {
        articleText = findViewById(R.id.article);
        buttonPractice = findViewById(R.id.buttonPractice);
        materialDB = FirebaseDatabase.getInstance().getReference(practiceKey);
    }

    private void getArticleText() {
        String name = new String();
        String text = new String();
        Bundle args = getIntent().getExtras();

        if (args != null) {
            name = args.get("article_name").toString();
            text = args.get("article_text").toString();
            int q = 0;
            switch (q) {
                case 0: if (name.equals("Как анализировать и решать беспокоящие вас проблемы")) {
                    buttonPractice.setVisibility(View.VISIBLE);
                    buttonPractice.setText(firstPracticeName);
                    practiceName = firstPracticeName;
                    break;
                }
                else q = 1;
                case 1: if (name.equals("Советы медитирующим")) {
                    buttonPractice.setVisibility(View.VISIBLE);
                    buttonPractice.setText(secondPracticeName);
                    practiceName = secondPracticeName;
                    break;
                }
                else q = 2;
                case 2: {
                    buttonPractice.setVisibility(View.GONE);
                    q = 3;
                }
                break;
            }

            articleText.setText(text);
        }
    }

    public void onPracticeClick(View view) {
        Intent out = new Intent(ArticleText.this, PracticeText.class);

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d: snapshot.getChildren()){
                    if (choicePractice(d, out))
                        startActivity(out);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        };
        materialDB.addValueEventListener(valueEventListener);

    }

    private boolean choicePractice(DataSnapshot dat, Intent out) {
        int q = 0;
        boolean t = true;
        switch (q) {
            case 0: if (dat.getKey().equals(practiceName)) {
                practice_text = dat.getValue(String.class);
                out.putExtra("practice_text", practice_text);
                break;
            }
            else q = 1;
            case 1: if (dat.getKey().equals(practiceName)) {
                practice_text = dat.getValue(String.class);
                out.putExtra("practice_text", practice_text);
                break;
            }
            else {
                q = 2;
                t = false;
            }
                break;
        }
        return t;
    }
}
