import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int [] arr = new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
		}
		
		int min = 1000000;
		int max = -1000000;
		
		for(int i =0; i<num; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		
		for(int i =0; i<num; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(min + " " +max);
	}
}