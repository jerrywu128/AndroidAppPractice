package work;

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
			System.out.println("�A�ثe���I�Ƭ�"+now);
		}
		
		else{
			System.out.print("�A�w�g�z�I�F!!");
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
