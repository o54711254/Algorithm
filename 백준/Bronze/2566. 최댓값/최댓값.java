

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] map = new int[9][9];
		
		int max = -1;
		int a =0;
		int b = 0;
		for(int i =0; i<map.length; i++) {
			for(int j =0; j<map[i].length; j++) {
				map[i][j] = sc.nextInt();
				
				if(max<map[i][j]) {
					max = map[i][j];
					a = i;
					b = j;
				}
			}
		}
		System.out.println(max);
		System.out.print((a+1)+" "+(b+1));
	}

}