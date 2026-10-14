package com.example.lab_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private static final int REQUEST_REZULTAT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void openActivity(View view){
       Intent it = new Intent(this,ActivitateRezultat.class);

        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "Salut din MainActivity2!");
        bundle.putInt("numar1", 10);
        bundle.putInt("numar2", 20);

        it.putExtras(bundle);

        startActivityForResult(it,70);
        //startActivity(it);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 70){
                if(resultCode == RESULT_OK) {

            String mesaj = data.getStringExtra("mesaj_return");
            int suma = data.getIntExtra("suma", 0);
            StringBuilder build = new StringBuilder(mesaj);
            build.append(suma);

            Toast.makeText(this,
                    build.toString(),
                    Toast.LENGTH_SHORT).show();
        }
        }
}}

