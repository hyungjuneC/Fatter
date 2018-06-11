package application;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.lang.Integer;
import java.lang.Float;
//import java.io.serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;



public class DBModule {

   DBModule(){//constructor
      try{
            FileInputStream Input = new FileInputStream("FoodDB.db");

               int i = 0;
                   
               
               if(Input.read()==-1) {
                  System.out.println("Not crawled yet!");
                  Crawling crawl = new Crawling(); //크롤링 모듈 선언
                  crawl.Crawling();
                             
               }
               else {
            	   /*
                  while((i = Input.read()) != -1) {
                     System.out.write(i);
                  }*/
               }
       } catch (IOException e) {
    	   System.out.println("Not crawled yet!");
           Crawling crawl = new Crawling(); //크롤링 모듈 선언
           crawl.Crawling();
       } finally {
          /*
          try{
              Input.close();
           } catch(IOException io) {}
           */
          
       }
   }
   
   public String searchName() {

	   try {

	         File input = new File("RecentUser.db");

	         FileReader filereader = new FileReader(input);

	         BufferedReader bufReader = new BufferedReader(filereader);

	         

	         String line="";

	         String split[];

	         

	         line = bufReader.readLine();

	         split = line.split(":");

	         

	         String DB_id=split[0];

	        

	         bufReader.close();

	         return DB_id;

	        

	         

	      }catch(FileNotFoundException e) {

	    	  return "";

	    	 

	      }catch(IOException e) {

	         System.out.println(e);

	         return "";

	        

	      }

	   

   }
   
   public float[] calculation(User user) {

	   float maxKcal=0, maxFat=0, maxProtein=0, maxCarbo=0;

	   float sumKcal=0,sumFat=0,sumProtein=0,sumCarbo=0;

	   float percentageOfKcal =0, percentageOfFat =0, percentageOfProtein =0, percentageOfCarbo =0;

	  
	   if(user.getSex().equals("male")) { 

		   maxKcal = (float) (1200 + 66.47 + user.getWeight()*13.75 +user.getHeight()*5 - user.getAge()*6.76) ; 

		   if (user.getAge() <20){

			   maxFat = 60;

			   maxProtein = 50;

			   maxCarbo = 1500;

		   }

		   else if(user.getAge() <30){

			   maxFat = 60;

			   maxProtein = 45;

			   maxCarbo = 1300;

		   }

		   else if(user.getAge() <50){

			   maxFat = 50;

			   maxProtein = 40;

			   maxCarbo = 1100;

		   }

		   else {

			   maxFat = 45;

			   maxProtein = 35;

			   maxCarbo = 900;

		   }

		 

	   }

	   else if(user.getSex().equals("female")) {

		   maxKcal = (float) (900 + 66.47 + user.getWeight()*13.75 +user.getHeight()*5 - user.getAge()*6.76) ;

		   if (user.getAge() <20){

			   maxFat = 55;

			   maxProtein = 40;

			   maxCarbo = 1000;

		   }

		   else if(user.getAge() <30){

			   maxFat = 50;

			   maxProtein = 35;

			   maxCarbo = 900;

		   }

		   else if(user.getAge() <50){

			   maxFat = 45;

			   maxProtein = 30;

			   maxCarbo = 800;

		   }

		   else {

			   maxFat = 40;

			   maxProtein = 20;

			   maxCarbo = 700;

		   }

	   }

	   

	   DBModule myDBModule = new DBModule();

	   String id = myDBModule.searchName();

	   ArrayList<FoodInfo> foodListOfUser = searchFoodByUser();

	   float[] percentageOfNut = new float[4];

	  

	   for(int i=0;i<foodListOfUser.size();i++) {

		   sumCarbo += Float.parseFloat(foodListOfUser.get(i).getKcal());

		   sumFat += Float.parseFloat(foodListOfUser.get(i).getFat());

		   sumProtein += Float.parseFloat(foodListOfUser.get(i).getProtein());

		   sumKcal += Float.parseFloat(foodListOfUser.get(i).getCatbo());
		   System.out.println(sumCarbo);

	   }

	   
	  
	   System.out.println("maxKcal"+maxKcal);
	   System.out.println("maxFat"+maxFat);
	   System.out.println("maxProtein"+maxProtein);
	   System.out.println("maxCarbo"+maxCarbo);
	   System.out.println();
	   System.out.println("sumKcal"+sumKcal);
	   System.out.println("sumFat"+sumFat);
	   System.out.println("sumProtein"+sumProtein);
	   System.out.println("sumCarbo"+sumCarbo);
	   
	   percentageOfKcal = sumKcal/maxKcal;

	   percentageOfFat = sumFat/maxFat;

	   percentageOfProtein = sumProtein/maxProtein;

	   percentageOfCarbo = sumCarbo/maxCarbo;	   

	   

	   percentageOfNut[0]=percentageOfKcal;

	   percentageOfNut[1]=percentageOfFat;

	   percentageOfNut[2]=percentageOfProtein;

	   percentageOfNut[3]=percentageOfCarbo;

	   

	   return percentageOfNut;

   }
   
