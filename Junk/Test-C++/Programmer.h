#include "Employee.h"
#ifndef PROGRAMMER_H
#define PROGRAMMER_H


class Programmer : public Employee
{
    public:
        Programmer(double =0.0);
        Programmer(char*,int,double);
        virtual ~Programmer();
        void print()const;

    protected:

    private:
    double salary;

};

#endif // PROGRAMMER_H
