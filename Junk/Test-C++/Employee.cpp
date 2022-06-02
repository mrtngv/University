#include "Employee.h"
#include <cstring>
#include <iostream>

Employee::Employee()
{
    name = "No name";
    id = -1;
}

Employee::~Employee()
{
    //dtor
}


Employee::Employee(char* n,int i)
{
        name = nullptr;

        name = new char[strlen(n)+1];
        strcpy(name,n);

        id = i;


}


Employee::Employee(Employee& a){
name = nullptr;

    name = new char[strlen(a.name)+1];
    strcpy(name,a.name);

    id = a.id;



}



void Employee::print() const{

    std::cout<<"\n";
    std::cout<<"Name: " << get_name();
    std::cout<<"\n";
    std::cout<<"Id: "<< get_id();
    std::cout<<"\n";



}

void Employee::set_name(char* a){
        delete [] name;
        name = nullptr;

        name = new char[strlen(a)+1];
        strcpy(name,a);



}
void Employee::set_id(int a){

    id = a;

}

char* Employee::get_name()const{
        return name;
}
int Employee::get_id()const{
    return id;

}

