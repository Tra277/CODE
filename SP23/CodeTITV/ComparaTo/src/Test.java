/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
import vidu.SinhVien;
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SinhVien sv1 = new SinhVien(150, "Do Son Tra", "SE1760", 9);
        SinhVien sv2 = new SinhVien(100, "Do Son B", "SE1760", 8);   
        SinhVien sv3 = new SinhVien(199, "Nguyen Van An", "SE1760", 9);
        System.out.println(sv1.compareTo(sv2));
        System.out.println(sv3.compareTo(sv1));
        }
    
}
