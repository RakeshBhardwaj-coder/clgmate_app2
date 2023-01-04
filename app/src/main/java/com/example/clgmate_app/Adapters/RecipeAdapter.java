package com.example.clgmate_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clgmate_app.Models.RecipeModel;
import com.example.clgmate_app.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

// adapter is used to fetch data from data source and to show it on any view.

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.viewHolder> {

    ArrayList<RecipeModel> list;
    Context context;

    public RecipeAdapter(ArrayList<RecipeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    // in oncreateviewholder we will inflate the recyclerview layout
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_recyclarview , parent, false);
        return new viewHolder(view);

    }

    @Override
    //we will get the values set of text and image view from sample_recyclarview
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        RecipeModel model = list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

        // now we will set OnclickListner on images in homefragment

//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(context, "Item is clicked", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        //now will get the postion

        switch (position){
            case 0:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    //this is called method or function in java
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Syllabus", Toast.LENGTH_SHORT).show();
                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Add Syllabus feature", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case 1:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    //this is called method or function in java
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(context, "Ebook", Toast.LENGTH_SHORT).show();
                    }
                });

                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(context, "Add Ebook feature ", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case 2:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    //this is called method or function in java
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(context, "Academic Calender", Toast.LENGTH_SHORT).show();
                    }
                });

                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(context, "Add Academic Calender feature", Toast.LENGTH_SHORT).show();

                    }
                });
                break;

            case 3:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    //this is called method or function in java
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(context, "Faculty", Toast.LENGTH_SHORT).show();
                    }
                });

                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(context, "Add Faculty feature", Toast.LENGTH_SHORT).show();

                    }
                });
            break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ebook);
            textView = itemView.findViewById(R.id.textView3);

        }
    }

}
