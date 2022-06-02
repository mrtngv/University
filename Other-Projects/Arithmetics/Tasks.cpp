#include <iostream>
#include "tasks.h"

using namespace std;
int nSelect(){
    int n;
    while(1){
        cout<<"n = ";
        cin>>n;
        if(n>0)break;
        cout<<"Not valid! n must be positive\n";
    }
    return n;
}



int* task_one(){
    int n = nSelect();
    int *arr = new int[n];
    for(int i=0;i<n;i++){
        cout<<i<<" ";
        arr[i] = i;
    }
    cout<<"\n";
    return arr;
}

int task_two(){
    int n = nSelect();
    int a,b;
        while(1){
        cout<<"number 1 = ";
        cin>>a;
        if(a>=0 && a<n)break;
        cout<<"not from Z";

        }
        while(1){
        std::cout<<"number 2 = ";
        std::cin>>b;
        if(b>=0 && b<n)break;
        cout<<"not from Z";
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cout<<i<<" + "<<j<<" = "<<(i+j)%n<<"\n";
            }
        }

         cout<<"\n******************\n"<<a<<" + "<<b<<" = "<<(a+b)%n<<"\n******************\n";
    return 0;
}

int task_three(){
    int n = nSelect();
    int a,b;
    int ans;
        while(1){
        cout<<"number 1 = ";
        cin>>a;
        if(a>=0 && a<n)break;
        cout<<"not from Z";

        }
        while(1){
        cout<<"number 2 = ";
        cin>>b;
        if(b>=0 && b<n)break;
        cout<<"not from Z";
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans = i-j;
                if(ans<0){
                    ans+=n;
                }
                else ans%=n;
                cout<<i<<" - "<<j<<" = "<<ans<<"\n";
            }
        }
        ans = a-b;
        if(ans<0){
            ans+=n;
        }
        else ans%=n;

        cout<<"\n******************\n"<<a<<" - "<<b<<" = "<<ans<<"\n******************\n";

return 0;
}

int task_four(){
    int n = nSelect();
    int a,b;

        while(1){
        cout<<"number 1 = ";
        cin>>a;
        if(a>=0 && a<n)break;
        cout<<"not from Z";

        }
        while(1){
        cout<<"number 2 = ";
        cin>>b;
        if(b>=0 && b<n)break;
        cout<<"not from Z";
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                std::cout<<i<<" * "<<j<<" = "<<(i*j)%n<<"\n";

            }
        }


    cout<<"\n******************\n"<<a<<" * "<<b<<" = "<<(a*b)%n<<"\n******************\n";
    return 0;
}

int **task_five(int a){
    int n = nSelect();
    int r = 0;
    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            if((i*j)%n==1) r++;
        }
    }
    int ** Matrix = new int*[2];
    Matrix[0] = new int[r+1];
    Matrix[1] = new int[r+1];
    Matrix[0][0] = r;
    r=0;

    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            if((i*j)%n==1){
                Matrix[0][r+1] = i;
                Matrix[1][r+1] = j;
                r++;
            }
        }
    }
    cout<<"\n";
    if(a){
        for(int i=0;i<2;++i){
            for(int j=1;j<r+1;j++){
                cout<<Matrix[i][j]<<"  ";
            }
            cout<<"\n";
            }
    }
    cout<<"\n";
    return Matrix;
}

int task_six(){
    int ** Matrix = task_five(0);
    int r = Matrix[0][0] + 1;
    for(int i=1;i<r;++i)
    cout<<Matrix[0][i]<<" = "<<Matrix[1][i]<<"\n";

    return 0;
}


int task_seven(){

    int n = nSelect();
    int element;
    int found = 0;
    while(1){
        cout<<"element = ";
        cin>>element;
        if(element>0 && element<n)break;
        else
            std::cout<<"Invalid argument\n";
    }

    for(int i=0;i<n;i++){
        if((i*element)%n==1){
        found = 1;
        cout<<"1/"<<element<<" = " <<i<<"\n";
        break;
        }
    }
    if(found==0)cout<<"1/"<<element<<" does not exist\n";
    cout<<"\n";
    return 0;
}



int task_eight(){

    int n = nSelect();
    int *Matrix = new int[n];
    for(int i=0;i<n;i++){
        Matrix[i]=-1;
    }

    for(int i=1;i<n;i++){
        for(int j=1;j<n;j++){
        if((i*j)%n==1) Matrix[i] = j;
        }
    }

    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            cout<<i<<" / "<<j<<" = ";
            if(Matrix[j]==-1)cout<<"-1\n";
            else cout<<((i*Matrix[j])%n)<<"\n";
        }
    }
    cout<<"\n";
    return 0;
}



