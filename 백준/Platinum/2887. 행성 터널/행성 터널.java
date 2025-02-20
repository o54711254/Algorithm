import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        long value;
        
        public Node(int to, long value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.value, o.value);  // 비용 기준으로 비교
        }
    }
    
    static int n;
    static List<Node>[] list;  // 각 노드에 연결된 간선 리스트
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        List<int[]> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            data.add(new int[]{i, x, y, z});
        }
        
        list = new ArrayList[n];  // 0부터 시작
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        // x, y, z 축별로 간선 추가
        for (int idx = 1; idx <= 3; idx++) {
            final int v = idx;
            // 해당 축을 기준으로 정렬
            Collections.sort(data, (o1, o2) -> Integer.compare(o1[v], o2[v]));
            
            // 정렬된 데이터를 기준으로 인접한 행성 간의 거리를 계산하여 간선 추가
            for (int i = 1; i < n; i++) {
                int[] p1 = data.get(i - 1);
                int[] p2 = data.get(i);
                int dis = Math.abs(p1[v] - p2[v]);
                
                list[p1[0]].add(new Node(p2[0], dis));
                list[p2[0]].add(new Node(p1[0], dis));
            }
        }

        // Prim 알고리즘을 사용해 최소 신장 트리(MST)를 구함
        prim(0);
    }
    
    static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] checked = new boolean[n];
        pq.add(new Node(start, 0));  // 시작 노드는 0번, 비용은 0
        
        long total = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.to;
            long value = cur.value;
            
            if (checked[node]) continue;  // 이미 방문한 노드는 건너뜁니다.
            
            checked[node] = true;
            total += value;  // MST의 비용을 누적합니다.
            
            // 현재 노드와 연결된 다른 노드들을 큐에 추가
            for (Node nxt : list[node]) {
                if (!checked[nxt.to]) {
                    pq.add(nxt);  // 방문하지 않은 노드만 큐에 추가
                }
            }
        }
        
        // 결과 출력
        System.out.println(total);
    }
}