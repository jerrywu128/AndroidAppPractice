package work;

import java.util.Scanner;

public class poker 
{
	
	private static float now=0;
	//public static boolean quit=false;
	
	public void Score(int input){	
		
		if(input%13>10){	//點數相加
			now+=0.5;
		}
		else{
			now+=input;
		}
		
		if(now<=10.5){  //輸出點數
			System.out.println("你目前的點數為"+now);
		}
		
		else{
			System.out.print("你已經爆點了!!");
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
			System.out.print("輸入點數:");
			test.Score(num = scanner.nextInt());
		}*/
	}
}
