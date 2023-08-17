class Solution {
    public int solution(int n) {
        if (n % 2 == 1) {
			int sum = 0;
			for (int i = 1; 2 * i - 1 <= n; i++) {
				sum += 2 * i - 1;
			}
			return sum;
		} else {
			int sum = 0;
			for (int i = 1; 2 * i <= n; i++) {
				sum += (2*i * 2*i);
			}
			return sum;
		}
	}
}