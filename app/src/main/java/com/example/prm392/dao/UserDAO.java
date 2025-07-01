package com.example.prm392.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm392.entity.User;

import java.util.List;

@Dao
public interface UserDAO {

    // Thêm người dùng
    @Insert
    void insertUser(User user);

    // Cập nhật thông tin người dùng
    @Update
    void updateUser(User user);

    // Xóa người dùng
    @Delete
    void deleteUser(User user);

    // Lấy toàn bộ người dùng
    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    // Lấy người dùng theo ID
    @Query("SELECT * FROM users WHERE user_id = :id")
    User getUserById(int id);

    // Tìm người dùng theo email
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    User getUserByEmail(String email);

    // Tìm người dùng theo email + password (dùng cho login)
    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    User login(String email, String password);

    // Kiểm tra email đã tồn tại chưa
    @Query("SELECT COUNT(*) FROM users WHERE email = :email")
    int checkEmailExists(String email);
}
