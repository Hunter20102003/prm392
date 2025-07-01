package com.example.prm392.activity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.prm392.R;
import com.example.prm392.bean.ProductBean;
import com.example.prm392.bean.ProductImageBean;
import com.example.prm392.entity.Product;
import com.example.prm392.entity.relation.ProductWithCategoryAndImages;
import com.example.prm392.repository.ProductRepository;
import com.example.prm392.utils.Currency;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends AppCompatActivity {
    private ProductRepository productRepository;
    private ImageSlider imageSlider;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private TextView tvSold;
    private TextView tvProductName;
    private TextView tvDescription;
    private TextView tvTitle;
    private RatingBar tvRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        productRepository = new ProductRepository(this);
        ProductBean productBean = productRepository.getProductById(1);
        imageSlider = findViewById(R.id.viewPagerImages);
        tvNewPrice = findViewById(R.id.tvNewPrice);
        tvOldPrice = findViewById(R.id.tvOldPrice);
        tvSold = findViewById(R.id.tvSold);
        tvTitle = findViewById(R.id.tvTitle);
        tvProductName = findViewById(R.id.tvProductName);
        tvDescription = findViewById(R.id.tvDescription);
        tvRating = findViewById(R.id.ratingBar);
      setImageList(productBean.getProductImageList());
      imageSlider.setImageList(setImageList(productBean.getProductImageList()));
       tvNewPrice.setText(Currency.formatVND(productBean.getNewPrice()));
        if (productBean.getOldPrice() != null) {
            tvOldPrice.setText(String.valueOf(productBean.getOldPrice()));
        }
       tvSold.setText(String.valueOf(productBean.getStockQuantity()));
       tvProductName.setText(productBean.getName());
       tvDescription.setText(productBean.getDescription());
      tvTitle.setText(productBean.getTitle());
//        tvRating.setText(String.valueOf(productBean.getCategoryId()));


    }

    private List<SlideModel> setImageList(List<ProductImageBean> imageBeans) {
        List<SlideModel> imageList = new ArrayList<>();
        if (imageBeans == null || imageBeans.isEmpty()) {
            imageList.add(new SlideModel(R.drawable.product_default, "default image", ScaleTypes.CENTER_INSIDE));
        } else {
            for (ProductImageBean imageBean : imageBeans) {
                imageList.add(new SlideModel(imageBean.getImageUrl(), "", ScaleTypes.CENTER_INSIDE));
            }
        }
        return imageList;
    }


}