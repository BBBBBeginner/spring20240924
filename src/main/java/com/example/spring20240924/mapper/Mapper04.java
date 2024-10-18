package com.example.spring20240924.mapper;


import com.example.spring20240924.dto.c34.Customer;
import com.example.spring20240924.dto.c34.Orders;
import com.example.spring20240924.dto.c34.Product;
import com.example.spring20240924.dto.c34.Supplier;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

@Mapper
public interface Mapper04 {
    @Select("""
            SELECT ProductName
            FROM Products
            WHERE ProductId = 1
            """)
    String getProductName();

    @Select("""
                SELECT ProductName
                FROM Products
                WHERE ProductId = 1
            
            """)
    String select2();

    @Select("""
            SELECT Price
            FROM Products
            WHERE ProductId = 1
            """)
    Double select3();

    @Select("""
            SELECT LastName
            FROM Employees
            WHERE EmployeeID =1
            """)
    String select5();


    @Select("""
            
            SELECT DISTINCT Country
            FROM Customers
            """)
    List<String> select8();

    @Select("""
                SELECT DISTINCT LastName
                FROM Employees
            """)
    List<String> select9();

    @Select("""
            SELECT DISTINCT Price
            FROM Products
            ORDER BY Price DESC
            LIMIT 5
            """)
    List<Double> select11();

    @Select("""
            SELECT CustomerName, City, Country
            FROM Customers
            WHERE CustomerID = 1
            """)
    Map<String, String> select12();


    @Select("""
            SELECT Customers.CustomerName name, Customers.City 도시 , Customers.Country 국가
            FROM Customers
            WHERE CustomerID = 1
            """)
    Map<String, String> select13();


    @Select("""
            SELECT ProductName name, Price, Products.CategoryID
            FROM Products
            WHERE ProductID = 1
            """)
    Map<String, Object> select14();


    @Select("""
            SELECT Customers.CustomerName, Customers.Address ,Customers.City
            FROM Customers
            WHERE CustomerID = 1
            """)
    Map<String, Object> select15();

    @Select("""
            SELECT Customers.CustomerName name, Customers.Address address, Customers.PostalCode post
            FROM Customers
            WHERE CustomerID = 3
            """)
    Customer select17();


    @Select("""
            SELECT Products.ProductID id, Products.ProductName name, Price
            FROM Products
            WHERE ProductID =1
            """)
    Product select18();

    @Select("""
            select o.OrderID, o.OrderDate, c.CustomerName
            FROM Orders o
            JOIN Customers c
            ON o.CustomerID = c.CustomerID
            WHERE OrderID = 10248
            """)
    Orders select19();

    @Select("""
            SELECT CustomerName, Address, PostalCode
            FROM Customers
            LIMIT 3
            """)
    List<Map<String, String>> select22();

    @Select("""
            SELECT Products.ProductName, Categories.CategoryName, OrderDetails.Quantity,Products.Price
            FROM Products
            JOIN Categories
            ON Products.CategoryID = Categories.CategoryID
            JOIN OrderDetails
            ON Products.ProductID = OrderDetails.OrderDetailID
            ORDER BY Products.Price DESC
            LIMIT 5
            """)
    List<Map<String, Object>> select23();

    @Select("""
            SELECT SupplierID, SupplierName,Phone 
            FROM Suppliers
            WHERE Country = 'USA'
            """)
    List<Supplier> select26();

    @Select("""
            SELECT SupplierID, SupplierName,Phone 
            FROM Suppliers
            WHERE Country = 'USA'
            """)
    List<Map<String, String>> select27();

    @Select("""
            select o.OrderID, o.OrderDate, c.CustomerName
            FROM Orders o
            JOIN Customers c
            ON o.CustomerID = c.CustomerID
            WHERE OrderID = 10248
            """)
    List<Orders> select28();


}
