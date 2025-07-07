package com.example.prm392.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.prm392.Fragment.HomeFragment;
import com.example.prm392.Fragment.SupportFragment;
import com.example.prm392.R;
import com.example.prm392.bean.ProvinceBean;
import com.example.prm392.dao.CategoryDAO;
import com.example.prm392.dao.ProvinceDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.Category;
import com.example.prm392.entity.Province;
import com.example.prm392.repository.LocationRepository;
import com.example.prm392.utils.ParseJSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy CategoryDAO
        AppDatabase db = AppDatabase.getInstance(this);
        categoryDAO = db.categoryDAO();

        // Thêm category mẫu
        Category cat = new Category();
        cat.setName("Đàn Guitar");
        cat.setDescription("Các loại đàn guitar acoustic và electric") ;
        cat.setImageUrl(null);


        categoryDAO.insert(cat);

        // In ra tất cả category
        String json = ParseJSON.loadJSONFromRaw(this, R.raw.hanoi).toString();
        Log.d("DEBUG", "JSON content = " + json);

        ProvinceBean provinceBean = ParseJSON.parseJSONFromRaw(this, R.raw.hanoi);
        Log.d("DEBUGG", "ProvinceBean = " + provinceBean.getDistricts().size());

        LocationRepository locationRepository = new LocationRepository(this);

       Log.d("Province",locationRepository.getProvince().toString());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new HomeFragment())
                .commit();

        findViewById(R.id.btnSupport).setOnClickListener(v -> {
            loadFragment(new SupportFragment());
        });

        findViewById(R.id.btnHome).setOnClickListener(v -> {
            loadFragment(new HomeFragment());
        });
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, fragment)
                .addToBackStack(null)
                .commit();
    }


}