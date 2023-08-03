import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int hr = sc.nextInt();
		int min = sc.nextInt();
		int cook = sc.nextInt();

		int hr2 = cook/60;
		int min2 = cook%60;
		
		int hr3 = hr + hr2;
		int min3 = min + min2;
		
		if(min3>=60) {
			min3 -= 60;
			hr3 += 1;
		}
		if(hr3>=24) {
			hr3 -= 24;
		}
		System.out.println(hr3+ " "+min3);
	}
}