int task_nine(){
    int n = nSelect();
    int a,m,k=1;
    int prev_a;
    cout<<"a = ";
    cin>>a;
    cout<<"m = ";
    cin>>m;
    prev_a=a;
    while(1){
        if(prev_a%n==1)break;
        k++;
        prev_a*=a;
    }

    int mod = m%k;
    prev_a=a;

    for(int i=0;i<mod-1;i++)
        prev_a*=a;
    cout<<a<<" pow "<<m<<" = "<<prev_a%n<<"\n";
    cout<<"\n";
    return 0;
}


int task_ten(){
    task_nine();
    return 0;
}



int task_eleven(){
    int n = nSelect();
    if(ifnIsPrime(n)){
        cout<<"IT IS A FIELD\n";
        return 0;
    }
    cout<<"IT IS NOT A FIELD\n";
    return 0;
}

int task_twelve(){
    int n,x;
    while(1){
        cout<<"n = ";
        cin>>n;
        if(n>=0 &&ifnIsPrime(n)==1)break;
        cout<<"Wrong input\n";
    }
    while(1){
        cout<<"x = ";
        cin>>x;
        if(x>0 && x<n)break;
        cout<<"not from Z";
    }
    int * roots = root(n,1,NULL);
    cout<<"\n";
    if(roots[x-1]) std::cout<<x<<" is primitive root\n";
    else
        cout<<x<<" is not primitive root .\n";
    cout<<"\n";
    return 0;
}

int task_thirteen(){
    int n = nSelect();
    int * roots = root(n,1,NULL);
    cout<<"primitive roots are:\n";
    for(int i=0;i<n-1;++i)
        if(roots[i]==1)
            cout<<i+1<<"\n";
    cout<<"\n";
    return 0;
}

int task_fourteen(){
    int n = nSelect();
    int a,k,element;
    cout<<"a = ";
   cin>>a;
    cout<<"element = ";
    cin>>element;
    if(a>0&&a<n&&element>=0&&element<n){
        int * characteristics = new int[3];
        characteristics[0] = 1;
        characteristics[1] = a;
        characteristics[2] = element;
        root(n,0,characteristics);
        if(characteristics[0]==-1){
         cout<<"(-1) Not possible\n";
    return -1;

        }
        cout<<"dlog = "<<characteristics[0]<<"\n";
        return characteristics[0];
    }

}


int * root(int n,int print,int * characteristics){
    int jj;
    if(n==1 || ifnIsPrime(n)==0) {
        std::cout<<"not a field \n";
        return NULL;
    }

    int * roots = new int [n-1];
    int **M = new int*[n-1];
    for(int i = 0; i < n-1; ++i)
        M[i] = new int[n-1];

    for(int i=1;i<n;++i){
        jj = i;
        for(int j=0;j<n-1;++j){
            M[i-1][j] = jj%n;
            jj*=i;
        }
    }
    if(print)show(M,n-1,n-1);
    roots=IDarr(M,n-1,n-1);

    if(characteristics!=NULL){
        if(roots[characteristics[1]-1]==1){
            if(characteristics[2]!=0) characteristics[0] = M[characteristics[1]-1][characteristics[2]-1];
        }
        else characteristics[0] = -1;


    }

// cleaning M
    for(int i = 0; i < n-1; ++i) {
        delete [] M[i];
    }
    delete [] M;
return roots;
}

int show(int** M,int rows,int cols){
    for(int i=0;i<rows;++i){
        for(int j=0;j<cols;j++){
            std::cout<<M[i][j]<<"  ";
        }
        std::cout<<"\n";
    }

return 0;
}

int * IDarr(int** M,int rows,int cols){
    int ifid = 0;
    int * id = new int [rows];
    for(int i=0;i<rows;++i){
        id[i] = 1;
    }
    for(int i=0;i<rows;++i){
        for(int j=0;j<cols;++j){
            int k;
            for(k=0;k<j;k++){
                if(M[i][j]==M[i][k]){
                    id[i] = 0;
                    ifid = 1;
                    break;
                }
            }
            if(ifid==1){
                ifid=0;
                break;
            }
        }
    }
        return id;
}

int ifnIsPrime(int n)
{
    if(n==0) return 0;
  int i;
  bool isPrime = true;

  for(i = 2; i <= n / 2; ++i)
  {
      if(n % i == 0)
      {
          isPrime = false;
          break;
      }
  }
  if (isPrime)
      return 1;

  return 0;
}
