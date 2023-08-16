import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			Stack<Integer> nums = new Stack<>();
			int sum = 0;
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num != 0) {
					nums.push(num);
				} else if (num == 0) {
					nums.pop();
				}
			}
			for (int i = 0; i < nums.size(); i++) {
				sum+=nums.get(i);
			}
			System.out.println("#" + tc+" "+sum);
		}
	}
}
