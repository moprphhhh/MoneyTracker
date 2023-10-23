package com.example.moneytracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.moneytracker.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_add, R.id.navigation_statistics)
                .build();
        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);*/
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

/*
        navView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {// 홈 탭 클릭 시 홈 화면 목적지로 이동
                navController.navigate(R.id.home_activity_destination);
                return true;
            } else if (itemId == R.id.navigation_add) {// 다른 탭에 대한 처리
                return true;
            } else if (itemId == R.id.navigation_statistics) {// 다른 탭에 대한 처리
                return true;
            }
            return false;
        });
*/


    }

}