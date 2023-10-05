package DTO;

import Utility.Utility;
import java.util.Scanner;

public class Vase extends Item {

        private int height;
        private String material;

        public Vase(int height, String material, int value, String creator) {
                super(value, creator);
                this.height = height;
                this.material = material;
        }

        public Vase() {
        }

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }

        public String getMaterial() {
                return material;
        }

        public void setMaterial(String material) {
                this.material = material;
        }

        @Override
        public void input(Scanner sc) {
                super.input(sc);
                Utility u = new Utility();
                setHeight(u.getInt(sc,"Enter height (1-100):",1,100));
                setMaterial(u.getString(sc,"Enter material (not empty):","^.*[a-zA-Z0-9]+.*$"));
        }

        @Override
        public void output() {
                super.output();
                System.out.println("Height: " + height);
                System.out.println("Material: " + material);
        }

}
