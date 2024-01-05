import java.util.*;
import java.awt.*;

class Solution {
    static int r;
    static int c;
    static boolean[][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] map;
    static ArrayList<Integer> list;


    public int[] solution(String[] maps) {
        int[] answer = {};

        r = maps.length;
        c = maps[0].length();
        map = new char[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i<r; i++){
            map[i] = maps[i].toCharArray();
        }

        int cnt = 0;

        list = new ArrayList<>();

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(map[i][j] != 'X' && !visit[i][j]){
                    bfs(new Point(i, j));
                    cnt++;
                }
            }
        }

        if(cnt == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        Collections.sort(list);
        answer = new int[cnt];
        for(int i = 0; i<cnt; i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
    static void bfs(Point p){
        int sum = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visit[p.x][p.y] = true;
        sum += map[p.x][p.y]-'0';
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int i = 0; i<4; i++){
                int nr = now.x+dr[i];
                int nc = now.y+dc[i];
                if(nr<0 || nc<0 || nr>=r || nc>=c || map[nr][nc] == 'X' || visit[nr][nc]){
                    continue;
                }
                visit[nr][nc] = true;
                sum += map[nr][nc]-'0';
                queue.add(new Point(nr, nc));
            }
        }
        list.add(sum);
    }
}