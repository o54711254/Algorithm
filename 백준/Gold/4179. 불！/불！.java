import java.io.*;
import java.awt.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static char[][] map;
    static boolean[][] visit;
    static int result = 0;
    static Queue<Point> fireQueue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visit = new boolean[N][M];
        Point start = null;
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'J') {
                    start = new Point(i, j);
                    map[i][j] = '.';
                } else if (map[i][j] == 'F') {
                    fireQueue.add(new Point(i, j));
                }
            }
        }
        
        bfs(start);
        
        System.out.println(result == 0 ? "IMPOSSIBLE" : result);
    }
    
    static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visit[start.x][start.y] = true;
        
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            // 불 먼저 퍼뜨리기
            spreadFire();
            
            int size = queue.size();
            while (size-- > 0) {
                Point now = queue.poll();
                
                // 가장자리에 도달했다면 탈출 성공
                if (now.x == 0 || now.y == 0 || now.x == N - 1 || now.y == M - 1) {
                    result = cnt;
                    return;
                }
                
                for (int i = 0; i < 4; i++) {
                    int nr = now.x + dr[i];
                    int nc = now.y + dc[i];
                    
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || 
                        visit[nr][nc] || map[nr][nc] != '.') {
                        continue;
                    }
                    
                    queue.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                }
            }
            cnt++;
        }
    }
    
    static void spreadFire() {
        int size = fireQueue.size();
        while (size-- > 0) {
            Point now = fireQueue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = now.x + dr[i];
                int nc = now.y + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != '.') {
                    continue;
                }
                
                map[nr][nc] = 'F';
                fireQueue.add(new Point(nr, nc));
            }
        }
    }
}