package com.example.clgmate_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainPage extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment  = new AboutFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);




        // bottom nevigation view fragments

         bottomNavigationView = findViewById(R.id.bottom_navigation);

         //This will help replacing the container that is frame layout with home fragment while we open our app

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        //On setOnItemClickListner we will check whether the item is home, about or profile

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        //it will replace the container with home fragment
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;

                    case R.id.about:
                        //it will replace the container with about fragment
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,aboutFragment).commit();
                        return true;

                    case R.id.profile:
                        //it will replace the container with profile fragment
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;

                }

                return false;
            }
        });








    }
}