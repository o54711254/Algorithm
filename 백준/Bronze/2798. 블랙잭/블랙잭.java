
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < arr.length-2; i++) {
			for (int j = 1+i; j < arr.length-1; j++) {
				for (int k = j+1; k < arr.length; k++) {
					int sum = arr[i]+arr[j]+arr[k]; 
					if(sum <= M) {
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);
	}
}