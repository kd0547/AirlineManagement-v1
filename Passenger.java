package miniProject;

public class Passenger {
	private String name; // 이름
	private String nation; //국적
	private String gender; //성별
	private String passportNo;// 여권 정보
	private int DoB;// 생년월일
	
	
	public void setPassenger (String name, String nation, String gender, String passportNo, int DoB) {
		this.name = name;
		this.nation = nation;
		this.gender = gender;
		this.passportNo = passportNo;
		this.DoB = DoB;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public String getpassportNo() {
		return passportNo;
	}
	
	public int getDate() {
		return DoB;
	}
	
	public String getNation() {
		return nation;
	}
	
	public String getGender() {
		return gender;
	}

	public int getDoB() {
		return DoB;
	}
}
