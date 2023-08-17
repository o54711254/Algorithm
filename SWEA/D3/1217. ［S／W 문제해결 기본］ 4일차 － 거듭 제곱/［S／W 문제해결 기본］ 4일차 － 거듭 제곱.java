import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int testC = sc.nextInt();
			int N = sc.nextInt();

			int M = sc.nextInt();

			Stack<Integer> nums = new Stack<>();

			for (int i = 0; i < M; i++) {
				nums.push(N);
			}

			int[] arr = new int[nums.size()];
			for (int i = 0; i < nums.size(); i++) {
				arr[i] = nums.get(i);
			}

			int sum = 1;
			for (int i = 0; i < arr.length; i++) {
				sum *= arr[i];
			}
			System.out.println("#" + testC + " " + sum);
		}
	}
}
