/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author alexf
 */
import java.util.Scanner;
import main.DanhSachSinhVien;
import main.SinhVien;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luaChon = 0;
        do {
            System.out.println("Menu-------");
            System.out.println("1.Add\n");
            System.out.println("2.In\n");
            System.out.println("3.Kiem tra co rong hay khong\n");
            System.out.println("4.In ra so' sinh vien\n");
            System.out.println("5.Lam` rong~\n");
            System.out.println("6.Exist check a student with id\n");
            System.out.println("7.Xoa' dua. theo Id\n");
            System.out.println("8.Tim kiem tat ca sinh vien dua tren ten nhap tu ban phim\n");
            System.out.println("9.Dsach svien diem tu cao den thap\n");
            System.out.println("0.Exit\n");
            luaChon = sc.nextInt();
            String a = sc.nextLine();
            if  (luaChon==1) {
                
                    System.out.println("Nhap ma sinh vien ");
                    String maSinhVien = sc.nextLine();
                    System.out.println("Nhap ho va ten: ");
                    String hoVaTen = sc.nextLine();
                    System.out.println("Nhap nam sinh: ");
                    int namSinh = sc.nextInt();
                    System.out.println("Nhap diem: ");
                    float diemTrungBinh = sc.nextFloat();
                    SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
                    dssv.themSinhVien(sv);
                   
                
            }else if(luaChon==2){
                System.out.println("Danh sach sau khi in:");
                dssv.inDanhSachSinhVien();
            }else if(luaChon==3){
                System.out.println("Kiem tra:(True:Rong , False:Khong Rong:"+dssv.kiemTraDanhSachRong());
                
            }else if(luaChon==4){
                System.out.println("So luong hien tai:"+dssv.laySoLuongSinhVien());
                
            }else if(luaChon==5){
               
                dssv.lamRongDanhSach();
            }else if(luaChon==6){
              
                
            }

        } while (luaChon!=0);
    }
}
