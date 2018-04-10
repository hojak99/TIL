import java.math.BigDecimal;
import java.util.Scanner;


/**
 * 
 * @author KwonJH
 *
 * 1009 : 분산처리 - 10개의 컴퓨터 중 데이터를 가장 마지막에 처리하는 컴퓨터는?
 * https://www.acmicpc.net/problem/1009
 * 
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testCase = 0, a = 0, b = 0; 
		
		testCase = scanner.nextInt();
		
		for(int i = 0; i<testCase; ++i){
			
			a = scanner.nextInt();
			b = scanner.nextInt();
			
			a = a % 10;
			
			// a % 10 을 해서 나누어 떨어지면 10의 배수이기 때문에 10번째 컴퓨터가 매번 처리하게 된다.
			if(a == 0) {
				System.out.println(10);
			}
			else if(a == 1){
				System.out.println(1);
			}
			
			// b 가 1이라면 일의 자리 그대로 출력하게 끔
			else if(b == 1) {
				System.out.println(a);
			}
			
			/**
			 * [2 4 8 ~6] [~2 ~4 ~8 ~6] 순으로 일의 자리가 반복한다.
			 * [3 9 ~7 ~1] [~3 ~9 ~7 ~1] 순으로 일의 자리가 반복한다.
			 * [7 ~9 ~3 ~1] [~7 ~9 ~3 ~1] 순으로 일의 자리가 반복한다.
			 * [8 ~4 ~2 ~6] [~8 ~4 ~2 ~6] 순으로 일의 자리가 반복한다.  
			 */
			else if(a == 2 || a == 3 || a == 7 || a == 8) {
				int result = b % 4;
				if(result == 0){
					System.out.println((int)Math.pow(a, 4) % 10);
				}else {
					System.out.println((int)Math.pow(a, result) % 10);
				}
			}
			/**
			 * a 가 4일 땐 [~4, ~6] 으로 반복되고 a가 9일 땐 [~9, ~1]로 반복되기 때문에
			 */
			else if(a == 4 || a == 9){
				int result = b % 2;
				
				// b 가 2로 나누어진다면 a가 4일 땐 항상 값이 [~6]으로 끝나고 a가 9일 땐 항상 값이 [1]로 끝나기 때문에 +2 해주고 10으로 나누고 그 나머지를 출력 
				if(result == 0) {
					System.out.println((a+2) % 10);
				}else {
					// 각각 항상 [~4], [~9]로 끝나기 때문에 그냥 출력해주면 됨
					System.out.println(a);
				}
			}
			/**
			 * 각각 항상 [~5], [~6] 으로 끝난다.
			 */
			else if(a == 5 || a == 6){
				System.out.println(a);
			}

		
		}
		
	}
}
