package com.example.prm392.repository;

import android.content.Context;
import android.util.Log;

import com.example.prm392.bean.CategoryBean;
import com.example.prm392.bean.ProductBean;
import com.example.prm392.bean.ProductImageBean;
import com.example.prm392.dao.ProductDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.Product;
import com.example.prm392.entity.ProductImage;
import com.example.prm392.entity.relation.ProductWithCategoryAndImages;
import com.example.prm392.utils.Mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;

public class ProductRepository {
private final ProductDAO productDAO;
private final ModelMapper mapper= Mapper.getInstance();

    public ProductRepository(Context context) {
        AppDatabase productRoomDatabase = AppDatabase.getInstance(context);
        productDAO = productRoomDatabase.productDao();
    }
    //test
    public void addProduct(Product product) {
       // productDAO.insert(product);
    }

    public void printAllProducts() {
//        List<Product> list = productDAO.selectAll();
//        for (Product p : list) {
//            Log.d("PRODUCT_LOG", "ID: " + p.productId +
//                    ", Name: " + p.name +
//                    ", New Price: " + p.newPrice +
//                    ", Stock: " + p.stockQuantity);
//        }
    }
    public ProductBean getProductById(Integer id){
        ProductWithCategoryAndImages product =  productDAO.getProductsWithCategoryAndImagesById(id);
        ProductBean productBean = mapper.map(product.product, ProductBean.class);
        productBean.setCategory(mapper.map(product.category, CategoryBean.class));

        for (ProductImage productImage : product.productImages) {
            productBean.getProductImageList().add(mapper.map(productImage, ProductImageBean.class));
        }
        return productBean;
    }
//    public ProductBean getProductWithCategoryAndImagesById(Integer id){
//        ProductWithCategoryAndImages product =  productDAO.getProductsWithCategoryAndImagesById(id);
//        ProductBean productBean = mapper.map(product.product, ProductBean.class);
//        productBean.setCategory(mapper.map(product.category, CategoryBean.class));
//        for (ProductImage productImage : product.productImages) {
//            productBean.getProductImageList().add(mapper.map(productImage, ProductImage.class));
//        }
//        return productBean;
//    }

}
