package com.example.prm392.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import androidx.room.Index;

import java.util.Date;

@Entity(
        tableName = "vouchers",
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "user_id",
                childColumns = "created_by",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "created_by")}
)
public class Voucher {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "voucher_id")
    private int voucherId;

    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "discount_value")
    private double discountValue;

    @ColumnInfo(name = "min_order_amount")
    private Double minOrderAmount; // nullable

    @ColumnInfo(name = "start_date")
    private Date startDate;

    @ColumnInfo(name = "end_date")
    private Date endDate;

    @ColumnInfo(name = "max_usage")
    private Integer maxUsage;

    @ColumnInfo(name = "remaining_usage")
    private Integer remainingUsage;

    @ColumnInfo(name = "is_active")
    private Boolean isActive = true;

    @ColumnInfo(name = "created_by")
    private Integer createdBy;

    public Voucher() {
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public Double getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(Double minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxUsage() {
        return maxUsage;
    }

    public void setMaxUsage(Integer maxUsage) {
        this.maxUsage = maxUsage;
    }

    public Integer getRemainingUsage() {
        return remainingUsage;
    }

    public void setRemainingUsage(Integer remainingUsage) {
        this.remainingUsage = remainingUsage;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
}
