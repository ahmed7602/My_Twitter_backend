#include<iostream>
using namespace std;
int main(){
    int m=4,n=3;
    int b[m][n]={{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
    //cout<<"Enter array sixe ";
   // cin>>m>>n;
    int a[m][n]={{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(a[i][j]==0){
                int count=0;
                if(a[i][j+1]==1)
                count++;
                if(a[i+1][j]==1)
                count++;
                if(a[i-1][j]==1)
                count++;
                if(a[i][j-1]==1)
                count++;
                if(a[i-1][j-1]==1)
                count++;
                if(a[i+1][j+1]==1)
                count++;
                if(a[i-1][j+1]==1)
                count++;
                if(a[i+1][j-1]==1)
                count++;
                if(count==3)
                b[i][j]=1;
                
            

            }
                 
            if(a[i][j]==1){
                int e=0;
                if(a[i][j+1]==1)
                e++;
                if(a[i+1][j]==1)
                e++;
                if(a[i-1][j]==1)
                e++;
                if(a[i][j-1]==1)
                e++;
                if(a[i-1][j-1]==1)
                e++;
                if(a[i+1][j+1]==1)
                e++;
                if(a[i-1][j+1]==1)
                e++;
                if(a[i+1][j-1]==1)
                e++;
                if(e<2)
                b[i][j]=0;
                if(e>3)
                b[i][j]=0;
               // if(e==2||3==3)
                //a[i][j]=1;
            }
        }
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            cout<<b[i][j]<<" ";
        }
        cout<<"\n";
        
    }
    
return 0;
}