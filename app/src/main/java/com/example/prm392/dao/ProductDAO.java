package com.example.prm392.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm392.entity.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM products")
    List<Product> selectAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product product);
}
