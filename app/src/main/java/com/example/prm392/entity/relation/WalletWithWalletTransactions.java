package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Wallet;
import com.example.prm392.entity.WalletTransaction;

import java.util.List;

public class WalletWithWalletTransactions {
    @Embedded
    public Wallet wallet;
    @Relation(parentColumn = "wallet_id", entityColumn = "wallet_id")
    public List<WalletTransaction> walletTransactions;
}
