package com.example.clgmate_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rajat.pdfviewer.PdfRendererView;
import com.rajat.pdfviewer.PdfViewerActivity;

public class PdfActivity extends AppCompatActivity {

    PdfRendererView pdfBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfBook = (PdfRendererView) findViewById(R.id.pdfRendererView);
        startActivity(PdfViewerActivity.Companion.launchPdfFromPath(
                this,
                "7th_sem_syllabus.pdf",
                "7th_sem_syllabus/name",
                "assets",
                false,
                true

        ));
    }
}