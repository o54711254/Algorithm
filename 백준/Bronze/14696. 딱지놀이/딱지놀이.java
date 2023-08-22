
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int[] arrA = new int[A];
			for (int i = 0; i < A; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int[] arrB = new int[B];
			for (int i = 0; i < B; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 4; i > 0; i--) {
				int countA = 0;
				int countB = 0;
				for (int j = 0; j < arrA.length; j++) {
					if (arrA[j] == i) {
						countA++;
					}
				}
				for (int j = 0; j < arrB.length; j++) {
					if (arrB[j] == i) {
						countB++;
					}
				}
				if (countA > countB) {
					System.out.println("A");
					break;
				} else if (countB > countA) {
					System.out.println("B");
					break;
				} else if (i == 1 && countA == countB) {
					System.out.println("D");
				}

			}
		}
	}

}
