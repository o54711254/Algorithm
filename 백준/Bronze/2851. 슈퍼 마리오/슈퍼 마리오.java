
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int sum = 0;
		int sum2 = 0;
		int[] arr = new int[10];
		for(int i =0; i<10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < 10; i++) {
			sum += arr[i];
			if (sum >= 100) {
				sum2 = sum - arr[i];
				break;
			}
		}
		
		if ((sum - 100) <= (100 - sum2)) {
			System.out.println(sum);
		}else {
			System.out.println(sum2);
		}
	}

}
