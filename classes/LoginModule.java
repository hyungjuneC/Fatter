
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
   public boolean registreUser(String strId,String strPw,String confirmPw, String sex, String height, String weight, String age) {
      DBModule myDBModule = new DBModule();
      if(!strPw.equals(confirmPw)) {
    	  return false;
      }
      else if(sex!="male"&&sex!="female") {
    	  return false;
      }
      else if(!(isStringFloat(height) && isStringFloat(weight) && isStringInt(age))) {
    	  return false;
      }
      else {
    	  myDBModule.setUserDBInfo(strId, strPw, sex, Float.parseFloat(height), Float.parseFloat(weight), Integer.parseInt(age));
    	  return true;
      }
    
   }

   public static boolean isStringFloat(String s) {
     try {
         Float.parseFloat(s);
         return true;
     } catch (NumberFormatException e) {
         return false;
     }
   }
   
   public static boolean isStringInt(String s) {
	     try {
	         Integer.parseInt(s);
	         return true;
	     } catch (NumberFormatException e) {
	         return false;
	     }
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
	     //login.registreUser("1234", "1","2", "female", "12", "31", "12");
	     //System.out.println(login.compareIDPassword("1234", "1"));
	 }
}
