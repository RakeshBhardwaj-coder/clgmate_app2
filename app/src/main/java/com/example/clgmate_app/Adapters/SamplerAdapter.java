package com.example.clgmate_app.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clgmate_app.EbookActivity;
import com.example.clgmate_app.Models.SamplerModel;
import com.example.clgmate_app.R;

import java.util.ArrayList;

public class SamplerAdapter extends RecyclerView.Adapter<SamplerAdapter.SamplerHolder> {

    EbookActivity ebookActivity;

    public SamplerAdapter(EbookActivity ebookActivity, ArrayList<SamplerModel> allBooksData) {
        this.ebookActivity = ebookActivity;
        this.allBooksData = allBooksData;
    }

    ArrayList<SamplerModel> allBooksData;
    @NonNull
    @Override
    public SamplerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SamplerHolder(LayoutInflater.from(ebookActivity).inflate(R.layout.sampler_ebook_design_show,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SamplerAdapter.SamplerHolder holder, int position) {
        holder.tvBookName.setText(allBooksData.get(position).getBookName());
        holder.tvBookAuthor.setText(allBooksData.get(position).getBookAuthor());

        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return allBooksData.size();
    }

    public class SamplerHolder extends RecyclerView.ViewHolder {

        TextView tvBookName,tvBookAuthor;
        Button btnDownload, btnView;

        public SamplerHolder(@NonNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.bookName);
            tvBookAuthor = itemView.findViewById(R.id.bookAuthorName);

            btnDownload = itemView.findViewById(R.id.btnDownload);
            btnView = itemView.findViewById(R.id.btnView);


        }
    }
}
