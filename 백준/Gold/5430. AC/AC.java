import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {

            // command 입력
            String str = br.readLine();
            char[] command = str.toCharArray();

            // 숫자 갯수
            int num = Integer.parseInt(br.readLine());

            // 배열 덱에 입력
            String array = br.readLine();
            array = array.substring(1, array.length() - 1);
            Deque<Integer> deque = new LinkedList<>();

            if (!array.isEmpty()) {
                st = new StringTokenizer(array, ",");
                while (st.hasMoreTokens()) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }

            boolean direction = true;
            boolean error = false;

            for (char now : command) {
                if (now == 'R') {
                    direction = !direction;
                } else if (now == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if (direction) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (!error) {
                sb.append("[");
                if (direction) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}