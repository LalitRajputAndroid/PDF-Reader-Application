package com.example.pdfreader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.pdfreader.Fragments.Favourite;
import com.example.pdfreader.Fragments.file_fragment;
import com.example.pdfreader.Fragments.Recent;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomNav_id);
        frameLayout = findViewById(R.id.framelayout_id);


        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new file_fragment()).commit();

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.file_id:
                        fragment = new file_fragment();
                        break;
                    case R.id.recent_id:
                        fragment = new Recent();
                        break;
                    case R.id.favourite_id:
                        fragment = new Favourite();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, fragment).commit();
                return true;
            }
        });

    }
}