/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author alexf
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhSach;

    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }

    public DanhSachSinhVien() {
        this.danhSach = new ArrayList<SinhVien>();
    }
    
    public void themSinhVien(SinhVien sv){
        this.danhSach.add(sv);
    }
    public void inDanhSachSinhVien(){
        for (SinhVien sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }
    //3.Kiểm tra danh sách sinh viên có rỗng hay k
    public boolean kiemTraDanhSachRong(){
        return this.danhSach.isEmpty();
    }
     //4.Lay ra so luong
    public int laySoLuongSinhVien(){
        return this.danhSach.size();
    }
    public void lamRongDanhSach(){
        this.danhSach.removeAll(danhSach);
    }

   //6
    public boolean kiemTraTonTai(SinhVien sv){
        return this.danhSach.contains(sv);
    }
    //7
    public boolean xoaSinhVien(SinhVien sv){
        return this.danhSach.remove(sv);
    }
    public void timSinhVien(String ten){
        for (SinhVien sinhVien : danhSach) {
            if(sinhVien.getHoVaTen().indexOf(ten)>=0){
                System.out.println(sinhVien);
            }
        }
    }
    public void sapXepSinhVienGiamDanTheoDiem(){
        Collections.sort(this.danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getDiemTrungBinh()<o2.getDiemTrungBinh()){
                    return -1;
                }else if(o1.getDiemTrungBinh()>o2.getDiemTrungBinh()){
                    return 1;
                }else{ return 0;}
            }
        });
    }
}
