package com.example.prm392.dao.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.prm392.dao.CartItemDAO;
import com.example.prm392.dao.CategoryDAO;
import com.example.prm392.dao.OrderDAO;
import com.example.prm392.dao.OrderItemDAO;
import com.example.prm392.dao.ProductDAO;
import com.example.prm392.dao.ProductImageDAO;
import com.example.prm392.dao.ReviewDAO;
import com.example.prm392.dao.ShoppingCartDAO;
import com.example.prm392.dao.UserDAO;
import com.example.prm392.dao.WalletDAO;
import com.example.prm392.dao.WalletTransactionDAO;
import com.example.prm392.entity.CartItem;
import com.example.prm392.entity.Category;
import com.example.prm392.entity.Order;
import com.example.prm392.entity.OrderItem;
import com.example.prm392.entity.Product;
import com.example.prm392.entity.ProductImage;
import com.example.prm392.entity.Review;
import com.example.prm392.entity.ShoppingCart;
import com.example.prm392.entity.User;
import com.example.prm392.entity.Wallet;
import com.example.prm392.entity.WalletTransaction;
import com.example.prm392.utils.Converters;

@Database(
        entities = {User.class, Category.class,Product.class, ProductImage.class, ShoppingCart.class, CartItem.class,Order.class, OrderItem.class, Review.class, Wallet.class, WalletTransaction.class},
        version = 1,
        exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDao();
    public abstract CategoryDAO categoryDAO();
    public abstract ProductDAO productDao();
    public abstract ProductImageDAO productImageDao();
    public abstract ShoppingCartDAO shoppingCartDao();
    public abstract CartItemDAO cartItemDao();
    public abstract OrderDAO orderDao();
    public abstract OrderItemDAO orderItemDao();
    public abstract ReviewDAO reviewDao();
    public abstract WalletDAO walletDao();
    public abstract WalletTransactionDAO walletTransactionDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "my_app_db"
                            )
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries() // test
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
