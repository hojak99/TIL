import java.util.*;
/*
 * 개구리가 X+1 의 곳으로 가고 싶어한다. 배열의 인덱스를 이용해 건너는데 이 때 배열의 인덱스들의 값이
 * 교차해야 강을 건널 수 있다. 
 * 에를 들면 1, 2, 3, 4, 5 이런 식으로 배열의 인덱스들이 교차해야 강을 건널 수 있다.
 * 
 * A[] = {1, 3, 1, 4, 2, 3, 5, 4}, X = 5
 * 일 때 개구린 는 1, 2, 3, 4, 5 로 강을 건널 수 있다. 이렇게 되면 X+1 인 6을 반환해야 한다.
 * 만약 강을 건널 수 없다면 -1을 반환해야 한다.
 * 
 * 풀이 :
 * 배열 A의 인덱스 값들 중 만약 0이 존재하면 코드가 터지는 것을 방지했고, 그 값이 인자로 들어온 X 보다 값이
 * 크지 않는 경우에만 해당 돌아갈 수 있게 하였다. 또한, B라는 배열을 생성해서 0 으로 초기화 시켰고,
 * A[i]-1 의 값을 배열 B의 인덱스로 해서 만약 A[i]-1 값의 인덱스에 값이 0 이라면 B[A[i]-1] 의 값을
 * + 1 을 하고 A[i] 의 값을 result 변수에 더해서 1에서 X 까지의 총합을 비교하고 만약 같다면 i 를 반환하도록 하였다.
 * 여기서 A[i]-1 을 한 이유는 이 문제의 조건에서 배열 인덱스 값은 1 이상부터라고 했기 때문이다.
 * 
 * 이걸 컴파일하면 [single - single element] 테스트에서 Runtime Error 이 발생하는데 아직 그 이유를 파악하지
 * 못하고 있다. 
 * java.lang.ArrayIndexOutOfBoundsException: 2
 * 
 * 그래서 점수가 90점 밖에 나오지 않는다 
 * */

public class FrogRiverOne {

	public static void main(String[] args) {
		int A[] = {1, 3, 0, 4, 2, 3, 5, 4};
		
		System.out.println(solution(5, A));
	}
	
	public static int solution(int X, int[] A){
	
		int result = 0;
		int arrLen = A.length;
		
		int tempResult = (X * (X+1))/2;
		System.out.println("tempResult : "+tempResult );
		
		int []B = new int[arrLen];
		
		for(int i=0; i<arrLen; ++i){
			B[i] = 0;
			
			if(A[i] ==0){
				return -1;
			}
		}
		
		for(int i=0; i<arrLen; ++i){
			if(A[i] <= X){
				if(B[A[i]-1] == 0){
					System.out.println("A[i] : "+ A[i] + "  " + i);
					B[A[i]-1] += 1;
					result += A[i];
				}
				
				if(result == tempResult){
					return i;
				}
			}
		}		
		
		return -1;
	}

}
