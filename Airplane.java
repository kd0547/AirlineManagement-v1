package miniProject;

public class Airplane {
	//비행 계획
	private Flightplan flightplan = new Flightplan();
	
	//승객 좌석
	//----------------------------------------------------------
	private final int row = 4;
	private final int col = 16;
	private char rowChar = 'A';
	private Passenger[][] seat = new Passenger[row][col];
	
	//----------------------------------------------------------
	
	public void setFlightplan(String to,String from,String srcTime,String desTime ) {
		this.flightplan.to  =  to;
		this.flightplan.from =  from;
		this.flightplan.srcTime = srcTime;
		this.flightplan.desTime = desTime;
	}
	
	
	
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	//비행 정보가 저장된 변수를 반환
	public Flightplan getAirplanePlan() {
		return flightplan;
	}
	public void seeAirplanePlan() {
		System.out.println("출발지 > 도착지,	출발시간 > 도착시간");
		System.out.println("   "+this.flightplan.from+"  >  "+this.flightplan.to +"            "+ this.flightplan.srcTime+" > "+this.flightplan.desTime );
		System.out.println();
	}
	
	public Passenger getPassenger(int row, int col) {
		return seat [row][col];
	}
	//자리 출력
	public void SeeSeat() {
		System.out.print("");
		System.out.println("	1"+"	2"+"	3"+"	4"+"	5"
		+"	6"+"	7"+"	8"+"	9"+"	10"+"	11"+"	12"+"	13"+"	14"+"	15");
		for(int i = 0;i <seat.length; i++) {
			System.out.print((rowChar++)+"	");
			for(int j = 1; j < seat[i].length; j++) {
				if(!isEmpty(i,j)) {
					System.out.print("■	");
				}
				else {
					System.out.print("□	");
				}
					
			}
			System.out.println("");
		}
		rowChar ='A';
	
	}
		
		//빈자리 검사
		public boolean isEmpty(int row,int col) {
			if(this.seat[row][col] == null) {
				return true;
			} else {
				return false;
			}
		}
		
		public void addPassengerSeat(Passenger passenger,int row, int col) {
				this.seat[row][col]  = passenger;
		}
		
}
