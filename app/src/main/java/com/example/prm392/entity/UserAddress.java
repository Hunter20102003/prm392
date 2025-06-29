package com.example.prm392.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_address",foreignKeys =
        {@ForeignKey (entity = User.class,parentColumns = "user_id",childColumns = "user_id"),
                @ForeignKey (entity = Province.class,parentColumns = "province_id",childColumns = "province_id"),
                @ForeignKey (entity = District.class,parentColumns = "district_id",childColumns = "district_id"),
                @ForeignKey (entity = Ward.class,parentColumns = "ward_id",childColumns = "ward_id")

        },
        indices = {@Index(value = "user_id"),@Index(value = "province_id"),@Index(value = "district_id"),@Index(value = "ward_id")})
public class UserAddress {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "address_id")
    private Integer addressId;
    @ColumnInfo(name="user_id")
    private Integer userId;
    @ColumnInfo(name="province_id")
    private Integer province_id;
    @ColumnInfo(name="district_id")
    private Integer districtId;
    @ColumnInfo(name="ward_id")
    private Integer wardId;
    @ColumnInfo(name="address_detail")
    private String addressDetail;
    @ColumnInfo(name = "is_default")
    private Boolean isDefault=false;

    public UserAddress() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
