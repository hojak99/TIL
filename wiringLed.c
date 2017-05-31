#include <wiringPi.h>
#include <stdio.h>

#define LED	4	// GPIO 23

int ledControl()
{
	int i = 0;
	pinMode(LED, OUTPUT);
	
	for(i = 0; i<10000; i++){
		digitalWrite(LED, HIGH);
		delay(1000);
		digitalWrite(LED, LOW);
		delay(1000);
	}

	return 0;
}

int main(int argc, char** argv) 
{
	wiringPiSetup();
	 ledControl();
	return 0;
}
