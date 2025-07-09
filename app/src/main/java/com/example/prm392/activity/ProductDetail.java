package com.example.prm392.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.prm392.R;
import com.example.prm392.adapter.ImageSliderAdapter;
import com.example.prm392.bean.CartItemBean;
import com.example.prm392.bean.ProductBean;
import com.example.prm392.bean.ProductImageBean;
import com.example.prm392.bean.ShoppingCartBean;
import com.example.prm392.bean.UserBean;
import com.example.prm392.entity.ShoppingCart;
import com.example.prm392.entity.User;
import com.example.prm392.repository.CartItemRepository;
import com.example.prm392.repository.OrderItemRepository;
import com.example.prm392.repository.ProductRepository;
import com.example.prm392.repository.ReviewRepository;
import com.example.prm392.repository.ShoppingCartRepository;
import com.example.prm392.repository.UserRepository;
import com.example.prm392.utils.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDetail extends AppCompatActivity {

    private ProductRepository productRepository;
    private ReviewRepository reviewRepository;
    private OrderItemRepository orderItemRepository;
    private ShoppingCartRepository shoppingCartRepository;

    private CartItemRepository cartItemRepository;
    private UserRepository userRepository;
    private ViewPager2 viewPagerImages;
    private TextView tvNewPrice, tvOldPrice, tvSold, tvProductName, tvDescription, tvTitle, tvAgvRating, tvCartBadge;
    private Button btnAddToCart, btnOrder;
    private ImageView btnCart;
    private UserBean user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        SharedPreferences prefs = this.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =prefs.edit();
        editor.putInt("user_id",1);
        editor.apply();
        setupEdgeToEdge();
        initRepositories();
        initViews();
        loadProductData(1);  // Giả định ID sản phẩm là 1
    }

    private void setupEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initRepositories() {
        productRepository = new ProductRepository(this);
        orderItemRepository = new OrderItemRepository(this);
        reviewRepository = new ReviewRepository(this);
        shoppingCartRepository = new ShoppingCartRepository(this);
        cartItemRepository = new CartItemRepository(this);
        userRepository = new UserRepository(this);

    }

    private void initViews() {
        viewPagerImages = findViewById(R.id.viewPagerImages);
        tvNewPrice = findViewById(R.id.tvNewPrice);
        tvOldPrice = findViewById(R.id.tvOldPrice);
        tvSold = findViewById(R.id.tvSold);
        tvTitle = findViewById(R.id.tvTitle);
        tvProductName = findViewById(R.id.tvProductName);
        tvDescription = findViewById(R.id.tvDescription);
        tvAgvRating = findViewById(R.id.tvAvgRating);
        btnCart = findViewById(R.id.btnCart);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnOrder = findViewById(R.id.btnOrder);
        tvCartBadge = findViewById(R.id.tvCartBadge);
        btnCart.setOnClickListener(v->{
            Intent intent=new Intent(this,CartActivity.class);
            startActivity(intent);
        });


    }

    private void loadProductData(int productId) {
        ProductBean productBean = productRepository.getProductById(productId);

        loadProductImages(productBean.getProductImageList());

        tvNewPrice.setText(Currency.formatVND(productBean.getNewPrice()));

        if (productBean.getOldPrice() != null) {
            tvOldPrice.setText(Currency.formatVND(productBean.getOldPrice()));
        }

        int soldQuantity = orderItemRepository.countOrderItemsByProductId(productId);
        tvSold.setText(String.valueOf(soldQuantity));

        tvProductName.setText(productBean.getName());
        tvDescription.setText(productBean.getDescription());
        tvTitle.setText(productBean.getTitle());
        updateCartBadge(1); // Giả định ID giỏ hàng là 1

        double avgRating = reviewRepository.getAvgRatingByProductId(productId);
        tvAgvRating.setText(String.valueOf(avgRating));
        btnAddToCart.setOnClickListener(v -> {
            showAddToCartDialog(productBean.getStockQuantity());
        });

    }

    private void loadProductImages(List<ProductImageBean> imageBeans) {
        List<Object> imageSources = new ArrayList<>();
        if (imageBeans != null && !imageBeans.isEmpty()) {
            for (ProductImageBean bean : imageBeans) {
                imageSources.add(bean.getImageUrl());  // String URL
            }
        } else {
            imageSources.add(R.drawable.product_default);  // Resource ID
        }

        ImageSliderAdapter adapter = new ImageSliderAdapter(this, imageSources);
        viewPagerImages.setAdapter(adapter);
    }

    private void showAddToCartDialog(int stock) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.quantity_dialog, null);
        builder.setView(view);
        TextView tvStock = view.findViewById(R.id.tvStock);
        TextView tvQuantity = view.findViewById(R.id.tvQuantity);
        Button btnIncrease = view.findViewById(R.id.btnIncrease);
        Button btnDecrease = view.findViewById(R.id.btnDecrease);
        Button btnAddToCart = view.findViewById(R.id.btnAddToCart);
        ImageView btnClose = view.findViewById(R.id.btnClose);
        tvStock.setText(stock > 0 ? "Còn " + stock + " sản phẩm" : "Hết hàng");
        final int[] quantity = new int[]{stock > 0 ? 1 : 0};
        tvQuantity.setText(String.valueOf(quantity[0]));
        boolean isOutOfStock = stock == 0;
        btnIncrease.setEnabled(!isOutOfStock);
        btnDecrease.setEnabled(!isOutOfStock);
        btnAddToCart.setEnabled(!isOutOfStock);
        Dialog dialog = builder.create();

        btnIncrease.setOnClickListener(v -> {
            if (quantity[0] < stock) {
                quantity[0]++;
                tvQuantity.setText(String.valueOf(quantity[0]));
            }
        });
        btnDecrease.setOnClickListener(v -> {
            if (quantity[0] > 1) {
                quantity[0]--;
                tvQuantity.setText(String.valueOf(quantity[0]));
            }
        });
        btnClose.setOnClickListener(v -> {
            dialog.dismiss();
        });
        btnAddToCart.setOnClickListener(v -> {
            ShoppingCartBean shoppingCart = shoppingCartRepository.getShoppingCartByUserId(1);
            if (cartItemRepository.countCartItemByCartIdAndProductId(shoppingCart.getCartId(), 1) == 0) {
                CartItemBean cartItemBean = new CartItemBean();
                cartItemBean.setProductId(1); // Giả định ID sản phẩm là 1
                cartItemBean.setQuantity(quantity[0]);
                cartItemBean.setCartId(shoppingCart.getCartId());
                cartItemRepository.insertCartItem(cartItemBean);
            }
            else{
                CartItemBean cartItemBean=cartItemRepository.getCartItemByCartIdAndProductId(shoppingCart.getCartId(), 1);
                int oldQuantity = cartItemBean.getQuantity();
                cartItemBean.setQuantity(oldQuantity + quantity[0]);
                cartItemRepository.updateCartItem(cartItemBean);

            }

            updateCartBadge(1); // Giả định ID giỏ hàng là 1
            tvCartBadge.setText(String.valueOf(cartItemRepository.countCartItemsByCartId(1)));
            dialog.dismiss();

            Toast.makeText(this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
        });

        dialog.show();

    }

    private void updateCartBadge(int cartId) {
        int itemCount = cartItemRepository.countCartItemsByCartId(cartId);
        if (itemCount > 0) {
            tvCartBadge.setText(String.valueOf(itemCount));
            tvCartBadge.setVisibility(View.VISIBLE);   // Hiện badge
        } else {
            tvCartBadge.setVisibility(View.GONE);       // Ẩn badge
        }
    }


}
