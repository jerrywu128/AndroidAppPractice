
package com.example.tool;


public class poker {


	//public static boolean quit=false;
	public float now = 0;
	public float cnow=0;
	int count = 0;

	public float Score(int input,int identity)
	{

		if(identity==0) {
			if ((input % 13) > 10 || (input % 13) == 0) {
				if (count < 2) {
					count++;
					now = 0;
				}

				now += 0.5;


			} else {
				if (count < 2) {
					count++;
					now = 0;
				}
				now += (input % 13);

			}
			return now;
		}
		else if(identity == 1)
		{
			if ((input % 13) > 10 || (input % 13) == 0) {
				if (count < 2) {
					count++;
					cnow= 0;
				}

				cnow += 0.5;


			} else {
				if (count < 2) {
					count++;
					cnow = 0;
				}
				cnow += (input % 13);

			}
			return cnow;
		}else if (identity==2)
		{
			return now;
		}else
		{
			return 0;
		}
	}

}
