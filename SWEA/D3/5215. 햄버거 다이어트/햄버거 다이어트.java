import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Hamburger {
		private int flavor;
		private int calories;

		public Hamburger() {
		}

		public Hamburger(int flavor, int calories) {
			this.flavor = flavor;
			this.calories = calories;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			Hamburger[] hamburger = new Hamburger[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				hamburger[i] = new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			int max = 0;
			for (int i = 0; i < (1 << N); i++) {
				int sumCalories = 0;
				int sumFlavor = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						sumCalories += hamburger[j].calories;
						sumFlavor += hamburger[j].flavor;
					}
				}
				if (sumCalories <= L) {
					max = Math.max(max, sumFlavor);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
