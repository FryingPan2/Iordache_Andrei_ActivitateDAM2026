package com.example.lab_04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntroduAvion extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_introdu_avion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button btn = findViewById(R.id.buton_avion);
            btn.setOnClickListener(this);

            return insets;
        });
    }


    @Override
    public void onClick(View v){

        EditText mdAv = findViewById(R.id.model_avion);
        EditText idAv = findViewById(R.id.id_avion);
        EditText mfAv = findViewById(R.id.manufacturer_avion);
        EditText fhAv = findViewById(R.id.flightHours_avion);
        EditText vlAv = findViewById(R.id.value_avion);

//        Avion av = new Avion(mdAv.getText().toString(),
//                             idAv.getText().toString(),
//                             mfAv.getText().toString(),
//                             Integer.parseInt(fhAv.getText().toString()),
//                             Float.parseFloat(vlAv.getText().toString()));

        Bundle bdl = new Bundle();
        bdl.putString("modelAvion",mdAv.getText().toString());
        bdl.putString("idAvion",idAv.getText().toString());
        bdl.putString("ManufacturerAvion",mfAv.getText().toString());
        bdl.putInt("oreZborAvion",Integer.parseInt(fhAv.getText().toString()));
        bdl.putFloat("valoareAvion",Float.parseFloat(vlAv.getText().toString()));

        Intent it = new Intent();
        it.putExtras(bdl);
        setResult(RESULT_OK,it);
        finish();
    }
}
