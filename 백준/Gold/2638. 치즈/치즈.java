import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, time, cheeseAll;
	static int[][] map, cheese;
	static boolean[][] visited;
	static int[] dr={-1,1,0,0};
	static int[] dc={0,0,-1,1};
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void Print(int[][] map) {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		time = 0; // 치즈가 다 녹는데 걸리는 시간
		cheeseAll = 0; // 맵에 있는 치즈의 총 개수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cheeseAll++;
				}
			}
		}// 입력끝
		
		while(cheeseAll>0) {
			// 공기인 부분은 9로 바꾸기
			visited = new boolean[N][M];
			bfs(0,0);
			
			// 치즈 주변에 있는 공기의 수를 카운트해서 저장하기
			cheese = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1) {
						
						for(int d=0; d<4; d++) {
							int nextR = i + dr[d];
							int nextC = j + dc[d];
							
							if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && map[nextR][nextC]==9) {
								cheese[i][j]++;
							}
						}					
					}
				}
			}
			
//			// 출력
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// 주변에 치즈가 2개 이상인 부분은 녹아 없어지므로 9로 표시
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(cheese[i][j]>1) {
						map[i][j] = 9;
						cheeseAll--;
					}
				}
			}
			
//			// 출력
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			time++;
			
		}
		
		System.out.println(time);		
		
		
	}//main
	
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0));
		visited[r][c] = true; // 방문 처리
		
		while(!q.isEmpty()) {
			Point take = q.poll();
			
			for(int d=0; d<4; d++) {
				int nextR = take.x + dr[d];
				int nextC = take.y + dc[d];
				
				if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && !visited[nextR][nextC] && (map[nextR][nextC]==9 || map[nextR][nextC]==0)) {
					q.offer(new Point(nextR, nextC));
					map[nextR][nextC] = 9;
					visited[nextR][nextC] = true;
				}
			}		
			
		}
		
		
	}//bfs
	
	

}