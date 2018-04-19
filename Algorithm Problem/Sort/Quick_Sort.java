import java.util.Scanner;

/**
 * Quick sort 
 * 
 * 1. 리스트 가운데서 하나의 원소를 고른다. (피벗)
 * 2. 피벗 앞에는 피벗보다 값이 작은 원소들이 오고, 피벗 뒤에는 피벗보다 큰 모든 원소들이 오도록 한다. 피벗은 움직이지 않는다.
 * 3. 분활된 두 개의 리스트에 대해 재귀적으로 이 과정을 반복한다.
 * 시간복잡도 : 평균적으로 O(n log n). 최악의 경우 n 제곱
 * 
 * @author KwonJH
 * @since 2018.04.17
 */

public class Main {

	public static void main(String[] args) {
		
		int arr[] = {9, 1, 4, 6, 7, 2, 3, 4, 5, 5};
		
		for(int temp : arr){
			System.out.print(temp +" ");
		}	
	}
	
	public static void quickSort(int[] arr){
		int pivotPosition = arr.length-1;
		int pivotValue = arr[pivotPosition];
		
		int startCount=0, endCount=pivotPosition-1;
		int i = arr[startCount];
		int j = arr[endCount];
		
		while(startCount < endCount){
			
			if((i > pivotValue) && (j < pivotValue)) {
				int temp = i;
				i = j;
				j = temp;
			
				arr[startCount] = i;
				arr[endCount] = j;
				
				startCount += 1;
				endCount -= 1;
				
				
			} else if(i < pivotValue && j < pivotValue) {
				startCount += 1;
			} else if (i > pivotValue && j > pivotValue) {
				endCount -= 1;
			} 
		}
		
		quickSort(arr);
	}
}
