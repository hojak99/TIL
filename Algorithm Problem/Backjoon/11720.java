import java.util.Scanner;

/**
 * 
 * @author KwonJH
 * 
 * 11720 : 숫자의 합
 * https://www.acmicpc.net/problem/11720
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = 0, result = 0; 
		String inputNumber;
		
		input = scanner.nextInt();
		inputNumber = scanner.next();		// 숫자 개수가 100 까지 되기 때문에 String 으로 받는다.
		
		// 처음에 String 으로 받아서 inputNumber를 10자리씩 끊어서 inputNumber % 10 하는 식으로 코드를 짜도 괜찮을 것 같다.
		
		for(int i = 0; i<input; ++i) {
			// 한글자씩 가져온다.
			result += Integer.parseInt(String.valueOf(inputNumber.charAt(i)));
		}
		
		System.out.println(result);
	}
}
