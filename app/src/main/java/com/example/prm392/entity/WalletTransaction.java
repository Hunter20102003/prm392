package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.prm392.enums.TransactionType;

import java.time.LocalDateTime;

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
    private Integer transactionId;

    @ColumnInfo(name = "wallet_id")
    @NonNull
    private Integer walletId;

    @ColumnInfo(name = "order_id")
    private Integer orderId;

    @ColumnInfo(name = "amount")
    @NonNull
    private Double amount;

    @ColumnInfo(name = "transaction_type")
    @NonNull
    private TransactionType transactionType;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "created_at")
    private LocalDateTime createdAt;

    public Integer getTransactionId() {
        return transactionId;
    }

    public WalletTransaction() {
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @NonNull
    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(@NonNull Integer walletId) {
        this.walletId = walletId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @NonNull
    public Double getAmount() {
        return amount;
    }

    public void setAmount(@NonNull Double amount) {
        this.amount = amount;
    }

    @NonNull
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(@NonNull TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
