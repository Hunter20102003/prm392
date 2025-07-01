package com.example.prm392.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {
    public static String formatVND(double amount) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);
        return currencyFormatter.format(amount);
    }
}
