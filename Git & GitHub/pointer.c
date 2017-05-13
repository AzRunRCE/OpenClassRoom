#include <stdio.h>

int main()
{
   int nombre = 8;
   int *pointeur = &nombre;
   printf("Entered Website:%d", *pointeur);
   
   return(0);
}