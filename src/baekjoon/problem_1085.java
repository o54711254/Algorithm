package baekjoon;

import java.util.Scanner;

public class problem_1085 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int[] Array = {w-x, h-y, y, x}; 
		
		int min = 1001;
		for(int i =0; i < Array.length; i++) {
			if(min>Array[i]) {
				min = Array[i];
			}
		}
		System.out.println(min);
	}
}
