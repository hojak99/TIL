public class OddOccurrencesInArray {
	public static void main(String[] args) {
		int aa[] = {9,3,9,3,9,7,9};
		System.out.println(solution(aa));
	}
	
	public static int solution(int[] A) {
		
		int count = 0;
		
		for(int q= 0; q<A.length; ++q){
			for(int i=q+1; i<A.length; ++i){
				if(A[q] == A[i]){
					A[q] = -1;
					A[i] = -1;
				}
			}
			if (A[q] != -1) {
				count = A[q];
			}
		}
		
		return count;
	}
}
