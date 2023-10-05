import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Direction {
	int sec;
	char d;

	public Direction(int sec, char d) {
		super();
		this.sec = sec;
		this.d = d;
	}
}

public class Main {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		// 인덱스 햇갈릴거 방지해서 +1
		int[][] map = new int[N + 1][N + 1];
		int K = Integer.parseInt(br.readLine());
		// 맵에 사과 정보 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = 1;
		}

		// 방향정보 ArrayList에 저장
		int L = Integer.parseInt(br.readLine());
		ArrayList<Direction> direction = new ArrayList<Direction>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);

			direction.add(new Direction(sec, d));
		}

		// 뱀 관리할 덱
		Deque<Point> deque = new LinkedList<Point>();
		// 시작점
		deque.add(new Point(1, 1));
		// 방향 관리할 dir
		int dir = 0;
		// 시간초 cnt
		int cnt = 0;

		while (true) {
			cnt++;
			// 덱 앞부분 조회
			Point p = deque.peekFirst();
			int nr = p.x + dr[dir];
			int nc = p.y + dc[dir];
			// 벗어나거나 몸통에 부딪히면 break
			if (nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] == -1) {
				break;
			}
			if (map[nr][nc] == 1) {
				// 뱀 있는곳 -1로 관리
				map[nr][nc] = -1;
				deque.addFirst(new Point(nr, nc));
			} else {
				map[nr][nc] = -1;
				deque.addFirst(new Point(nr, nc));

				// 꼬리부분(덱 뒷부분) 삭제 후 0으로 돌림
				Point tail = deque.pollLast();
				map[tail.x][tail.y] = 0;
			}
			for (int i = 0; i < direction.size(); i++) {
				if (cnt == direction.get(i).sec) {
					if (direction.get(i).d == 'D') {
						dir = (dir + 1) % 4;
					} else {
						dir = (dir + 3) % 4;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}