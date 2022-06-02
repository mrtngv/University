#include <iostream>
#include "fun.h"
using namespace std;

int printMatrix(int**M){
    int lenghtcols = M[0][0];
for(int i=0;i<2;i++){
    for(int j=0;j<lenghtcols;j++){
           cout<<M[i][j+1]<<" ";
    }
    cout<<"\n";
}

}

int**fun1(){
    unsigned int n;
    cout<<"Enter n for size:\n";
    while(1){
        cout<<"n = ";
        cin>>n;
        if(n>0)break;
        cout<<"Not valid! n must be positive\n";
    }
    int **M = new int*[2];

    M[0] = new int[n+1];
    M[1] = new int[n+1];

    M[0][0] = n;

    return M;
}

int fun2(int** M){

int lenghtcols = M[0][0];
int userinput;
for(int i=0;i<2;i++)
    for(int j=0;j<lenghtcols;j++){
            cout<<"Enter element ["<<i<<"]["<<j<<"] = ";
            cin>>userinput;
            M[i][j+1] = userinput;
    }

return 0;
}

int fun3(int **M,int five){
int inekciq =1;
int lenghtcols = M[0][0];


   for(int i=1;i<lenghtcols;i++){
        for(int k= i+1;k<=lenghtcols;k++){
        //cout<<M[1][i]<<"---->"<<M[1][k]<<"\n";
            if(M[1][i]==M[1][k]){

                inekciq = 0;
                break;
            }
        }
        if(inekciq==0)break;
   }
    if(five ==0 ){
           if(inekciq==1){
                cout<<"\nYes, it is Injective!\n";
                }
            else  { cout<<"\nNo, it is not Injective\n";
            }

}
return inekciq;
}


int fun4(int**M,int five){
int surekciq =1;
int lenghtcols = M[0][0];


for(int i=1;i<=lenghtcols;i++){
    if(find_index(M[1][i],M)==0){
        surekciq=0;
        break;
    }

}
if(five==0){

if(surekciq==1){
    cout<<"\nYes, it is Surjective!\n";
}
else{
    cout<<"\nNo, it is not Surjective!\n";
}
}
return surekciq;
}
int funfive (int**M){
    if(fun5(M))
    cout<<"\nYes, it is bijective, a.k. permutation!\n";
else
    cout<<"No,it is not bijective, a.k. permutation!\n";


}
int fun5(int**M){
int permutaciq=0;
if(fun3(M,1)==1)
    if(fun4(M,1)==1)
        permutaciq = 1;




return permutaciq;
}




int fun6(int **M){
int factoriel =1;
for(int i=1;i<=M[0][0];i++)
    factoriel *=i;

    cout<<"P n = "<<factoriel<<"\n";

    return factoriel;
}

int fun7(int**M){
if(fun5(M)==0){
    cout<<"First of all, it is not permutation,please try again with different input!\n";
    return-1;
}
    int nepodvijna_tochka = 0;
    for(int i=1;i<=M[0][0];i++){
        if(M[0][i]==M[1][i]){
            nepodvijna_tochka = 1;

        }
    }

    if(nepodvijna_tochka==1){
        cout<<"There is stationary point\n";
        return 1;
    }
    else{

     cout<<"There is not stationary point\n";
    return 0;
    }

return 0;
}

int fun8(int**M){
if(fun5(M)==0){
    cout<<"First of all, it is not permutation,please try again with different input!\n";
    return-1;
}
    int nepodvijna_tochki = 0;
    for(int i=1;i<=M[0][0];i++){
        if(M[0][i]==M[1][i]){
            nepodvijna_tochki++;

        }
    }



     cout<<"There is "<<nepodvijna_tochki<<" stationary point\n";


return 0;
}

int fun9(int**M){
if(fun5(M)==0){
    cout<<"First of all, it is not permutation,please try again with different input!\n";
    return-1;
}
        int identitet = 1;
    for(int i=1;i<=M[0][0];i++){
        if(M[0][i]!=M[1][i]){
            identitet = 0;


        }
    }


if(identitet==1){
        cout<<"Yes, The permutation IS identitet\n";
        return 1;
    }
    else{

     cout<<"No, The permutation is NOT identitet\n";
    return 0;
    }
    return 0;
}

