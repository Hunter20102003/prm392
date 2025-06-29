package com.example.prm392.repository;

import android.content.Context;
import android.util.Log;

import com.example.prm392.dao.ProductDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.Product;

import java.util.List;

public class ProductRepository {
private final ProductDAO productDAO;

    public ProductRepository(Context context) {
        AppDatabase productRoomDatabase = AppDatabase.getInstance(context);
        productDAO = productRoomDatabase.productDao();
    }
    //test
    public void addProduct(Product product) {
       // productDAO.insert(product);
    }

    public void printAllProducts() {
//        List<Product> list = productDAO.selectAll();
//        for (Product p : list) {
//            Log.d("PRODUCT_LOG", "ID: " + p.productId +
//                    ", Name: " + p.name +
//                    ", New Price: " + p.newPrice +
//                    ", Stock: " + p.stockQuantity);
//        }
    }

}
