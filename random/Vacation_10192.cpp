#include <cstring>  
#include <cstdio>  
#include <algorithm>  
using namespace std;  
const int MAXN = 105;  
char A[MAXN];  
char B[MAXN];  
  
int d[MAXN][MAXN];  
int n1, n2;  
void dp()  
{  
    for(int i=1; i<=n1; i++) {  
        for(int j=1; j<=n2; j++) {  
            if(A[i-1] == B[j-1]) {  
                d[i][j] = d[i-1][j-1] + 1;  
            } else {  
                if(d[i-1][j] > d[i][j-1]) {  
                    d[i][j] = d[i-1][j];  
                } else {  
                    d[i][j] = d[i][j-1];  
                }  
            }  
        }  
    }  
}  
  
int main(){  
    #ifndef ONLINE_JUDGE  
    freopen("in.txt", "r", stdin);  
    #endif  
    int T=0;  
    while(gets(A) && A[0]!='#') {  
        gets(B);  
        n1 = strlen(A);  
        n2 = strlen(B);  
        dp();  
        printf("Case #%d: you can visit at most %d cities.\n", ++T, d[n1][n2]);  
    }  
}  