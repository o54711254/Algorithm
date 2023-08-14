import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			String s = sc.next();

			char[] arr = new char[s.length()];
			char[] arr2 = new char[s.length()];
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i);
				arr2[i] = s.charAt((s.length() - 1) - i);
				if (arr[i] == arr2[i]) {
					count++;
				}
			}
			System.out.print("#" +tc+ " ");
			if (count == arr.length) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
