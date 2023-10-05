package GUI;
import java.util.Comparator;

public class sortByValue implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.getValue() < item2.getValue()) {
            return -1;
        } else if (item1.getValue() > item2.getValue()) {
            return 1;
        } else {
            return 0;
        }
    }
}
