package com.happynacho.bookland;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
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

        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentEmail()).commit();

            navi.setCheckedItem(R.id.i_bc_art);
        }

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
                        new FragmentEmail()).commit();
                break;
            case R.id.i_bc_sports:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentEmail()).commit();
                break;

            case R.id.i_bc_englishlit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentEmail()).commit();
                break;

            case R.id.i_bc_art:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentEmail()).commit();
                break;

            case R.id.i_bc_comics:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentEmail()).commit();
                break;
            case R.id.i_bc_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentEmail()).commit();
                break;

            case R.id.i_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentEmail()).commit();
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
