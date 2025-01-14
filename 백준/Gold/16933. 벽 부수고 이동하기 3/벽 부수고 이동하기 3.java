import java.util.*;
import java.io.*;

class Main {
    static class Point {
        int x, y;      // 현재 좌표
        int flag;      // 0=낮, 1=밤
        int cnt;       // 부순 벽 개수
        int dist;      // 현재까지의 이동 거리(시간)
        
        public Point(int x, int y, int flag, int cnt, int dist) {
            this.x = x;
            this.y = y;
            this.flag = flag;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    static int N, M, K;
    static char[][] map;
    static boolean[][][][] visited;
    
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        // visited[x][y][0 or 1][벽 부순 횟수]
        visited = new boolean[N][M][2][K+1];

        // BFS 수행
        int answer = bfs();

        System.out.println(answer);
    }

    static int bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, 0, 1));
        visited[0][0][0][0] = true;

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int flag = cur.flag;   // 0=낮, 1=밤
            int cnt = cur.cnt;     // 부순 벽의 개수
            int dist = cur.dist;

            if(x == N-1 && y == M-1){
                return dist;
            }

            int nextFlag = (flag + 1) % 2;

            // 4방향 이동
            for(int i=0; i<4; i++){
                int nx = x + dr[i];
                int ny = y + dc[i];

                // 범위 벗어나면 skip
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                
                if(map[nx][ny] == '0'){
                    // 벽이 아니면 그냥 이동
                    // 다음 칸에 아직 방문한 적이 없어야 함
                    if(!visited[nx][ny][nextFlag][cnt]){
                        visited[nx][ny][nextFlag][cnt] = true;
                        queue.offer(new Point(nx, ny, nextFlag, cnt, dist+1));
                    }
                } 
                else { // map[nx][ny] == '1' (벽)
                    // 이미 벽을 K번 부쉈다면 더 이상 부술 수 없음
                    if(cnt >= K) {
                        continue;
                    }
                    // 낮(flag=0)일 때는 즉시 벽 부수고 이동 가능
                    if(flag == 0){
                        // 부순 횟수 + 1
                        if(!visited[nx][ny][nextFlag][cnt+1]){
                            visited[nx][ny][nextFlag][cnt+1] = true;
                            queue.offer(new Point(nx, ny, nextFlag, cnt+1, dist+1));
                        }
                    }
                    else {
                        if(!visited[x][y][nextFlag][cnt]){
                            visited[x][y][nextFlag][cnt] = true;
                            queue.offer(new Point(x, y, nextFlag, cnt, dist+1));
                        }
                    }
                }
            }
        }

        // 도착 못하면 -1 리턴
        return -1;
    }
}