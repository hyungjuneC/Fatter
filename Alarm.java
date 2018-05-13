package fattar;

public class Alarm {
	private Time eatTime;
	
	public void getEatTimeDB() {			// getEatTimeDB()를 통해 DB에 저장되어 있는 가장 최근의 식사 정보 가져온다.
		DBModule dbModule;
		dbModule.getEatenDBinfro()
	}
	public void setAlarmTime(Time time) {	// 유저가 식사한 시간 기준으로 6시간 이후를 식사 예상시간으로 설정, 해당 시간을 Time 형식으로 반환
		this.eatTime = time;
	}	
	public void startAlarm() {				// JAVA Thred를 사용해 식사 예상 시간이 되었는지 판단하고, 소리를 출력
		
	}
	public void stopAlarm() {				//  유저가 알람을 끄면 실행되며, thread를 종료 시킨다.
		
	}
}
