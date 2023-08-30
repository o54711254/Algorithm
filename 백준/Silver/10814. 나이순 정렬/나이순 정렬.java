import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Person {
		int age;
		String name;
		int number;

		public Person() {
		}

		public Person(int age, String name, int number) {
			this.age = age;
			this.name = name;
			this.number = number;
		}

		@Override
		public String toString() {
			return age +" "+name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Person[] person = new Person[N];

		int number = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), number++);
		}
		
		Arrays.sort(person, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.age == o2.age) {
					return o1.number-o2.number;
				}
				return o1.age-o2.age;
			}
		});
		
		for(Person p : person) {
			System.out.println(p.toString());
		}
	}
}
