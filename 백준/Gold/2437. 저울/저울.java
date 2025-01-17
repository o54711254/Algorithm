import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < N; i++) {

			if (arr[i] > sum + 1) {
				break;
			}
			sum += arr[i];
		}

		System.out.println(sum + 1);
	}
}