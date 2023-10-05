package DTO;

import Utility.Utility;
import java.util.Scanner;

public class Item implements IIo {

        private int value;
        private String creator;

        public Item(int value, String creator) {
                this.value = value;
                this.creator = creator;
        }

        public Item() {
        }

        public int getValue() {
                return value;
        }

        public void setValue(int value) {
                this.value = value;
        }

        public String getCreator() {
                return creator;
        }

        public void setCreator(String creator) {
                this.creator = creator;
        }

        @Override
        public void input(Scanner sc) {
                Utility u = new Utility();
                setValue(u.getInt(sc,"Enter value (1-100):",1,100));
                setCreator(u.getString(sc,"Enter creator (not empty):", "^.*[a-zA-Z0-9]+.*$"));
        }

        @Override
        public void output() {
                System.out.println("Value: " + value + "\nCreator: " + creator);
        }

}
