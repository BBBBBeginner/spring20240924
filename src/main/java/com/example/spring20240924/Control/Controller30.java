package com.example.spring20240924.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.DocFlavor;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("main30")
public class Controller30 {
    @Autowired
    DataSource dataSource;

    @GetMapping("sub1")
    public String sub1() {
        int t = 500;
        String sql1 = """
                UPDATE db1.my_table58
                SET money = money - ?
                WHERE name = 'kim'
                """;
        String sql2 = """
                UPDATE db1.my_table58
                SET money = money + ?
                WHERE name = 'lee'
                """;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt(1, t);
            ps.executeUpdate();

            PreparedStatement pss = conn.prepareStatement(sql2);
            pss.setInt(1, t);
            pss.executeUpdate();

            pss.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("sub2")
    public String sub2() {
        int t = 500;
        String sql1 = """
                UPDATE db1.my_table58
                SET money = money - ?
                WHERE name = 'kim'
                """;
        String sql2 = """
                UPDATE db1.my_table58
                SET money = money + ?
                WHERE name = 'lee'
                """;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt(1, t);
            ps.executeUpdate();

            int a = 0;
            int b = 5 / a; // Exception

            PreparedStatement pss = conn.prepareStatement(sql2);
            pss.setInt(1, t);
            pss.executeUpdate();

            pss.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("sub3")
    public String sub3() {
        int t = 500;
        String sql1 = """
                UPDATE db1.my_table58
                SET money = money - ?
                WHERE name = 'kim'
                """;
        String sql2 = """
                UPDATE db1.my_table58
                SET money = money + ?
                WHERE name = 'lee'
                """;

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt(1, t);
            ps.executeUpdate();

            int a = 0;
            int b = 5 / a; // Exception

            PreparedStatement pss = conn.prepareStatement(sql2);
            pss.setInt(1, t);
            pss.executeUpdate();

            conn.commit();

            pss.close();
            ps.close();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    @GetMapping("sub4")
    public String sub4() {
        int t = 500;
        String sql1 = """
                UPDATE db1.my_table58
                SET money = money - ?
                WHERE name = 'kim'
                """;
        String sql2 = """
                UPDATE db1.my_table58
                SET money = money + ?
                WHERE name = 'lee'
                """;

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt(1, t);
            ps.executeUpdate();


            PreparedStatement pss = conn.prepareStatement(sql2);
            pss.setInt(1, t);
            pss.executeUpdate();

            conn.commit();

            pss.close();
            ps.close();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    @GetMapping("sub5")
    public String sub5() throws SQLException {
        // 1.kim 계좌에서 1000 차감
        String sql1 = """
                UPDATE db1.my_table58
                SET money = money - ?
                WHERE name = 'kim'
                """;
        // 2. lee 계좌에서 1000 증액
        String sql2 = """
                UPDATE db1.my_table58
                SET money = money + ?
                WHERE name = 'lee'
                """;

        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);  // 트랜잭션 시작

            // kim 계좌에서 차감
            ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, 1000);
            ps1.executeUpdate();

            // lee 계좌에서 증액
            ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, 1000);
            ps2.executeUpdate();

            conn.commit();  // 모두 성공 시 커밋

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();  // 오류 발생 시 롤백
                    System.out.println("트랜잭션 롤백됨");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // 자원 해제
            if (ps1 != null) ps1.close();
            if (ps2 != null) ps2.close();
            if (conn != null) conn.close();
        }

        return "Success";
    }
}