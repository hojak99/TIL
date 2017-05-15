import java.util.*;

/*
 * N개의 요소로 이루어진 0 인덱스의 배열 A가 주어지는데 배열 A가 가지고 있는 고유한 값의 수를 반환해야 한다.
 * 예를 들어,
 * A[] = {2, 1, 1, 2, 3, 1} 일 때
 * 3을 반환해야 한다. 왜냐하면 배열 A에 고유한 값의 수가 3이기 때문인데 그 고유한 값이 1, 2, 3이기 때문이다.
 * 
 * 풀이 :
 * 이 문제는 극도로 쉬웠다. 우선 HashSet을 사용해서 배열 A의 인덱스 값들이 포함 유무를 판단해 포함되어 있지 않으면
 * HashSet에 추가하는 식으로 해서 count 를 세서 문재를 해결했다.
 * */
public class Distinct {

	public static void main(String[] args) {
		int A[] = {2,1,1,2,3,1};
		System.out.println(solution(A));
	}
	
	public static int solution(int A[]) {
	
		Set<Integer> resultSet = new HashSet<>();
		
		int count = 0;
		
		for(int i=0; i<A.length; ++i){
			if(!resultSet.contains(A[i])){
				resultSet.add(A[i]);
				count+=1;
			}
		}
		
		return count;
	}

}
