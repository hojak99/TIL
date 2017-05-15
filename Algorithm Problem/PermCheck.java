import java.util.*;

/*
 * N개의 정수로 구성된 비어있지 않은 배열 A가 주어지며 이 배열이 순열인지 검사해 순열이면 1을 아니면 0을 반환
 * 순열은 1에서 N까지의 각 요소를 한 번만 포함하는 시퀀스이다.
 * 
 * 예를 들어 
 * A[] = {4, 1, 3, 2}
 * 일 때, 배열 A는 순열이다
 * 
 * A[] = {4, 1, 3}
 * 일 때, 배열 A는 순열이 아니다.
 * 
 * 풀이 :
 * Arrays.sort 메소드를 이용해 인자로 들어온 배열 A를 정렬시킨 뒤, A의 첫번째 인덱스의 값이 1이 아닐 경우는 순열이
 * 아니라고 판단하고, 해당 인덱스의 값과 그 다음 인덱스의 값이 다르다면 순열이 아니라고 판단해 0을 반환한다.
 * */

public class PermCheck {
	public static void main(String[] args){
		int []A = {2};
		
		System.out.println(solution(A));
	}
	

	public static int solution(int A[]){
			
		Arrays.sort(A);
		
		if(A[0] != 1){
			return 0;
		}
		
		for(int i=0; i<A.length-1; ++i) {
			if((A[i])+1 != A[i+1]){
				return 0;
			}
		}
		
		return 1;
	}
}
