package com.example.prm392.repository;

import android.content.Context;

import com.example.prm392.bean.UserBean;
import com.example.prm392.dao.UserDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.User;
import com.example.prm392.utils.Mapper;

public class UserRepository {
    private final UserDAO userDao;
    public UserRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        this.userDao = appDatabase.userDao();
    }
    public UserBean getUserById(int id) {
     User user = userDao.getUserById(id);
     return Mapper.getInstance().map(user, UserBean.class);
    }
}
