package com.example.ocrreceipt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ocrreceipt.databinding.ActivityMainBinding;
import com.example.ocrreceipt.ui.add.AddFragment;
import com.example.ocrreceipt.ui.home.HomeFragment;
import com.example.ocrreceipt.ui.stats.StatsFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setBottomNavigationView();

        //앱 초기 실행 시 홈화면으로 설정
        if(savedInstanceState == null){
            binding.bottomnav.setSelectedItemId(R.id.navigation_home);
        }


    }

    public void setBottomNavigationView() {
        binding.bottomnav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
                return true;
            } else if (itemId == R.id.navigation_add) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new AddFragment()).commit();
                return true;
            } else if (itemId == R.id.navigation_stats) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new StatsFragment()).commit();
                return true;
            }
            return false;
        });
    }
}