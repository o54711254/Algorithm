import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int [] arr = new int[num];
		
		for(int i = 0; i<num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = a+b;
		}
		for(int i =0; i<arr.length; i++) {
			System.out.println("Case #"+(i+1)+": " + arr[i]);
		}
		
	}
}