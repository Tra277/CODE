package test;

import java.util.Scanner;
import main.DanhSachSinhVien;
import main.SinhVien;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luaChon =0;
        do{
            System.out.println("Lựa chọn chức năng:");
            System.out.println("MENU");
            System.out.println("1.Add sinh viên");
            System.out.println("2.In danh sách");
            System.out.println("3.isEmpty");
            System.out.println("4.số lượng sinh viên");
            System.out.println("5.làm rỗng");
            System.out.println("6.kiểm tra sinh viên theo mã SV");
            System.out.println("7.Xóa SV theo mã SV");
            System.out.println("8.tìm kiếm sinh viên dựa theo tên");
            System.out.println("9.Xuất danh sách điểm từ cao đến thấp");
            System.out.println("0.Exit");
            luaChon =sc.nextInt();
            sc.nextLine();
            switch (luaChon){
                case 1:
                    System.out.println("Nhap ma Sv: ");
                    String maSinhVien = sc.nextLine();
                     System.out.println("Nhap name: ");
                    String hoVaTen = sc.nextLine();
                     System.out.println("Nhap nam sinh: ");
                    int namSinh = sc.nextInt();
                     System.out.println("Nhap diem TB: ");
                    float diemTrungBinh = sc.nextFloat();
                    SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                    dssv.themSinhVien(sv);
                    break;
                case 2:
                    dssv.inDanhSachSinhVien();
                    break;
                case 3:
                    System.out.println(dssv.kiemTraDanhSachRong());
                    break;
                case 4:
                    System.out.println(dssv.laySoLuongSinhVien());
                    break;
                case 5:
                    System.out.println("DOne!");
                    dssv.lamRongDanhSah();
                    break;
                case 6:
                    System.out.println("Nhap ma sinh vien:");String maSinhVien1 = sc.nextLine();
                    SinhVien sv1 = new SinhVien(maSinhVien1);
                    System.out.println(dssv.kiemTraTonTai(sv1));
                    break;
                case 7:
                    System.out.println("Nhap ma sinh vien:");String maSinhVien2 = sc.nextLine();
                    SinhVien sv2 = new SinhVien(maSinhVien2);
                    dssv.xoaSinhVien(sv2);
                    break;
                case 8:
                    System.out.println("Nhap Ten:");String hoVaTen1 = sc.nextLine();
                    dssv.timSinhVien(hoVaTen1);
                    break;
                case 9:
                    dssv.sapXepSinhVienGiamDanTheoDiem();
                    dssv.inDanhSachSinhVien();
                    break;
                

            }
        }while(luaChon!=0);
    }

}
