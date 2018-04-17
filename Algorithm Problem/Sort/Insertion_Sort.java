import java.util.Scanner;

/**
 * Insertion sort 
 * 
 * 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입함
 * 시간복잡도 : O n제곱 
 * 
 * @author KwonJH
 * @since 2018.04.17
 */

public class Main {

	public static void main(String[] args) {
		
		int arr[] = {9, 1, 4, 6, 7, 2, 3, 4, 5, 5};
			
		/**
		 * 9 1 4 6 7 2 3 4 5 5
		 * 1 9 4 6 7 2 3 4 5 5
		 * 1 4 9 6 7 2 3 4 5 5
		 * 1 4 6 9 7 2 3 4 5 5
		 * 1 4 6 7 9 2 3 4 5 5
		 * 1 4 6 7 2 9 3 4 5 5
		 * 1 4 6 2 7 9 3 4 5 5
		 * 1 4 2 6 7 9 3 4 5 5
		 * 1 2 4 6 7 9 3 4 5 5
		 * 1 2 4 6 7 3 9 4 5 5
		 * 1 2  
		 */
		
		for(int i=1; i<arr.length; ++i) {
			
			int temp_i = i;
			
			for(int q=i-1; q >=0; --q) {
				if(arr[temp_i] < arr[q]) {
					int temp = arr[temp_i];
					arr[temp_i] = arr[q];
					arr[q] = temp;
					
					temp_i -= 1;
				}
			}
		}
		

		for(int temp : arr){
			System.out.print(temp +" ");
		}	
		System.out.println();
	}
}
