import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
		
		int R = sc.nextInt();
		
		String S = sc.next();


		char[] arr = S.toCharArray();

		String result = "";

		int i = 0;
		int count = 0;
		while(i < arr.length) {
			result += arr[i];
			count++;
			if(count == R) {
				i++;
				count = 0;
			}
		}
		
		System.out.println(result);
	}
	}
}
