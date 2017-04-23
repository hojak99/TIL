import java.util.*;

/*
 * 비어있지 않은 배열 A가 있는데 A에 존재하지 않는 가장 작은 양의 정수를 반환해야 한다.
 * 예를 들어
 * A[] = {1, 3, 6, 4, 1, 2}
 * 가 있을 때 5를 반환해야 한다.
 * 
 * 풀이 :
 * 가장 빠른 임의 접근 속도를 가지고 있고 중복을 허용하지 않는 HashSet에 배열 A에 인덱스들을 넣고,
 * max 변수를 이용해 배열 A의 가장 큰 변수를 넣는다. 그리고 max + 2 만큼의 for문을 이용해
 * HashSet에 해당 수가 있는지 없는지 판별하고 없으면 해당 숫자를 반환하는 식으로 문제를 해결하였다.
 * max + 2 를 한 이유는 해당 for문이 1부터 시작하고 마지막 인덱스에 접근하기 위해서 + 2 를 해주었다.
 * */

public class MissingInteger {
	public static void main(String[] args){
		
		int []A = {4, 2, 5,5,5};
		
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A){
		long max = A[0];
		
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				if (set.add(A[i])) {
					if (max < A[i]) {
						max = A[i];
					}
				}
			}
		}

		for (int i = 1; i < max + 2; i++) {
			if(!set.contains(i)) return i;
		}
		
		return 1;
		
	}
}
