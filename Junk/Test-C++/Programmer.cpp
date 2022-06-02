#include <cstring>
#include <iostream>
#include "Programmer.h"

Programmer::Programmer(double a):Employee(),salary(a)
{
    //ctor
}

Programmer::Programmer(char* n,int i, double s):Employee(n,i),salary(s)
{
    //ctor
}


Programmer::~Programmer()
{
    //dtor
}


void Programmer::print()const{

    Employee::print();
    std::cout<<"Salary: "<<salary<<"\n\n";


}
