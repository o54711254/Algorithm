import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			LinkedList<Integer> pw = new LinkedList<>();

			// 원본 암호문의 길이
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pw.add(Integer.parseInt(st.nextToken()));
			}

			// 명령어의 개수
			int M = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String str = st.nextToken();

				if (str.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());

					for (int j = 0; j < y; j++) {
						pw.add(x + j, Integer.parseInt(st.nextToken()));
					}
				} else if (str.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						pw.remove(x);
					}
				} else if (str.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						pw.addLast(Integer.parseInt(st.nextToken()));
					}
				}
			}

			sb.append("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(pw.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
