/*
 * 세 개의 A, B, K가 주어진다. [A..B] 까지의 범위에서 K로 나눌 수 있는 수를 카운트해서 반환해야 한다.
 * 예를 들어 A = 6, B = 11, K = 2 일 때 3을 반환해야 한다. 왜냐하면 6, 8, 10 을 2로 나눌 수 있기 때문에
 * 3을 반환할 수 있다.
 * 
 * 풀이 :
 * A 와 B가 같을 때 A와 K를 나눠서 나머지가 0이라면 count + 1 을 한다. 그리고 만약 A와 B가 다르다면
 * B/K 를 해서 그 몫을 count로 정하고, 만약 A%K 가 나누어 떨어지면 count + 1 을 한 뒤, A/K의 몫을 다시 count 에서
 * 빼주면 원하는 값이 나온다.
 * 
 * 처음에 for 문으로 계산을 했는데 문제 조건에서 O(1) 을 요구해서 다시 생각했다.
 * */

public class CountDiv {

	public static void main(String[] args) {
		System.out.println(solution(10, 10, 5));
	}
	
	public static int solution(int A, int B, int K){
		
		int count = 0;
		
		if(A == B){
			if(A % K == 0){
				count += 1;
			}
		}else {
			count = B/K;
			
			if(A%K == 0){
				count += 1;
			}

			count -= A/K;
		}
		
		return count;
	}

}
