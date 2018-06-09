import java.util.Date;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Container;

import java.awt.Dimension;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.border.EmptyBorder;
     class TestLayOut5 {

	 static JFrame mainFrame;

	 public TestLayOut5(){

	  JPanel textViewPanel=new JPanel();

	  JButton c_buttonOk = new JButton("확인");

	  

	  Container cp = new Container();

	  JTextArea chetView = new JTextArea();
	  chetView.setSelectedTextColor(Color.RED);
	  
	  chetView.setText("it's time to eat!! 6hours left after your last eaten time");
	  chetView.setFont(chetView.getFont().deriveFont(16f));

	  chetView.select(0, 100);
	 
	  chetView.setEditable(false);
	  

	  JScrollPane js = new JScrollPane(chetView);

	  mainFrame = new JFrame("Alarm");

	  // 텍스트판넬

	  textViewPanel.setBorder(new EmptyBorder(5,5,380, 235));

	  textViewPanel.setLayout(null);

	  textViewPanel.setBounds(5,5,380, 235);

	  textViewPanel.add(js);
	  

	  js.setBounds(5,5,383, 30);

	  textViewPanel.add(c_buttonOk);

	  c_buttonOk.setBounds(322, 240, 65, 20);

	 

	  //익명이너클레스 액션처리

	  c_buttonOk.addActionListener(new ActionListener() {

	 

	   @Override

	   public void actionPerformed(ActionEvent e) {

	    // TODO Auto-generated method stub

	    mainFrame

	      .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    mainFrame.setVisible(false);

	   }

	  });

	 

	 

	  //프레임 사이즈및 적재 

	  cp = mainFrame.getContentPane();

	  cp.add("Center", textViewPanel);

	  mainFrame.setSize(400, 297);

	  mainFrame.setResizable(false); 

	 

	  //정중앙위치잡기

	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();

	  Dimension f_size = mainFrame.getSize();

	  int x=((int)(screen.getWidth()/2-f_size.width/2));

	  int y=((int)(screen.getHeight()/2-f_size.height/2));

	  mainFrame.setLocation(x,y);

	 

	  //화면그리기

	  mainFrame.setVisible(true);

	 

	 }
	 


}
     class TestLayOut6 {

	 static JFrame mainFrame;

	 public TestLayOut6(int hour, int minute, int second){

	  JPanel textViewPanel=new JPanel();

	  JButton c_buttonOk = new JButton("확인");

	  

	  Container cp = new Container();

	  JTextArea chetView = new JTextArea();
	  
	  
	  chetView.setText(String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second));
	  chetView.setFont(chetView.getFont().deriveFont(16f));

	  
	 
	  chetView.setEditable(false);
	  

	  JScrollPane js = new JScrollPane(chetView);

	  mainFrame = new JFrame("Eaten time");

	  // 텍스트판넬

	  textViewPanel.setBorder(new EmptyBorder(5,5,380, 235));

	  textViewPanel.setLayout(null);

	  textViewPanel.setBounds(5,5,380, 235);

	  textViewPanel.add(js);
	  

	  js.setBounds(5,5,383, 30);

	  textViewPanel.add(c_buttonOk);

	  c_buttonOk.setBounds(322, 240, 65, 20);

	 

	  //익명이너클레스 액션처리

	  c_buttonOk.addActionListener(new ActionListener() {

	 

	   @Override

	   public void actionPerformed(ActionEvent e) {

	    // TODO Auto-generated method stub

	    mainFrame

	      .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    mainFrame.setVisible(false);

	   }

	  });

	 

	 

	  //프레임 사이즈및 적재 

	  cp = mainFrame.getContentPane();

	  cp.add("Center", textViewPanel);

	  mainFrame.setSize(400, 297);

	  mainFrame.setResizable(false); 

	 

	  //정중앙위치잡기

	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();

	  Dimension f_size = mainFrame.getSize();

	  int x=((int)(screen.getWidth()/2-f_size.width/2));

	  int y=((int)(screen.getHeight()/2-f_size.height/2));

	  mainFrame.setLocation(x,y);

	 

	  //화면그리기

	  mainFrame.setVisible(true);

	 

	 }
	 


}

public class Time  extends Thread{
	private int hour;
	private int minute;
	private int second;
	private int countsec = 0;
	private int countmin = 0;
	private int countHour =0;
	
	public void getEatenTime() {
		new TestLayOut6(this.hour,this.minute,this.second);
	}
	public int getHour() {
		return this.hour;
	}
	public int getMin() {
		return this.minute;
	}
	public int getSec() {
		return this.second;
	}
	public void run() {
		Calendar C = Calendar.getInstance();
		this.hour =  C.get(Calendar.HOUR);
		this.minute = C.get(Calendar.MINUTE);
		this.second = C.get(Calendar.SECOND);
		
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			countsec++;
			if(countsec==60) {
				countsec =0;
				
				countmin++;
				if(countmin==60) {
					
					countmin=0;
					countHour ++;
				}
				if(countHour==6) {
					break;
				}
			}
			
			
		}
		new TestLayOut5();
		
		return;
	}
	
	
	public static void main(String[] args) {
		  Time a= new Time();
		  a.start();
		  
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  a.getEatenTime();

		  

		 }
	


	
}