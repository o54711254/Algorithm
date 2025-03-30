import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int idx = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			if (L == 0 && P == 0 && V == 0) {
				return;
			}

			int n = V / P;

			int result = L * n + Math.min((V - (P * n)), L);
			System.out.println("Case " + idx + ": " +result);
			idx++;
		}
	}

}