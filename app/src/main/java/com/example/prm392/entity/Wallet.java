package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "wallet",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "user_id",
                childColumns = "user_id"),indices = {
        @Index(value = {"user_id"})
})
public class Wallet {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "wallet_id")
    private Integer walletId;

    @ColumnInfo(name = "user_id")
    @NonNull
    private Integer userId;

    @ColumnInfo(name = "balance")
    private Double balance = 0.00;

    @ColumnInfo(name = "is_active")
    private Boolean isActive = true;


    public Wallet() {
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