   public ArrayList searchFoodByUser() {

		  DBModule myDBModule = new DBModule();

		  String id = myDBModule.searchName();

		  ArrayList<FoodInfo> foodListOfUser = new ArrayList();

		  

		  try {

		         File input = new File("UserFoodInfo_"+id+".db");

		         FileReader filereader = new FileReader(input);

		         BufferedReader bufReader = new BufferedReader(filereader);

		         

		         String line="";

		         String split[];

		         String date;

		         String name;

		         String kcal;

		         String fat;

		         String carbo;

		         String protein;

		         

	     

		         while((line = bufReader.readLine()) !=null) {

		        	FoodInfo food = new FoodInfo();

		        	

		            split = line.split(":");

		            name= split[0];

		            carbo = split[1]; 

		            kcal = split[2]; 

		            fat = split[3]; 

		            protein = split[4]; 
		            
		            date = split[5];

		            

		            food.setFoodName(name);

		            food.setCatbo(carbo);

		            food.setFat(fat);

		            food.setKcal(kcal);

		            food.setProtein(protein);

		            food.setDate(date);

		            foodListOfUser.add(food);

		     

		         }

		         bufReader.close();

		         return foodListOfUser;

		        

		      }catch(FileNotFoundException e) {

		    	  return foodListOfUser ;

		    	 

		      }catch(IOException e) {

		         System.out.println(e);

		         return foodListOfUser ;

		        

		      }

	   }
   	public ArrayList<FoodInfo> deleteFoodDB(int index) {

	   ArrayList<FoodInfo> newFoodList =new ArrayList();

	   ArrayList<FoodInfo> foodList = searchFoodByUser();

	   foodList.remove(index);
	   
	   return foodList;

   }
 

 

 

   public void setEatenFoodByUser(String strId,FoodInfo food) {

	      try {

	         File output = new File("UserFoodInfo_"+strId+".db");

	         FileWriter fw = new FileWriter(output,true);


	         fw.write(String.format("%s",food.getFoodName()));

	         fw.write(String.format(":"));
	         
	      
	         fw.write(String.format("%s",food.getKcal()));

	         fw.write(String.format(":"));
	        
	         fw.write(String.format("%s",food.getCatbo()));
	         
	         fw.write(String.format(":"));

	         fw.write(String.format("%s",food.getFat()));

	         fw.write(String.format(":"));

	         fw.write(String.format("%s",food.getProtein()));     
	         
	         fw.write(String.format(":"));
	         
	         fw.write(String.format("%s",food.getDate()));

	         
	         
	        

	        
	       

	         

	         fw.flush();

	         fw.write(LINE_SEPARATOR);

	         System.out.println("DONE");

	         fw.close();

	      }catch(FileNotFoundException e) {

	         

	      }catch(IOException e) {

	         System.out.println(e);

	      }

	      

   }

   
   public ArrayList<FoodInfo> getFoodDB() {

	   ArrayList<FoodInfo> foodnames = new ArrayList<>();

	  

	   

	   try {

	         File input = new File("FoodDB.db");

	         FileReader filereader = new FileReader(input);

	         BufferedReader bufReader = new BufferedReader(filereader);

	         String line="";

	         String split[];

	      

	         while((line = bufReader.readLine()) !=null) {

	        	 FoodInfo myFoodInfo = new FoodInfo();

	        	 

	             split = line.split(":");

	             myFoodInfo.setFoodName(split[0]);      

	             myFoodInfo.setKcal(split[1]);

	             myFoodInfo.setCatbo(split[2]);

	             myFoodInfo.setProtein(split[4]);

	             myFoodInfo.setFat(split[3]);

	                      

	             foodnames.add(myFoodInfo);

	         }

	       	        

	         bufReader.close();

	         return foodnames;

	      }catch(FileNotFoundException e) {

	    	  System.out.println(e);

	    	  return foodnames;

	      }catch(IOException e) {

	         System.out.println(e);

	         return foodnames;

	      }

   }
   
