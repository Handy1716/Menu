package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSubmit;
    private EditText editTexInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. lépé, adat elmentés
                adatMentes();

            }
        });

    }
    // Tároljuk a textinput értékét
    private void adatMentes() {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String seged = editTexInput.getText().toString();
        if (seged.equals(null)){
            editTexInput.setError("Muszáj kitölteni");
        } else {
            editor.putString("editTextErteke", seged);
            editor.apply();
            //2.lépés, átmegyunk egy másik Activity-re(ablakra)
            // Intent zarojelben:(honnan -hova)
            Intent intent = new Intent(
                    MainActivity.this,MasodikActivity.class);
            startActivity(intent);
            //backStack - szabályozása hogy telefonon a vissza gombal mennyire tudjunk vissza
            //lépni vagy, hogy egyáltalán vissza tudunk e lépni
            finish();
        }
        editor.putString("editTextErteke",seged);
        editor.commit();
        editor.apply();
    }

    private void init() {
        buttonSubmit = findViewById(R.id.buttonSubmit);
        editTexInput = findViewById(R.id.editTextInput);
    }
}