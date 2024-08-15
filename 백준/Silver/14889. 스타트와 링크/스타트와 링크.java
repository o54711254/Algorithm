import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int result;
	static boolean[] visit;
	static int[] teamA;
	static int[] teamB;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		teamA = new int[(N / 2) + 1];
		teamB = new int[(N / 2) + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solution(1, 1);

		System.out.println(result);

	}

	static void solution(int depth, int start) {
		if (depth == N / 2 + 1) {
			setTeamB(teamA);
			int A = calculate(teamA);
			int B = calculate(teamB);
			int now = Math.abs(A - B);
			result = Math.min(result, now);
			return;
		}

		for (int i = start; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				teamA[depth] = i;
				solution(depth + 1, i + 1);
				visit[i] = false;
			}
		}
	}

	static void setTeamB(int[] team) {
		int cnt = 1;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				teamB[cnt++] = i;
			}
		}
		return;
	}

	static int calculate(int[] team) {
		int result = 0;
		int size = team.length;
		for (int i = 1; i <= size - 1; i++) {
			for (int j = 1; j <= size - 1; j++) {
				result += arr[team[i]][team[j]];
			}
		}
		return result;
	}

	static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}