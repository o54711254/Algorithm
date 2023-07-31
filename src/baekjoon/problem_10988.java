package baekjoon;

import java.util.Scanner;

public class problem_10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		String revs = "";
		for(int i = s.length()-1; i>-1; i--) {
			revs += s.charAt(i);
		}
		if(s.equals(revs)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
