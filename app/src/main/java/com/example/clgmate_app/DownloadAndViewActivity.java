package com.example.clgmate_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.clgmate_app.R;
import com.rajat.pdfviewer.PdfViewerActivity;

public class DownloadAndViewActivity extends AppCompatActivity {

    private TextView tvFileName,tvFileName2;
    Button btnDownload;
    private Button  btnView1, btnView2;

    private String filepath = "http://192.168.181.228/7th%20Sem%20syllabus%20IT.pdf";
    private URL url = null;
    private String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_and_view);

        initViews();
        setListeners();

        //toolbar in syllabus
        btnView1 = findViewById(R.id.btnAavaView);
        btnView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PdfViewerActivity.Companion.launchPdfFromPath(
                        getApplicationContext(),
                        "7th_sem_syllabus.pdf",
                        "7th_sem_syllabus/name",
                        "assets",
                        false,
                        true

                ));
            }
        });
        btnView2 = findViewById(R.id.btnAavaView2);
        btnView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PdfViewerActivity.Companion.launchPdfFromPath(
                        getApplicationContext(),
                        "8th_sem_syllabus.pdf",
                        "8th_sem_syllabus/name",
                        "assets",
                        false,
                        true

                ));
            }
        });


    }

    private void initViews() {
        tvFileName = findViewById(R.id.tvAavaFileName);
        btnDownload = findViewById(R.id.btnAavaDownload);
        btnView1 = findViewById(R.id.btnAavaView);


        try {
            url = new URL(filepath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        fileName = url.getPath();
        fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
        tvFileName.setText("7th_sem_syllabus.pdf");
        tvFileName2 = findViewById(R.id.tvAavaFileName2);
        tvFileName2.setText("8th_sem_syllabus.pdf");
    }
//
    private void setListeners() {

        btnDownload.setOnClickListener(v -> {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url + ""));
            request.setTitle(fileName);
            request.setMimeType("applcation/pdf");
            request.allowScanningByMediaScanner();
            request.setAllowedOverMetered(true);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
            DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            dm.enqueue(request);
        });

        btnView1.setOnClickListener(v -> {
            File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/"+fileName);
            Uri uri= FileProvider.getUriForFile(DownloadAndViewActivity.this ,"com.example.clgmate_app"+".provider",file);
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setDataAndType(uri,"application/pdf");
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(i);

        });
    }

}