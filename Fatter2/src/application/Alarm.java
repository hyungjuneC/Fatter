package application;

public class Alarm {
	private Time eatentm ;
	private boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public  void setAlarmTime() {
		if (flag==false) {
			eatentm = new Time();
			flag = true;
		}
		if(eatentm.getflag()==false) {
		eatentm = new Time();
		eatentm.start();
		
		
		}
		else {
			eatentm.getEatenTime();
			
		}
		
		
		
	}
	public void getEatenTimeDB() {
		eatentm.getEatenTime();
	}

}
