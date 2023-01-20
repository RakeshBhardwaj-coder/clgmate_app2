package com.example.clgmate_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rajat.pdfviewer.PdfViewerActivity;

public class Academic_Calender extends AppCompatActivity {

    Button cldView1;
    TextView cldFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calender);

        cldFileName = findViewById(R.id.tvAacFileName1);
        cldFileName.setText("Academic_Calender_2022.pdf");
        cldView1 = findViewById(R.id.btnAacView1);
        cldView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PdfViewerActivity.Companion.launchPdfFromPath(
                        getApplicationContext(),
                        "Academic_Calender_2022.pdf",
                        "Academic_Calender_2022/name",
                        "assets",
                        false,
                        true

                ));
            }
        });
    }
}