package com.example.prm392.repository;

import android.content.Context;

import com.example.prm392.bean.CartItemBean;
import com.example.prm392.bean.ProductBean;
import com.example.prm392.dao.CartItemDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.CartItem;
import com.example.prm392.entity.Product;
import com.example.prm392.entity.relation.CartItemWithProduct;
import com.example.prm392.entity.relation.CartWithCartItems;
import com.example.prm392.utils.Mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartItemRepository {
    private final CartItemDAO cartItemDAO;

    public CartItemRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        this.cartItemDAO = appDatabase.cartItemDao();

    }

    public void insertCartItem(CartItemBean cartItemBean) {
        CartItem cartItem = Mapper.getInstance().map(cartItemBean, CartItem.class);
        cartItemDAO.insert(cartItem);
    }

    public int countCartItemsByCartId(int cartId) {
        Integer num = cartItemDAO.countCartItemsByCartId(cartId);
        return num == null ? 0 : num;

    }

    public List<CartItemBean> getCartItemsByCartId(int cartId) {
        CartWithCartItems cartWithCartItems = cartItemDAO.getCartItemsByCartId(cartId);

        if (cartWithCartItems.cartItems == null || cartWithCartItems.cartItems.isEmpty()) {
            return Collections.emptyList();
        }
        List<CartItemBean> cartItemBeans = new ArrayList<>();
        for (CartItem cartItem : cartWithCartItems.cartItems) {
            CartItemBean cartItemBean = Mapper.getInstance().map(cartItem, CartItemBean.class);
            CartItemWithProduct cartItemWithProduct = cartItemDAO.getCartItemWithProduct(cartItem.getProductId());
            ProductBean product = Mapper.getInstance().map(cartItemWithProduct.product, ProductBean.class);
            cartItemBean.setProduct(product);
            cartItemBeans.add(cartItemBean);
        }
        return cartItemBeans;


    }

    public int countCartItemByCartIdAndProductId(int cartId, int productId) {
        Integer quantity = cartItemDAO.countCartItemByCartIdAndProductId(cartId, productId);
        return quantity == null ? 0 : quantity;
    }

    //   public  void updateQuantityOfCartItem(int quantity, int productId){
//        cartItemDAO.updateQuantityOfCartItem(quantity, productId);
//    }
    public CartItemBean getCartItemByCartIdAndProductId(int cartId, int productId) {
        CartItem cartItem = cartItemDAO.getCartItemByCartIdAndProductId(cartId, productId);
        return Mapper.getInstance().map(cartItem, CartItemBean.class);
    }

    public void updateCartItem(CartItemBean cartItemBean) {
        CartItem cartItem = Mapper.getInstance().map(cartItemBean, CartItem.class);
        cartItemDAO.updateCartItem(cartItem);
    }

    public int deleteCartItemByID(int id) {
        return cartItemDAO.deleteCartItemByID(id);
    }

    public int increaseCartItemQuantity(int cartItemId) {
        return cartItemDAO.increaseCartItemQuantity(cartItemId);
    }

    public int decreaseCartItemQuantity(int cartItemId) {
        return cartItemDAO.decreaseCartItemQuantity(cartItemId);
    }


}
