package com.example.spring20240924.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper02 {


    @Select("""
            SELECT SupplierName
            FROM Suppliers
            WHERE SUpplierId = 1
            """)
    String selectSupplierName();

}
