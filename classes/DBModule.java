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
import java.util.Date;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;



public class DBModule {
   //private FoodInfo eatenInfo;
   //private FoodInfo foodInfo;
   //private double[] actInfo;// 행동의 정보는 전부 수치이기 때문에 배열의 index각각이 행동의 정보를 저장
   //private String foodName;
   //private User user;
   //private String date;
   //private FatterMath math;


   DBModule(){//constructor
      try{
            FileInputStream Input = new FileInputStream("FoodDB.txt");

               int i = 0;
                   
               
               if(Input.read()==-1) {
                  System.out.println("Start Crawl!");
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
          System.out.println(e);
       } finally {
          /*
          try{
              Input.close();
           } catch(IOException io) {}
           */
          
       }
   }
   /*
   public static void main(String[] args) {//unit test 용 메인 함수
      User myuser = new User();
      DBModule myDB = new DBModule();
      //myDB.getUserDBInfo("aaa", myuser);
      //myDB.setUserDBInfo("hey", "hi");
   }*/
   private static final String LINE_SEPARATOR = System
               .getProperty("line.separator");

   
   public void setUserDBInfo(String strId, String strPw,String sex, float height, float weight, int age) {
      try {
         File output = new File("UserDB.txt");
         FileWriter fw = new FileWriter(output,true);
         //BufferedWriter bw = new BufferedWriter(fw);
        
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
         System.out.println("Register DONE");
         fw.close();
      }catch(FileNotFoundException e) {
         
      }catch(IOException e) {
         System.out.println(e);
      }
      
   }//유저 클래스안에서 setUserInfo 함수 안에서 실행될 함수로 파라미터로  회원가입 시 입력된 정보가 저장된 User 클래스를 받아 그정보를 DB에 기록한다.
   
   public void getUserDBInfo(String u_id,User user) {
      try {
         File input = new File("UserDB.txt");
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
               
               double height = Float.parseFloat(split[3]);
               double weight = Float.parseFloat(split[4]);
               int age = Integer.parseInt(split[5]);
      
               user.setUserInfo(DB_id,DB_pw,sex, height, weight, age);
               break;
            }
         }
         bufReader.close();
      }catch(FileNotFoundException e) {
         
      }catch(IOException e) {
         System.out.println(e);
      }
   
   }
   public boolean search(String name) {
	   try {
	         File input = new File("UserDB.txt");
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
   
   
   /*
   public void setFoodDBInfo() {
      FileOutputStream foodFile = new FileOutPutStream("foodDB");
      ObjectOutputStream d_stream = new ObjectOutputStream(foodFile);//데이터베이스 접속
      
      wrt.write();//정해진 형식에 따라 db에  입력
   }// 유저에게 입력받은 음식의 정보를 음식 db에 저장
   
   public void getFoodDBInfo(String foodName) {
      FileInputStream fred = new FileInputStream("foodDB");
      DBModule.search(foodname);//search 함수를 통해 음식이름와 일치하는 레코드 검색
      String arr = fred.read();//일치하는 음식 정보 가져옴
      arr.split(":");
      for(int i = 0; i< arr.length(); i++) {
      foodInfo.info = arr[i];// 맞는 정보를 순서대로 파싱하여 저장
      }
      fred.close();
   }
   public void setActDBInfo(double[] act) {
      FileOutputStream actFile = new FileOutPutStream("ActDB");
      //데이터베이스 접속
      
      wrt.write();//정해진 형식에 따라 db에  입력
   }// 유저에게 입력받은  운동의 정보를 운동 db에 저장
   
   public void getActDBInfo(String actName) {
      FileInputStream fred = new FileInputStream("ActDB");
      DBModule.search(actName);//search 함수를 통해 운동의 이름과 일치하는 레코드 검색
      String arr = fred.read();//일치하는 운동 정보 가져옴
      arr.split(":");
      for(int i = 0; i< arr.length(); i++) {
      actInfo.info = (double)arr[i];// 맞는 정보를 순서대로 파싱하여 저장
      }
      fred.close();
   }
   
   public void setEatenDBInfo() {
      FileOutputStream EatenfoodFile = new FileOutPutStream("EatenfoodDB");
      ObjectOutputStream d_stream = new ObjectOutputStream(EatenfoodFile);//데이터베이스 접속
      if(math.evaluateEatenFood(eatenInfo))// 만약 먹은 음식이 기준에 맞지 않는지 확인
      wrt.write();//기준에 맞으면 정해진 형식에 따라 db에  입력
   }// 유저에게 입력받은 음식의 정보를 음식 db에 저장
   
   public void getEatenDBInfo(String foodName) {
      FileInputStream fred = new FileInputStream("EatenfoodDB");
      while(String arr = fred.read())//파일 끝이 다달을때까지 음식 정보 가져옴
      
      arr.split(":");
      for(int i = 0; i< arr.length(); i++) {
      EatenInfo.info = arr[i];// 맞는 정보를 순서대로 파싱하여 저장
      }
      print(math.totalNutrient());// 먹은 음식의 총 영양가 계산 후 출력
      fred.close();
   }//오늘 먹은 음식의 정보들을 가져옴
   
   public void search(String name) {
   
   }// 이름과 일치하는 정보를 가진 항목이 DB안에 있는 지 검사하고 그 위치를 전달
   
      
   }//유저 클래스 안에서 getUsesrInfo 함수안에서 쓰이는 함수로 id와 일치하는 레코드를 데이터 베이스 안에서 찾고 이를  
   */
   
}
