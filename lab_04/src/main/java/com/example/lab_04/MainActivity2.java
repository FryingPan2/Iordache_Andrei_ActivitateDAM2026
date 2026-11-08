package com.example.lab_04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ArrayList<Avion> listaAvioane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //ArrayAdapter<Avion> adapter;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            return insets;
        });
//        listaAvioane = (ArrayList<Avion>)
//        getIntent().getSerializableExtra("listaAvioane");
        listaAvioane = getIntent().getParcelableArrayListExtra("listaAvioane");
        if (listaAvioane == null) {
            listaAvioane = new ArrayList<>();
        }

        final ArrayList<Avion> lista = listaAvioane;

        ListView listView = findViewById(R.id.lista_avioane_LV);

        //adapter = new ArrayAdapter<>(
        //       this,
        //      android.R.layout.simple_list_item_1,
        //       lista
        //);
        AvionAdapter adapter = new AvionAdapter(listaAvioane,this);
        listView.setAdapter(adapter);

        // Tap: display the selected aircraft
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            Avion avion = lista.get(position);
//
//            Toast.makeText(
//                    MainActivity2.this,
//                    avion.toString(),
//                    Toast.LENGTH_LONG
//            ).show();
//        });
        listView.setOnItemClickListener((parent, view, position, id) -> {

            Avion avion = lista.get(position);

            Intent it = new Intent(MainActivity2.this, IntroduAvion.class);

            it.putExtra("avion_selectat", avion);
            it.putExtra("pozitie_avion", position);

            startActivityForResult(it, 2);
        });

        // Long press: delete the selected aircraft
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Avion avion = lista.remove(position);

            adapter.notifyDataSetChanged();

            Toast.makeText(
                    MainActivity2.this,
                    "Avion sters: " + avion.getModel(),
                    Toast.LENGTH_SHORT
            ).show();

            return true;
        });
    }
    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {

            Avion avionModificat =
                    data.getParcelableExtra("avion");

            int pozitie =
                    data.getIntExtra("pozitie_avion", -1);

            if (avionModificat != null && pozitie >= 0
                    && pozitie < listaAvioane.size()) {

                listaAvioane.set(pozitie, avionModificat);

                ((AvionAdapter)
                        ((ListView)findViewById(R.id.lista_avioane_LV))
                                .getAdapter())
                        .notifyDataSetChanged();

                Toast.makeText(
                        this,
                        "Avion modificat cu succes!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}