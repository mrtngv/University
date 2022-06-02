#include <iostream>
#include "fun.h"
using namespace std;

int main()
{

     int menuSelect;
label1:
     int **M = fun1();
     fun2(M);

    while(1){
        std::cout<<"Select 3-17 for functions.\nSelect 0 for exit\n";
        std::cout<<"If you want to enter new function Select -1\n";
        std::cin>>menuSelect;

        switch(menuSelect){
            case 0: cout<<"Exiting program...";break;
            case -1:goto label1;break;
            case 3:fun3(M,0);break;
            case 4:fun4(M,0);break;
            case 5:funfive(M);break;
            case 6:fun6(M);break;
            case 7:fun7(M);break;
            case 8:fun8(M);break;
            case 9:fun9(M);break;
            case 10:fun10(M);break;
            case 11:fun11(M);break;
            case 12:fun12();break;
            case 13:;break;
            case 14:fun14(M);break;
            case 15:;break;
            case 16:;break;
            case 17:;break;

            default:std::cout<<"Invalid argument!\n";break;

        }
        if(menuSelect==0){
            break;
        }

    }

    return 0;
}
