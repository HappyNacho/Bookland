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
    RecyclerView.LayoutManager manejadorLayout;
    BookAdapter adapter;
    private String filtro = "";
    List<Book> book_list;
    private Handler handler = new Handler();

    JSONArray json;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_category, container, false);
    }

    public void onCreate(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setContentView(R.layout.frag_category);
        book_list = new ArrayList<>();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        manejadorLayout = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(manejadorLayout);


       /* RequestBook.getRequest(this,this);
        Toast.makeText(getApplicationContext(),"Getting data from server. . .",Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                try {
                    adapter.notifyDataSetChanged();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);
        */
        populateRecyclerView();
    }

    private void populateRecyclerView()
    {

        adapter = new BookAdapter(book_list, getActivity().getApplicationContext(), recyclerView);
        recyclerView.setAdapter(adapter);
    }
    private String getResponse(String response)
    {
        return response;
    }
    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    public void processJSON(String response) {
        try{
            json = new JSONArray(response);

            for(int i = 0; i<json.length();i++)
            {
                JSONArray jsonArray = json.getJSONArray(i);

                Book book = new Book();
                book.setTitle(jsonArray.getJSONObject(0).getString("title"));
                book.setAuthor(jsonArray.getJSONObject(0).getString("author"));
                book.setCategory(jsonArray.getJSONObject(0).getString("category"));
                book.setEditorial(jsonArray.getJSONObject(0).getString("editorial"));
                book.setDescription(jsonArray.getJSONObject(0).getString("description"));
                book.setPrice(jsonArray.getJSONObject(0).getString("price"));
                book.setUrl_image(jsonArray.getJSONObject(0).getString("urlImage"));
                book_list.add(book);
            }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
    }


}
