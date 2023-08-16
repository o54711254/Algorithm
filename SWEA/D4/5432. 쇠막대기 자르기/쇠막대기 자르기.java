import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
		String s = sc.next();

		char[] charArr = s.toCharArray();

		int sum = 0;

		Stack<Integer> a = new Stack<>();


		for (int i = 1; i < charArr.length; i++) {
			if (charArr[i - 1] == '(') {
				if (charArr[i] == ')') {
					// 스택에 있는값 sum에 더하기
					sum += a.size();
					
				} else {
					a.add(1);
				}

			} else if (charArr[i - 1] == ')') {
				if (charArr[i] == ')') {
					a.pop();
					sum++;
				}
			}
		}
		System.out.println("#"+tc+" "+sum);
		}
	}
}
