import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			arr[i] = number;
		}

		Arrays.sort(arr);
		int a = 0;
		int b = 0;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {

			// 역수 number
			int number = -arr[i];

			// idx 위
			int highIdx = N - 1;
			// idx 밑
			int lowIdx = i + 1;

			while (lowIdx <= highIdx) {
				int midIdx = (highIdx + lowIdx) / 2;
				if (arr[midIdx] == number) {
					a = -number;
					b = arr[midIdx];
					System.out.println(a + " " + b);
					return;
				} else if (arr[midIdx] < number) {
					lowIdx = midIdx + 1;
				} else {
					highIdx = midIdx - 1;
				}

				int sum = arr[i] + arr[midIdx];
				if (Math.abs(sum) < Math.abs(result)) {
					result = sum;
					a = -number;
					b = arr[midIdx];
				}

			}
		}
		System.out.println(a + " " + b);

	}
}