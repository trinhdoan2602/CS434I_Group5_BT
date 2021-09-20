/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLNhanVienn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public abstract class NHANVIEN {
    protected String maNV;
    protected String hoTen;
    protected Date ngaySinh;
    protected Date ngayVao;
    public static final int LCB = 1150000;
    public NHANVIEN(){
        
    }

    public NHANVIEN(String maNV, String hoTen, Date ngaySinh, Date ngayVao) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.ngayVao = ngayVao;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public Date getNgayVao() {
        return ngayVao;
    }

    public static int getLCB() {
        return LCB;
    }
    public abstract double tinhPhuCap();
    public abstract double tinhLuong();
    public int tinhThamNien(){
        Calendar c1 = new GregorianCalendar();
        Calendar c2 = new GregorianCalendar();
        Date ngayHT = Calendar.getInstance().getTime();
        c1.setTime(ngayHT);
        c2.setTime(ngayVao);
        int thamNien = c1.get(Calendar.YEAR)-c2.get(Calendar.YEAR);
        return thamNien;
    }
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.println("Nhap ho ten nhan vien: ");
        hoTen = sc.nextLine();
        System.out.println("Nhap ngay sinh nhan vien: ");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ngaySinh = df.parse(sc.nextLine());
        } catch (ParseException ex) {
            Logger.getLogger(NHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ngayVao = df.parse(sc.nextLine());
        } catch (ParseException ex) {
            Logger.getLogger(NHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Nhap he so luong");
    }
    public void Xuat(){
        System.out.println("ma nhan vien la: ");
        System.out.println("Ho ten nhan vien la: ");
        System.out.println("Ngay sinh cua nhan vien la: ");
        System.out.println("Ngay vao cua nhan vien la: ");
        System.out.println("He so luong cua nhan vien la: ");
    }
}
