package com.example.clgmate_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.clgmate_app.Adapters.SamplerAdapter;
import com.example.clgmate_app.Models.SamplerModel;

import java.util.ArrayList;

public class EbookActivity extends AppCompatActivity {

    RecyclerView rvEbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        ArrayList<SamplerModel> allBooksData = new ArrayList<>();
        rvEbook = findViewById(R.id.rvAeBook);

        // Set data to recycle view
        rvEbook.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
        rvEbook.setAdapter(new SamplerAdapter(EbookActivity.this,allBooksData));
    }
}