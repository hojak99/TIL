/*
	16진수를 입력받아 8진수로 출력하기.
*/

#include <iostream>

int main()
{
	int inputNumber;

	/*
		8진수  : std::oct
		10진수 : std::dec
		16진수 : std::hex
	*/


	// 16진수로 입력 받기
	std::cin >> std::hex >> inputNumber;
	
	// 8진수로 출력
	std::cout << std::oct << inputNumber;

	return 0;
}