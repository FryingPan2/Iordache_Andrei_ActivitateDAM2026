package com.example.lab_02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultat extends AppCompatActivity {

    private String mesaj;
    private int numar1;
    private int numar2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rezultat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        if (bundle != null) {
            this.mesaj = bundle.getString("mesaj", "");
            this.numar1 = bundle.getInt("numar1", 0);
            this.numar2 = bundle.getInt("numar2", 0);
        } else {
            this.mesaj = "";
            this.numar1 = 0;
            this.numar2 = 0;
        }
        StringBuilder builder = new StringBuilder(this.mesaj);
        builder.append(" Numerele primite sunt: ");
        builder.append(this.numar1);
        builder.append(" si ");
        builder.append(this.numar2);
        Toast.makeText(this, builder.toString(),
                Toast.LENGTH_SHORT).show();

    }
    public void trimiteRezultat() {
        String newMesaj = "Rezultatul a fost calculat!";
        int suma = this.numar1 + this.numar2;

        Intent intent = new Intent();
        intent.putExtra("mesaj_return",
                newMesaj);
        intent.putExtra("suma", suma);
        setResult(RESULT_OK, intent);
        finish();
    }
}