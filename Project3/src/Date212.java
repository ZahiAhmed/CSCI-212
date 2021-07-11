//Ahmed, Zahi Lab 11E

public class Date212 {
	//private instance variables to convert the dates
	private int year;
	private int month;
	private int day;

	//substrings to separate the years months and days
	public Date212(String d){	
	year = Integer.parseInt(d.substring(0, 4));
    month = Integer.parseInt(d.substring(4, 6));
    day = Integer.parseInt(d.substring(6));
	
    if((d.length() != 8) || (month>12) || (month<0) || (day>31))
			throw new Date212Exception("Invalid Date: " + d);
    }
	
	//get and set methods
	public int getYear() {
		return year;
	}	
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
  
	public void setYear(int y) {
		year = y;
	}
	public void setMonth(int m) {
		month = m;
	}
	public void setDay(int d) {
		day = d;
	}
	
	//toString method converts month number to name
	public String toString() {
		String m = " ";
		if (month == 1) 
			m = "January";
		if (month == 2)
			m = "February";
		if (month == 3)
			m = "March";
		if (month == 4) 
			m = "April";
		if (month == 5) 
			m = "May";	
		if (month == 6)
			m = "June";
		if (month == 7)
			m = "July";
		if (month == 8) 
			m = "August";
		if (month == 9) 
			m = "September";
		if (month == 10)
			m = "October";
		if (month == 11) 
			m = "November";
		if (month == 12) 
			m = "December";
		m += " " + Integer.toString(day) + ", " + Integer.toString(year) + ".";
		return m;
	}
	
	//equals method
	public boolean equals(Date212 date) {
		if(this.year == date.year && this.month == date.month && this.day == date.day) {
			return true;
		} else {
			return false;
		}
	}
	
	//compareTo method called in SelectionSort
	public int compareTo(Date212 date) {
		if(this.year == date.getYear() && this.month == date.getMonth() && this.day == date.getDay()) {
			return 0;
		}
		
		if(this.year < date.getYear()) {
			return -1;
		} else if(this.year == date.getYear() && this.month < date.getMonth()) {
			return -1;
		} else if(this.year == date.getYear() && this.month == date.getMonth() && this.day < date.getDay()) {
			return -1;
		}

		if(this.year > date.getYear()) {
			return 1;
		} else if(this.year == date.getYear() && this.month > date.getMonth()) {
			return 1;
		} else if(this.year == date.getYear() && this.month == date.getMonth() && this.day > date.getDay()) {
			return 1;
		}
		
		return -2;
	}
}
