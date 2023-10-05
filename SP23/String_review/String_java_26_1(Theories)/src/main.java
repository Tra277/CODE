
/**
 *
 * @author alexf
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Khởi tạo đối tượng thuộc lớp StringBuilder
        String a="hello,";
        StringBuilder chuoi = new StringBuilder(a);
        // append: thêm vào cuối chuỗi.
        chuoi.append("XinChao,");
        chuoi.append(" Minh moi hoc lap trinh");
        System.out.println(chuoi);
        // insert(index, String): chèn từ vị trí index.
        chuoi.insert(8, "Obama");
        System.out.println(chuoi);
        // delete(start,end):xóa chuỗi từ start tới end -1
         chuoi.delete(8,13);
         System.out.println(chuoi);
         
        //length() : độ dài chuỗi
        System.out.println(chuoi.length());
        
        //indexOf: vị trí đầu tiên xuất hiện (index)
        String s7="tôi đi tìm tôi";
        System.out.println(s7.indexOf("tôi"));
        //lastIndexOf: Vị trí cuối cùng xuất hiện (trả về index )
        System.out.println(s7.lastIndexOf("tôi"));
        
        //contains(): kiểm tra có chứa chuỗi không
        String s9=".mp4 ";
        String s10="tuhoc.mp3";
        System.out.println(s10.contains(s9));
        boolean check = s10.contains(s9);
        if (check) {
            System.out.println("Có .mp3 trong chuỗi"); 
        } else {
            System.out.println("Không tìm thấy");
        }
        //substring(): lấy một chuối con từ chuỗi ban đầu
        // ==> cách cắt chuỗi Vd: s21 = s21.substring(...);
        String s11 = "abcdefgh";
        String s12 = s11.substring(4);
        System.out.println(s12);
        String s13 = s11.substring(4, 7);
        System.out.println(s13);
        //replace("old","new"): thay thế toàn bộ chuỗi old bằng chuỗi new
        //replaceFirst("old","new") thay thế chuỗi old đầu tiên bằng chuỗi new
         String s14 = "học học nữa học mãi";
         String s15 = s14.replace("học", "chơi");
         String s16 = s14.replaceFirst("học", "chơi");
         System.out.println(s15);
         System.out.println(s16);
         //trim()
         String s17 = "       con cu        ";
         System.out.println(s17.trim());
         //trimEnd()
         while (s17.endsWith(" ")) {            
            s17=s17.substring(0, s17.length()-1);
        }
         System.out.println(s17);
         
         //trimStart()
         while (s17.startsWith(" ")) {            
            s17=s17.substring(1, s17.length());
        }
         System.out.println(s17);
        
        //split(regex)
        String s38 = "Hello, world1";
        String[] mangString = s38.split(",");
        // duyệt mảng 
        for (String string : mangString) {
            System.out.println(string);
        }
        
        //toCharArray: return mảng kí tự
        String s42 = "Con cu";
        char[] mang2 = s42.toCharArray();
        for (char c : mang2) {
            System.out.println(c);
        }
        
        //reverse() đảo ngược chuỗi (Thuộc String Builder)
        // bắt buộc phải khai báo class StringBuilder
        String s43= "123456789";
        StringBuilder sb1 = new StringBuilder(s43);
        String s44 = sb1.reverse().toString();
        System.out.println(s44);
                

    
        
    }
}
