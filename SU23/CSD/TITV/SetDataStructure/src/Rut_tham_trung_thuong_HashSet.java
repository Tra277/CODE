
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Rut_tham_trung_thuong_HashSet {
    Set<String> tapHopPhieuDuThuong = new HashSet<String>();

    public Rut_tham_trung_thuong_HashSet() {
    }
    
    public boolean themPhieu(String giaTri){
        return this.tapHopPhieuDuThuong.add(giaTri);
    }
    
    public boolean xoaPhieu(String giaTri){
        return this.tapHopPhieuDuThuong.remove(giaTri);
    }
    
    public boolean kiemTraPhieuTonTai(String giaTri){
        return this.tapHopPhieuDuThuong.contains(giaTri);
    }
    
    public void xoaTatCaPhieuDuThuong(){
       this.tapHopPhieuDuThuong.clear();
    }
    
    public int laySoLuong(){
        return this.tapHopPhieuDuThuong.size();
    }
    
    public String rutMotPhieu(){
        String ketQua = "";
        Random rd = new Random();
        int viTri = rd.nextInt(this.tapHopPhieuDuThuong.size()-1);
        ketQua = (String) this.tapHopPhieuDuThuong.toArray()[viTri];
        return ketQua;
    }
    
    public void inTatCa(){
        System.out.println(Arrays.toString(this.tapHopPhieuDuThuong.toArray()));
    }
    
    
    public static void main(String[] args) {
        /*Set được triển khai bởi hashSet,LinkedHashSet,TreeSet và EnumSet*/
        //Tuy nhiên đa số dùng hashSet và TreeSet thì phải
        //TreeSet khác ở chỗ là nó sẽ sắp xếp phần tử còn hashSet thì không.
        //TreeSet nghe có vẻ áp dụng vào từ điển mạnh phết
        
       //HashSet
        int luaChon = 0;
        Scanner sc = new Scanner(System.in);
        Rut_tham_trung_thuong_HashSet rt = new Rut_tham_trung_thuong_HashSet();
        do{
            System.out.println(".....................................................");
            System.out.println("MENU: ");
            System.out.println("1.Them ma so du thuong");
            System.out.println("2.xoa ma so du thuong");
            System.out.println("3.kiem tra 1 ma co ton tai hay khong");
            System.out.println("4.xoa tat ca cac ma du thuong");
            System.out.println("5.so luong ma du thuong");
            System.out.println("6.Rut tham trung thuong");
            System.out.println("7.In ra tất cả các phiếu");
            System.out.println("0.Cut di");
            luaChon = sc.nextInt();
            sc.nextLine();
            if(luaChon==1 || luaChon == 2||luaChon==3){
                System.out.println("Nhập vào mã phiếu dự thưởng mother fucking bullshit!");
                String giaTri = sc.nextLine();
                if(luaChon==1){
                    rt.themPhieu(giaTri);
                }
                if(luaChon==2){
                    rt.xoaPhieu(giaTri);
                }
                if(luaChon==3){
                    System.out.println("Kết quả kiểm tra:"+rt.kiemTraPhieuTonTai(giaTri));
                    
                }
            }else if(luaChon==4){
                
                  rt.xoaTatCaPhieuDuThuong();
            }else if(luaChon==5){
                  System.out.println(rt.laySoLuong());
            }else if(luaChon==6){
                  System.out.println("Mã số trúng thưởng của bạn là: "+rt.rutMotPhieu());
            }else if(luaChon==7){
                System.out.println("Các mã phiếu dự thưởng là: ");
                rt.inTatCa();
            }
            
        }while(luaChon!=0);
    }

}
