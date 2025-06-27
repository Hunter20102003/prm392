package com.example.prm392.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DistrictBean {
    @JsonProperty("Id")

    private String id;
    @JsonProperty("Name")

    private String name;
    @JsonProperty("Wards")

    private List<WardBean> wards;

    public DistrictBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WardBean> getWards() {
        return wards;
    }

    public void setWards(List<WardBean> wards) {
        this.wards = wards;
    }
}
