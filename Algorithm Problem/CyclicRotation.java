import java.util.*;

public class CyclicRotation {
	public static void main(String[] args){
		int A[] = {3,8,9,7,6};
		int B[] = solution(A, 3);
		
		for(int a : B){
			System.out.print(a +" ");
		}

	}
	
	public static int[] solution(int[] A, int K){
		
		int []result = new int[A.length];
		
		 for (int i = 0; i < A.length; i++) {
	            result[(i + K) % A.length] = A[i];
	      }
		
		return result;
	}
}
