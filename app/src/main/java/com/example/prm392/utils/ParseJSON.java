package com.example.prm392.utils;

import android.content.Context;

import com.example.prm392.bean.ProvinceBean;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ParseJSON {
    public static ProvinceBean parseJSONFromRaw(Context context, int rawResId) {
        ObjectMapper mapper = new ObjectMapper();
        String json = loadJSONFromRaw(context, rawResId);

        if (json == null) {
            throw new RuntimeException("JSON content is null for resource id: " + rawResId);
        }

        try {
            return mapper.readValue(json, ProvinceBean.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String loadJSONFromRaw(Context context, int rawResId) {
        try {
            InputStream is = context.getResources().openRawResource(rawResId);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}




