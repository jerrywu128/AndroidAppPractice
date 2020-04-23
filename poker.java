package work;

import java.util.Scanner;

public class poker 
{
	
	private static float now=0;
	//public static boolean quit=false;
	
	public void Score(int input){	
		
		if(input%13>10){	//翴计
			now+=0.5;
		}
		else{
			now+=input;
		}
		
		if(now<=10.5){  //块翴计
			System.out.println("ヘ玡翴计"+now);
		}
		
		else{
			System.out.print("竒脄翴!!");
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
			System.out.print("块翴计:");
			test.Score(num = scanner.nextInt());
		}*/
	}
}
