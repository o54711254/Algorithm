

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        // 개미의 이동 거리 계산
        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        // 개미가 격자의 경계를 넘어갈 경우 반대 방향으로 위치 계산
        if (x > w) {
            x = 2 * w - x;
        }
        if (y > h) {
            y = 2 * h - y;
        }

        System.out.println(x + " " + y);
    }
}
