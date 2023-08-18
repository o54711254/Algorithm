import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			

		int N = sc.nextInt();

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		int len1 = (arr.length + 1) / 2;
		int len2 = arr.length - len1;

		String[] arr1 = new String[len1];
		String[] arr2 = new String[len2];

		for (int i = 0; i < len1; i++) {
			arr1[i] = arr[i];
		}
		for (int i = 0; i < len2; i++) {
			arr2[i] = arr[i+len1];
		}

		
		Queue<String> queue = new LinkedList<String>();
		
		for(int i = 0; i < len2; i++) {
			queue.add(arr1[i]);
			queue.add(arr2[i]);
		}
		if(arr.length%2 == 1) {
			queue.add(arr1[len1-1]);
		}
		
		System.out.print("#"+tc+" ");
		for(String s: queue) {
			System.out.print(s+" ");
		}System.out.println();
		
		}
	}
}
