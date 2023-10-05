
import java.util.List;


/**
 *
 * @author alexf
 */
public class MyCoffee implements ICoffee{

    @Override
    public int f1(List<Coffee> t) {
        
        int countGE=0;
        for (Coffee coffee : t) {
            int count=0;
            for (int i = 0; i < coffee.getName().length(); i++) {
                
                if("A".contains(coffee.getName().substring(i, i+1))){
                    
                    count++;
                    break;
                }
                if("B".contains(coffee.getName().substring(i, i+1))){
                    count++;
                    break;
                }
            if(count==2){
                countGE++;
            }
        }
        
    }
        return t.size() - countGE -1;
    }
    @Override
    public void f2(List<Coffee> t) {
        int firstIndexMax=0;
        int valueMax= t.get(0).getSize();
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getSize()>valueMax){
                valueMax= t.get(i).getSize();
            }
        }
        for (int j = 0; j < t.size(); j++) {
            if (t.get(j).getSize()==valueMax){
                firstIndexMax=j;
                break;
            }    
        }
        t.remove(firstIndexMax);
    }

    @Override
    public void f3(List<Coffee> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
