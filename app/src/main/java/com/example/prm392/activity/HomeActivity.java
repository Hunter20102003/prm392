package com.example.prm392.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392.R;
import com.example.prm392.adapter.ProductAdapter;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.relation.ProductWithProductImages;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        AppDatabase db = AppDatabase.getInstance(this);

        List<ProductWithProductImages> products = db.productDao().getAllProductsWithImages();

        adapter = new ProductAdapter(this, products);
        recyclerView.setAdapter(adapter);
    }
}
