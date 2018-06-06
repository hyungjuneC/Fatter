package fattar;

public class User {
	private String u_id;
	private String password;
	private boolean sex;
	private double height;
	private double weight;
	private int age;
	private double BMR;
	
	public void getUserInfo() {	// dbModule을 사용하는 getter 함수
		LoginModule loginModule;
		DBModule dbModule;

		if (loginModule.compareIDPassword()) {	// 입력 아이디와 비번이 DB와 일치시 
			dbModule.getUserDBInfo(this);
		}
	}
	
	public void setUserInfo(boolean Sex, double Height, double Weight, int Age) {	// 사용자의 입력을 받아 저장하는 setter 함수
		this.sex = Sex;
		this.height = Height;
		this.weight = Weight;
		this.age = Age;
	}
	
	public double getBMR(){
		return this.BMR;
	}
}
