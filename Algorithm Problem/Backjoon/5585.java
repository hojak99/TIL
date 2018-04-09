import java.util.Scanner;

/**
 * 
 * @author KwonJH
 *
 * 5585 : 거스롬돈 - 거스롬돈 갯수가 가장 작게 출력
 * https://www.acmicpc.net/problem/5585
 * 
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = 0, result = 0; 
		
		input = scanner.nextInt();	
		result = 1000 - input;
	
		// 동전 개수를 세는 변수
		int count = 0;
		
		while(result > 0) {
			if(result >= 500) {
				result -= 500;
				count += 1;
			} else if(result >= 100) {
				result -= 100;
				count += 1;
			} else if(result >= 50) {
				result -= 50;
				count += 1;
			} else if(result >= 10) {
				result -= 10;
				count += 1;
			} else if(result >= 5) {
				result -= 5;
				count += 1;
			} else if(result >= 1) {
				result -= 1;
				count += 1;
			}
		}
		
		System.out.println(count);
		
	}
}
