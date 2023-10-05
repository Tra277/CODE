package main;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author alexf
 */
public class ViduFile {
    File file;

    public ViduFile(String tenFile) {
        this.file = new File(tenFile);
    }
    public boolean kiemTraThucThi(){
        //Kiểm tra file có thể thực thi được hay khoog ?
        return this.file.canExecute();
    }
    public boolean kiemTraDoc(){
        //Kiểm tra file có thể đọc 
        return this.file.canRead();
    }
     public boolean kiemTraGhi(){
        //Kiểm tra file có thể ghi 
        return this.file.canWrite();
    }
    public void inDuongDan(){
        //In đường dẫn ra màn hình
        System.out.println(this.file.getAbsolutePath());
    }
    public void inTen(){
        System.out.println(this.file.getName());
    }
    public void kiemTraLaThuMucHoacTapTin(){
        if(this.file.isDirectory()){
        System.out.println("đây là thư mục");
        }else if(this.file.isFile()){
            System.out.println("Đây là tập tin");
        }
    }
    public void inCayThuMuc(){
        this.inChiTietCayThuMuc(this.file,1);
    }
    
    public void inChiTietCayThuMuc(File f, int bac){
        for (int i = 0; i < bac; i++) {
            System.out.print("\t");
        }
            System.out.print("|__");
            System.out.println(f.getName());
            if(f.canRead()&&f.isDirectory()){
                File[] mangCon = f.listFiles();
                for (File fx : mangCon) {
                inChiTietCayThuMuc(fx, bac+1);
                }
            
            }
        
    }
    
    public void inDanhSachCacFileCon(){
        if(this.file.isDirectory()){
            System.out.println("Các tập tin con/ thư mục con là:");
            File[] mangCon=this.file.listFiles();
            for (File file1 : mangCon) {
                System.out.println(file1.getAbsolutePath());
            }
        }else if(this.file.isFile()){
            System.out.println("Đây là tập tin, không có dữ liệu con bên trong");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int luaChon =0;
        System.out.println("Nhập tên File:");
        String tenFile = sc.nextLine();
        ViduFile vdf = new ViduFile(tenFile);
        do {            
            System.out.println("Menu*********");
            System.out.println("1.Kiểm tra file có thể thực thi:");
            System.out.println("2.Kiểm tra file có thể đọc:");
            System.out.println("3.Kiểm tra file có thể ghi:");
            System.out.println("4.Đường dẫn:");
            System.out.println("5.In tên file:");
            System.out.println("6.Kiểm tra file có là thư mục hay tập tin:");
            System.out.println("7.In ra danh sách các file con:");
            System.out.println("8.In ra cây thư mục:");
            System.out.println("0.Cút mọe mày đê");
            luaChon = sc.nextInt();
            switch(luaChon){
            case 1:
                System.out.println(vdf.kiemTraThucThi());
                break;
            case 2:
                System.out.println(vdf.kiemTraDoc());
                break;
            case 3:
                System.out.println(vdf.kiemTraGhi());
                break;
            case 4:
                vdf.inDuongDan();
                break;
            case 5:
                vdf.inTen();
                break;
            case 6:
                vdf.kiemTraLaThuMucHoacTapTin();
                break;
            case 7:
                vdf.inDanhSachCacFileCon();
                break;
            case 8:
                vdf.inCayThuMuc();
                break;
            default:
                    break;
            }
            String c =sc.nextLine();
        } while (luaChon!=0);
    }
    
}
