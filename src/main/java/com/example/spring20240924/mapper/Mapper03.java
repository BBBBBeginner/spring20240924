package com.example.spring20240924.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper03 {

    @Select("""
            SELECT Description d
            FROM Categories
            WHERE CategoryID = 1;
            """)
    String getDescription();

}
