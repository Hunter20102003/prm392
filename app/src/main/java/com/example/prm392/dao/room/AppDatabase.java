package com.example.prm392.dao.room;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.prm392.dao.*;
import com.example.prm392.entity.*;
import com.example.prm392.utils.Converters;

import java.util.concurrent.Executors;

@Database(
        entities = {User.class, Category.class, Product.class, ProductImage.class, ShoppingCart.class, CartItem.class,
                Order.class, OrderItem.class, Review.class, Wallet.class, WalletTransaction.class,
                Province.class, District.class, Ward.class, UserAddress.class},
        version = 6,
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
    public abstract ProvinceDAO provinceDao();
    public abstract DistrictDAO districtDao();
    public abstract WardDAO wardDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    RoomDatabase.Builder<AppDatabase> builder = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "my_app_db"
                            ).allowMainThreadQueries();

                    INSTANCE = builder
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
