package miniProject;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FlightCalendar {
	Calendar calendar = Calendar.getInstance();
	Calendar currentDate = Calendar.getInstance();
	Calendar inputDate = Calendar.getInstance();
	Calendar SrcDate = Calendar.getInstance();
	Calendar desDate = Calendar.getInstance();
	
	int monthSet[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	//윤년
	public void isLeapYear (int year) {
		if(year % 4  ==0 && year % 100 != 0 || year % 400 == 0)
			this.monthSet[1] = 29;
		else {
			this.monthSet[1] = 28;
		}
	}
	/*
	 * 
	 */
	//월의 1일 찾기 
	public int calMonth1stDayWeek(int year, int month) {
		 calendar = Calendar.getInstance();
    
        String YMD = year + "-" + month + "-01";// ex) 2020 - 03- 01
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            calendar.setTime(formatter.parse(YMD));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        // 1(일) 2(월) 3(화) 4(수) 5(목) 6(금) 7(토)
        return dayNum;
    }
	//
	public void CreateMonthCal(int year ,int month,int dayMax, int dayWeek1) {
		isLeapYear(year);
		System.out.println("========== " + year + "년 " + month + "월 ==========");
        System.out.println("  일      월      화      수     목     금     토  ");
        
        for (int j = 1; j < dayWeek1; j++) {
            System.out.print("         "); //
        }
        for (int i = 1; i <= dayMax; i++) {
            if (i < 10) {// 한 자리 수이면 앞에 공백 한 번 더 추가
                System.out.print("    " + i + "   ");
            }
            if (i >= 10) {
                System.out.print("  " + i + "  ");
            }
            // 줄바꿈
            if ((dayWeek1 - 1 + i ) % 7 == 0) { // 공백 = (dayWeek1 - 1) + i 가 일주일 한 줄.
                System.out.println();//줄바꿈
            }
        }
        
	}
	
	public void printCalendar(int year, int month) {
		
		int Month1stDayWeek = calMonth1stDayWeek(year,month);
		
		CreateMonthCal(year,month,monthSet[month - 1],Month1stDayWeek);
	}
	
	public boolean srcDesDesSrcCheck(int year, int month, int day) {
		inputDate.set(Calendar.YEAR, year);
		inputDate.set(Calendar.MONTH, month-1);
		inputDate.set(Calendar.DAY_OF_MONTH, day);
		
		if(currentDate.compareTo(inputDate) == 1) {
			return true;
			
		} else if(currentDate.compareTo(inputDate) == -1) {
			return false;
		} else  {
			return false;
		}
	}
	public boolean srcDesDesSrcCheck(int srcYear, int srcMonth, int srcDay,int desYear, int desMonth, int desDay) {
		//srcDate 가 출국일 , des가 귀국일
		SrcDate.set(Calendar.YEAR, srcYear);
		SrcDate.set(Calendar.MONTH, srcMonth-1);
		SrcDate.set(Calendar.DAY_OF_MONTH, srcDay);
		
		desDate.set(Calendar.YEAR, desYear);
		desDate.set(Calendar.MONTH, desMonth-1);
		desDate.set(Calendar.DAY_OF_MONTH, desDay);
		
		if(SrcDate.compareTo(desDate) == 1) {
			return true;
			
		} else if(SrcDate.compareTo(desDate) == -1) {
			return false;
		} else  {
			return false;
		}
	}
}
