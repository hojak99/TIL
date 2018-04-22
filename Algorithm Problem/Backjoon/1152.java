import java.util.Scanner;

/**
 * 영어 대소문자와 띄어쓰기만으로 이루어진 문장이 주어진다. 이 문장에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
 * 
 * @author KwonJH
 * @since 2018.03.29
 */

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String data = scanner.nextLine();
		
		if(data.length() <= 1000000) {
			
			// String[] words = data.split("\\s"); 동일코드
			String[] words = data.split(" ");
			
			int count = 0;
			for(int i = 0; i<words.length; ++i) {
				
				// 처음에 공백을 넣었을 때를 대비
				if(!words[i].equals("")){
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}
