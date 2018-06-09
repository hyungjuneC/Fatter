package application;

public class User {
	private String u_id;
	private String password;
	private String sex;
	private float height;
	private float weight;
	private float firstWeight;
	private int age;
	private float BMR;
	/*
	public void getUserInfo() {	// dbModule을 사용하는 getter 함수
		LoginModule loginModule;
		DBModule dbModule;
		if (loginModule.compareIDPassword()) {	// 입력 아이디와 비번이 DB와 일치시 
			dbModule.getUserDBInfo(this);
		}
	}*/
	
	public void setUserInfoFirst(String u_id,String password,String Sex, float Height, float Weight, int Age,float firstWeight) {	// 사용자의 입력을 받아 저장하는 setter 함수
		this.u_id = u_id;
		this.password = password;
		this.sex = Sex;
		this.height = Height;
		this.weight = Weight;
		this.age = Age;
		this.firstWeight=firstWeight;
	}
	public void setUserInfo(String u_id,String password,String Sex, float Height, float Weight, int Age) {	// 사용자의 입력을 받아 저장하는 setter 함수
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
	public float getHeight() {
		return this.height;
	}
	public float getWeight() {
		return this.weight;
	}
	public float getFirstWeight() {
		return this.firstWeight;
	}
	public String getSex() {
		return this.sex;
	}
	public int getAge() {
		return this.age;
	}
	public float getBMR(){
		return this.BMR;
	}
}