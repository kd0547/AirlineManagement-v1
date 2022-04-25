package miniProject;


import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Scanner;

import kr.re.nsr.crypto.Hash;



public class Start {
	

	
	
	
	public static void main(String[] args) {
		/*
		 * *****발표 이후에 만들기***** 
		 * 항공 예약 순서 
		 *  1. 출발인원 + 출발지 설정,도착지 설정(왕복도 같은 개념 )
		 *  2. 
		 * 중요)	클래스 다이어그램으로 클래스 관계 다시 설정하기 
		 * 1.    출발 공항과 도착 공항을 정하는 코드 만들기
		 * 1-1 
		 * 2.    유저 로그인, 회원가입 만들기 User.class, login.class 
		 * 3.    관리자 기능을 추가하고 관리자가 항공편 추가하는 기능 admin.class 
		 * 4.    
		 * 5.    
		 * 
		 * 
		 */
		// zkwlrtm1935 ->  3384
		// zkwlrtm193s5 -> [B@5305068a
		
		LoginConnector loginConnector = new LoginConnector();
		
		Connection connection = loginConnector.createConnection();
		if(connection != null) {
			System.out.println("연결 성공");
		}
		
		String TEST="zkwlrtm193s51";
		String hashtestString="dlrjtdmsqlalfdkagh12345";
		byte[] testbyte = TEST.getBytes(StandardCharsets.UTF_8);
		byte[] hashbyte=hashtestString.getBytes(StandardCharsets.UTF_8);
		
		
 		Hash lsh = Hash.getInstance(Hash.Algorithm.LSH512_512);
		
		lsh.update(testbyte);
		lsh.update(hashbyte);
		
		byte[] hash = lsh.doFinal();
	
		char [] test = new char[256];
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	
		
		
		int breakNum = 99;
		Scanner scan = new Scanner(System.in);
		FlightManagement flightmanagement = new FlightManagement();
		Airplane airplane;
		
		//비행편 생성
		airplane = flightmanagement.newAirplane("부산", "서울", "11:40","12:00");
		flightmanagement.setNewAirplaneFlightSchedule(airplane,4,7);
		airplane = flightmanagement.newAirplane("서울", "부산", "14:40","17:10");
		flightmanagement.setNewAirplaneFlightSchedule(airplane,4,12);
		
		
		
		
		
		// breakNum == 0이면 중단
		while(breakNum != 0) {
			// 1번은 조회 2번은 예약 0번은 종료 
			System.out.println("1. 조회    2. 예약                          0. 종료");
			breakNum= scan.nextInt();
			if(breakNum == 1) {
				System.out.print("조회하실 영문 이름을 적어주세요");
				String name = flightmanagement.setEqualName();
				flightmanagement.SearchDayName(name);
				
				breakNum = 99;
			} else if(breakNum == 2) {
				while(breakNum != 0) {
					System.out.println("1. 편도 2. 왕복                   0. 종료");
					breakNum= scan.nextInt();
					//1 편도 2 왕복
					if(breakNum == 1) {
						//날짜 출력
						System.out.println("출발일을 정해주세요");
						System.out.print("출발 년도 >");
						int year = scan.nextInt();
						System.out.print("출발 월 >");
						int month = scan.nextInt();
						
						flightmanagement.flightCalendar.printCalendar(year, month);
						System.out.println();
						System.out.print("출발 일 >");
						int day = scan.nextInt();
						
						
						//입력 값이 현재년,월,일보다 크고 비행편이 있으면 종료
						while(flightmanagement.flightCalendar.srcDesDesSrcCheck(year, month, day) || flightmanagement.isEmptFlightplan(month,day)) {
							if(flightmanagement.flightCalendar.srcDesDesSrcCheck(year, month, day)) {
								System.out.print("지난 년,월,일은 입력하실 수 없습니다. ");
								System.out.println();
								System.out.print("출발일을 정해주세요");
								System.out.println();
								System.out.print("출발 년도 >");
								year = scan.nextInt();
								System.out.print("출발 월 >");
								month = scan.nextInt();
								flightmanagement.flightCalendar.printCalendar(year, month);
								System.out.println();
								System.out.print("출발 일 >");
								day = scan.nextInt();
							} else if(flightmanagement.isEmptFlightplan(month,day)) {
								System.out.print("해당 일에 비행편이 없습니다. 다른 일을 선택해주세요");
								System.out.println();
								System.out.print("출발 년도 >");
								year = scan.nextInt();
								System.out.print("출발 월 >");
								month = scan.nextInt();
								
								flightmanagement.flightCalendar.printCalendar(year, month);
								System.out.println();
								System.out.print("출발 일 >");
								day = scan.nextInt();
							}
						}
					
						//해당 일에 비행기가 있는지 검색하는 코드
						System.out.println();
						System.out.println("가는 편" + month + "월 "+day +"일");
						flightmanagement.getFlightPlan(month, day);
						
						//인적사항 작성
						Passenger passenger =  flightmanagement.setUserInfo();
						
						//좌석 출력
						flightmanagement.getAirplaneFlightMonthDay(month,day);
						
						System.out.print("원하시는 자리를 선택해주세요 >");
						String seat = scan.next();
						//좌석 선택
						flightmanagement.addPassengerSeat(passenger,month,day,seat);
						flightmanagement.getAirplaneFlightMonthDay(month,day);
						
						
					} else if(breakNum == 2) {
						System.out.println("출발일을 정해주세요");
						System.out.print("출발 년도 >");
						int srcDesyear = scan.nextInt();
						System.out.print("출발 월 >");
						int srcDesmonth = scan.nextInt();
						
						flightmanagement.flightCalendar.printCalendar(srcDesyear, srcDesmonth);
						System.out.println();
						System.out.print("출발 일 >");
						int srcDesday = scan.nextInt();

					
						while(flightmanagement.flightCalendar.srcDesDesSrcCheck(srcDesyear, srcDesmonth, srcDesday) || flightmanagement.isEmptFlightplan(srcDesmonth,srcDesday)) {
							if(flightmanagement.flightCalendar.srcDesDesSrcCheck(srcDesyear, srcDesmonth, srcDesday)) {
								System.out.print("지난 년,월,일은 입력하실 수 없습니다. ");
								System.out.println();
								System.out.print("출발일을 정해주세요");
								System.out.println();
								System.out.print("출발 년도 >");
								srcDesyear = scan.nextInt();
								System.out.print("출발 월 >");
								srcDesmonth = scan.nextInt();
								flightmanagement.flightCalendar.printCalendar(srcDesyear, srcDesmonth);
								System.out.println();
								System.out.print("출발 일 >");
								srcDesday = scan.nextInt();
							} else if(flightmanagement.isEmptFlightplan(srcDesmonth,srcDesday)) {
								System.out.print("해당 일에 비행편이 없습니다. 다른 일을 선택해주세요");
								System.out.println();
								System.out.print("출발 년도 >");
								srcDesyear = scan.nextInt();
								System.out.print("출발 월 >");
								srcDesmonth = scan.nextInt();
								
								flightmanagement.flightCalendar.printCalendar(srcDesyear, srcDesmonth);
								System.out.println();
								System.out.print("출발 일 >");
								srcDesday = scan.nextInt();
							}
						}
						
						System.out.println();
						System.out.println("귀국일을 정해주세요");
						System.out.print("복귀 년도 >");
						int desSrcyear = scan.nextInt();
						System.out.print("복귀 월 >");
						int desSrcmonth = scan.nextInt();
						
						flightmanagement.flightCalendar.printCalendar(desSrcyear, desSrcmonth);
						System.out.println();
						System.out.print("복귀 일 >");
						int desSrcday = scan.nextInt();
						
						
						while(flightmanagement.flightCalendar.srcDesDesSrcCheck(desSrcyear, desSrcmonth, desSrcday) || flightmanagement.isEmptFlightplan(desSrcmonth,desSrcday) || flightmanagement.flightCalendar.srcDesDesSrcCheck(srcDesyear,srcDesmonth,srcDesday,desSrcyear,desSrcmonth,desSrcday)) {
							if(flightmanagement.flightCalendar.srcDesDesSrcCheck(srcDesyear,srcDesmonth,srcDesday,desSrcyear,desSrcmonth,desSrcday)) {
								System.out.print("출국일보다 앞에 있는 일은 선택하실 수 없습니다. ");
								System.out.println();
								System.out.print("귀국일을 정해주세요");
								System.out.println();
								System.out.print("귀국 년도 >");
								desSrcyear = scan.nextInt();
								System.out.print("귀국 월 >");
								desSrcmonth = scan.nextInt();
								flightmanagement.flightCalendar.printCalendar(desSrcyear, desSrcmonth);
								System.out.println();
								System.out.print("귀국 일 >");
								desSrcday = scan.nextInt();
							} else if(flightmanagement.flightCalendar.srcDesDesSrcCheck(desSrcyear, desSrcmonth, desSrcday )) {
								System.out.println();
								System.out.print("지난 년,월,일은 입력하실 수 없습니다. ");
								System.out.println();
								System.out.print("귀국일을 정해주세요");
								System.out.println();
								System.out.print("귀국 년도 >");
								desSrcyear = scan.nextInt();
								System.out.print("귀국 월 >");
								desSrcmonth = scan.nextInt();
								flightmanagement.flightCalendar.printCalendar(desSrcyear, desSrcmonth);
								System.out.println();
								System.out.print("귀국 일 >");
								desSrcday = scan.nextInt();
							} else if(flightmanagement.isEmptFlightplan(desSrcmonth,desSrcday)) {
								System.out.print("해당 일에 비행편이 없습니다. 다른 일을 선택해주세요");
								System.out.println();
								System.out.print("귀국 년도 >");
								desSrcyear = scan.nextInt();
								System.out.print("귀국 월 >");
								desSrcmonth = scan.nextInt();
								
								flightmanagement.flightCalendar.printCalendar(desSrcyear, desSrcmonth);
								System.out.println();
								System.out.print("귀국일 >");
								desSrcday = scan.nextInt();
							}
						}
						
						
						
			
						System.out.println("가는 편" + srcDesmonth + "월 "+srcDesday +"일");
						flightmanagement.getFlightPlan(srcDesmonth, srcDesday);
						System.out.println();
						System.out.println("오는 편"+ desSrcmonth + "월 "+desSrcday +"일");
						flightmanagement.getFlightPlan(desSrcmonth, desSrcday);
						
						//인적사항 작성
						Passenger passenger =  flightmanagement.setUserInfo();
						System.out.println();
						
						
						System.out.println("가는 편 좌석 선택");
						//좌석 출력
						flightmanagement.getAirplaneFlightMonthDay(srcDesmonth,srcDesday);
						
						System.out.print("원하시는 자리를 선택해주세요 >");
						String seat = scan.next();
						//좌석 선택
						flightmanagement.addPassengerSeat(passenger,srcDesmonth,srcDesday,seat);
						
						
						System.out.println("오는 편 좌석 선택");
						//좌석 출력
						flightmanagement.getAirplaneFlightMonthDay(desSrcmonth,desSrcday);
						
						System.out.print("원하시는 자리를 선택해주세요 >");
						seat = scan.next();
						//좌석 선택
						System.out.println();
						flightmanagement.addPassengerSeat(passenger,desSrcmonth,desSrcday,seat);
						System.out.println("가는 편 좌석 ");
						System.out.println();
						
						flightmanagement.getAirplaneFlightMonthDay(srcDesmonth,srcDesday);
						System.out.println();
						System.out.println("오는 편 좌석 ");
						flightmanagement.getAirplaneFlightMonthDay(desSrcmonth,desSrcday);
						System.out.println();
					}
				}
				breakNum = 99;
				
			} else if(breakNum == 3) {
				
			}
			
			
		}
		
		
		
	}
	
	public void checkinStart(FlightManagement flightManagement) {
		
	}*/
	}
}






