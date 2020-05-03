package com.example.tool;

import android.widget.TextView;

import java.util.Scanner;

public class poker
	{

		private static float now=0;
		//public static boolean quit=false;


		public void Score(int input){
		
		if(input%13>10){	//�I�Ƭۥ[
			now+=0.5;
		}
		else{
			now+=input;
		}

		if(now<=10.5){  //��X�I��
			System.out.println(now);
		}
		
		else{
			System.out.print("Error");
			//quit=true;
		}	
		
	}
	
	public static void main(String[] args)
	{ 
		/*int num=0;
		
		Scanner scanner = new Scanner(System.in);
		
		poker test=new poker();

		while(!quit)
		{	
			System.out.print("��J�I��:");
			test.Score(num = scanner.nextInt());
		}*/
	}
}
