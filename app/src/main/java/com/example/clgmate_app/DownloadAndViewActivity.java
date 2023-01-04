package com.example.clgmate_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.clgmate_app.R;

public class DownloadAndViewActivity extends AppCompatActivity {

    private TextView tvFileName;
    private Button btnDownload, btnView;

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
//        Toolbar toolbar = findViewById(R.id.syllabus);
//        setSupportActionBar(toolbar);

    }

    private void initViews() {
        tvFileName = findViewById(R.id.tvUrl);
        btnDownload = findViewById(R.id.btnDownload);
        btnView = findViewById(R.id.btnView);


        try {
            url = new URL(filepath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        fileName = url.getPath();
        fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
        tvFileName.setText(fileName);
    }

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

        btnView.setOnClickListener(v -> {
            File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/"+fileName);
            Uri uri= FileProvider.getUriForFile(DownloadAndViewActivity.this ,"com.example.clgmate_app"+".provider",file);
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setDataAndType(uri,"application/pdf");
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(i);

        });
    }

}