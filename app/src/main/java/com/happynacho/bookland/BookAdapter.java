package com.happynacho.bookland;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ArrayList<Book> book_list;
    private Context context;

    public BookAdapter(ArrayList<Book>book_list, Context context){
        this.book_list=book_list;
        this.context=context;

    }


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_userlayout,null,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.title.setText("Title: "+book_list.get(position).getTitle());
        holder.author.setText("Author: "+book_list.get(position).getAuthor());
        holder.category.setText("Category: "+book_list.get(position).getCategory());
        holder.editorial.setText("Editorial: "+book_list.get(position).getEditorial());
        holder.description.setText("Description: "+book_list.get(position).getDescription());
        holder.price.setText("Price: "+book_list.get(position).getPrice());
        Picasso.with(context).load(book_list.get(position).getUrl_image()).placeholder(R.mipmap.ic_launcher_round).into(holder.image);


    }



    @Override
    public int getItemCount() {
        return book_list.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        TextView title,author,category,editorial,description,price;
        ImageView image;
        public BookViewHolder (View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            author = itemView.findViewById(R.id.textViewAuthor);
            category = itemView.findViewById(R.id.textViewCategory);
            editorial = itemView.findViewById(R.id.textViewEditorial);
            description = itemView.findViewById(R.id.textViewDescription);
            price = itemView.findViewById(R.id.textViewPrice);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
