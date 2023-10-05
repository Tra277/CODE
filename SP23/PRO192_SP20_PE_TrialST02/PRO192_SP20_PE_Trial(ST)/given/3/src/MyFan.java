
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author alexf
 */
public class MyFan implements IFan{

    @Override
    public void f1(List<Fan> t, String xCode) {
//            for (Fan fan : t) {
//            if( fan.getCode().startsWith(xCode)){
//                double gia=fan.getPrice()*1.1;
//                fan.setPrice(gia);
//            } else {
//            }
//           
//        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int f2(List<Fan> list, double d) {
        int count=0;
        for (Fan fan : list) {
            if(fan.getPrice()<=d){
                count++;
            }
            
        }
        return count;
    }

    @Override
    public void f3(List<Fan> list) {
        Comparator<Fan> sort1= new Comparator<Fan>() {
            @Override
            public int compare(Fan o1, Fan o2) {
                if(o1.getPrice()<o2.getPrice()){
                    return -1;
                }else if(o1.getPrice()>o2.getPrice()){
                   return 1;
                }else{
                   return o1.getCode().compareTo(o2.getCode());
                }
            }
           
        };
          Collections.sort(list,sort1);
                
           
      }

}
