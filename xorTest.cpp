/*
	정수 2개를 입력받아 xor 연산해 출력시키기.
*/

#include <iostream>

int main()
{

	int inputNum1 = 0;
	int inputNum2 = 0;

	std::cin >> inputNum1;
	std::cin >> inputNum2;

	int temp = inputNum1 ^ inputNum2;

	std::cout << temp << std::endl;

	return 0;
}