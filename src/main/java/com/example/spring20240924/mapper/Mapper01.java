package com.example.spring20240924.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper01 {

    @Select("""
            SELECT CustomerName
            FROM Customers
            WHERE CustomerId = 1
            """)
    public String selectName();

    @Select("""
            SELECT ProductName
            FROM Products
            WHERE ProductId = 10
            """)
    String getProductName();

    @Select("""
            SELECT FirstName
            FROM Employees
            WHERE EmployeeId = 3
            """)
    String getEmployeeName();
}