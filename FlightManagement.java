package miniProject;



import java.util.Scanner;

public class FlightManagement {
	
	Scanner scan = new Scanner(System.in);
	
	
	FlightSchedule FlightSchedule = new FlightSchedule();
	
	//비행 캘린더 
	FlightCalendar flightCalendar = new FlightCalendar();
	
	
	
	//새로운 비행기를 생성하고 비행 계획 입력
	public Airplane newAirplane(String to,String from,String srcTime,String desTime ) {
		Airplane airplane = new Airplane();
		
		//새로운 비행기에 비행계획을 입력
		airplane.setFlightplan(to, from, srcTime, desTime);
		
		return airplane;
	}
	
	//비행기를 month,day에 저장 
	public void setNewAirplaneFlightSchedule(Airplane airplane,int month,int day) {
		FlightSchedule.setFilght(airplane, month, day);
	}
	//month,day에 저장된 비행기의 좌석 출력
	public void getAirplaneFlightMonthDay(int month,int day) {
		Airplane airplane = FlightSchedule.getFlightplan(month, day);
		airplane.SeeSeat();
	}
	//승객을 month월 day일 row행 col열에 저장
	public void addPassengerSeat(Passenger passenger,int month,int day,String S_code) {
		int row = (int)S_code.charAt(0) - 65;
		int col = Integer.parseInt(S_code.replaceAll(".*[A-Z]", ""));
		
		Airplane airplane = FlightSchedule.getFlightplan(month, day);
		if(!airplane.isEmpty(row,col)) {
			System.out.println("해당 좌석은 선택하실 수 없습니다.");
		}
		else {
			airplane.addPassengerSeat(passenger,row,col);
		}
		
	}
	public void getFlightPlan(int month,int day) {
		FlightSchedule.getFlightplan(month, day).seeAirplanePlan();
	}
	
	public boolean isEmptFlightplan(int month,int day) {
		//값이 있으면 true 
		if(FlightSchedule.getFlightplan(month, day) == null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public Passenger createPassenger(String name,String nation,String gender,String passportNo,int DoB) {
		Passenger passenger = new Passenger();
		passenger.setPassenger(name, nation, gender, passportNo, DoB);
		return passenger;
		
	}
	
	public boolean isEng(String str) {
		return str.matches("^[a-zA-Z]*$");
	}
	public String setEqualName() {
		
		String name =  scan.nextLine();
		
		while(!isEng(name = name.replaceAll(" ", "").toUpperCase())) {
			System.out.println("영문 이름으로 작성해주세요 >");
			 name = scan.nextLine();
			
			
		}
		return name;
	}
public String setEqualNation() {
		
		String nation =  scan.nextLine();
		
		while(!isEng(nation = nation.replaceAll(" ", "").toUpperCase())) {
			System.out.println("영문 표기로 작성해주세요 >");
			nation = scan.nextLine();
			
			
		}
		return nation;
	}
public String setEqualgender() {
	int num;
	String gender = null;
	while(gender == null) {
		System.out.println("1  -  M		2  -  F");
		num = scan.nextInt();
		
		if( num == 1 ) {
			gender = "M";
			return gender;
		} else if(num == 2) {
			gender = "F";
			return gender;
		}  else {
			System.out.println("성별을 제대로 표기해주세요");
		}
	}
	return null;
}
public int setEqualDoB() {
	String DoB;
	
	DoB = scan.next();
	while(!DoB.matches("^\\d{6}$")) {
		System.out.println("6자리 생년월일을 입력해주세요");
		DoB = scan.next();
	}
	return Integer.parseInt(DoB);
	
}

public Passenger setUserInfo() {
	System.out.print("영문이름을작성해주세요>");
	String name = setEqualName();
	System.out.print("국가를 작성해주세요 >");
	String nation =setEqualNation();
	System.out.print("6자리 생년월일을 입력해주세요>");
	int DoB = setEqualDoB();
	System.out.print("성별>");
	String gender = setEqualgender();
	System.out.print("여권  번호를 입력해주세요>");
	String PassNo = scan.next();
	Passenger passenger =  createPassenger(name, nation, gender, PassNo, DoB);
	return passenger;
}

public void SearchDayName(String name) {
	Airplane airplane ;
	Passenger passenger;
	int i = 1;
	 while(i < 13) {
		 int j = 1;
		 while(j <= 34) {
			 airplane = FlightSchedule.getFlightplan(i, j);
			// System.out.println(i+"월"+j+"일"+airplane);
			 if(airplane != null) {
				 
				 passenger  = SearchSeatName(airplane);
		
				 if(passenger != null && passenger.getName().equals(name)) {
					 PrintName(i,j,airplane,passenger);
				 } else {
					 System.out.println("예약된 날짜가 없습니다");
				 }
			 }
			 j++;
		 }
		 i++;
	 }
	 
}

public void PrintName(int month,int day, Airplane airplane,Passenger passenger) {
	System.out.println(passenger.getName()+"님의 예약 날짜는 "+month +" 월"+day+"일 입니다");
	airplane.seeAirplanePlan();
}


public Passenger SearchSeatName(Airplane airplane) {
	Passenger passenger = null;
	int i = 0;
	 while(i < airplane.getRow()) {
		 int j = 1;
		 while(j < airplane.getCol()) {
			 passenger = airplane.getPassenger(i, j);
			 if(passenger != null) {
					 return passenger;
				 }
			 j++;
			 }
		 i++;
	 }
	 return passenger;
}

	
	
	
	
}


