package application;

public class RegisterModel {
	// Sign up 
	 public boolean registerUser(String strId,String strPw,String confirmPw, String sex, String height, String weight, String age) {
	      DBModule myDBModule = new DBModule();
	      if(!strPw.equals(confirmPw)) {
	    	  return false;
	      }
	      else if(myDBModule.search(strId)) {
	    	  return false;
	      }
	      else if(sex!="male"&&sex!="female") {
	    	  return false;
	      }
	      else if(!(isStringFloat(height) && isStringFloat(weight) && isStringInt(age))) {
	    	  return false;
	      }
	      else {
	    	  myDBModule.setUserDBInfoFirst(strId, strPw, sex, Float.parseFloat(height), Float.parseFloat(weight), Integer.parseInt(age));
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

}
