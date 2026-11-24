package com.example.lab_04;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        // Allow webpages to open inside the WebView
        webView.setWebViewClient(new WebViewClient());

        // Enable JavaScript if needed by the webpage
        webView.getSettings().setJavaScriptEnabled(true);

        // Receive URL from AvionWebAdapter
        String link = getIntent().getStringExtra("link");

        if (link != null && !link.isEmpty()) {

            webView.loadUrl(link);

        } else {

            Toast.makeText(
                    this,
                    "Invalid link!",
                    Toast.LENGTH_SHORT
            ).show();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}