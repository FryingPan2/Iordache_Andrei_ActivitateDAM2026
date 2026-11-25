package com.example.lab_04;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class JsonWeatherActivity extends AppCompatActivity implements View.OnClickListener {

    private String city = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json_weather);

        Button btnWeather = findViewById(R.id.buttonWeather);

        btnWeather.setOnClickListener(this);

        EditText SlcCity = findViewById(R.id.editTextWeather);

        city = SlcCity.getText().toString();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    Executor executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.myLooper());


    String api = "zpka_c6251be8fecc4bd9bbd12f2a164a9630_42b693cc";
    @Override
    public void onClick(View v){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String link = "https://dataservice.accuweather.com/locations/v1/cities/search?apiKey="+api+"&q="+city;
                try{
                    URL url = new URL(link);
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    BufferedReader reader = new BufferedReader(new InputStreamReader());
                    StringBuilder = new StringBuilder("");

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }



}