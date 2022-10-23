/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.tester;

import com.btl.pojo.DocGia;
import com.btl.services.DocGiaServices;
import com.btl.utils.JdbcUtils;
import java.io.IOException;
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
public class DangNhapTestSuite {
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
    public void testDangNhap() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDoiTuong(2);
        docGia.setMaDocGia("admin");
        docGia.setMatKhau("c4ca4238a0b923820dcc509a6f75849b");
   
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
        Assertions.assertEquals(docGia.getMaDoiTuong(), newDocGia.getMaDoiTuong());
        Assertions.assertEquals(docGia.getMaDocGia(), newDocGia.getMaDocGia());
        Assertions.assertEquals(docGia.getMatKhau(), newDocGia.getMatKhau());
        
    }  
    
    
    @Test
    @Order(2)
    public void testDangNhapErr1() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDoiTuong(1);
        docGia.setMaDocGia("admin");
        docGia.setMatKhau("c4ca4238a0b923820dcc509a6f75849b");
   
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
        Assertions.assertNotEquals(docGia.getMaDoiTuong(), newDocGia.getMaDoiTuong());
        Assertions.assertEquals(docGia.getMaDocGia(), newDocGia.getMaDocGia());
        Assertions.assertEquals(docGia.getMatKhau(), newDocGia.getMatKhau());
        
    } 
    
    
    @Test
    @Order(3)
    public void testDangNhapErr2() throws SQLException {
        DocGia docGia = new DocGia();
        
        docGia.setMaDoiTuong(2);
        docGia.setMaDocGia("admin");
        docGia.setMatKhau("4ca4238a0b923820dcc509a6f75849b");
   
        
        DocGia newDocGia = DocGiaServices.getDocGiaById(docGia.getMaDocGia());
        Assertions.assertNotNull(newDocGia);
        Assertions.assertEquals(docGia.getMaDoiTuong(), newDocGia.getMaDoiTuong());
        Assertions.assertEquals(docGia.getMaDocGia(), newDocGia.getMaDocGia());
        Assertions.assertNotEquals(docGia.getMatKhau(), newDocGia.getMatKhau());
        
    } 
}
