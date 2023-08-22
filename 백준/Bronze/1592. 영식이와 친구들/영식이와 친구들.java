import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int count = 0;

		int i = 0;
		while (true) {
			arr[i] += 1;
			count++;
			if (arr[i] == M) {
				break;
			}
			if (arr[i] % 2 == 1) {
				i += L;
				i = i % N;
			} else if (arr[i] % 2 == 0) {
				i = i - L;
				if (i < 0) {
					i = i + N;
				}
			}
		}
		System.out.println(count-1);

	}
}
