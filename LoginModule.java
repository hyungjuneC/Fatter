
public class LoginModule {
	
	private String inputID;			// 사용자가 입력한 ID
	private String inputPassword;		// 사용자가 입력한 비밀번호
	private Boolean inputSex;		// 사용자가 입력한 성별(true : 남성  / false : 여성)
	private double inputHeight;		// 사용자가 입력한 키
	private double inputWeight;		// 사용자가 입력한 몸무게
	private double inputAge;		// 사용자가 입력한 나이
	
	// Constructor
	public LoginModule() {
		// TODO Auto-generated constructor stub
	}
	
	// Sign up 
	public registreUser() {
		System.out.print("ID:") 		// 현재는 UI 고려하지 않음
		String strId = scn.next();
		
		System.out.print("PW:") 
		String strPw = scn.next();
		
		DBModule myDBModule = new DBModule();
		myDBModule.setUserDBInfo(strId,strPw);
	}
	
	// Sign in 하기전에 ID/Password 확인 
	public compareIDPassword(strId,strPw) {
		DBModule myDBModule = new DBModule();
		userDB = myDBModule.getUserDBInfo();	//userDB에 DB 내용 저장. 
		//UserDB에서 입력된 아이디를 찾아본다.
		//아이디와 비밀번호가 DB와 일치하는지 체크한다.
	}
}
