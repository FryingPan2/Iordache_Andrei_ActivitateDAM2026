package com.example.lab_02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitateRezultat extends AppCompatActivity {

    private String mesaj;
    private int numar1;
    private int numar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            mesaj = bundle.getString("mesaj", "");
            numar1 = bundle.getInt("numar1", 0);
            numar2 = bundle.getInt("numar2", 0);
        } else {
            mesaj = "";
            numar1 = 0;
            numar2 = 0;
        }

        Toast.makeText(this,
                mesaj + " Numerele primite sunt: "
                        + numar1 + " si " + numar2,
                Toast.LENGTH_LONG).show();

        Button btnTrimite = findViewById(R.id.btnTrimite);

        btnTrimite.setOnClickListener(v -> trimiteRezultat());
    }

    private void trimiteRezultat() {
        int suma = numar1 + numar2;

        Intent intent = new Intent();
        intent.putExtra("mesaj_retur",
                "Rezultatul a fost calculat!");
        intent.putExtra("suma", suma);

        setResult(RESULT_OK, intent);
        finish();
    }
}
