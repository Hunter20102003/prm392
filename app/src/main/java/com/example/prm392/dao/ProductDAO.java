package com.example.prm392.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.prm392.entity.Product;
import com.example.prm392.entity.relation.ProductWithCategoryAndImages;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM products")
    List<Product> selectAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product product);

    @Transaction
    @Query ("select * from products where product_id = :id")
    ProductWithCategoryAndImages getProductsWithCategoryAndImagesById(Integer id);
}
