// CartActivity.java
package com.example.prm392.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392.R;
import com.example.prm392.adapter.CartItemAdapter;
import com.example.prm392.bean.CartItemBean;
import com.example.prm392.listener.CartItemListener;
import com.example.prm392.repository.CartItemRepository;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    private CartItemRepository cartItemRepository;
    private RecyclerView recyclerView;
    private CartItemAdapter cartItemAdapter;
    private TextView tvTotalAmount;
    private CheckBox checkboxSelectAll;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerCartItems);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        checkboxSelectAll = findViewById(R.id.checkboxSelectAll);
        btnCheckout = findViewById(R.id.btnCheckout);

        cartItemRepository = new CartItemRepository(this);
        List<CartItemBean> cartItemBeans = cartItemRepository.getCartItemsByCartId(1);

        cartItemAdapter = new CartItemAdapter(cartItemBeans, new CartItemListener() {
            @Override
            public void onQuantityChanged(CartItemBean item, int newQuantity) {
                item.setQuantity(newQuantity);
                cartItemRepository.updateCartItem(item);
                updateTotalAmount();
            }

            @Override
            public void onItemCheckedChanged(CartItemBean item, boolean isChecked) {
                item.setChecked(isChecked);
                updateTotalAmount();
            }

            @Override
            public void onItemDeleted(CartItemBean item) {
                cartItemRepository.deleteCartItemByID(item.getCartItemId());
                cartItemAdapter.getItemList().remove(item);
                cartItemAdapter.notifyDataSetChanged();
                updateTotalAmount();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartItemAdapter);

        checkboxSelectAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            for (CartItemBean item : cartItemAdapter.getItemList()) {
                item.setChecked(isChecked);
            }
            cartItemAdapter.notifyDataSetChanged();
            updateTotalAmount();
        });

        btnCheckout.setOnClickListener(v -> {
            if (validateQuantities()) {
                Toast.makeText(this, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Có sản phẩm vượt quá số lượng cho phép!", Toast.LENGTH_SHORT).show();
            }
        });

        updateTotalAmount();
    }

    private void updateTotalAmount() {
        double total = 0;
        boolean isValid = true;

        for (CartItemBean item : cartItemAdapter.getItemList()) {
            if (item.isChecked()) {
                total += item.getProduct().getNewPrice() * item.getQuantity();
                if (item.getQuantity() > item.getProduct().getStockQuantity()) {
                    isValid = false;
                }
            }
        }

        tvTotalAmount.setText("Tổng: " + total + "đ");
        btnCheckout.setEnabled(isValid);
    }

    private boolean validateQuantities() {
        for (CartItemBean item : cartItemAdapter.getItemList()) {
            if (item.isChecked() && item.getQuantity() > item.getProduct().getStockQuantity()) {
                return false;
            }
        }
        return true;
    }
}