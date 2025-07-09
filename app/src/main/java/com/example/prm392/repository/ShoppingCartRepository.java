package com.example.prm392.repository;

import android.content.Context;

import com.example.prm392.bean.ShoppingCartBean;
import com.example.prm392.dao.ShoppingCartDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.ShoppingCart;
import com.example.prm392.utils.Mapper;

public class ShoppingCartRepository {
    private final ShoppingCartDAO shoppingCartDAO;

    public ShoppingCartRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        shoppingCartDAO = appDatabase.shoppingCartDao();

    }

    public void insertShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDAO.insert(shoppingCart);
    }

    public ShoppingCartBean getShoppingCartById(int id) {
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartById(id);
        return Mapper.getInstance().map(shoppingCart, ShoppingCartBean.class);
    }

    public ShoppingCartBean getShoppingCartByUserId(int userId) {
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartByUserId(userId);
        return Mapper.getInstance().map(shoppingCart, ShoppingCartBean.class);

    }

}
