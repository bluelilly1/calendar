import java.util.Scanner;
public class MyCalendar {
	public int YearOddDays(int year) {
		year = year % 400;
		int oddDays = year / 300;
//		System.out.println("OddDays 1:" + OddDays);			

		year = year % 300;
		oddDays += 3 * (year / 200);

		year %= 200;
		oddDays += 5 * (year / 100);

		year %= 100;
		
		int leapYears = (year / 4) % 7;
		oddDays += leapYears;
		year %= 7;
		oddDays += year;
		oddDays %= 7;
		return oddDays;
		
	}
	public void printMonth (int start, int dayCount) {
		
		int days = 1;
		int startSpace = start;
		int counter=0;
		System.out.println("M   T   W   Th  F   Sa  Su"); 
		
		while (days <= dayCount) {			
			
			while (startSpace!=1) {
				System.out.print("    ");
				counter++;
				startSpace--;
			}
			
			/*
			if ((((days-start+2) % 7) == 0) && (days != 1)) {
				System.out.print("\n");
			}*/
			if (counter==7) {
				System.out.print("\n");
				counter=0;
			}
			
			if (days <= 9) {
				System.out.print(days + "   ");
			}
			else {
				System.out.print(days + "  ");
			}


			counter++;
			days++;
		}
	}
	
	public static void main(String[] args) {
		MyCalendar mycal = new MyCalendar();
		//user input 
		Scanner checking = new Scanner(System.in);
		System.out.println("Enter the year: ");
		String YearTold = checking.nextLine();
		int YearByUser = Integer.parseInt(YearTold);
		checking.close();

		//Print Year Calendar
		int dayLimit=31;
		int carry=0;
		
		int oddDaysYear =mycal.YearOddDays(YearByUser);
		
		System.out.println("January");
		mycal.printMonth(oddDaysYear, dayLimit);
		
		int [] monthTotals = {31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String [] monthNames = {"\nMarch", "\nApril", "\nMay", "\nJune", "\nJuly", "\nAugust", "\nSeptember", "\nOctober", "\nNovember", "\nDecember"};
		
		carry = dayLimit % 7;
		dayLimit=28;
		System.out.println("\nFebruary");
		mycal.printMonth(oddDaysYear + carry, dayLimit);
		
		for (int count = 0; count < monthTotals.length; count++) {
			carry = (carry  + monthTotals[count]) % 7; 
			System.out.println(monthNames[count]);
			mycal.printMonth(oddDaysYear + carry, monthTotals[count]);
		}
		
		/*carry = (carry+ dayLimit) % 7;
		dayLimit=31;
		System.out.println("\nMarch");
		mycal.printMonth(oddDaysYear+carry, dayLimit);
		
		carry = (carry+ dayLimit) % 7; 
		dayLimit=30;
		System.out.println("\nApril");
		mycal.printMonth(oddDaysYear +carry, dayLimit);*/
	}	
	
 }

