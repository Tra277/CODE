package DTO;

import Utility.Utility;
import java.util.Scanner;

public class Painting extends Item {

        private int height, width;
        private boolean isWatercolour, isFramed;

        public Painting(int height, int width, int value, String creator, boolean isWatercolour, boolean isFramed) {
                super(value, creator);
                this.height = height;
                this.width = width;
                this.isWatercolour = isWatercolour;
                this.isFramed = isFramed;
        }

        public boolean isIsWatercolour() {
                return isWatercolour;
        }

        public void setIsWatercolour(boolean isWatercolour) {
                this.isWatercolour = isWatercolour;
        }

        public boolean isIsFramed() {
                return isFramed;
        }

        public void setIsFramed(boolean isFramed) {
                this.isFramed = isFramed;
        }

        public Painting() {
        }

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }

        public int getWidth() {
                return width;
        }

        public void setWidth(int width) {
                this.width = width;
        }

        @Override
        public void input(Scanner sc) {
                super.input(sc);
                Utility u = new Utility();
                setHeight(u.getInt(sc, "Enter height (1-100):", 1, 100));
                setWidth(u.getInt(sc, "Enter width (1-100):", 1, 100));
                switch (u.getInt(sc, "Enter isWatercolour (1-true, 0-false):", 0, 1)) {
                        case 1:
                                setIsWatercolour(true);
                                break;
                        case 0:
                                setIsWatercolour(false);
                                break;
                }
                switch (u.getInt(sc, "Enter isFramed (1-true, 0-false):", 0, 1)) {
                        case 1:
                                setIsFramed(true);
                                break;
                        case 0:
                                setIsFramed(false);
                                break;
                }
        }
        @Override
        public void output() {
                super.output();
                System.out.println("Height: " + height);
                System.out.println("Width: " + width);
                System.out.println("isWatercolour: " + ((isWatercolour) ? "Yes" : "No" ));
                System.out.println("isFramed: " +  ((isFramed) ? "Yes" : "No" ));
        }

}
