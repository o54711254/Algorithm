class Solution {
    public int solution(int a, int b) {
        String s = "";
		s += a;
		s += b;
		
		int result = Integer.parseInt(s);
		int result2 = 2*a*b;
		
		if(result>=result2) {
			return result;
		}else {
			return result2;
		}

	}
}