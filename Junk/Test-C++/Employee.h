#ifndef EMPLOYEE_H
#define EMPLOYEE_H


class Employee
{
    public:

        Employee();
        Employee(char*,int);
        Employee(Employee&);


        virtual ~Employee();
        void set_name(char*);
        void set_id(int);

        char* get_name()const;
        int get_id()const;

        void print() const;



    protected:

    private:
    char* name;
    int id;
};

#endif // EMPLOYEE_H
