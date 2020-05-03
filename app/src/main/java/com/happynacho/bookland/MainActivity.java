package com.happynacho.bookland;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private BookDBMS bookDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navi = findViewById(R.id.nav_view);
        navi.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        bookDB = new BookDBMS(this);

        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentWelcome()).commit();

            navi.setCheckedItem(R.id.i_bc_art);
        }

        RequestQueue queue = Volley.newRequestQueue(this);

        final String url ="http://androidstorepddm.000webhostapp.com/services/getbooks.php?category=scifi";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(null,"Response is: "+ response);
                        JSONArray jsonArray = null;
                        JSONObject jsonObject = null;
                        try {
                            jsonArray = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i = 0; i < jsonArray.length();i++){
                            try {
                                jsonObject = jsonArray.getJSONArray(i).getJSONObject(0);
                                String id_book = jsonObject.getString("id_book");
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String category = jsonObject.getString("category");
                                String editorial = jsonObject.getString("editorial");
                                String description = jsonObject.getString("description");
                                String price = jsonObject.getString("price");
                                String url_picture = jsonObject.getString("url_picture");
                                Log.e(null,"id: "+id_book+"\ntitle: "+title+"\nauthor: "+author+"\ncategory: "+category+"\neditorial: "+editorial+"\ndescription: "+description+"\nprice: "+price+"\nurl_picture: "+url_picture);
                                Book book = new Book(id_book,title,author,category,editorial,description,price,url_picture);
                                bookDB.insertBook(book);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(null,"That didn't work!");

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        final String url2 ="http://androidstorepddm.000webhostapp.com/services/getbooks.php?category=english";
// Request a string response from the provided URL.
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        JSONObject jsonObject = null;
                        try {
                            jsonArray = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i = 0; i < jsonArray.length();i++){
                            try {
                                jsonObject = jsonArray.getJSONArray(i).getJSONObject(0);
                                String id_book = jsonObject.getString("id_book");
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String category = jsonObject.getString("category");
                                String editorial = jsonObject.getString("editorial");
                                String description = jsonObject.getString("description");
                                String price = jsonObject.getString("price");
                                String url_picture = jsonObject.getString("url_picture");
                                Log.e(null,"id: "+id_book+"\ntitle: "+title+"\nauthor: "+author+"\ncategory: "+category+"\neditorial: "+editorial+"\ndescription: "+description+"\nprice: "+price+"\nurl_picture: "+url_picture);
                                Book book = new Book(id_book,title,author,category,editorial,description,price,url_picture);
                                bookDB.insertBook(book);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(null,"That didn't work!");

            }
        });


// Add the request to the RequestQueue.
        queue.add(stringRequest2);
        final String url3 ="http://androidstorepddm.000webhostapp.com/services/getbooks.php?category=comics";
// Request a string response from the provided URL.
        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, url3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        JSONObject jsonObject = null;
                        try {
                            jsonArray = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i = 0; i < jsonArray.length();i++){
                            try {
                                jsonObject = jsonArray.getJSONArray(i).getJSONObject(0);
                                String id_book = jsonObject.getString("id_book");
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String category = jsonObject.getString("category");
                                String editorial = jsonObject.getString("editorial");
                                String description = jsonObject.getString("description");
                                String price = jsonObject.getString("price");
                                String url_picture = jsonObject.getString("url_picture");
                                Log.e(null,"id: "+id_book+"\ntitle: "+title+"\nauthor: "+author+"\ncategory: "+category+"\neditorial: "+editorial+"\ndescription: "+description+"\nprice: "+price+"\nurl_picture: "+url_picture);
                                Book book = new Book(id_book,title,author,category,editorial,description,price,url_picture);
                                bookDB.insertBook(book);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(null,"That didn't work!");

            }
        });


// Add the request to the RequestQueue.
        queue.add(stringRequest3);
        final String url4 ="http://androidstorepddm.000webhostapp.com/services/getbooks.php?category=art";
