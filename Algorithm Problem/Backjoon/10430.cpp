#include <iostream>

/**
  (A * B) * C 일 때 (A * C) + (B * C) 와 같다.
  하지만 나머지 연산은 다르다(고 한다).

  (A * B) % C 일 때 (A % C) + (B % C) % C 와 같다.
  % c 일 땐 그렇다고 한다.
*/

int main()
{
	int a = 0, b = 0, c= 0;

	std::cin >> a >> b >> c;

	if (2 <= a && b <= 10000 && c<=10000) {
		std::cout << (a + b) % c << std::endl;
		std::cout << (a%c + b%c)%c << std::endl;
		std::cout << (a*b)%c << std::endl;
		std::cout << (a%c * b%c) << std::endl;
	}
}