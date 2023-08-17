import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[] arr = new String[N];

		ArrayList<String> List = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return Integer.compare(s1.length(), s2.length());
				}
			}
		});

		System.out.println(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1].equals(arr[i])) {
				continue;
			}
			System.out.println(arr[i]);
		}
	}
}
