
public class LoginModule {
   
   private String inputID;         
   private String inputPassword;      
   private Boolean inputSex;      
   private double inputHeight;      
   private double inputWeight;      
   private double inputAge;      
   
   // Constructor
   public LoginModule() {
      // TODO Auto-generated constructor stub
   }
   
   // Sign up 
   public void registreUser(String strId,String strPw,String sex, float height, float weight, int age) {
      DBModule myDBModule = new DBModule();
      myDBModule.setUserDBInfo(strId,strPw,sex,height,weight,age);
   }
   
   // Sign in 
   public boolean compareIDPassword(String strId,String strPw) {
      User user = new User();
      
      DBModule myDBModule = new DBModule();
      if(myDBModule.search(strId)) {
    	   myDBModule.getUserDBInfo(strId,user);
    	   return strPw.equals(user.getPW());
      }
      else {
    	  return false;
      }
   
   }
   public static void main(String[] args) {//unit test 
	     LoginModule login = new LoginModule();
	     //login.registreUser("1234", "1", "female", 12, 31, 12);
	     System.out.println(login.compareIDPassword("1234", "1"));
	 }
}
