package com.example.prm392.repository;

import android.content.Context;

import com.example.prm392.bean.DistrictBean;
import com.example.prm392.bean.ProvinceBean;
import com.example.prm392.bean.WardBean;
import com.example.prm392.dao.DistrictDAO;
import com.example.prm392.dao.ProvinceDAO;
import com.example.prm392.dao.WardDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.District;
import com.example.prm392.entity.Province;
import com.example.prm392.entity.Ward;
import com.example.prm392.utils.Mapper;

import java.util.List;

public class LocationRepository {
    private final WardDAO wardDAO;
    private final DistrictDAO districtDAO;
    private final ProvinceDAO provinceDAO;

    public LocationRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        this.wardDAO = database.wardDao();
        this.districtDAO = database.districtDao();
        this.provinceDAO = database.provinceDao();
    }

    public void insertLocationData(ProvinceBean provinceBean) {
        Province province = Mapper.getInstance().map(provinceBean, Province.class);
        provinceDAO.insert(province);
        for (DistrictBean districtBean : provinceBean.getDistricts()) {
            District district = Mapper.getInstance().map(districtBean, District.class);
            district.setProvinceId(province.getId());
            districtDAO.insert(district);
            for (WardBean wardBean : districtBean.getWards()) {
                Ward ward = Mapper.getInstance().map(wardBean, Ward.class);
                ward.setDistrictId(district.getId());
                wardDAO.insert(ward);

            }


        }

    }
    public List<Province> getProvince(){
        return provinceDAO.getAllProvinces();
    }


}
