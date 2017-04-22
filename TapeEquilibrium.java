/*
 * 비어있지 않은 배열 A가 N개의 정수로 구성되 있다.
 * 0 < P < N 인 P는 테이프를 비어있지 않은 두 파트로 나눈다.
 * 두 파트 간의 차이 값을 구하려면 첫 파트의 합계와 두 번째 파트의 합계를 뺀 절댓값이며 가장 작은 절댓값을 구해야 한다.
 * 예를 들면 A라는 배열이 있을 경우다.
 * A[] = {3, 1, 2, 4, 3}
 * 이란 배열이 있을 경우에 총 4가지 방법으로 파트를 나눌 수 있다.
 * P = 1, (3) - (1+2+4+3) = 7
 * p = 2, (3+1) - (2+4+3) = 5
 * p = 3, (3+1+2) - (4+3) = 1
 * p = 4, (3+1+2+4) - (3) = 7
 * 
 * 과 같이 나눌 수 있다. 차이 값의 최소 값을 리턴해라
 * 
 * 
 * 풀이 :
 * 이 문제도 쉬운 것 같았다. 생각 외로.
 * 우선, leftResult 변수와 rightResult 변수를 생성해서 leftResult 변수는 A[0] 으로 초기화,
 * rightResult 는 0으로 초기화 시킨다. 그리고 나서 A[1]부터 rightResult 변수에 더한다. 
 * 그리고 result 변수에 Math.abs() 메소드를 이용해 leftResult - rightResult 의 절댓값을 구한 뒤에
 * 다시 A[1]부터 A[A.length-1] 까지 leftResult 에 더하고, rightResult 에는 다시 빼주는 과정을 진행하면서
 * result 값이 leftResult - rightResult 의 절댓값보다 크면 이 절댓값을 result 값으로 변경해준다. 
 * 그러면 해결~
 * */

public class TapeEquilibrium {
	public static void main(String[] args) {
		
		int[] A = {3,1,2,4,3};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		int arrLen = A.length;
		
		int leftResult = A[0];
		int rightResult = 0;
	
		int result = 0;
		
		for(int i=1; i<arrLen; i++){
			rightResult += A[i];
		}
	
		result = Math.abs(rightResult - leftResult);
		
		for(int i=1; i<arrLen-1; i++){
			leftResult += A[i];
			rightResult -= A[i];
			
			if(result > Math.abs(leftResult-rightResult)){
				result =  Math.abs(leftResult-rightResult);
			}
		}
		
		
		return result;
	}
}
