/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.tester;

import com.btl.pojo.DocGia;
import com.btl.services.DocGiaServices;
import com.btl.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Phan Nhat Thien
 */
public class DangkyTestSuite {
    private static Connection conn;
    private static DocGiaServices s;
    
    @BeforeAll
    public static void beforeAll() {
        s = new DocGiaServices();
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DocGiaTestSuite.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    @Test
    @Order(1)
    public void testDangKy() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDocGia("test900");
        docGia.setHoTen("vanvan");
        docGia.setEmail("van@gmail.com");
        docGia.setNgaySinh(Date.valueOf(LocalDate.now()));
        docGia.setMaDoiTuong(2);
        docGia.setMaBoPhan(1);
        docGia.setGioiTinh("Nam");
        docGia.setNgayDangKy(Date.valueOf(LocalDate.now()));
        docGia.setNgayHetHan(Date.valueOf(LocalDate.now()));
        docGia.setDiaChi("Da Nang");
        docGia.setDienThoai("0899800");
        docGia.setMatKhau("1");
        
        Assertions.assertTrue(s.dangKy(docGia));
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
        Assertions.assertEquals(docGia.getMaDocGia(), newDocGia.getMaDocGia());
    }  
    
    @Test
    @Order(2)
    public void testDangKyErr() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDocGia("test980");
        docGia.setHoTen("vanvan");
        docGia.setEmail("van@gmail.com");
        docGia.setNgaySinh(Date.valueOf(LocalDate.now()));
        docGia.setMaDoiTuong(2);
        docGia.setMaBoPhan(1);
        docGia.setGioiTinh("Nam");
        docGia.setNgayDangKy(Date.valueOf(LocalDate.now()));
        docGia.setNgayHetHan(Date.valueOf(LocalDate.now()));
        docGia.setDiaChi("Da Nang");
        docGia.setDienThoai("0899800");
        docGia.setMatKhau("1");
        
        Assertions.assertFalse(s.dangKy(docGia));
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
    }  
}
