package com.example.mycomfort.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycomfort.R;
import com.example.mycomfort.classes.Rorschach;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RorschachTest extends AppCompatActivity {
    DatabaseReference dB;
    ArrayList <Rorschach> rorschachMaterials;
    String key = "Практика/Тест Роршаха";
    TextView rorschach;
    TextView numbTest;
    TextView nameTest;
    ImageView imgTest;
    TextView textTest;
    TextView author;
    Button button;
    int indexTest = 0;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rorschach_test);

        init();
        setHomeButton();
        getMaterialFromDB();
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
       rorschachMaterials = new ArrayList<>();
       dB = FirebaseDatabase.getInstance().getReference(key);
       rorschach = findViewById(R.id.rorschach);
       numbTest = findViewById(R.id.numberCard);
       nameTest = findViewById(R.id.nameRorschach);
       imgTest = findViewById(R.id.imageRorschach);
       textTest = findViewById(R.id.questRorschach);
       author = findViewById(R.id.author);
       button = findViewById(R.id.findAnswer);
    }

    private void setListData() {
            Rorschach ror;
            for (int i=0; i<10;i++) {
                ror = new Rorschach();
                rorschachMaterials.add(ror);
            }
            Log.d("TAG", "size is " + rorschachMaterials.size());
    }

    private void getMaterialFromDB() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (rorschachMaterials.size() > 0) rorschachMaterials.clear();
                setListData();
                for (DataSnapshot dat : snapshot.getChildren()) {
                    Rorschach ror = new Rorschach(dat.getKey(),(String) dat.child("Вопрос").getValue(), (String) dat.child("Ответ").getValue());
                    assert ror != null;
                    setData(ror);
                  }
                testQuestion(indexTest);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        };
        dB.addValueEventListener(vListener);
        Log.d("TAG", "size is " + rorschachMaterials.size());
    }

    private void setData(Rorschach ror) {
            int q = 0;
            switch (q) {
                case 0: if (ror.name.equals("Стрессоустойчивость")) {
                    ror.setImgSource(R.drawable.rorschach_test_1);
                    rorschachMaterials.set(0, ror);
                    break;
                }
                else q = 1;
                case 1: if (ror.name.equals("Эмоциональное состояние")) {
                    ror.setImgSource(R.drawable.rorschach_test_2);
                    rorschachMaterials.set(1, ror);
                    break;
                }
                else q = 2;
                case 2: if (ror.name.equals("Отношение к миру")) {
                    ror.setImgSource(R.drawable.rorschach_test_3);
                    rorschachMaterials.set(2, ror);
                    break;
                }
                else q = 3;
                case 3: if (ror.name.equals("Отношения с родителями")) {
                    ror.setImgSource(R.drawable.rorschach_test_4);
                    rorschachMaterials.set(3, ror);
                    break;
                }
                else q = 4;
                case 4: if (ror.name.equals("Собственное “Я”")) {
                    ror.setImgSource(R.drawable.rorschach_test_5);
                    rorschachMaterials.set(4, ror);
                    break;
                }
                else q = 5;
                case 5: if (ror.name.equals("Межличностная близость")) {
                    ror.setImgSource(R.drawable.rorschach_test_6);
                    rorschachMaterials.set(5, ror);
                    break;
                }
                else q = 6;
                case 6: if (ror.name.equals("Материнство")) {
                    ror.setImgSource(R.drawable.rorschach_test_7);
                    rorschachMaterials.set(6, ror);
                    break;
                }
                else q = 5;
                case 7: if (ror.name.equals("Выражение эмоций")) {
                    ror.setImgSource(R.drawable.rorschach_test_8);
                    rorschachMaterials.set(7, ror);
                    break;
                }
                else q = 8;
                case 8: if (ror.name.equals("Отношение к неопределенности")) {
                    ror.setImgSource(R.drawable.rorschach_test_9);
                    rorschachMaterials.set(8, ror);
                    break;
                }
                else q = 9;
                case 9: if (ror.name.equals("Самая многоговорящая карта")) {
                    ror.setImgSource(R.drawable.rorschach_test_10);
                    rorschachMaterials.set(9, ror);
                    break;
                }
                else q = 10;
            }
    }

    private void testQuestion(int indexTest){
            Log.d("TAG","size " + rorschachMaterials.size());
            if (indexTest < 10) {
                Rorschach ror = rorschachMaterials.get(indexTest);
                rorschach.setVisibility(View.VISIBLE);
                numbTest.setText(Integer.toString(indexTest + 1));
                nameTest.setText(ror.name);
                imgTest.setImageResource(ror.imgSource);
                textTest.setText(ror.question);
                author.setVisibility(View.GONE);
                button.setText(R.string.findAnswer);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        testAnswer(ror.answer);
                    }
                });

            }

    }

    private void testAnswer(String answer) {
        rorschach.setVisibility(View.GONE);
        textTest.setText(answer);
        if (indexTest != 9) {
            indexTest++;
            button.setText(R.string.nextCard);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    testQuestion(indexTest);
                }
            });
        }
        else {
            button.setVisibility(View.GONE);
            author.setVisibility(View.VISIBLE);
        }
    }
}