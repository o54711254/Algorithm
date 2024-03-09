import java.io.*;
import java.util.*;

class Tower {
	int height;
	int idx;

	public Tower(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "Tower [height=" + height + ", idx=" + idx + "]";
	}
}


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int N = Integer.parseInt(br.readLine());

		Stack<Tower> stack = new Stack<>();

		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			int num = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {						// 1. 만약에 스택이 비어있다면 -> 시작단계 
				sb.append(0).append(" ");				// sb에 0 넣고 
				stack.add(new Tower(num, i + 1));		// 스택에 추가 
			} else {
				while (true) {							// 2. 스택에 뭐가 들어잇다면 
					
					if(stack.isEmpty()) {				// 4. 쳐내고 쳐내다 남은게 없으면					
						sb.append(0).append(" ");		// sb에 0 추가 
						stack.add(new Tower(num, i+1));	// stack에 넣음 
						break;
					}
					if (stack.peek().height > num) {				// 3-1. 스택 맨 위의것이 현재 숫자보다 크다면 
						sb.append(stack.peek().idx).append(" ");	// 현재 맨 위에 있는 스택(타워)에 신호가 걸린거니까 그 인덱스 추가 
						stack.add(new Tower(num, i + 1));			// 현재 탑도 스택에 추가 
						break;
					} else {
						stack.pop();		// 3-2. 아니면 쳐냄 -> 예를들어 6, 9 , a, b, c 있을때 9가 더 크기에 a,b,c 신호가 6에 걸릴 일이 없음 
					}
				}
			}
		}
		System.out.println(sb);
	}
}