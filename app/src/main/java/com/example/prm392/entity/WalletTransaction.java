package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.prm392.enums.TransactionType;

@Entity(tableName = "wallet_transactions",
        foreignKeys = {
                @ForeignKey(entity = Wallet.class,
                        parentColumns = "wallet_id",
                        childColumns = "wallet_id"),
                @ForeignKey(entity = Order.class,
                        parentColumns = "order_id",
                        childColumns = "order_id")
        },indices = {
        @Index(value = {"wallet_id"}),@Index(value={"order_id"})
})
public class WalletTransaction {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    public int transactionId;

    @ColumnInfo(name = "wallet_id")
    @NonNull
    public int walletId;

    @ColumnInfo(name = "order_id")
    public Integer orderId;

    @ColumnInfo(name = "amount")
    @NonNull
    public double amount;

    @ColumnInfo(name = "transaction_type")
    @NonNull
    public TransactionType transactionType;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "created_at")
    public String createdAt;
}
