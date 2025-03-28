import java.io.*;
import java.util.*;

class Point{
    int r;
    int c;
    
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    static int result;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0, 0, -1, 1};
    
    static boolean[][] visit;
    public int[] solution(int m, int n, int[][] picture) {
        
        result = Integer.MIN_VALUE;
        visit = new boolean[m][n];
        int cnt = 0;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] != 0 && !visit[i][j]){
                    cnt++;
                    bfs(new Point(i,j), picture, m, n);
                }
            }
        }
        
        int numberOfArea = cnt;
        int maxSizeOfOneArea = result;
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    static void bfs(Point start, int[][] picture, int m, int n){
        int count = 1;
        int nowColor = picture[start.r][start.c];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visit[start.r][start.c] = true;
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            
            for(int i = 0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if(nr < 0 || nc < 0 || nr>=m || nc>=n || picture[nr][nc] != nowColor ||  visit[nr][nc]){
                    continue;
                }
                
                queue.add(new Point(nr, nc));
                count++;
                visit[nr][nc] = true;
            }
        }
        result = Math.max(result, count);
    }
}