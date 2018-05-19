package fattar;

public class Alarm {
	private Time nextEatTime;		// 다음 식사 예정 시간
	private Time latestEatTime;		// 마지막으로 식사를 한 시간
	
	public void getEatTimeDB() {			// getEatTimeDB()를 통해 DB에 저장되어 있는 가장 최근의 식사 정보 가져온다.
		DBModule dbModule;
		dbModule.getEatenDBinfro()
	}
	public void setAlarmTime(Time time) {		// 유저가 식사한 시간 기준으로 6시간 이후를 식사 예상시간으로 설정
		time.hour += 6;
		this.nextEatTime = time;
	}	
	public void startAlarm() {			// JAVA Thred를 사용해 식사 예정 시간이 되었는지 판단하고, 예정 시간일 경우 소리를 출력
		while(1){
			if (current == nextEatTime){
				//alarm 울리기
				break;
			}
		}				
			
	}
	public void stopAlarm() {			//  유저가 알람을 끄면 실행되며, thread를 종료 시킨다.
		//Thread 종료
	}
}

public static void main(String[] args) {		//unit test 용 메인 함수
		
}
