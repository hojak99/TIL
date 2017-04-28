/*
	8진수를 10진수로 출력
*/

#include <iostream>

int main()
{

	int inputNumber;

	std::cin >> std::oct >> inputNumber;

	std::cout << std::dec << inputNumber;

	return 0;
}