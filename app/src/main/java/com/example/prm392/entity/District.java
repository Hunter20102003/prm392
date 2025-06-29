package com.example.prm392.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "districts",
foreignKeys = @ForeignKey(entity= Province.class,parentColumns="province_id",childColumns="province_id"),indices = @Index(value = {"province_id"}))
public class District {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "district_id")
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "province_id")
    private String provinceId;

    public District() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
}
