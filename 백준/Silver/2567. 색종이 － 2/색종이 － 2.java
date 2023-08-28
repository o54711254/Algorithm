import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int map[][] = new int[101][101];

		for(int t=0;t<T;t++) {
			int x= sc.nextInt();
			int y= sc.nextInt();
			
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) 
					map[x+i][y+j] = 1;
			}
			//색종이 채우고
		}
		/*for(int i=0;i<101;i++)
			System.out.println(Arrays.toString(map[i]));*/
		int totalSum = 0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(i-1>=0 && map[i][j] == 1 && map[i-1][j] == 0) totalSum++;
				if(i+1<101 && map[i][j] == 1 && map[i+1][j] == 0) totalSum++;
				if(j-1>=0 && map[i][j] == 1 && map[i][j-1] == 0) totalSum++;
				if(j+1<101 && map[i][j] == 1 && map[i][j+1] == 0) totalSum++;
			}
		}
		
		System.out.println(totalSum);
	}
}