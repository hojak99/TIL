/*
  모든 순열을 구하는 문제
*/

#include <algorithm>
#include <iostream>
#include <vector>

int main() {
	int n;
	std::cin >> n;
	std::vector<int> a(n);
	for (int i = 0; i < n; i++) {
		a[i] = i + 1;
	}
	do {
		for (int i = 0; i < n; i++) {
			std::cout << a[i] << ' ';
		}
		std::cout << '\n';
	} while (std::next_permutation(a.begin(), a.end()));
	return 0;
}