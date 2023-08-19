import java.util.Scanner;
 
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt(); // 테스트 케이스의 수
 
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 판의 크기
 
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                arr[i] = s.toCharArray();
            }
 
            int result = 0;
 
            // 수평 및 수직으로 패턴 확인
            for (int i = 0; i < N; i++) {
                int countHorizontal = 0;
                int countVertical = 0;
 
                for (int j = 0; j < N; j++) {
                    // 수평 확인
                    if (arr[i][j] == 'o') {
                        countHorizontal++;
                        if (countHorizontal >= 5) {
                            result++;
                        }
                    } else {
                        countHorizontal = 0;
                    }
 
                    // 수직 확인
                    if (arr[j][i] == 'o') {
                        countVertical++;
                        if (countVertical >= 5) {
                            result++;
                        }
                    } else {
                        countVertical = 0;
                    }
                }
            }
 
            // 대각선 확인
            for (int i = 0; i <= N - 5; i++) {
                for (int j = 0; j <= N - 5; j++) {
                    int countDiagonalRight = 0;
                    int countDiagonalLeft = 0;
 
                    // 대각선 오른쪽 아래 확인
                    for (int k = 0; k < 5; k++) {
                        if (arr[i + k][j + k] == 'o') {
                            countDiagonalRight++;
                            if (countDiagonalRight >= 5) {
                                result++;
                            }
                        } else {
                            countDiagonalRight = 0;
                        }
                    }
 
                    // 대각선 왼쪽 아래 확인
                    for (int k = 0; k < 5; k++) {
                        if (arr[i + k][j + 4 - k] == 'o') {
                            countDiagonalLeft++;
                            if (countDiagonalLeft >= 5) {
                                result++;
                            }
                        } else {
                            countDiagonalLeft = 0;
                        }
                    }
                }
            }
 
            // 결과 출력
            if (result >= 1) {
                System.out.println("#"+t+" "+"YES");
            } else {
                System.out.println("#"+t+" "+"NO");
            }
        }
    }
}