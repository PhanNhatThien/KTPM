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
public class DocGiaTestSuite {
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
    public void testXoaDocGia() throws SQLException {
        String maDocGia = "7f4f3647-95e0-4008-973c-6e69467f046d";
        
        Assertions.assertTrue(s.xoaDocGia(maDocGia));
    }
    
    
    @Test
    @Order(2)
    public void testXoaDocGiaErr() throws SQLException {
        String maDocGia = "ahhjjhj";
        
        Assertions.assertFalse(s.xoaDocGia(maDocGia));
    }
    
    
    @Test
    @Order(3)
    public void testSuaDocGia() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDocGia("1085dbac-c2db-4573-a654-b80e19569983");
        docGia.setHoTen("thien123");
        docGia.setEmail("thien@gmail.com");
        docGia.setNgaySinh(Date.valueOf(LocalDate.now()));
        docGia.setMaDoiTuong(1);
        docGia.setMaBoPhan(1);
        docGia.setGioiTinh("Nam");
        docGia.setNgayDangKy(Date.valueOf(LocalDate.now()));
        docGia.setNgayHetHan(Date.valueOf(LocalDate.now()));
        docGia.setDiaChi("HCM");
        docGia.setDienThoai("08912839");
        docGia.setMatKhau("2");
        
        Assertions.assertTrue(s.suaDocGia(docGia));
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
        Assertions.assertEquals(docGia.getMaDocGia(), newDocGia.getMaDocGia());
    }
    
    
    @Test
    @Order(4)
    public void testSuaDocGiaErr() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDocGia("thien456");
        docGia.setHoTen("thien123");
        docGia.setEmail("thien@gmail.com");
        docGia.setNgaySinh(Date.valueOf(LocalDate.now()));
        docGia.setMaDoiTuong(1);
        docGia.setMaBoPhan(1);
        docGia.setGioiTinh("Nam");
        docGia.setNgayDangKy(Date.valueOf(LocalDate.now()));
        docGia.setNgayHetHan(Date.valueOf(LocalDate.now()));
        docGia.setDiaChi("HCM");
        docGia.setDienThoai("08912839");
        docGia.setMatKhau("2");
        
        Assertions.assertFalse(s.suaDocGia(docGia));
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
         Assertions.assertNull(newDocGia);
    }
    @Test
    @Order(5)
    public void testThemDocGia() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDocGia("huy265");
        docGia.setHoTen("huy456");
        docGia.setEmail("huy@gmail.com");
        docGia.setNgaySinh(Date.valueOf(LocalDate.now()));
        docGia.setMaDoiTuong(2);
        docGia.setMaBoPhan(2);
        docGia.setGioiTinh("Nữ");
        docGia.setNgayDangKy(Date.valueOf(LocalDate.now()));
        docGia.setNgayHetHan(Date.valueOf(LocalDate.now()));
        docGia.setDiaChi("Ha Noi");
        docGia.setDienThoai("089980");
        docGia.setMatKhau("c4ca4238a0b923820dcc509a6f75849b");
        
        Assertions.assertTrue(s.themDocGia(docGia));
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
        Assertions.assertEquals(docGia.getMaDocGia(), newDocGia.getMaDocGia());
    }  
    @Test
    @Order(6)
    public void testThemDocGiaErr() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDocGia("huy265");
        docGia.setHoTen("huy456");
        docGia.setEmail("huy@gmail.com");
        docGia.setNgaySinh(Date.valueOf(LocalDate.now()));
        docGia.setMaDoiTuong(2);
        docGia.setMaBoPhan(2);
        docGia.setGioiTinh("Nữ");
        docGia.setNgayDangKy(Date.valueOf(LocalDate.now()));
        docGia.setNgayHetHan(Date.valueOf(LocalDate.now()));
        docGia.setDiaChi("Ha Noi");
        docGia.setDienThoai("089980");
        docGia.setMatKhau("c4ca4238a0b923820dcc509a6f75849b");
        
        Assertions.assertFalse(s.themDocGia(docGia));
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
    } 
}
