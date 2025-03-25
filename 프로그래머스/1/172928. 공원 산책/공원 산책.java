import java.util.*;
import java.io.*;

class Point{
    int r, c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Route{
    String dir;
    int dist;
    
    public Route(String dir, int dist){
        this.dir = dir;
        this.dist = dist;
    }
}
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static char[][] map;
    static Queue<Route> list = new LinkedList<>();
    static int[] answer = new int[2];
    public int[] solution(String[] park, String[] routes) {
        StringTokenizer st;
        
        map = new char[park.length][park[0].length()];
        
        for(int i = 0; i<park.length; i++){
            map[i] = park[i].toCharArray();    
        }
        
        for(int i = 0; i<routes.length; i++){
            st = new StringTokenizer(routes[i]);
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            list.add(new Route(dir, dist));
        }
        
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                if(map[i][j] == 'S'){
                    run(new Point(i, j));
                    break;
                }
            }
        }
        
        return answer;
    }
    static void run(Point start){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            System.out.println(now.r + " " + now.c);
            if(list.isEmpty()){
                answer[0] = now.r;
                answer[1] = now.c;
                return;
            }
            
            Route nowRoute = list.poll();
            String dir = nowRoute.dir;
            int dist = nowRoute.dist;
            
            int nr = now.r;
            int nc = now.c;
            boolean flag = true;
            for(int i = 0; i<dist; i++){
                nr = nr + dr[findDir(dir)];
                nc = nc + dc[findDir(dir)];
                if(nr < 0 || nc< 0 || nr >= map.length || nc >= map[0].length || map[nr][nc] == 'X'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                queue.add(new Point(nr, nc));
            }else{
                queue.add(now);
            }
        }
        
    }
    static int findDir(String dir){
        if(dir.equals("N")){
            return 0;
        }else if(dir.equals("S")){
            return 1;
        }else if(dir.equals("W")){
            return 2;
        }else{
            return 3;
        }
    }
    static void print(){
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}