int fun10(int**M){
if(fun5(M)==0){
    cout<<"First of all, it is not permutation,please try again with different input!\n";
    return-1;
}
     int **M1 = new int*[2];

    M1[0] = new int[M[0][0]+1];
    M1[1] = new int[M[0][0]+1];
    for(int i=0;i<=M[0][0];i++){
        M1[0][i]= M[0][i];
        M1[1][i]= M[1][i];
    }


    int falshivo = -100;

    for(int i=1;i<M1[0][0];i++){
    if(M1[1][i]!=falshivo){
        if(M1[0][i]!=M1[1][i]){
        cout<<"( ";
        int tmp=i;
        int tmp2=i;
            while(true){
            if(M1[1][tmp]==falshivo)
                break;
                cout<<M1[0][tmp]<<" ";
                tmp2 = tmp;
                tmp = find_index(M1[1][tmp],M1);
                M1[1][tmp2] = falshivo;


            }
            cout<<")";
        }
    }
}
cout<<"\n";
return 0;
}


int find_index(int target,int**M){
    for(int i=1;i<=M[0][0];i++){
        if(M[0][i]==target){
            return i;
        }

    }




return 0;
}


int* fun11(int**M){
if(fun5(M)==0){
    cout<<"First of all, it is not permutation,please try again with different input!\n";
    int * p;
    return p;
}
 int **M1 = new int*[2];

    M1[0] = new int[M[0][0]+1];
    M1[1] = new int[M[0][0]+1];
    for(int i=0;i<=M[0][0];i++){
        M1[0][i]= M[0][i];
        M1[1][i]= M[1][i];
    }

    int c = 0;
    int p=0;
    int falshivo = -100;
    int * arr = new int[M[0][0]];
    for(int i=1;i<M1[0][0];i++){
    if(M1[1][i]!=falshivo){
        if(M1[0][i]!=M1[1][i]){

        int tmp=i;
        int tmp2=i;
        c++;
            while(true){

            if(M1[1][tmp]==falshivo)
                break;
                p++;

                tmp2 = tmp;
                tmp = find_index(M1[1][tmp],M1);
                M1[1][tmp2] = falshivo;


            }

            arr[c-1] = p;
            p=0;
        }
    }
}

int *arr1 = new int[c];
for(int i=0;i<c;i++){
    arr1[i] = arr[i];
    cout<<"Independent loop ["<<i+1<<"] lenght: -->"<<arr[i]<<"\n";
}

return arr1;
}
int fun12(){
int proi;
cout<<"ot Kolko proizvedeniq shte se sustoi permutaciqta\n";
cin>>proi;
int *arr = new int[100];
for(int i=0;i<100;i++){
    arr[i] = -100;
}
    int index=0;
for(int i=0;i<proi;i++){
    int val;
    cout<<"Kolko stoinosti shte vuvedete za tova proizvedenie\n";
    cin>>val;

    for(int j=0;j<val;j++){
        int k;
        cout<<i+1<<"."<<j+1<<" = ";
        cin>>k;
        arr[index] = k;
        index++;

    }
    arr[index] = -200;
    index++;



}


for(int i=0;i<100;i++){
if(arr[i]==-100){
break;
}
if(arr[i]!=-200)
    cout<<arr[i]<<" ";
}
cout<<"\n";

int indextrue=0;

for(int i=1;i<100;i++){
if(arr[i]==-100){
break;
}
if(arr[i]!=-200)
    cout<<arr[i]<<" ";
else{
    cout<<arr[indextrue]<<" ";
    arr[indextrue];
    indextrue = i+1;
    i++;

}
}





return 0;
}

int fun14(int** M){

if(fun5(M)==0){
    cout<<"First of all, it is not permutation,please try again with different input!\n";
    return-1;
}

cout<<"The reverse permutation is:\n";
     int **M1 = new int*[2];

    M1[0] = new int[M[0][0]+1];
    M1[1] = new int[M[0][0]+1];
    for(int i=0;i<=M[0][0];i++){
        M1[0][i]= M[0][i];
        M1[1][i]= M[1][i];
    }


    int falshivo = -100;

    for(int i=1;i<M1[0][0];i++){
    if(M1[1][i]!=falshivo){
        if(M1[0][i]!=M1[1][i]){

        int tmp=i;
        int tmp2=i;
        int *be = new int[M[0][0]];
        for(int i=0;i<M[0][0];i++)
            be[i] = 0;

            int broqch=0;
            while(true){
            if(M1[1][tmp]==falshivo)
                break;
               // cout<<M1[0][tmp]<<" ";
               be[broqch] = M[0][tmp];
               broqch++;
                tmp2 = tmp;
                tmp = find_index(M1[1][tmp],M1);
                M1[1][tmp2] = falshivo;


            }
            cout<<"( ";
            for(int i=M[0][0]-1;i>=0;i--){
                if(be[i]!=0)
                    cout<<be[i]<<" ";

            }
            cout<<")";
        }
    }
}
cout<<"\n";
return 0;
}
