Given S, a set of integers, find the largest d such that a + b + c = d where a, b, c, and d are distinct elements of S.


### input
Several S, each consisting of a line containing an integer 1 <= n <= 1000 indicating the number of elements in S, followed by the elements of S, one per line. Each element of S is a distinct integer between -536870912 and +536870911 inclusive. The last line of input contains '0'.

### output
For each S, a single line containing d, or a single linbe containing 'no solution'.

### sample input
5
2
3
5
7
12
5
2
16
64
256
1024
0

### sample output
12
no solution

---

4중 포문으로도 짜봤다. 첫번째 while 로 짠거는 if가 많아서 아쉽다

```
public class Main {

    private final static String END_MESSAGE = "no_solution";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            int arrSize = scanner.nextInt();

            if (arrSize == 0) {
                break;
            }

            int[] inputArr = new int[arrSize];

            for(int i = 0; i<arrSize; ++i) {
                inputArr[i] = scanner.nextInt();
            }

            // 정렬
            Arrays.sort(inputArr);

            /////////////////////////////////////////////////////////

            int pivot = arrSize / 2;    // b 의 역할
            int a = 0;                  // 시작
            int d = arrSize - 1;        // 끝
            int c = 1;

            while(true) {

                if(d == (a+1) || a == (pivot+1)) {
                    System.out.println(END_MESSAGE);
                    break;
                }

                int a_value = inputArr[a];
                int pivot_value = inputArr[pivot];
                int c_value = inputArr[c];
                int d_value = inputArr[d];

                int total = a_value + c_value + pivot_value;

                if(total == d_value) {
                    System.out.println(d_value);
                    break;
                } else {
                    if(total > d_value) {
                        pivot -= 1;

                        if(a == pivot) {
                            a = 0;
                            c = a + 1;

                            d -= 1;
                            pivot = (arrSize - (arrSize - d)) / 2;

                            if((a + 2) == d) {
                                System.out.println(END_MESSAGE);
                                break;
                            }
                            continue;
                        }

                        c = a + 1;

                        if(c == pivot) {
                            c += 1;
                        }

                    } else {
                        c += 1;

                        if(c == d) {
                            if(a == (d-2)) {
                                pivot += 1;

                                if(pivot == a) {
                                    d -= 1;
                                    pivot = (arrSize - (arrSize - d)) / 2;

                                    a = 0;
                                    c = a + 1;

                                    continue;
                                }

                                c = a + 1;
                                continue;
                            }

                            a += 1;

                            if(a == pivot) {
                                a += 1;
                            }

                            c = a + 1;

                            if(c == pivot) {
                                c += 1;
                            }
                            continue;
                        }

                        if(c == pivot) {
                            c += 1;
                        }

                        // a 와 d 가 겹칠 때
                        if(a == (d - 1)) {
                            pivot += 1;
                            a = pivot + 1;
                            c = a + 1;
                        }
                    }
                }
            }
        }
    }
}
```



```
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    private final static String END_MESSAGE = "no_solution";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isOk = false;


        while (true) {
            int arrSize = scanner.nextInt();

            if (arrSize == 0) {
                break;
            }

            int[] inputArr = new int[arrSize];

            for (int i = 0; i < arrSize; ++i) {
                inputArr[i] = scanner.nextInt();
            }

            Arrays.sort(inputArr);

            for (int i = 0; i < arrSize; ++i) {
                int standard_i = inputArr[i];

                for (int q = i + 1; q < arrSize; ++q) {
                    int standard_q = inputArr[q];

                    for (int z = q + 1; z < arrSize; ++z) {
                        int standard_z = inputArr[z];

                        for (int t = z + 1; t < arrSize; ++t) {
                            int resultTemp = inputArr[t];

                            if (standard_i + standard_q + standard_z == resultTemp) {
                                System.out.println(resultTemp);
                                isOk = true;
                                break;
                            }else {
                                isOk = false;
                            }
                        }

                        if (isOk) {
                            break;
                        }
                    }

                    if (isOk) {
                        break;
                    }
                }
                if (isOk) {
                    break;
                }
            }

            if (!isOk) {
                System.out.println(END_MESSAGE);
                break;
            }
        }
    }
}

//

```

