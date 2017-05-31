#include <stdio.h>
#include <fcntl.h>
#include <string.h>
#include <wiringPi.h>

#define LED 1

int readSwitch(int gpio)
{
	int value = 0;
	int fd;
	pinMode(LED, OUTPUT);

	char buf[BUFSIZ];
	fd = open("/sys/class/gpio/export", O_WRONLY);
	sprintf(buf, "%d", gpio);
	write(fd,buf, strlen(buf));
	close(fd);

	sprintf(buf, "/sys/class/gpio/gpio%d/value", gpio);
	printf("\n ..... %s ..... \n", buf);
	fd = open(buf, O_RDONLY);
	read(fd, &value, 1);
	
	printf("value : %d %c", value, value);

	if(value == '0') {
		printf("\n ======= Switch Pressed ========\n");
		digitalWrite(LED, HIGH);
	}else {
		printf("\n ......  Switch Released ....... ");
		digitalWrite(LED, LOW);
	}

	close(fd);
	getchar();

	fd = open("/sys/class/gpio/unexport", O_WRONLY);
	sprintf(buf, "%d", gpio);
	write(fd, buf, strlen(buf));
	close(fd);

	return 0;
}

int main(int argc, char **argv)
{
	int gno;
	if(argc < 2) {
		printf("Usage : %s SW_GPIO_NO", argv[0]);
		return (-1);
	}

	wiringPiSetup();
	gno = atoi(argv[1]);
	readSwitch(gno);
	return 0;
}
