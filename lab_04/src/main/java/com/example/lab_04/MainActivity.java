package com.example.lab_04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.result.ActivityResultLauncher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnDate = findViewById(R.id.buton_date);

        btnDate.setOnClickListener(this::culegeDate);
        Button btnAvion = findViewById(R.id.buton_avion);

        btnAvion.setOnClickListener(view -> {

            Intent it = new Intent(
                    MainActivity.this,
                    IntroduAvion.class
            );

            startActivityForResult(it, 1);
        });

        Button btnLista = findViewById(R.id.buton_lista);

        btnLista.setOnClickListener(view -> {

            Intent it = new Intent(
                    MainActivity.this,
                    MainActivity2.class
            );

            it.putExtra("listaAvioane", listaAvioane);

            startActivity(it);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    ArrayList<Avion> listaAvioane = new ArrayList<>();


    public void deschideCulesDateAvion(View view) {
        Intent it = new Intent(this, IntroduAvion.class);
        startActivity(it);
    }

    // Collects the name and checkbox information
    public void culegeDate(View view) {

        EditText et = findViewById(R.id.nume_ET);
        CheckBox cb = findViewById(R.id.check_CB);

        String nume = et.getText().toString();
        boolean chk = cb.isChecked();

        Toast.makeText(
                this,
                "Nume: " + nume + "\nStudent: " + chk,
                Toast.LENGTH_SHORT
        ).show();
    }


    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            //Avion avion = (Avion)
                    //data.getSerializableExtra("avion");
            Avion avion = data.getParcelableExtra("avion");
            if (avion != null) {
                listaAvioane.add(avion);

                Toast.makeText(
                        this,
                        "Avion adaugat cu succes!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}