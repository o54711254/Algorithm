import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] >= M) {
				System.out.println(1);
				System.exit(0);
			}
			sum += arr[i];
		}

		if (sum < M) {
			System.out.println(0);
			System.exit(0);
		}

		int start = 0;
		int end = 1;
		int left = 0;
		int right = N - 1;

		int temp = arr[start] + arr[end];

		while (start <= end) {

			if (temp < M) {
				if(end==N-1) {
					break;
				}
				end++;
				temp += arr[end];
			} else {
				if ((end - start) <= (right - left)) {
					right = end;
					left = start;
				}
				temp -= arr[start];
				start++;
			}
		}

		System.out.println((right - left) + 1);
	}
}