package com.example.prm392.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm392.entity.User;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM users WHERE user_id = :id")
    User getUserById(int id);
}
