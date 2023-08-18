class Solution {
    public int solution(int a, int d, boolean[] included) {
        	int[] arr = new int[included.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (a + i * d);
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (included[i] == true) {
				sum += arr[i];
			}
		}
		return sum;
	}
}