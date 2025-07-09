package com.example.prm392.listener;

import com.example.prm392.bean.CartItemBean;

public interface CartItemListener {

        void onQuantityChanged(CartItemBean item, int newQuantity);
        void onItemCheckedChanged(CartItemBean item, boolean isChecked);
        void onItemDeleted(CartItemBean item);


}
