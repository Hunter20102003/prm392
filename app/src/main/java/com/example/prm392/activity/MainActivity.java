package com.example.prm392.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.prm392.R;
import com.example.prm392.bean.ProvinceBean;
import com.example.prm392.dao.CategoryDAO;
import com.example.prm392.dao.ProvinceDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.Category;
import com.example.prm392.entity.Province;
import com.example.prm392.repository.LocationRepository;
import com.example.prm392.utils.ParseJSON;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, ProductDetail.class);
       // intent.putExtra("productId", 1); // 1 là id sản phẩm ví dụ
        startActivity(intent);
//       //  Lấy CategoryDAO
//       AppDatabase db = AppDatabase.getInstance(this);
//     categoryDAO = db.categoryDAO();
//     Log.d("test",categoryDAO.getAll().toString());
//
//        // Thêm category mẫu
//        Category cat = new Category();
//        cat.setName("Đàn Guitar");
//        cat.setDescription("Các loại đàn guitar acoustic và electric") ;
//        cat.setImageUrl(null);
//
//
//      // categoryDAO.insert(cat);
//
//        // In ra tất cả category
//        String json = ParseJSON.loadJSONFromRaw(this, R.raw.hanoi).toString();
//        Log.d("DEBUG", "JSON content = " + json);
//
//        ProvinceBean provinceBean = ParseJSON.parseJSONFromRaw(this, R.raw.hanoi);
//        Log.d("DEBUGG", "ProvinceBean = " + provinceBean.getDistricts().size());
//        Log.d("DB", "AppDatabase created");

       // LocationRepository locationRepository = new LocationRepository(this);
        //insert location data
//       locationRepository.insertLocationData(provinceBean);
      // Log.d("Province",locationRepository.getProvince().toString());


    }

//    private void printAllCategories() {
//        List<Category> categories = categoryDAO.getAll();
//        for (Category c : categories) {
//            Log.d("CATEGORY_LOG", "ID: " + c.getCategoryId() +
//                    ", Name: " + c.getName() +
//                    ", Description: " + c.getDescription());
//        }
//    }
//    private void seedDataIfNeeded(Context context) {
//        SharedPreferences prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
//        boolean isSeeded = prefs.getBoolean("data_seeded", false);
//
//        if (!isSeeded) {
//                try {
//                    ProvinceBean provinceBean=ParseJSON.parseJSON(context,String.valueOf(R.raw.hanoi));
//
//                    // Convert DTO → Entity
//                    Province province = new Province(provinceBean.getId(), provinceBean.getName());
//                    long provinceId = AppDatabase.Prov().insert(province);
//
//                    for (DistrictDto districtDto : provinceDto.Districts) {
//                        District district = new District(districtDto.Id, districtDto.Name, provinceId);
//                        long districtId = db.districtDao().insert(district);
//
//                        for (WardDto wardDto : districtDto.Wards) {
//                            Ward ward = new Ward(wardDto.Id, wardDto.Name, wardDto.Level, districtId);
//                            db.wardDao().insert(ward);
//                        }
//                    }
//
//                    prefs.edit().putBoolean("data_seeded", true).apply(); // Đánh dấu đã insert
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//        }
//    }

}