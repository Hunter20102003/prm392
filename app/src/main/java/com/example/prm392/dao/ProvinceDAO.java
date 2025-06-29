package com.example.prm392.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.prm392.entity.Province;

import java.util.List;

@Dao
public interface ProvinceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Province province);
    @Query("SELECT * FROM provinces")
    List<Province> getAllProvinces();

}
