package com.example.prm392.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "provinces")
public class Province {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "province_id")

    private String id;
    @ColumnInfo(name="name")
    private String name;

    public Province() {
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
}
