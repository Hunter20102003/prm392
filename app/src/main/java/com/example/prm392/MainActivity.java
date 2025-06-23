package com.example.prm392;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.prm392.dao.CategoryDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.Category;

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
        cat.name = "Đàn Guitar";
        cat.description = "Các loại đàn guitar acoustic và electric";
        cat.imageUrl = null;
        cat.createdAt = "2025-06-23";
        cat.updatedAt = "2025-06-23";

        categoryDAO.insert(cat);

        // In ra tất cả category
        printAllCategories();
    }

    private void printAllCategories() {
        List<Category> categories = categoryDAO.getAll();
        for (Category c : categories) {
            Log.d("CATEGORY_LOG", "ID: " + c.categoryId +
                    ", Name: " + c.name +
                    ", Description: " + c.description);
        }
    }
}