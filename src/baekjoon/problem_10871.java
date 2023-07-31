package baekjoon;

import java.util.Scanner;

public class problem_10871 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] Array = new int[n];
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			Array[i] = num;
			if(Array[i]<x) {
				System.out.print(Array[i]+" ");
			}
		}
		
		
		
	}
}