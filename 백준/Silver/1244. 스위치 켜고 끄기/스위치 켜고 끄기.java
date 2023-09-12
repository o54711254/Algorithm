import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		int[] arr = new int[N + 1]; // 헷갈리니까 0번 인덱스는 버리자
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) { // 스위치 입력
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int stu = Integer.parseInt(br.readLine()); // 학생수
		int gender;
		int num;

		for (int j = 0; j < stu; j++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken()); // 성별
			num = Integer.parseInt(st.nextToken()); // 해당 학생이 받은 수

			if (gender == 1) { // 남자면			
				for (int i = num; i < N + 1; i += num) {// 배수 위치를 변경
						arr[i] = 1 - arr[i]; // 0과 1을 토글
				}
			} else { // 여자면
				arr[num] = 1 - arr[num];	// 중심 위치를 토글
				
				int left = num - 1;
                int right = num + 1;

                while (left >= 1 && right <= N && arr[left] == arr[right]) { // 대칭 체크
                    arr[left] = 1 - arr[left];
                    arr[right] = 1 - arr[right];
                    left--;
                    right++;
                }		
			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(arr[i] + " ");
			if(i%20 ==0)				//20개씩 잘라주기~~~
				System.out.println();
		}
		br.close();
	}
}

