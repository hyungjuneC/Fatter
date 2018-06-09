package application;

public class LoginModel {
	
	User user = new User();
	public LoginModel() {
	      // TODO Auto-generated constructor stub
	   }
	   
	   // Sign in 
	   public boolean compareIDPassword(String strId,String strPw) {
	      
	      DBModule myDBModule = new DBModule();
	      if(myDBModule.search(strId)) {
	    	   myDBModule.getUserDBInfo(strId,user);
	    	   myDBModule.setUserDBInfoRecent(user.getId(), user.getPW(), user.getSex(), user.getHeight(), user.getWeight(), user.getAge(),user.getFirstWeight());
	    	   return strPw.equals(user.getPW());
	      }
	      else {
	    	  return false;
	      }
	   
	   }
	   public static void main(String[] args) {//unit test 
		     LoginModel login = new LoginModel();
		     //login.registreUser("1234", "1", "female", 12, 31, 12);
		     //System.out.println(login.compareIDPassword("1234", "1"));
	   }
}
