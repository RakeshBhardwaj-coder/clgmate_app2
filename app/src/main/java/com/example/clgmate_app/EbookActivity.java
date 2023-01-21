package com.example.clgmate_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.clgmate_app.Adapters.SamplerAdapter;
import com.example.clgmate_app.Models.SamplerModel;
import com.rajat.pdfviewer.PdfViewerActivity;

import java.util.ArrayList;

public class EbookActivity extends AppCompatActivity {

    Button viewEbook1,viewEbook2;
    TextView bookName1,bookName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        //for three dots

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewEbook1 = findViewById(R.id.btnAeView1);
        bookName1 = findViewById(R.id.tvAeFileName1);
        bookName1.setText("Cryptography_and_Network_Security.pdf");

        viewEbook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PdfViewerActivity.Companion.launchPdfFromPath(
                        getApplicationContext(),
                        "Cryptography_and_Network_Security.pdf",
                        "Cryptography_and_Network_Security/name",
                        "assets",
                        false,
                        true

                ));
            }
        });

        bookName2 = findViewById(R.id.tvAeFileName2);
        bookName2.setText("ERP.pdf");
        viewEbook2 = findViewById(R.id.btnAeView2);
        viewEbook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PdfViewerActivity.Companion.launchPdfFromPath(
                        getApplicationContext(),
                        "ERP.pdf",
                        "ERP/name",
                        "assets",
                        false,
                        true

                ));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       menu.add("upload");

        return super.onCreateOptionsMenu(menu);
    }
}