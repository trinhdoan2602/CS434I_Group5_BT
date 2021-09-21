package qlnhanvien;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DSNV {
    public ArrayList <NHANVIEN> list;
    public DSNV(){
        list = new ArrayList<>();
    }
    public void themMoi(){
        Scanner sc = new Scanner(System.in);
        char ch = 'Y';
        while (ch == 'Y' || ch == 'y'){
            System.out.println("Nhap F cho NVBC, P cho NVHD");
            char K = sc.next().charAt(0);
            if (K == 'F'|| K == 'f') {
                NHANVIEN nvbc = new NVBC();
                nvbc.Nhap();
                list.add(nvbc);
            }
            else{
                NHANVIEN nvhd = new NVHD();
                nvhd.Nhap();
                list.add(nvhd);
            }
            System.out.println("Nhap Y de tiep tuc");
            ch = sc.next().charAt(0);
        }
    }
    public void CapNhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can sửa");
        String maNVSua = sc.nextLine();
        NHANVIEN nv;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNV().equals(maNVSua)) {
                if (list.get(i) instanceof NVBC) {
                    nv = new NVBC();
                }
                else{
                    nv = new NVHD();
                }
                nv.Nhap();
                list.set(i, nv);
            }
        }
    }
    public void Xoa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao maNV can xoa");
        String  maNVXoa = sc.nextLine();
        for (NHANVIEN nhanvien : list) {
            if (nhanvien.getMaNV().equalsIgnoreCase(maNVXoa)) {
                list.remove(nhanvien);
                break;
            }
        }
    }
    public void TimKiem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap maNV can tim kiem");
        String maNVTimKiem = sc.nextLine();
        for (NHANVIEN nhanvien : list) {
            if (nhanvien.getMaNV().equalsIgnoreCase(maNVTimKiem)) {
                if (nhanvien instanceof NVBC) {
                    NVBC nvbc = (NVBC)nhanvien;
                    nvbc.Xuat();
                }
                else{ 
                    NVHD nvhd = (NVHD)nhanvien;
                    nvhd.Xuat();
                }
            }
        }
    }
    public void XuatDSNV(){
        for (NHANVIEN nhanvien : list) {
            if (nhanvien instanceof NVBC) {
                NVBC nvbc = (NVBC)nhanvien;
                nvbc.Xuat();
            }
            else{
                NVHD nvhd = (NVHD)nhanvien;
                nvhd.Xuat();
            }
        }
    }
    public void TimMax(){
        double MaxLuong = list.get(0).tinhLuong();
        NHANVIEN nvmax = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).tinhLuong()>MaxLuong) {
                MaxLuong = list.get(i).tinhLuong();
                nvmax = list.get(i);
                
            }
            
        }
        System.out.println("Nhan vien co muc luong cao nhat la: "+ nvmax.getMaNV());
    }
     public void ThongKe(){
            int demNVBC=0;
            int demNVHD=0;
            for (NHANVIEN nhanvien : list) {
                if (nhanvien instanceof NVBC) {
                    demNVBC++;
                }
                else
                    demNVHD++;
            }
            System.out.println("So nhan vien bien che la: "+demNVBC);
            System.out.println("So nhan vien hop dong la:"+demNVHD);
        }
        
        public void TaoMenu(){
            do{
                System.out.println("Cac chuc nang chinh cua chuong trinh:");
                System.out.println("1. Them moi");
                System.out.println("2. Cap nhat");
                System.out.println("3. Xoa nhan vien");
                System.out.println("4. Tim kiem");
                System.out.println("5. Xuat DSNV");
                System.out.println("6. Tim nhan vien co luong cao nhat");
                System.out.println("7. Thong ke so nhan vien");

                Scanner sc = new Scanner(System.in);
                System.out.println("Moi ban chon chuc nang: ");
                int chon = sc.nextInt();
                switch (chon) {
                    case 1:
                        themMoi();
                        break;
                    case 2:
                        CapNhap();
                        break;
                    case 3:
                        Xoa();
                        break;
                    case 4:
                        TimKiem();
                        break;
                    case 5:
                        XuatDSNV();
                        break;
                    case 6:
                        TimMax();
                        break;
                    case 7:
                        ThongKe();
                        break;
                    default:
                        System.exit(0);
                }

            }while(true);
        }
  }
