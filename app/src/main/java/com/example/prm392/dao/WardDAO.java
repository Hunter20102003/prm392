package com.example.prm392.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.prm392.entity.Ward;

import java.util.List;

@Dao
public interface WardDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Ward ward);
    @Query("SELECT * FROM wards")
    List<Ward> getAllWards();
}
