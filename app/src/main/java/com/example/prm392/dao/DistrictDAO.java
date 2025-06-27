package com.example.prm392.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.prm392.entity.District;

import java.util.List;

@Dao
public interface DistrictDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(District district);
    @Query("SELECT * FROM districts")
    List<District> getAllDistricts();
}
