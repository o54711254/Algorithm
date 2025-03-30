import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > K) {
				continue;
			}
			list.add(num);
		}

		int result = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			int coin = list.get(i);
			int value = K / coin;
			result += value;
			K = K - coin * value;
		}
		
		System.out.println(result);
	}

}