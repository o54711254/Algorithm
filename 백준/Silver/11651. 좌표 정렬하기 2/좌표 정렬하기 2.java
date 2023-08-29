
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	private static class Point {
		private int x;
		private int y;

		public Point() {
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		Point[] point = new Point[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(point, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.y == o2.y) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
		});
		
		for(Point p : point) {
			System.out.println(p.x+" " + p.y);
		}
	}

}