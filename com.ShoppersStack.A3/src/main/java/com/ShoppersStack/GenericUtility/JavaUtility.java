package com.ShoppersStack.GenericUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber() {
		
		Random r=new Random();
		int num = r.nextInt(1000);
		return num;
		
	}
	
	public String getLocalDate() {
		
		String date = LocalDate.now().toString().replace("-","");
		return date;
		
	}
	
	public String getLocalDateTime() {
		
		String dateTime = LocalDateTime.now().toString().replace("-","").replace(":","").replace(".","");
		return dateTime;
		
	}

//	public static void main(String[] args) {
//		
//		Random r=new Random();
//		int num = r.nextInt(1000);
//		System.out.println(num);
//		
//		String date = LocalDate.now().toString().replace("-","");
//		System.out.println(date);
//		
//		String dateTime = LocalDateTime.now().toString().replace("-","").replace(":","").replace(".","");
//		System.out.println(dateTime);
//		
//		String time = LocalTime.now().toString();
//		System.out.println(time);
//
//	}

}
