package com.example.prm392.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm392.entity.ProductImage;

@Dao
public interface ProductImageDAO {
    @Insert
    void insert(ProductImage productImage);
}
