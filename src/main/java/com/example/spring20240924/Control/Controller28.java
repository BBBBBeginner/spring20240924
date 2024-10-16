package com.example.spring20240924.Control;

import com.example.spring20240924.dto.c28.Employee;
import com.example.spring20240924.dto.c27.Customer;
import com.example.spring20240924.dto.c27.Product;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Name;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main28")
public class Controller28 {
    @Autowired
    DataSource dataSource;

    // main28/sub1?name=흥민&contact=득점왕
    @PostMapping("sub1")//post 입력
    public void sub1(String name, String contact) {
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName)
                VALUES
                (?,?)
                """;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "흥민");
            pstmt.setString(2, "득점왕");
//        pstmt.executeQuery(); //SELECT 쿼리 쓸때만 씀
            pstmt.executeUpdate(); //INSERT,UPDATE, DELETE 쿼리 쓸때 사용, 수정된 수를()에 저장
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("sub2")// 입력 받음
    public void sub2() {

    }


    // get /main28/sub3 은 상품입력 form 이 있는 jsp로 forward
    @GetMapping("sub3")
    public void sub3() {

    }

    // post /main28/sub4 은 새 상품을 insert하는 로직 실행
    @PostMapping("sub4")
    public String sub4(String name,
                       String unit,
                       String price,
                       RedirectAttributes rttr) {
        String sql = """
                INSERT INTO Products
                    (ProductName, Unit, Price)
                VALUES
                    (?, ?, ?)
                """;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            try (conn; pstmt) {
                pstmt.setString(1, name);
                pstmt.setString(2, unit);
                pstmt.setString(3, price);
                int count = pstmt.executeUpdate();

                if (count == 1) {
                    rttr.addFlashAttribute("message", "새 상품이 등록되었습니다.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/main28/sub3";
    }


    @GetMapping("sub5")
    public void sub5(String id, Model model) {
        // SQL 쿼리 정의: 특정 ID에 해당하는 고객 정보를 조회하는 SQL 문
        String sql = """
                SELECT * FROM Customers
                WHERE CustomerId = ?
                """;
        try {
            // 데이터베이스 연결 객체를 얻음
            Connection con = dataSource.getConnection();

            // SQL 쿼리를 준비 (CustomerId 조건에 맞는 데이터를 조회)
            PreparedStatement pstmt = con.prepareStatement(sql);

            // 첫 번째 ?에 id 값을 바인딩 (SQL 쿼리의 WHERE 조건)
            pstmt.setString(1, id);

            // 쿼리 실행: SQL 쿼리를 실행하고 결과를 ResultSet에 저장
            ResultSet rs = pstmt.executeQuery();

            // 결과 집합에서 첫 번째 행이 있는지 확인
            if (rs.next()) {
                // Customer 객체 생성 및 값 설정 (ResultSet에서 값을 가져와 고객 정보를 설정)
                Customer customer = new Customer();
                customer.setId(rs.getString("CustomerId"));       // 고객 ID 설정
                customer.setName(rs.getString("CustomerName"));   // 고객 이름 설정
                customer.setContact(rs.getString("ContactName")); // 연락처 이름 설정
                customer.setAddress(rs.getString("Address"));     // 주소 설정
                customer.setCity(rs.getString("City"));           // 도시 설정
                customer.setCountry(rs.getString("Country"));     // 국가 설정
                customer.setPostalCode(rs.getString("PostalCode"));// 우편번호 설정

                // 모델에 고객 정보를 추가하여 뷰에 전달
                model.addAttribute("customer", customer);
            }
        } catch (Exception e) {
            // 예외가 발생한 경우 스택 트레이스를 출력하여 오류 내용을 확인
            e.printStackTrace();
        }
    }

    @PostMapping("sub6")
    public String sub6(String id, RedirectAttributes rttr) {
        // SQL 쿼리 정의: 특정 ID에 해당하는 고객을 삭제하는 SQL 문
        String sql = """
                DELETE FROM Customers
                WHERE CustomerId = ?
                """;

        try {
            // 데이터베이스 연결 객체를 얻음
            Connection con = dataSource.getConnection();

            // SQL 쿼리를 준비 (CustomerId 조건에 맞는 데이터를 삭제)
            PreparedStatement pstmt = con.prepareStatement(sql);

            // 리소스를 자동으로 닫기 위한 try-with-resources 구문
            try (con; pstmt) {
                // 첫 번째 ?에 id 값을 설정 (삭제할 고객의 ID)
                pstmt.setString(1, id);

                // DELETE 쿼리 실행 (삭제된 행의 개수를 반환)
                int count = pstmt.executeUpdate();

                // 삭제된 행이 1개라면 성공 메시지를 추가
                if (count == 1) {
                    // 고객 삭제 성공 메시지를 RedirectAttributes에 추가 (삭제된 고객 ID 포함)
                    rttr.addFlashAttribute("message", id + "번 고객이 삭제 되었습니다.");
                }
            }
        } catch (SQLException e) {
            // 예외 발생 시 오류 메시지를 출력
            e.printStackTrace();
        }

        // 삭제 후 id를 쿼리 파라미터로 포함하여 sub5 메소드로 리다이렉트
        rttr.addAttribute("id", id);
        return "redirect:/main28/sub5"; // 고객 조회 페이지로 리다이렉트
    }


    // 상품을 상품번호로 조회하고
    // 해당 상품을 삭제하는 로직 작성

    @GetMapping("sub7")
    public void sub7(String id, Model model) {
        String sql = """
                SELECT * 
                FROM Products
                WHERE ProductId = ?
                """;
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try (con; pstmt) {
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Product product = new Product();
                    product.setUnit(rs.getString("Unit"));
                    product.setPrice(rs.getString("Price"));
                    product.setId(rs.getString("ProductId"));
                    product.setName(rs.getString("ProductName"));
                    product.setSupplierId(rs.getString("SupplierId"));
                    product.setCategoryId(rs.getString("CategoryId"));
                    model.addAttribute("product", product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("sub8")
    public String sub8(String id, RedirectAttributes rttr) {
        String sql = """
                DELETE FROM Products
                WHERE ProductId = ?
                """;
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try (con; pstmt) {
                pstmt.setString(1, id);
                int count = pstmt.executeUpdate();
                if (count == 1) {
                    rttr.addFlashAttribute("message", id + "번 상품 삭제되었습니다.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rttr.addAttribute("id", id);
        return "redirect:/main28/sub7";
    }


    @PostMapping("sub9")
    public String sub9(Customer customer, RedirectAttributes rttr) {
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    Country = ?,
                    PostalCode = ?
                WHERE CustomerId = ?
                """;

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try (con; pstmt) {
                pstmt.setString(1, customer.getName());
                pstmt.setString(2, customer.getContact());
                pstmt.setString(3, customer.getAddress());
                pstmt.setString(4, customer.getCity());
                pstmt.setString(5, customer.getCountry());
                pstmt.setString(6, customer.getPostalCode());
                pstmt.setString(7, customer.getId());
                pstmt.executeUpdate();
                rttr.addFlashAttribute("message", customer.getId() + "번 고객 정보가 수정되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rttr.addAttribute("id", customer.getId());
        return "redirect:/main28/sub10";
    }

    @GetMapping("sub10")
    public void sub10(String id, Model model) {
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerId = ?
                """;

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);

            try (con; pstmt) {
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getString("CustomerId"));
                    customer.setName(rs.getString("CustomerName"));
                    customer.setContact(rs.getString("ContactName"));
                    customer.setAddress(rs.getString("Address"));
                    customer.setCity(rs.getString("City"));
                    customer.setCountry(rs.getString("Country"));
                    customer.setPostalCode(rs.getString("PostalCode"));
                    model.addAttribute("customer", customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 직원 정보 조회 후 수정하는
    // 2개의 메소드와 jsp, dto 만들기

    // 직원 정보 조회 후 수정하는 메소드 (Employee 객체 사용)
    @GetMapping("sub11")
    public void sub11(String id, Model model) {
        String sql = """
                
                    SELECT *
                FROM Employees
                WHERE EmployeeId = ?
                """;
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try (con; pstmt) { // 자원 자동 관리 (try-with-resources)
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Employee e = new Employee(); // DTO 객체 사용 (Employee)
                    e.setId(rs.getString("EmployeeId"));
                    e.setBirthDate(rs.getString("BirthDate"));
                    e.setFirstName(rs.getString("FirstName"));
                    e.setLastName(rs.getString("LastName"));
                    e.setNotes(rs.getString("Notes"));
                    e.setPhoto(rs.getString("Photo"));

                    model.addAttribute("employee", e); // 조회된 직원 객체를 모델에 추가
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("sub12")
    public String sub12(Employee employee, RedirectAttributes rttr) {
        String sql =
                """
                        UPDATE Employees
                        SET FirstName =?,
                            LastName=?,
                            Notes=?,
                            Photo=?,
                            BirthDate=?
                         WHERE EmployeeId = ?
                        """;
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try (con; pstmt) {
                pstmt.setString(1, employee.getFirstName());
                pstmt.setString(2, employee.getLastName());
                pstmt.setString(3, employee.getNotes());
                pstmt.setString(4, employee.getPhoto());
                pstmt.setString(5, employee.getBirthDate());
                pstmt.setString(6, employee.getId());

                pstmt.executeUpdate(); // 데이터 업데이트 실행
                rttr.addFlashAttribute("message", employee.getId() + "번 직원 정보가 수정되었습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        rttr.addAttribute("id", employee.getId()); // 수정 후 직원 ID를 리다이렉트 URL에 추가

        return "redirect:/main sub11";
    }
}