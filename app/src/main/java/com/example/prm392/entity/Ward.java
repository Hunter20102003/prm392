package com.example.prm392.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "wards", foreignKeys = @ForeignKey(entity=District.class,parentColumns="district_id",childColumns="district_id"),indices = @Index(value="district_id"))
public class Ward {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ward_id")
    private String id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "level")
    private String level;
    @ColumnInfo(name="district_id")
    private String districtId;

    public Ward() {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
}
