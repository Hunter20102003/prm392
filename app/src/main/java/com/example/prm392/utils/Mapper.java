package com.example.prm392.utils;

import org.modelmapper.ModelMapper;

public class Mapper {

        private static final ModelMapper modelMapper = new ModelMapper();
        private Mapper(){}
        public static ModelMapper getInstance() {
            return modelMapper;
        }
    }

