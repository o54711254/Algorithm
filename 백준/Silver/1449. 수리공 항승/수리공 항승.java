import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;
		int limit = arr[0] + L - 1;

		for (int i = 0; i < N; i++) {
			int num = arr[i];
			if (num <= limit) {
				continue;
			} else {
				limit = num + L - 1;
				count++;
			}
		}

		System.out.println(count + 1);
	}

}