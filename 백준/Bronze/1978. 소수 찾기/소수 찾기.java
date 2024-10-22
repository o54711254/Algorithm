import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (number == 1) {
				cnt++;
			}

			for (int j = 2; j < number; j++) {
				if (number == 2) {
					break;
				}
				if (number % j == 0) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(N - cnt);
	}
}