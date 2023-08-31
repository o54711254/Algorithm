import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			Queue<Character> queue = new LinkedList<>();
			String str = br.readLine();
			char[] arr = str.toCharArray();

			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {
					queue.add(arr[i]);
				} else if (arr[i] == ')') {
					if (queue.isEmpty()) {
						count++;
						break;
					}
					queue.remove();
				}
			}
			
			for(int i =0; i<queue.size(); i++) {
				count++;
			}
			
			if(count!=0) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}
