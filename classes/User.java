public class User {
	private String u_id;
	private String password;
	private String sex;
	private double height;
	private double weight;
	private double firstWeight;
	private int age;
	private double BMR;
	/*
	public void getUserInfo() {	// dbModule을 사용하는 getter 함수
		LoginModule loginModule;
		DBModule dbModule;

		if (loginModule.compareIDPassword()) {	// 입력 아이디와 비번이 DB와 일치시 
			dbModule.getUserDBInfo(this);
		}
	}*/
	
	public void setUserInfo(String u_id,String password,String Sex, double Height, double Weight, int Age) {	// 사용자의 입력을 받아 저장하는 setter 함수
		this.u_id = u_id;
		this.password = password;
		this.sex = Sex;
		this.height = Height;
		this.weight = Weight;
		this.age = Age;
	}
	
	public String getId() {
		return this.u_id;
	}
	public String getPW() {
		return this.password;
	}
	public double getHeight() {
		return this.height;
	}
	public double getWeight() {
		return this.weight;
	}
	public double getFirstWeight() {
		return this.firstWeight;
	}
	public double getBMR(){
		return this.BMR;
	}
}
