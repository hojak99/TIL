import java.util.*;

/*
 * 0으로 초기화 되어 있는 N 개의 카운터가 주어지며, 
 * increase(X) 는 해당 카운터 를 1 증가시킨다.
 * max counter 는 모든 카운터를 가장 큰 카운터의 값으로 설정 한다.
 * 
 * 비어있지 않는 M개의 요소를 가진 배열 A가 주어지며
 * 만약 A[K] = X, 1 <= X <= N 이면 increase(X)를 한다.
 * 만약 A[K] = N + 1 이면 max counter 를 한다.
 * 
 * 예를 들어 
 * A[] = {3, 4, 4, 6, 1, 4, 4} , N = 5 일 때,
 * (0, 0, 1, 0, 0)	 이 이유는 인덱스 값 3은 1<=3<=5 에 충족하기 때문에 해당 카운터를 1 증가시킨다.
 * (0, 0, 1, 1, 0)	 이 이유는 인덱스 값 4는 1<=4<=5 에 충족하기 때문이다.
 * (0, 0, 1, 2, 0)	 이 이유는 인덱스 값 4는 1<=4<=5 에 충족하기 때문이다.
 * (2, 2, 2, 2, 2)	 이 이유는 인덱스 값 6에서 N + 1 을 충족하기 때문에 가장 큰 카운터로 다른 카운터를 설정한다.
 * (3, 2, 2, 2, 2)	 이 이유는 인덱스 값 1에서 1<=1<=5 를 충족하기 때문이다.
 * (3, 2, 2, 3, 2)	 이 이유는 인덱스 값 4는 1<=4<=5 에 충족하기 때문이다.
 * (3, 2, 2, 4, 2)	 이 이유는 인덱스 값 4는 1<=4<=5 에 충족하기 때문이다.
 * 
 * [3, 2, 2, 4, 2] 를 반환해야 한다.
 * 
 * 조건 :
 * N 과 M 은 [1...100,000] 범위의 정수
 * 배열 A의 각 요소는 [1..N+1] 범위의 정수
 * 
 * 
 * 풀이 :
 * 우선 위에 설명한 대로 A[i] 값이 1보다 같거나 크고 N보다 같거나 작을 시에 
 * countArr[A[i]-1] 인덱스 값이 만약 max 보다 작으면 그 값이 max + 1로 설정했고 만약 그렇지 않을 시에는
 * countArr[A[i]-1] 인덱스 값을 + 1 하도록 하였다. 그리고 tempMax와 max 를 나눠서 tempMax 가 
 * countArr[A[i]-1] 보다 작으면 그 값으로 tempMax 변수의 값으로 설정하고 만약 A[i] == N+1 일 경우에
 * max = tempMax 로 실질적인 max 값을 설정하였다. 이렇게 tempMax와 max를 나눈 이유는 tempMax 로만 진행할 경우
 * 항상 tempMax의 값으로 카운터가 증가되기 때문에 값이 원하는 대로 나오지 않기 때문이다.
 * 그리고 첫번 째 for 문을 나와서 두번 째 for문이 존재하는 이유는 증가되지 못한 카운터를 위함이다. 
 * */

public class MaxCounters {
	
	public static void main(String[] args) {
		int A[] = {3, 4, 4, 6, 1, 4, 4};
		solution(5, A);
	}
	
	public static int[] solution(int N, int[] A){
		
		int countArr[] = new int[N];
		int tempMax = 0;
		int max = 0;
		
		for(int i=0; i<A.length; ++i){
		
			if(1 <= A[i] && A[i] <= N){
				
				if(countArr[A[i]-1] < max){
					countArr[A[i]-1] = max+1;
				}else{
					++countArr[A[i]-1];
				}
				
				if(tempMax < countArr[A[i]-1]){
					tempMax = countArr[A[i]-1];
				}
				
			}else if(A[i] == (N+1)){
				max = tempMax;
			}
		}
	
		for(int q = 0; q<N; q++){
			if(countArr[q] < max){
				countArr[q] = max;	
			}
		}
		
		for(int i : countArr){
			System.out.print(i + "  ");
		}
		
		return countArr;
	}

}
