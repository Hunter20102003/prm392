package com.example.prm392.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.prm392.entity.Product;
import com.example.prm392.entity.relation.ProductWithProductImages;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM products")
    List<Product> selectAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Product product);

    @Transaction
    @Query("SELECT * FROM products")
    List<ProductWithProductImages> getAllProductsWithImages();
}
