import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, K, cnt;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }
        cnt = 0;
        visit = new int[1000001];
        bfs(N);
        System.out.println(visit[K]);
        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = now - 1;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = now * 2;
                }
                if (next < 0 || next > 100000) {
                    continue;
                }

                if (visit[next] == 0 || visit[next] == visit[now] + 1) {
                    visit[next] = visit[now] + 1;
                    if (next == K) {
                        cnt++;
                    }
                    queue.add(next);
                }
            }

        }
    }
}