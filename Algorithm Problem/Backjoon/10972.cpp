/**
  입력된 수열에서 다음 수열 구하는 문제.
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

	if (std::next_permutation(a.begin(), a.end())) {
		for (int i = 0; i < n; ++i) {
			std::cout << a[i] << ' ';
		}
	}
	else {
		std::cout << "-1";
	}

	std::cout << "\n";
	return 0;
}
