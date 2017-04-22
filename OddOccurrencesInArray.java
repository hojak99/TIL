public class OddOccurrencesInArray {
	public static void main(String[] args) {
		int aa[] = {9,3,9,3,9,7,9};
		
		System.out.println(solution(aa));
	}
	
	public static int solution(int[] A) {
		
		int temp = 0;
		
		for(int i= 0; i<A.length; ++i){
			temp = temp ^ A[i];
			System.out.println("xor : "+temp);
		}
		return temp;
	}
	
	// 실화냐?
}
