/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author alexf
 */
public class Math implements Serializable {

    private String num1 = "", num2 = "", op = "";

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Math(String num1, String num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public Math() {
    }

    public String getResult() {
        String rs = "";
        try {
            int numb1 = Integer.parseInt(num1);
            int numb2 = Integer.parseInt(num2);
            switch (op) {
                case "+":
                    rs = "Tong: " + (numb1 + numb2);
                    break;
                case "-":
                    rs = "Hieu: " + (numb1 - numb2);
                    break;
                case "*":
                    rs = "Tich: " + (numb1 * numb2);
                    break;
                case "/":
                    if (numb2 == 0) {
                        rs = "Khong chia duoc cho 0!";
                    } else {
                        rs = "Thuong: " + (numb1 / numb2);
                    }
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            rs = "Khong phai la so";
            System.out.println(e);
        }

        return rs;
    }
}
