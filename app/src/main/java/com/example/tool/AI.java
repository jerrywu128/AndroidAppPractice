package com.example.tool;
import java.util.Scanner;
public class AI 
{
	private int count=0;

	public boolean determine(float reading)
	{
		count++;
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
}
