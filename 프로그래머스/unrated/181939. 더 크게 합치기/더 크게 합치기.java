class Solution {
    public int solution(int a, int b) {
        int answer = 0;
		String s1 = "";
		s1 += a;
		s1 += b;
		String s2 = "";
		s2 += b;
		s2 += a;

		int result1 = Integer.parseInt(s1);
		int result2 = Integer.parseInt(s2);

		if (result1 >= result2) {
			return result1;
		} else {
			return result2;
		}

	}
}