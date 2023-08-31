import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dimensions = br.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);

        int[][] arr = new int[N * 3][M * 3];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char s = str.charAt(j);
                if (s == '-') {
                    arr[i * 3 + 1][j * 3 + 0] = 1;
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 1][j * 3 + 2] = 1;
                } else if (s == '|') {
                    arr[i * 3 + 0][j * 3 + 1] = 1;
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 2][j * 3 + 1] = 1;
                } else if (s == '+') {
                    arr[i * 3 + 0][j * 3 + 1] = 1;
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 2][j * 3 + 1] = 1;
                    arr[i * 3 + 1][j * 3 + 0] = 1;
                    arr[i * 3 + 1][j * 3 + 2] = 1;
                } else if (s == '1') {
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 1][j * 3 + 2] = 1;
                    arr[i * 3 + 2][j * 3 + 1] = 1;
                } else if (s == '2') {
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 1][j * 3 + 2] = 1;
                    arr[i * 3 + 0][j * 3 + 1] = 1;
                } else if (s == '3') {
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 0][j * 3 + 1] = 1;
                    arr[i * 3 + 1][j * 3 + 0] = 1;
                } else if (s == '4') {
                    arr[i * 3 + 1][j * 3 + 0] = 1;
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 2][j * 3 + 1] = 1;
                } else if (s == 'M' || s == 'Z') {
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                }
            }
        }

        int x = 0, y = 0;
        boolean a = false, b = false, c = false, d = false;

        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i * 3 + 1][j * 3 + 1] == 0) {
                    if (i * 3 - 1 >= 0 && arr[i * 3 - 1][j * 3 + 1] == 1)
                        a = true;
                    if (i * 3 + 3 < N * 3 && arr[i * 3 + 3][j * 3 + 1] == 1)
                        b = true;
                    if (j * 3 - 1 >= 0 && arr[i * 3 + 1][j * 3 - 1] == 1)
                        c = true;
                    if (j * 3 + 3 < M * 3 && arr[i * 3 + 1][j * 3 + 3] == 1)
                        d = true;
                    if (a || b || c || d) {
                        x = i + 1;
                        y = j + 1;
                        break loop;
                    }
                }
            }
        }

        if (a && b && c && d) {
            bw.write(x + " " + y + " +");
        } else if (a && b) {
            bw.write(x + " " + y + " |");
        } else if (a && c) {
            bw.write(x + " " + y + " 3");
        } else if (a && d) {
            bw.write(x + " " + y + " 2");
        } else if (b && c) {
            bw.write(x + " " + y + " 4");
        } else if (b && d) {
            bw.write(x + " " + y + " 1");
        } else if (c && d) {
            bw.write(x + " " + y + " -");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