   public void changeUserDBInfo(String ageN, String heightN, String weightN) {

	   try {

		   	 DBModule myDBModule = new DBModule();

	         File input = new File("RecentUser.db");

	         FileReader filereader = new FileReader(input);

	         BufferedReader bufReader = new BufferedReader(filereader);
	         

	         String line = bufReader.readLine();

	         String[] split = line.split(":");

	         String u_id = split[0];
	         
    
	         ArrayList<User> userList = new ArrayList<User>();
	         File input2 = new File("UserDB.db");

	         FileReader filereader2 = new FileReader(input2);
	         BufferedReader bufReader2 = new BufferedReader(filereader2);
	         
	         while((line = bufReader2.readLine()) !=null) {
	           	 User user = new User();
	        	 split = line.split(":");

	        	 String id = split[0];
	        	 System.out.println(id);
	        	 String pw = split[1];
	        	 String sex = split[2];	  
	             float height = Float.parseFloat(split[3]);
	             float weight = Float.parseFloat(split[4]);
	             int age = Integer.parseInt(split[5]);
	             float firstWeight = Float.parseFloat(split[6]);
	             if (id.equals(u_id)) {
	            	 height = Float.parseFloat(heightN);
	            	 weight = Float.parseFloat(weightN);
	            	 age = Integer.parseInt(ageN);
	             }
	             
	             user.setUserInfoFirst(id,pw,sex,height,weight,age,firstWeight);
	             userList.add(user);	             
	         }
	         filereader.close();
	         FileWriter fw = new FileWriter(input2);
	         
	         for(int i=0;i<userList.size();i++) {
	                fw.write(String.format("%s",userList.get(i).getId()));

	                fw.write(String.format(":"));

	                fw.write(String.format("%s",userList.get(i).getPW()));

	                fw.write(String.format(":"));

	                fw.write(String.format("%s",userList.get(i).getSex()));

	                fw.write(String.format(":"));

	                fw.write(String.format("%f",userList.get(i).getHeight()));  //       

	                fw.write(String.format(":"));

	                fw.write(String.format("%f",userList.get(i).getWeight()));	//

	                fw.write(String.format(":"));

	                fw.write(String.format("%d",userList.get(i).getAge()));		//

	                fw.write(String.format(":"));

	                fw.write(String.format("%f",userList.get(i).getFirstWeight()));

	                fw.flush();

	                fw.write(LINE_SEPARATOR);

	         }
             System.out.println("DONE");

	         fw.close();
             // filereader.close();

	      }catch(FileNotFoundException e) {

	         

	      }catch(IOException e) {

	         System.out.println(e);

	      }

   }
   
   
   private static final String LINE_SEPARATOR = System
               .getProperty("line.separator");

   
   public void setUserDBInfo(String strId, String strPw,String sex, float height, float weight, int age) {
      try {
         File output = new File("UserDB.db");
         FileWriter fw = new FileWriter(output,true);
        
         fw.write(String.format("%s",strId));
         fw.write(String.format(":"));
         fw.write(String.format("%s",strPw));
         fw.write(String.format(":"));
         fw.write(String.format("%s",sex));
         fw.write(String.format(":"));
         fw.write(String.format("%f",height));         
         fw.write(String.format(":"));
         fw.write(String.format("%f",weight));
         fw.write(String.format(":"));
         fw.write(String.format("%d",age));
         fw.flush();
         fw.write(LINE_SEPARATOR);
         System.out.println("DONE");
         fw.close();
      }catch(FileNotFoundException e) {
         
      }catch(IOException e) {
         System.out.println(e);
      }
      
   }//유저 클래스안에서 setUserInfo 함수 안에서 실행될 함수로 파라미터로  회원가입 시 입력된 정보가 저장된 User 클래스를 받아 그정보를 DB에 기록한다.
   public void setUserDBInfoFirst(String strId, String strPw,String sex, float height, float weight, int age) {
	      try {
	         File output = new File("UserDB.db");
	         FileWriter fw = new FileWriter(output,true);
	        
	         fw.write(String.format("%s",strId));
	         fw.write(String.format(":"));
	         fw.write(String.format("%s",strPw));
	         fw.write(String.format(":"));
	         fw.write(String.format("%s",sex));
	         fw.write(String.format(":"));
	         fw.write(String.format("%f",height));         
	         fw.write(String.format(":"));
	         fw.write(String.format("%f",weight));
	         fw.write(String.format(":"));
	         fw.write(String.format("%d",age));
	         fw.write(String.format(":"));
	         fw.write(String.format("%f",weight));
	         fw.flush();
	         fw.write(LINE_SEPARATOR);
	         System.out.println("DONE");
	         fw.close();
	      }catch(FileNotFoundException e) {
	         
	      }catch(IOException e) {
	         System.out.println(e);
	      }
	      
	   }
   public void setUserDBInfoRecent(String strId, String strPw,String sex, float height, float weight, int age,float firstweight) {
	      try {
	    	 String filename = "RecentUser.db";
	         File output = new File(filename);
	         FileWriter fw = new FileWriter(output);
	        
	         fw.write(String.format("%s",strId));
	         fw.write(String.format(":"));
	         fw.write(String.format("%s",strPw));
	         fw.write(String.format(":"));
	         fw.write(String.format("%s",sex));
	         fw.write(String.format(":"));
	         fw.write(String.format("%f",height));         
	         fw.write(String.format(":"));
	         fw.write(String.format("%f",weight));
	         fw.write(String.format(":"));
	         fw.write(String.format("%d",age));
	         fw.write(String.format(":"));
	         fw.write(String.format("%f",firstweight));
	         fw.flush();
	         fw.write(LINE_SEPARATOR);
	         System.out.println("DONE");
	         fw.close();
	      }catch(FileNotFoundException e) {
	         
	      }catch(IOException e) {
	         System.out.println(e);
	      }
	      
	   }
   public void getUserDBInfo(String u_id,User user) {
      try {
         File input = new File("UserDB.db");
         FileReader filereader = new FileReader(input);
         BufferedReader bufReader = new BufferedReader(filereader);
      
         String line="";
         String split[];
         String DB_id="";
         String DB_pw="";
         while((line = bufReader.readLine()) !=null) {
            
            split = line.split(":");
            DB_id = split[0];
            DB_pw = split[1]; 
            if(u_id.equals(DB_id)) {
               String sex = split[2];
               
               float height = Float.parseFloat(split[3]);
               float weight = Float.parseFloat(split[4]);
               int age = Integer.parseInt(split[5]);
               float firstWeight = Float.parseFloat(split[6]);
      
               user.setUserInfoFirst(DB_id,DB_pw,sex, height, weight, age,firstWeight);
               break;
            }
         }
         bufReader.close();
      }catch(FileNotFoundException e) {
         
      }catch(IOException e) {
         System.out.println(e);
      }
   
   }
   public void getRecentUserDBInfo(User user) {
	      try {
	         File input = new File("RecentUser.db");
	         FileReader filereader = new FileReader(input);
	         BufferedReader bufReader = new BufferedReader(filereader);
	      
	         String line="";
	         String split[];
	         String DB_id="";
	         String DB_pw="";
	        
	            line = bufReader.readLine();
	            split = line.split(":");
	            DB_id = split[0];
	            DB_pw = split[1]; 
	           
	               String sex = split[2];
	               
	               float height = Float.parseFloat(split[3]);
	               float weight = Float.parseFloat(split[4]);
	               int age = Integer.parseInt(split[5]);
	               float firstWeight = Float.parseFloat(split[6]);
	      
	               user.setUserInfoFirst(DB_id,DB_pw,sex, height, weight, age,firstWeight);
	               
	            
	         
	         bufReader.close();
	      }catch(FileNotFoundException e) {
	         
	      }catch(IOException e) {
	         System.out.println(e);
	      }
	   
	   }
   public boolean search(String name) {
	   try {
	         File input = new File("UserDB.db");
	         FileReader filereader = new FileReader(input);
	         BufferedReader bufReader = new BufferedReader(filereader);
	      
	         String line="";
	         String split[];
	         String DB_id="";
	         
	         while((line = bufReader.readLine()) !=null) {
	            
	            split = line.split(":");
	            DB_id = split[0];
	            
	            if(name.equals(DB_id)) {
	              return true;	    
	            }
	         }
	         bufReader.close();
	         return false;
	         
	      }catch(FileNotFoundException e) {
	    	  return false;
	         
	      }catch(IOException e) {
	         System.out.println(e);
	         return false;
	      }
	   
	   
   }// 이름과 일치하는 정보를 가진 항목이 DB안에 있는 지 검사하고 그 위치를 전달
   
}