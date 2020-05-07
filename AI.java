package score;
import java.util.Scanner;
public class AI 
{
	private int count=0;

	public boolean determine(float reading)
	{
		count++;
		System.out.println("目前牌數"+count);
		if(count==1)
		{	
			if(reading<=6)
				return true;
			else
				return false;
		}
		else if(count>=2)
		{
			if(reading<=8)
				return true;
			else
				return false;
		}
		else
		{
			return false;
		}	

	}
	/*
	public static void main(String[] args)
	{
		AI det=new AI();
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("請輸入一個數字:");
			int input=scanner.nextInt();
			System.out.println(det.determine(input));
		}	
	}
	*/
}
