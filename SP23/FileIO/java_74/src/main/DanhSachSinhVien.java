package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhSach;

    public DanhSachSinhVien() {
        this.danhSach = new ArrayList<SinhVien>() ;
    }
    
    
    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }
    public void themSinhVien(SinhVien sv){
        this.danhSach.add(sv);
    }
    
    public void inDanhSachSinhVien(){
        for (SinhVien sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }
    
    public boolean kiemTraDanhSachRong(){
        return this.danhSach.isEmpty();
    }
    
    public int laySoLuongSinhVien(){
        return this.danhSach.size();
    }
    
    public void lamRongDanhSah(){
        this.danhSach.removeAll(danhSach);
    }
    
    public boolean kiemTraTonTai(SinhVien sv){
        return this.danhSach.contains(sv);
    }
    
    public void xoaSinhVien(SinhVien sv){
       this.danhSach.remove(sv);
    }
    
    public void timSinhVien(String ten){
        for (SinhVien sinhVien : danhSach) {
            if(sinhVien.getHoVaTen().contains(ten)){
                System.out.println(sinhVien);
            }
        }
    }
    
    public void sapXepSinhVienGiamDanTheoDiem(){
        Comparator<SinhVien> sort1 = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getDiemTrungBinh()>o2.getDiemTrungBinh()) {return -1;}
                else if (o1.getDiemTrungBinh()<o2.getDiemTrungBinh()) {return 1;}
                else {return 0;}   
                
            }
        };
                Collections.sort(danhSach, sort1);
    }
    
    public void ghiDuLieuXuongFile(File file){
            //Tạo đối tượng để ghi dữ liệu xuống file
            try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
                for (SinhVien sinhVien : danhSach) {
                    oos.writeObject(sinhVien);
                }
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }

    public void docDuLieuTuFile(File f1) {
            try {
            InputStream is = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(is);
            SinhVien sv = null;
            while(true){
                Object oj =  ois.readObject();
                if(sv==null){
                    break;
                }                
                if(sv!=null){
                    sv = (SinhVien) oj;
                    this.danhSach.add(sv);
                }

            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
}
