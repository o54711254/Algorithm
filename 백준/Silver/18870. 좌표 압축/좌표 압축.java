import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] arr2 = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i] = arr[i];
		}

		Arrays.sort(arr2);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0, index = 0; i < arr2.length; i++) {
			if (!map.containsKey(arr2[i])) {

				map.put(arr2[i], index++);
			}
		}
		
		sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb);
	}
}
