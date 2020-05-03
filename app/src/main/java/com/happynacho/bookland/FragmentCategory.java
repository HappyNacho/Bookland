package com.happynacho.bookland;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;

public class FragmentCategory extends Fragment {


    RecyclerView recyclerView;
    ArrayList<Book> book_list;
    String category;

    public FragmentCategory (String category){
        this.category=category;
        book_list= new ArrayList<>();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.frag_category, container, false);
        book_list = new ArrayList<>();
        recyclerView = vista.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarlista();
        BookAdapter adapter = new BookAdapter(book_list,getContext());
        recyclerView.setAdapter(adapter);
        return vista;
                //inflater.inflate(R.layout.frag_category, container, false);

    }
    public void llenarlista(){
        ArrayList<Book> fullList = ((MainActivity)getActivity()).getBookDB().getAllBooks();
        for(int i = 0;i < fullList.size(); i++){
            if(fullList.get(i).getCategory().equals(this.category)){
                book_list.add(fullList.get(i));
            }
        }
    }



}
