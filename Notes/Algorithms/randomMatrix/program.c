#include <stdio.h>

//От index до m рамени rowa с rowb.
int changeRows(int m,int matrix[][m],int rowa,int rowb,int index){
int tmp;
while(index<m){
    tmp = matrix[rowa][index];
    matrix[rowa][index] = matrix[rowb][index];
    matrix[rowb][index] = tmp;
    index++;
}

return 0;
}

int printMatrix(int n,int m,int matrix[][m]){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            printf("%d ",matrix[i][j]);
        }
        printf("\n");
    }
return 0;
}

int main(){
int n,m,index;
int ok = 1;
scanf("%d",&n);
scanf("%d",&m);
int matrix[n][m];

for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        scanf("%d", &matrix[i][j]);
    }
}

printf("MATRIX BEFORE SORTING:\n");
printMatrix(n,m,matrix);


for(int i =0;i<n;i++){
    for(int j =0;j<n-i-1;j++){
        index =0;
        while(index<m){
            if(matrix[j][index]<matrix[j+1][index])
                break;
            else if(matrix[j][index]==matrix[j+1][index])
                index++;
            else{
                changeRows(m,matrix,j,j+1,index);
                break;
            }
            
        }
        
    }

}


printf("\n\nMATRIX AFTER SORTING:\n");
printMatrix(n,m,matrix);

return 0;
}
