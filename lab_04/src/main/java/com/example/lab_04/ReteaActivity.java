package com.example.lab_04;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class ReteaActivity extends AppCompatActivity {

    private ArrayList<Bitmap> listImages = new ArrayList<>();
    private List<String> Links = new ArrayList<>();

    ArrayList<Object> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_retea);

        Links.add("https://upload.wikimedia.org/wikipedia/commons/d/d2/Delta_Air_Lines%2C_N991AT%2C_Boeing_717-23S_%2849593115578%29.jpg");
        Links.add("https://upload.wikimedia.org/wikipedia/commons/2/2f/%D0%90%D0%BD%D1%82%D0%BE%D0%BD%D0%BE%D0%B2_%D0%90%D0%BD-148_01-02%2C_%D0%9A%D0%B8%D0%B5%D0%B2_-_%D0%90%D0%BD%D1%82%D0%BE%D0%BD%D0%BE%D0%B2_%28%D0%93%D0%BE%D1%81%D1%82%D0%BE%D0%BC%D0%B5%D0%BB%D1%8C%29_RP29608.jpg");
        Links.add("https://thumb.wikimedia.org/wikipedia/commons/thumb/7/7f/N466SW_LAX_%2830314755488%29.jpg/1920px-N466SW_LAX_%2830314755488%29.jpg");
        Links.add("https://thumb.wikimedia.org/wikipedia/commons/thumb/8/8c/Airbus_A220-300.jpg/1920px-Airbus_A220-300.jpg");
        Links.add("https://thumb.wikimedia.org/wikipedia/commons/thumb/8/83/Japan_Airlines_Boeing_787-9_JA867J_after_departing_Runway_33L_Boston_Feb_2025_3.jpg/1920px-Japan_Airlines_Boeing_787-9_JA867J_after_departing_Runway_33L_Boston_Feb_2025_3.jpg");


        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(String link:Links){
                    HttpsURLConnection con = null;
                    try{
                        URL url = new URL(link);
                        con = (HttpsURLConnection) url.openConnection();
                        InputStream is = con.getInputStream();
                        listImages.add(BitmapFactory.decodeStream(is));

                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                lista = new ArrayList<>();
                lista.add(new ImagesDomain("Boeing 717", listImages.get(0),"https://en.wikipedia.org/wiki/Boeing_717"));
                lista.add(new ImagesDomain("Antonov An-148", listImages.get(1),"https://en.wikipedia.org/wiki/Antonov_An-148"));
                lista.add(new ImagesDomain("Bombardier CRJ100/200", listImages.get(2),"https://en.wikipedia.org/wiki/Bombardier_CRJ100/200"));
                lista.add(new ImagesDomain("Airbus A220", listImages.get(3),"https://en.wikipedia.org/wiki/Airbus_A220"));
                lista.add(new ImagesDomain("Boeing 787 Dreamliner", listImages.get(4),"https://en.wikipedia.org/wiki/Boeing_787_Dreamliner"));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}