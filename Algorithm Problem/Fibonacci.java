/*
 * 메모이제이션을 이용한 피보나치 수열 구현
 * F0 = 0;
 * F1 = 1
 * Fn = Fn-1 + Fn-2
 * 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, .... 와 같다.
 * 
 * */

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(solution(5));
	}
	
	public static int solution(int A){
		
		int []B = new int[500];
		
		if(A <= 1){
			return A;
		}
		
		if(B[A] != 0){
			return B[A];
		}else{
			B[A] = solution(A-1) + solution(A - 2);
			return B[A];
		}
	}

}
