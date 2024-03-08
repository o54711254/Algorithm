import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		Set<String> set = new HashSet<String>();
		List<String> result = new ArrayList<String>();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			set.add(str);
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				result.add(str);
			}
		}
		Collections.sort(result);
		sb = new StringBuilder();
		int size = result.size();
		sb.append(size).append("\n");
		for (int i = 0; i < size; i++) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.println(sb);

	}
}