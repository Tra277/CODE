
/**
 *
 * @author alexf
 */
public class MyString implements IString{

    @Override
    public int f1(String string) {
        int cnt=0;
        for(int i=0;i<string.length();i++){
            if("0123456789".contains(string.substring(i, i+1))){
                cnt += Integer.parseInt(string.substring(i, i+1));
            }
    }
        
        return cnt;
    }
 
//    @Override
//    public String f2(String string) {
//      String[] str= string.split("//str");
//      String s="";
//      int b =0;
//        for (String string1 : str) {
//             if("012345678".contains(string1)){
//              
//                 b =  Integer.parseInt(string1)+1;   
//                s.concat(b+"") ;
//            }else{
//            s.concat(string1);
//             }
//        }
//        return s;
// 
// }
//}
    public String f2(String string) {
  String[] str = string.split("");
  String s = "";
  for (String strElement : str) {
    if ("012345678".contains(strElement)) {
      int b = Integer.parseInt(strElement) + 1;
      s = s.concat(b + "");
    } else {
      s = s.concat(strElement);
    }
  }
  return s;
}
}