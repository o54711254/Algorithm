import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int K = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < K; i++) {
			int N = Integer.parseInt(br.readLine());
			if (!stack.isEmpty()) {
				if (N == 0) {
					stack.pop();
					continue;
				}
			}
			stack.add(N);
		}
		
		int sum = 0;
		for(int i =0; i<stack.size(); i++) {
			sum+= stack.get(i);
		}
		System.out.println(sum);
	}
}
