import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[][] map = new char[5][15];
		for (int i = 0; i < 5; i++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = arr[j];
			}
		}
		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[j][i] != 0) {
					System.out.print(map[j][i]);
				}
			}
		}

	}

}