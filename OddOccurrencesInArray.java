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

/*
	Set은 집합적인 개념의 Collection 으로 순서의 의미가 없지만 Data를 중복해서 포함할 수 없는 특징을 가지고있다.
	그러면 HashSet의 특징으로는 add() 메소드를 이용해 데이터를 삽입, next()를 이용해 데이터를 추출 할 수 있다.
	또한, Iterator를 이용해서 추출할 수가 있다.

	public static int solution(int[] A) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int i : A){
			if(set.contains(i)){
				set.remove(i);
			}else{
				set.add(i);
			}
		}

		return set.iterator().next();
	} 
*/
	
	// 실화냐?
}
