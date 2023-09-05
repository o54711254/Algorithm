import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static boolean[] visit;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        arr = new int[M];
        visit = new boolean[N];
        
        dfs(N,M,0);
        
        
    }
    
    public static void dfs(int N, int M, int depth) {
        //깊이가 끝까지 도달하면 출력한다. 모든 요소를
        if(depth == M) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        
        //처음 방문한 곳이 flase라면 true로 바꾸고 깊이를 i+1로 증가시킨다.
        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i +1;
                //그 후 다시 depth를 1증가시켜 재귀를 돌린다.
                dfs(N,M, depth+1);
                // 돌린 후 원래 있던 자리는 false로 바꾼다.
                
                //간혹 depth + 1 이 아니라 depth++ 을 해줘서 틀리는 사람이 꽤 여럿 있는데, 이렇게 하면 dfs 재귀호출 다음 줄에 depth--을 해주지 않으면 안된다.
                visit[i] = false;
            }
        }
    }
}