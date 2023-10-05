/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void display() {
		String day = this.day + ""; //chuyển thành String mới thêm 0 đằng trc đc
		String month = this.month + ""; // +"" thành kiểu String
		String year = this.year + "";
		if (day.length() == 1) {
			day = "0" + day;			
		}
		if (month.length() == 1) {
			month = "0" + month;			
		}
		System.out.println(day + "/" + month + "/" + year);
	}
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date d = new Date(1, 1, 1997);
		d.display();
		d.setDate(12, 12, 2004);
		d.display();
		d.setMonth(3);
		d.display();
    }
    
}
