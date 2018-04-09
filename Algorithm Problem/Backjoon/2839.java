import java.util.Scanner;

/**
 * 
 * @author KwonJH
 *
 * 2839 : 설탕배달 문제 - 5키로, 3키로 봉지로 최대한 적은 봉투 개수로 설탕 담기
 * https://www.acmicpc.net/problem/2839
 * 
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = 0;
		input = scanner.nextInt();
		
		// 5로 나눠서 나머지가 0 이면 바로 출력하게
		if(input % 5 == 0) {
			System.out.println(input / 5);
			return ;
		}
		
		// 봉지 개수를 셀 변수
		int count = 0;
		
		while(input > 0) {
			input -= 3;
			count += 1;
			
			if(input % 5 == 0){
				count += input / 5;
				input -= input;
			}
		}
		
		
		if(input != 0) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
	}
}
