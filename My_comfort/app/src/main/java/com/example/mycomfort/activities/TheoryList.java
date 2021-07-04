package com.example.mycomfort.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mycomfort.R;
import com.example.mycomfort.classes.Material;
import com.example.mycomfort.classes.MaterialAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TheoryList extends AppCompatActivity {
    private DatabaseReference materialDB;
    private String article_key = "Статьи";
    private ListView listView;

    private MaterialAdapter materialAdapter;
    private ArrayList <Material> materials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theory_list);

        setHomeButton();
        init();
        getMaterialFromDB();
        setOnClickItem();
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
        listView = findViewById(R.id.listView);
        materials = new ArrayList<>();
        materialAdapter = new MaterialAdapter(this, R.layout.list_item_art_pr, materials);
        listView.setAdapter(materialAdapter);
        materialDB = FirebaseDatabase.getInstance().getReference(article_key);
    }

    private void getMaterialFromDB() {
        ValueEventListener vListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (materials.size() > 0) materials.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    Material article = new Material (data.getKey(), data.getValue());
                    assert article != null;
                    setImageData(article);
                    materials.add(article);
                }
                materialAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        };
        materialDB.addValueEventListener(vListener);
    }

    private void setOnClickItem() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Material article = materials.get(position);
                Intent intent = new Intent(TheoryList.this, ArticleText.class);
                intent.putExtra("article_name", article.name);
                intent.putExtra("article_text", article.text.toString());
                startActivity(intent);
            }
        });
    }

    private void setImageData(Material article) {
        int q = 0;
        switch (q) {
            case 0: if (article.name.equals("Как анализировать и решать беспокоящие вас проблемы")){
                article.setImageResource(R.drawable.problem_analysys);
                break;
            }
            else q = 1;
            case 1: if (article.name.equals("Найдите себя и будьте собой: помните, что на земле нет человека, подобного вам")) {
                article.setImageResource(R.drawable.search_for_yourself);
                break;
            }
            else q = 2;
            case 2: if (article.name.equals("Парадокс успеха\\неудачи")) {
                article.setImageResource(R.drawable.success);
                break;
            }
            else q = 3;
            case 3: if (article.name.equals("Почему так сложно не быть жертвой?")) {
                article.setImageResource(R.drawable.victim);
                break;
            }
            else q = 4;
            case 4: if (article.name.equals("Семь способов сформировать умонастроение, которое принесет вам счастье и душевное спокойствие")) {
                article.setImageResource(R.drawable.calm);
                break;
            }
            else q = 5;
            case 5: if (article.name.equals("Советы медитирующим")) {
                article.setImageResource(R.drawable.meditation);
                break;
            }
            else q = 6;
            case 6: if (article.name.equals("Состояния Я")) {
                article.setImageResource(R.drawable.ego);
                break;
            }
            else q = 7;
            case 7: if (article.name.equals("Судьба человека, жизненные планы и сценарии")) {
                article.setImageResource(R.drawable.fate);
                break;
            }
            else q = 8;
                break;
        }
    }
}
