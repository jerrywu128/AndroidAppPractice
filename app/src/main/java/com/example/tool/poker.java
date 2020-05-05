
package com.example.tool;


public class poker {


	//public static boolean quit=false;
	public float now = 0;
	int count = 0;

	public float Score(int input) {

		if ((input % 13) > 10 || (input % 13) == 0) {
			if(count<2){
				count++;
				now = 0;
			}

			now += 0.5;
			return now;

		}
		else {
			if(count<2){
				count++;
				now = 0;
			}
			now += (input % 13);
			return now;

		}

	}

}
