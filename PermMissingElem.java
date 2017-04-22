import java.util.*;

/*
 * 배열 A에서 배열 크기 + 1 만큼의 숫자 중에서 빠진 숫자를 찾기
 * A[] = {2,3,1,5} 결과 : 4
 * 
 * 풀이 : 
 * 배열 크기의 + 1 만큼의 숫자 중에서 빠진 숫자를 찾는 것이기 때문에 위의 예제에서는 배열의 크기는 4이다.
 * 그렇다면 4 + 1 = 5 까지의 숫자가 있는데 이 중 빠진 숫자를 찾는 것이기 때문에 boolean 배열을 이용해
 * true/false 를 이용해 값을 찾는데 boolean 의 배열 크기를 A.length+2 를 한 이유는 
 * 5까지의 숫자가 있는데 5의 인덱스로 접근하지 못하기에 다시 + 1 을 해서 배열 크기를 설정했다.
 * 
 * */

public class PermMissingElem {
	public static void main(String[] args){
		int []A = {1,2,3,5};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A){
		
		boolean result[] = new boolean[A.length+2];
		
		for(int i=0; i<A.length; ++i){
			result[A[i]] = true;
		}
		
		for(int i=1; i<result.length; i++){
			if(!result[i]){
				return i;
			}
		}
		
		return 0;
	}
}
