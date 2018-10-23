import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int g = gcb(a, b);
        System.out.println(g);
        System.out.println((a*b) / g);
    }

    public static int gcb(int a, int b) {
        if ( b == 0 ) {
            return a;
        }

        return gcb(b, a%b);
    }
}
