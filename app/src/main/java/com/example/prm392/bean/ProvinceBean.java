package com.example.prm392.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ProvinceBean {
    @JsonProperty("Id")

    private String id;
    @JsonProperty("Name")

    private String name;
    @JsonProperty("Districts")

    private List<DistrictBean> districts;
    public ProvinceBean() {
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

    public List<DistrictBean> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictBean> districts) {
        this.districts = districts;
    }
}
