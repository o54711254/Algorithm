import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static class Person {
		int num;
		int cnt;

		public Person(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int pNum = 1;

			Queue<Person> queue = new LinkedList<Person>();
			queue.add(new Person(pNum++, 1));

			while (N > 0) {
				Person p = queue.poll();
				N -= p.cnt;
				if (N <= 0) {
					System.out.println("#"+tc+" "+p.num);
				}else {
					p.cnt++;
					queue.add(p);
					queue.add(new Person(pNum++, 1));
				}
			}
		}
	}
}
