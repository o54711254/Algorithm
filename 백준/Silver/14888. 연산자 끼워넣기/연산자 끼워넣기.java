import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] calc = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 숫자 갯수
		int N = Integer.parseInt(br.readLine());

		// 숫자 입력받을 배열
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 +,-,*,/ 갯수 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < calc.length; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}

		// depth는 1부터 시작, num은 첫번째 숫자인 arr[0]부터 더해나감
		func(1, arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	public static void func(int depth, int num) {
		int N = arr.length;
		// depth가 1부터 N(숫자개수)이 되면 끝
		if (depth == N) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}

		// 연산자 배열을 탐색
		for (int i = 0; i < 4; i++) {
			// 연산자 배열의 값이 0보다 크다는건 그 연산자가 갯수만큼 있다는 거임
			if (calc[i] > 0) {
				// calc[i] 하나 줄이고
				calc[i]--;
				// 인덱스에 따라 덧셈, 뺄셈, 곱셈, 나눗셈 하고 재귀 돌림
				// depth+1
				switch (i) {
				case 0:
					func(depth + 1, num + arr[depth]);
					break;
				case 1:
					func(depth + 1, num - arr[depth]);
					break;
				case 2:
					func(depth + 1, num * arr[depth]);
					break;
				case 3:
					func(depth + 1, num / arr[depth]);
					break;
				}
				calc[i]++;
			}
		}
	}

}
