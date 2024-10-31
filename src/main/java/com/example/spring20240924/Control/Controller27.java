package com.example.spring20240924.Control;

import com.example.spring20240924.dto.c26.Customer;
import com.example.spring20240924.dto.c26.Product;
import com.example.spring20240924.dto.c27.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    DataSource dataSource;

    @GetMapping("sub1")
    public void sub1(Model model, String id) throws SQLException {
        // SQL injection
        String sql = STR."""
                SELECT *
                FROM Customers
                WHERE CustomerId = \{id}
                """;
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (conn; stmt; rs) {
            List<Customer> list = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setPostalCode(rs.getString("PostalCode"));
                customer.setName(rs.getString("CustomerName"));
                customer.setContact(rs.getString("ContactName"));
                customer.setAddress(rs.getString("Address"));
                customer.setCity(rs.getString("City"));
                customer.setId(rs.getString("CustomerId"));
                customer.setCountry(rs.getString("Country"));
                list.add(customer);
            }
            model.addAttribute("customerList", list);
        }
    }

    // Statement 객체는 SQL injection 위험 있음
    // -> PreparedStatement 객체를 사용해야 함
    @GetMapping("sub2")
    public String sub2(Model model, String id) throws SQLException {
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerId = ?
                """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        try (conn; pstmt; rs) {
            List<Customer> list = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setPostalCode(rs.getString("PostalCode"));
                customer.setName(rs.getString("CustomerName"));
                customer.setContact(rs.getString("ContactName"));
                customer.setAddress(rs.getString("Address"));
                customer.setCity(rs.getString("City"));
                customer.setCountry(rs.getString("Country"));
                customer.setId(rs.getString("CustomerId"));
                list.add(customer);
            }
            model.addAttribute("customerList", list);
        }

        return "/main27/sub1";
    }

    // /main26/sub5
    // /main27/sub3
    @GetMapping("sub3")
    public String sub3(Model model, String from, String to) throws SQLException {
        String sql = """
                SELECT *
                FROM Products
                WHERE Price BETWEEN ? AND ?
                ORDER BY Price
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, from);
        pstmt.setString(2, to);
        ResultSet rs = pstmt.executeQuery();

        try (conn; pstmt; rs) {
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getString("ProductID"));
                product.setName(rs.getString("ProductName"));
                product.setCategoryId(rs.getString("CategoryID"));
                product.setSupplierId(rs.getString("SupplierID"));
                product.setUnit(rs.getString("Unit"));
                product.setPrice(rs.getString("Price"));
                list.add(product);
            }
            model.addAttribute("productList", list);
        }

        return "/main26/sub5";
    }

    @GetMapping("sub4")
    public void sub4(Model model, String begin, String end) throws SQLException {
        String sql = """
                SELECT *
                FROM Orders
                WHERE OrderDate BETWEEN ? AND ?
                ORDER BY OrderDate
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, begin);
        pstmt.setString(2, end);
        ResultSet rs = pstmt.executeQuery();

        try (conn; pstmt; rs) {
            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getString("OrderID"));
                order.setOrderDate(rs.getString("OrderDate"));
                order.setCustomerId(rs.getString("CustomerID"));
                order.setEmployeeId(rs.getString("EmployeeID"));
                order.setShipperId(rs.getString("ShipperID"));
                list.add(order);
            }
            model.addAttribute("orderList", list);
        }

    }

    @GetMapping("sub5")
    public void sub5(Model model,
                     @RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                     @RequestParam(value = "page_count", defaultValue = "10") Integer pageCount) throws SQLException {
        // 총 레코드 수 조회
        String numberOfRowSQL = """
                SELECT COUNT(*)
                FROM Customers
                """;
        Connection conn2 = dataSource.getConnection();
        PreparedStatement pstmt2 = conn2.prepareStatement(numberOfRowSQL);
        ResultSet rs2 = pstmt2.executeQuery();
        try (conn2; pstmt2; rs2;) {
            // 총 레코드 수
            Integer numberOfRows = rs2.next() ? rs2.getInt(1) : 0;
            // 마지막 페이지 번호
            Integer lastPageNumber = (numberOfRows - 1) / pageCount + 1;

            model.addAttribute("lastPageNumber", lastPageNumber);

            // 현재 페이지 번호
            model.addAttribute("currentPageNumber", pageNumber);
            // 페이지 번호의 끝(맨 오른쪽)값 (10개씩 보여줄 때)
            Integer endPageNumber = ((pageNumber - 1) / 10 + 1) * 10;
            // 페이지 번호의 시작(맨 왼쪽)값 (10개씩 보여줄 때)
            Integer beginPageNumber = endPageNumber - 9;

            // 다음버튼 클릭시 사용될 페이지 번호
            Integer nextPageNumber = endPageNumber + 1;
            // 이전버튼 클릭시 사용될 페이지 번호
            Integer prevPageNumber = beginPageNumber - 1;

            if (nextPageNumber <= lastPageNumber) {
                model.addAttribute("nextPageNumber", nextPageNumber);
            }

            if (prevPageNumber > 0) {
                model.addAttribute("prevPageNumber", prevPageNumber);
            }
            model.addAttribute("endPageNumber", Math.min(endPageNumber, lastPageNumber));
            model.addAttribute("beginPageNumber", beginPageNumber);

        }
        // 고객 목록 조회
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerId
                LIMIT ?, ?
                """;

        Integer offset = (pageNumber - 1) * pageCount;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, offset);
        pstmt.setInt(2, pageCount);
        ResultSet rs = pstmt.executeQuery();

        try (conn; pstmt; rs) {
            List<Customer> list = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("CustomerId"));
                customer.setName(rs.getString("CustomerName"));
                customer.setContact(rs.getString("ContactName"));
                customer.setAddress(rs.getString("Address"));
                customer.setCity(rs.getString("City"));
                customer.setCountry(rs.getString("Country"));
                customer.setPostalCode(rs.getString("PostalCode"));
                list.add(customer);
            }
            model.addAttribute("customerList", list);
        }
    }
    // 6번째 메소드
    // 최신 주문 순 (ORDER BY OrderID DESC)
    // 각 페이지에 20개씩 주문이 조회되는 코드 작성

    // 마지막 페이지 구해서 Model로 넘겨주고
    // jsp에서 마지막 페이지 번호까지 출력

    // 페이지 번호 나열을 페이징 하기

    // 이전 버튼, 다음 버튼 만들기
    // 이전, 다음 버튼 적절히 출력

    // 마지막 페이지 번호 목록이 최종페이지보다 크지 않도록
    @GetMapping("sub6")
    public void sub6(Model model,
                     @RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                     @RequestParam(value = "count", defaultValue = "20") Integer rowCount) throws SQLException {

        // 1. 총 주문 수를 계산하여 마지막 페이지 구하기
        String countSql = """
                SELECT COUNT(*)
                FROM Orders
                """;

        Connection conn2 = dataSource.getConnection();
        PreparedStatement pstmt2 = conn2.prepareStatement(countSql);
        ResultSet rs2 = pstmt2.executeQuery();
        try (conn2; pstmt2; rs2;) {
            // 총 레코드 수 (전체 주문 수)
            Integer numberOfRows = rs2.next() ? rs2.getInt(1) : 0;
            // 마지막 페이지 번호 계산 (총 레코드 수를 한 페이지당 표시할 수 있는 개수로 나누어 구함)
            Integer lastPageNumber = (numberOfRows - 1) / rowCount + 1;
            model.addAttribute("lastPageNumber", lastPageNumber); // 마지막 페이지를 Model에 저장하여 JSP로 전달

            // 2. 현재 페이지 번호를 Model로 넘기기
            model.addAttribute("currentPageNumber", pageNumber);

            // 3. 페이지 목록 (현재 페이지 기준으로 몇 페이지가 보일지를 결정)
            // 끝페이지 (7개 단위로 페이징)
            Integer endPageNumber = ((pageNumber - 1) / 7 + 1) * 7;
            // 시작페이지 (끝페이지에서 6을 빼서 구함)
            Integer beginPageNumber = endPageNumber - 6;
            // 끝 페이지가 마지막 페이지를 넘지 않도록 설정
            model.addAttribute("endPageNumber", Math.min(endPageNumber, lastPageNumber));
            model.addAttribute("beginPageNumber", beginPageNumber);

            // 4. 이전 버튼 만들기
            // 이전 버튼 클릭 시 이동할 페이지 계산 (시작 페이지 번호에서 -1)
            Integer prevPageNumber = beginPageNumber - 1;
            if (prevPageNumber > 0) {
                model.addAttribute("prevPageNumber", prevPageNumber); // 이전 버튼이 있을 경우 Model에 저장
            }

            // 5. 다음 버튼 만들기
            // 다음 버튼 클릭 시 이동할 페이지 계산 (끝 페이지 번호에서 +1)
            Integer nextPageNumber = endPageNumber + 1;
            if (nextPageNumber <= lastPageNumber) {
                model.addAttribute("nextPageNumber", nextPageNumber); // 다음 버튼이 있을 경우 Model에 저장
            }
        }

        // 6. 최신 주문 순으로 각 페이지에 20개씩 조회
        String sql = """
                SELECT *
                FROM Orders
                ORDER BY OrderID DESC
                LIMIT ?, ? 
                """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 7. 페이지에 맞게 데이터를 가져오기 (LIMIT으로 조회할 시작점과 개수 설정)
        pstmt.setInt(1, (pageNumber - 1) * rowCount); // 페이지에 따른 시작 offset 계산
        pstmt.setInt(2, rowCount); // 한 페이지당 보여줄 rowCount 개수 설정

        ResultSet rs = pstmt.executeQuery();
        try (conn; pstmt; rs) {
            // 8. 결과를 Order 객체에 담고, 리스트에 저장한 후 JSP에 넘기기
            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getString("OrderID"));
                order.setOrderDate(rs.getString("OrderDate"));
                order.setCustomerId(rs.getString("CustomerID"));
                order.setEmployeeId(rs.getString("EmployeeID"));
                order.setShipperId(rs.getString("ShipperID"));
                list.add(order); // 조회된 주문을 리스트에 추가
            }
            model.addAttribute("orderList", list); // JSP에 주문 목록을 넘기기 위해 Model에 저장
        }

    }
}
