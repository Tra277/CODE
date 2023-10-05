/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Time{
    private int hour;
    private int minute;
    private int second;
    public Time(int hour , int minute,int second){
        this.hour =hour;
        this.minute = minute;
        this.second = second;
    }
    public void setTime(int hour , int minute , int second){
           this.hour =hour;
        this.minute = minute;
        this.second = second;
    }
    
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public void previousSecond() {
		if (hour == 0 && minute == 0 && second == 0) {
			hour = 23;
			minute = 59;
			second = 59;
			return;
		}
		if (minute == 0 && second == 0) {
			hour--;
			minute = 59;
			second = 59;
			return;
		}
		if (second == 0) {
			minute--;
			second = 59;
			return;
		}
		second--;
	}

	public void nextSecond() {
		if (hour == 23 && minute == 59 && second == 59) {
			hour = 0;
			minute = 0;
			second = 0;
			return;
		}
		if (minute == 59 && second == 59) {
			hour++;
			minute = 0;
			second = 0;
			return;
		}
		if (second == 59) {
			minute++;
			second = 0;
			return;
		}
		second++;
	}

	void display() {
		String hour = this.hour + "";
		String minute = this.minute + "";
		String second = this.second + "";
		if (hour.length() == 1)
			hour = "0" + hour;
		if (minute.length() == 1)
			minute = "0" + minute;
		if (second.length() == 1)
			second = "0" + second;
		System.out.println(hour + ":" + minute + ":" + second);
	}
}

public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        	Time t = new Time(12, 1, 1);
		t.display();
		t.setTime(23, 59, 59);
		t.display();
		t.nextSecond();
		t.display();
		t.nextSecond();
		t.display();
		t.setTime(7, 0, 0);
		t.display();
		t.previousSecond();
		t.display();
    }
    
}
