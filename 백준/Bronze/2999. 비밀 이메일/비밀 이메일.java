
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Integer> list = new ArrayList<Integer>();

		String str = br.readLine();

		int N = str.length();
		int i = N;
		while (true) {
			if (i == 0) {
				break;
			}
			if (N % i == 0) {
				list.add(i);
			}
			i--;
		}

		int len = list.get(list.size() / 2);
		
		char[][] map = new char[len][N / len];

		int a = 0;
		for (int j = 0; j < map[0].length; j++) {
			for (int k = 0; k < map.length; k++) {
				map[k][j] = str.charAt(a++);
			}
		}

		for (int j = 0; j < map.length; j++) {
			for (int k = 0; k < map[0].length; k++) {
				System.out.print(map[j][k]);
			}
		}
	}
}