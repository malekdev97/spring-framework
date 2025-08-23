package com.backend.backend.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class Utils <T> {

    public List<T> genericList;
    public Class<T> type;
    public Utils(Class<T> type) {
        genericList = new ArrayList<T>();
        this.type = type;
    }

    @Bean
    public boolean isNullOrEmpty(Object obj) {
        return obj == null || obj == "";
    }
}
