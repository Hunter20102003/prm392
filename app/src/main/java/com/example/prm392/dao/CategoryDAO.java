package com.example.prm392.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm392.entity.Category;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Category category);

    @Query("SELECT * FROM categories")
    List<Category> getAll();
}
