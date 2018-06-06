
public class Controller {
	
	User myUser = new User();
	LoginModule myLoginModule = new LoginModule();
	DBModule myDBModule = new DBModule();
	Alarm myAlarm = new Alarm();
	Graph myGraph = new Graph();
	Setting mySetting = new Setting();
	
	public Controller() {
		
	}
	
	public void login() { 			// 로그인
		Scanner scn = new Scanner(System.in);
		boolean resultOfLogin = false;		// 로그인 성공 여부 
		do{					// 로그인 성공할때까지 사용자의 입력을 받는다. 
			System.out.print("ID:") 		// 현재는 UI 고려하지 않음
			String strId = scn.next();
		
			System.out.print("PW:") 
			String strPw = scn.next();
		
			resultOfLogin = myLoginModule.compareIdPassword(strId,strPw);
		}
		while(resultOfLogin == false);
	}
	
	public void register() {		// 회원가입 
		myLoginModule.registerUser();

	}
		
	public void setting() {			// 프로그램 환경 설정
	

	}
	
	public void alarm() {			// 알람 control
		
		if(){	//UI에서 알람 종류 눌리면	
			myAlarm.stopAlarm();
		}

	}
	
	public void showGraph() {
		myGraph.showUserWeeklyTotalNutrient();	//user의 일주일 영양상태를 그래프로 출력
		mygraph.showUserPractice();		//user의 운동상태를 그래프로 출력
	}
}
