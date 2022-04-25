package miniProject;


public  class FlightSchedule{
	// [] [] =  [month][day]
	//1일 1개 비행기가 비행 가능
	//추가 
	//수정 할 부분  Airplane[][][] 배열로 비행편을 추가시키거나 
	// 비행기의 출발 날짜로 정렬해 출력하는 방법도 있음 
	//아니면 LinkedLIst || ArrayList로 추가하는 방법도 있음
	private Airplane[][] flightplanAirplane = new Airplane[13][35];
	
	
	
	public Airplane  getFlightplan(int month,int day) {
		return this.flightplanAirplane[month][day];
	}
	
	//스케줄에 비행 정보를 저장
	public void setFilght(Airplane flightplan,int month,int day) {
		this.flightplanAirplane[month][day] = flightplan; 
	}

}
