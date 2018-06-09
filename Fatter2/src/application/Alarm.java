package application;

public class Alarm {
	private Time eatentm = new Time();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public  void setAlarmTime() {
		if(eatentm.getflag() ==false) {
		eatentm.start();
		}
		else {
			
		}
		
		
		
	}
	public void getEatenTimeDB() {
		eatentm.getEatenTime();
	}

}