// Request a string response from the provided URL.
        StringRequest stringRequest4 = new StringRequest(Request.Method.GET, url4,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        JSONObject jsonObject = null;
                        try {
                            jsonArray = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i = 0; i < jsonArray.length();i++){
                            try {
                                jsonObject = jsonArray.getJSONArray(i).getJSONObject(0);
                                String id_book = jsonObject.getString("id_book");
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String category = jsonObject.getString("category");
                                String editorial = jsonObject.getString("editorial");
                                String description = jsonObject.getString("description");
                                String price = jsonObject.getString("price");
                                String url_picture = jsonObject.getString("url_picture");
                                Log.e(null,"id: "+id_book+"\ntitle: "+title+"\nauthor: "+author+"\ncategory: "+category+"\neditorial: "+editorial+"\ndescription: "+description+"\nprice: "+price+"\nurl_picture: "+url_picture);
                                Book book = new Book(id_book,title,author,category,editorial,description,price,url_picture);
                                bookDB.insertBook(book);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(null,"That didn't work!");

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest4);
        final String url5 ="http://androidstorepddm.000webhostapp.com/services/getbooks.php?category=self";
// Request a string response from the provided URL.
        StringRequest stringRequest5 = new StringRequest(Request.Method.GET, url5,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        JSONObject jsonObject = null;
                        try {
                            jsonArray = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i = 0; i < jsonArray.length();i++){
                            try {
                                jsonObject = jsonArray.getJSONArray(i).getJSONObject(0);
                                String id_book = jsonObject.getString("id_book");
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String category = jsonObject.getString("category");
                                String editorial = jsonObject.getString("editorial");
                                String description = jsonObject.getString("description");
                                String price = jsonObject.getString("price");
                                String url_picture = jsonObject.getString("url_picture");
                                Log.e(null,"id: "+id_book+"\ntitle: "+title+"\nauthor: "+author+"\ncategory: "+category+"\neditorial: "+editorial+"\ndescription: "+description+"\nprice: "+price+"\nurl_picture: "+url_picture);
                                Book book = new Book(id_book,title,author,category,editorial,description,price,url_picture);
                                bookDB.insertBook(book);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(null,"That didn't work!");

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest5);
        final String url6 ="http://androidstorepddm.000webhostapp.com/services/getbooks.php?category=sports";
// Request a string response from the provided URL.
        StringRequest stringRequest6 = new StringRequest(Request.Method.GET, url6,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        JSONObject jsonObject = null;
                        try {
                            jsonArray = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for(int i = 0; i < jsonArray.length();i++){
                            try {
                                jsonObject = jsonArray.getJSONArray(i).getJSONObject(0);
                                String id_book = jsonObject.getString("id_book");
                                String title = jsonObject.getString("title");
                                String author = jsonObject.getString("author");
                                String category = jsonObject.getString("category");
                                String editorial = jsonObject.getString("editorial");
                                String description = jsonObject.getString("description");
                                String price = jsonObject.getString("price");
                                String url_picture = jsonObject.getString("url_picture");
                                Log.e(null,"id: "+id_book+"\ntitle: "+title+"\nauthor: "+author+"\ncategory: "+category+"\neditorial: "+editorial+"\ndescription: "+description+"\nprice: "+price+"\nurl_picture: "+url_picture);
                                Book book = new Book(id_book,title,author,category,editorial,description,price,url_picture);
                                bookDB.insertBook(book);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(null,"That didn't work!");

            }
        });


// Add the request to the RequestQueue.
        queue.add(stringRequest6);
    }

    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.i_bc_scifi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentCategory()).commit();
                break;
            case R.id.i_bc_sports:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentCategory()).commit();
                break;

            case R.id.i_bc_englishlit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentCategory()).commit();
                break;

            case R.id.i_bc_art:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentCategory()).commit();
                break;

            case R.id.i_bc_comics:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentCategory()).commit();
                break;
            case R.id.i_bc_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentCategory()).commit();
                break;

            case R.id.i_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMaps()).commit();
                break;
            case R.id.i_email:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentEmail()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

}
