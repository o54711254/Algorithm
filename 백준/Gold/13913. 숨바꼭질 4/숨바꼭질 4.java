import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] min;
	static int[] pre;
	static int N,K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		min = new int[100002];
		pre = new int[100002];
		
		start();
//		System.out.println(Arrays.toString(min));
		Stack<Integer> stack = new Stack<>();
		
		System.out.println(min[K]-1);
		
		int preview = K;
		while(preview != N) {
			stack.add(pre[preview]);
			preview = pre[preview];
		}
		
		while(!stack.isEmpty()) {
			System.out.printf("%d ",stack.pop());
		}
		System.out.printf("%d",K);
	}
	
	static void start() {
		Queue<Integer> info = new LinkedList<>();
		
		min[N] = 1;
		info.add(N);
		
		while(!info.isEmpty()) {
			int now = info.poll();
			
			if(inRange(now*2) && min[now*2] == 0) {
				min[now*2] = min[now] + 1;
				pre[now*2] = now;
				info.add(now*2);
			}
			
			if(inRange(now-1) && min[now-1] == 0) {
				min[now-1] = min[now] + 1;
				pre[now - 1] = now;
				info.add(now-1);
			}
			
			if(inRange(now+1) && min[now+1] == 0) {
				min[now+1] = min[now] + 1;
				pre[now + 1] = now;
				info.add(now+1);
			}
		}
	}
	
	static boolean inRange(int i) {
		return 0 <= i && i <= 100000;
	}
}