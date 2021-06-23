package com.example.mycomfort.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mycomfort.classes.Material;
import com.example.mycomfort.classes.MaterialAdapter;
import com.example.mycomfort.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PracticeList extends AppCompatActivity {
    private DatabaseReference materialDB;
    private String practice_key = "Практика";
    private ListView listViewPractice;
    private ArrayAdapter <String> adapter;
    private List<String> listMaterialKey;
    private List <Material> listMaterial;
    private MaterialAdapter materialAdapter;
    private ArrayList <Material> materials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_list);

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
        listViewPractice = findViewById(R.id.listViewPractice);
        materials = new ArrayList<>();
        materialAdapter = new MaterialAdapter(this, R.layout.list_item_art_pr, materials);
        listViewPractice.setAdapter(materialAdapter);
        materialDB = FirebaseDatabase.getInstance().getReference(practice_key);
    }

    private void getMaterialFromDB() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (materials.size() > 0) materials.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    if (!(data.getKey().equals("Тест Роршаха"))) {
                        Material practice = new Material(data.getKey(), data.getValue());
                        assert practice != null;
                        setImageData(practice);
                        materials.add(practice);
                    }
                    else {
                        Material practice = new Material(data.getKey());
                        assert practice != null;
                        setImageData(practice);
                        materials.add(practice);
                    }
                }
                materialAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        };
        materialDB.addValueEventListener(vListener);
    }

    private void setOnClickItem() {
        listViewPractice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Material practice = materials.get(position);
                Intent intent;
                if (!(practice.name.equals("Тест Роршаха"))) {
                    intent = new Intent(PracticeList.this, PracticeText.class);
                    intent.putExtra("practice_text", practice.text.toString());
                }
                else {
                    intent = new Intent(PracticeList.this, RorschachTest.class);
                }
                startActivity(intent);
            }
        });
    }

    private void setImageData (Material practice) {
        int q = 0;
        switch (q) {
            case 0: if (practice.name.equals("Волшебная формула для разрешения ситуаций, вызывающих беспокойство")){
                practice.setImageResource(R.drawable.formula);
                break;
            }
            else q = 1;
            case 1: if (practice.name.equals("Тест на проявление абьюза со стороны партнера\\партнерки")) {
                practice.setImageResource(R.drawable.abuse);
                break;
            }
            else q = 2;
            case 2: if (practice.name.equals("Фиксация своего внутреннего состояния")) {
                practice.setImageResource(R.drawable.anxiety);
                break;
            }
            else q = 3;
            case 3: if (practice.name.equals("Динамическая медитация Ошо")) {
                practice.setImageResource(R.drawable.practice_meditation);
                break;
            }
            else q = 4;
            case 4: if (practice.name.equals("Как справиться с усталостью")) {
                practice.setImageResource(R.drawable.tired);
                break;
            }
            else q = 5;
            case 5: if (practice.name.equals("Тест Роршаха")) {
                practice.setImageResource(R.drawable.rorschach_test_10);
                break;
            }
            else q = 6;
                break;
        }
    }
}