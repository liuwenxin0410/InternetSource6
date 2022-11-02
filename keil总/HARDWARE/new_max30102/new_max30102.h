#ifndef __NEW_MAX30102_H
#define __NEW_MAX30102_H	 


#include "stm32f10x.h"
#include "myiic.h"
#include "MAX30102.h"
#include "algorithm.h"
#include "usart.h"

int reset_max30102(void);
int got_data(void);

#endif
