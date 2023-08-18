import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}

			int i = 1;
			while (true) {
				if (queue.peek() - i > 0) {
					queue.add(queue.poll() - i);

					i++;
					if (i == 6) {
						i = 1;
					}
				} else {
					break;
				}
			}
			queue.poll();
			queue.add(0);

			System.out.print("#"+num+" ");
			for(int a : queue) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}
}
