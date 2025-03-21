import java.util.*;

class Point{
    public final long x, y;
    
    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static char[][] arr;
    static List<Point> list = new ArrayList<>();
    public String[] solution(int[][] line) {
        for(int i = 0; i<line.length-1; i++){
            for(int j = i+1; j<line.length; j++){
                Point p = findPoint(line[i], line[j]);
                if(p != null){
                    list.add(p);
                }
            }
        }
        
        Point maximum = getMaximumPoint();
        Point minimum = getMinimumPoint();
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);
        
        arr = new char[height][width];
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }
        
        for(Point p : list){
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
        // print(arr);
        String[] answer = new String[arr.length];
        for(int i = 0; i<answer.length; i++){
            answer[i] = new String(arr[answer.length-1-i]);
        }
        return answer;
    }
    
    private static Point findPoint(int[] line1, int[] line2){
        long a1 = line1[0];
        long b1 = line1[1];
        long c1 = line1[2];
        
        long a2 = line2[0];
        long b2 = line2[1];
        long c2 = line2[2];
        
        double x = (double)((b1*c2) - (c1*b2))/((a1*b2)-(a2*b1));
        double y = (double)((a2*c1) - (a1*c2))/((a2*b1)-(a1*b2));
        
        if(x % 1 != 0 || y %1 != 0){
            return null;
        }
        return new Point((long)x, (long)y);
    }
    
    private Point getMaximumPoint(){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : list){
            if(p.x>x) x = p.x;
            if(p.y>y) y = p.y;
        }
        return new Point(x,y);
    }
    
    private Point getMinimumPoint(){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : list){
            if(p.x<x) x = p.x;
            if(p.y<y) y = p.y;
        }
        return new Point(x,y);
    }
    
    private void print(char[][] line){
        for(int i = 0; i<line.length; i++){
            for(int j = 0; j<line[0].length; j++){
                System.out.print(line[i][j] + " ");
            }
            System.out.println();
        }
    }
}