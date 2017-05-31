#include <stdio.h>
#include <fcntl.h>
#include <string.h>

int readSwitch(int gpio)
{
	int fd;
	char buf[BUFSIZ];
	fd = open("/sys/class/gpio/export", O_WRONLY);
	sprintf(buf, "%d", gpio);
	write(fd,buf, strlen(buf));
	close(fd);
}
