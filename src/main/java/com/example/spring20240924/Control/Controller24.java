package com.example.spring20240924.Control;


import com.example.spring20240924.dto.c24.Customer;
import com.example.spring20240924.dto.c24.Employees;
import com.example.spring20240924.dto.c24.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.events.Event;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main24")
public class Controller24 {
    @Autowired
    DataSource dataSource;

    @GetMapping("sub1")
    public void sub1() throws SQLException {
        String sql = """
                SELECT DISTINCT CITY
                FROM Customers
                """;
        //연결
        Connection con = dataSource.getConnection();
        //쿼리실행 준비
        Statement stmt = con.createStatement();
        //쿼리 실행
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs) {
            //실행 결과 가공
            while (rs.next()) {
                String City = rs.getString("CITY");
                System.out.println("City = " + City);
            }
        }

    }

    @GetMapping("sub2")
    public void sub2(Model model) throws SQLException {
        String sql = """
                SELECT CustomerName, ContactName, Address
                FROM Customers
                """;
        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try (con; stmt; rs) {
            List<Customer> list = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("CustomerName");
                String contact = rs.getString("ContactName");
                String address = rs.getString("Address");

                Customer customer = new Customer();
                customer.setName(name);
                customer.setContactName(contact);
                customer.setAddress(address);

                list.add(customer);

            }
            model.addAttribute("customerList", list);
        }
        // jsp로 forward
    }

    @GetMapping("sub3")
    public void sub3(Model model) throws SQLException {
        String sql = """
                SELECT EmployeeID, FirstName, LastName, BirthDate
                FROM Employees
                """;
        // 이 메소드와 Employee, sub3.jsp 작성
        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Employees> list = new ArrayList<>();
        try (con; stmt; rs) {
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setFirstName(rs.getString("FirstName"));
                employee.setLastName(rs.getString("LastName"));
                employee.setId(rs.getString("EmployeeID"));
                list.add(employee);
            }
            model.addAttribute("employeeList", list);
        }
    }

    // 상품번호, 상품명, 단위, 가격을 상품테이블에서 조회 후 출력
    // ProductID, ProductName, Unit, Price
    // 4번째 메소드, jsp, javaBean(dto) 작성
    @GetMapping("sub4")
    public void sub4(Model model) throws SQLException {
        String sql = """
                 SELECT ProductID, ProductName, Unit, Price
                 FROM Products
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Product> list = new ArrayList<>();

        try (con; stmt; rs) {
            while (rs.next()) {
                Product product = new Product();
                product.setPrice(rs.getString("Price"));
                product.setName(rs.getString("ProductName"));
                product.setUnit(rs.getString("Unit"));
                product.setId(rs.getString("ProductID"));
                list.add(product);
            }
            model.addAttribute("ProductList", list);
        }

    }

}