class Solution {
    private static final int[] dr = {1,0,-1};
    private static final int[] dc = {0,1,-1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int r = 0;
        int c = 0;
        int i = 1;
        int dir = 0;
        
        while(true){
            arr[r][c] = i++;
            
            int nr = r+dr[dir];
            int nc = c + dc[dir];
            
            if(nr == n || nc == n || nr == -1 || nc == -1 || arr[nr][nc] != 0){
                dir = (dir+1)%3;
                nr = r + dr[dir];
                nc = c + dc[dir];
                if(nr == n || nc == n || nr == -1 || nc == -1 || arr[nr][nc] != 0){
                    break;
            }
            }
        r = nr;
         c = nc;
            
        }
        int[] result = new int[i-1];
        int index = 0;
        for(int j = 0; j<n; j++){
            for(int k =0; k<=j; k++){
                result[index++] = arr[j][k];
            }
        }
        return result;
    
    }
}