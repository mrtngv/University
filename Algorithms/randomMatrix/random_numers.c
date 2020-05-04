#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{ 
    //Искам първите 2 числа да са в интервала м/у 5 и 12
    // за да правя матрици и по лесно да ги чета
//  int n = 100, m=1000; //до 215-1
  int n,m;// n на брой числа , m обхват
  scanf("%d",&n);
  //scanf("%d",&m);
  m = 99;
  srand((unsigned)time(NULL));
  //printf("%d\n",n);
  printf("%d\n",rand()%12+4);
  printf("%d\n",rand()%12+4);
  for(int i=0;i<n-2;i++)
  printf("%d\n",rand()%m+1);
}
