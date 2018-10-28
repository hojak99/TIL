/**
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|


이 문제도 순열을 하나하나 구하면서 하면 된다.
절댓값을 구하는 문제이기 때문에 std::abs() 함수를 사용했다.
*/

#include <algorithm>
#include <iostream>
#include <vector>

int main()
{
	int n = 0;
	std::cin >> n;

	std::vector<int> a(n);

	for (int i = 0; i < n; ++i) {
		std::cin >> a[i];
	}

	std::sort(a.begin(), a.end());

	int result = 0;

	do {
		int sum = 0;
		for (int i = 0; i < n - 1; ++i) {
			sum += std::abs(a[i] - a[i + 1]);
		}	

		if (sum > result) {
			result = sum;
		}

	} while (std::next_permutation(a.begin(), a.end()));

	std::cout << result;

	return 0;
}
