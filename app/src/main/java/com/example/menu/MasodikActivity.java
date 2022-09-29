package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ConcurrentModificationException;

public class MasodikActivity extends AppCompatActivity {

    private TextView textViewResoult;
    private Button buttonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masodik);
        init();
        String seged = getSharedPreferenceData();
        textViewResoult.setText(seged);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //felugro ablak
                Toast.makeText(MasodikActivity.this,
                        "Viszlát", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(
                        MasodikActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
    private void init() {
        textViewResoult = findViewById(R.id.textViewResoult);
        buttonBack = findViewById(R.id.buttonBack);
    }
    private String getSharedPreferenceData() {
        SharedPreferences sharedPreferences =
                getSharedPreferences("Data", Context.MODE_PRIVATE);
                return sharedPreferences.
                        getString("editTextErteke", "Nincs ilyen érték");

    }
}