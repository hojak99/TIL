import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[9];
        int total = 0;

        for (int i = 0; i < 9; ++i){
            arr[i] = scanner.nextInt();
            total += arr[i];
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; ++i) {
            for(int j = i+1; j < arr.length; ++j) {
                if(total - arr[j] - arr[i] == 100) {
                    for(int q = 0; q < arr.length; ++q) {
                        if(q == j || q == i) {
                            continue;
                        }
                        System.out.println(arr[q]);
                     }
                }
            }
        }
    }
}
