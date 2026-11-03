package com.example.lab_04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

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
        Button btn = findViewById(R.id.buton_avion2);
        btn.setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);



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

        String model = mdAv.getText().toString().trim();
        String id = idAv.getText().toString().trim();
        String manufacturer = mfAv.getText().toString().trim();

        Integer flightHours = Integer.parseInt(fhAv.getText().toString());
        Float value = Float.parseFloat(vlAv.getText().toString());

        if (model.isEmpty() || id.isEmpty() ||
                manufacturer.isEmpty() || flightHours.toString().trim().isEmpty() ||
                value.toString().trim().isEmpty()) {

            Toast.makeText(this,
                    "Completeaza toate campurile!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        CheckBox disponibilCB = findViewById(R.id.disponibil_avion_CB);

        boolean disponibil = disponibilCB.isChecked();

        RadioGroup tipAvionRG = findViewById(R.id.tip_avion_RG);

        int selectedId = tipAvionRG.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this,
                    "Selecteaza tipul avionului!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String tipAvion = "";

        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            tipAvion = selectedRadioButton.getText().toString();
        }

        Spinner categorieSP = findViewById(R.id.categorie_avion_SP);

        String categorie = categorieSP.getSelectedItem().toString();

        RatingBar stareRB = findViewById(R.id.stare_avion_RB);

        float stareTehnica = stareRB.getRating();

        Switch serviciuSW = findViewById(R.id.in_serviciu_SW);

        boolean inServiciu = serviciuSW.isChecked();

        Avion avion = new Avion(
                model,
                id,
                manufacturer,
                flightHours,
                value,
                disponibil,
                tipAvion,
                categorie,
                stareTehnica,
                inServiciu
        );

        //Bundle bdl = new Bundle();
        //bdl.putString("modelAvion",mdAv.getText().toString());
        //bdl.putString("idAvion",idAv.getText().toString());
        //bdl.putString("ManufacturerAvion",mfAv.getText().toString());
        //bdl.putInt("oreZborAvion",Integer.parseInt(fhAv.getText().toString()));
        //bdl.putFloat("valoareAvion",Float.parseFloat(vlAv.getText().toString()));

        //Intent it = new Intent();
        //it.putExtras(bdl);
        //setResult(RESULT_OK,it);
        //finish();

        Intent it = new Intent();
        it.putExtra("avion", avion);

        setResult(RESULT_OK, it);
        finish();
    }
}
