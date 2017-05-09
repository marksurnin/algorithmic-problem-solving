#include<iostream>
#include<list>
#include<string>
#include<cstring>
#include<sstream>
#include<cctype>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<stack>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<map>
#include<set>
#include<utility>
#include<iomanip>
#include<queue>

using namespace std;

#define INF (1<<29)
#define SET(a) memset(a,-1,sizeof(a))
#define ALL(a) a.begin(),a.end()
#define CLR(a) memset(a,0,sizeof(a))
#define FILL(a,v) memset(a,v,sizeof(a))
#define PB push_back
#define FOR(i,n) for(int i = 0;i<n;i++)
#define PI acos(-1.0)
#define EPS 1e-9
#define MP(a,b) make_pair(a,b)
#define min3(a,b,c) min(a,min(b,c))
#define max3(a,b,c) max(a,max(b,c))
#define READ freopen("input.txt", "r", stdin)
#define WRITE freopen("output.txt", "w", stdout)
#define LL long long
#define MX 10000
#define MOD 1000000007

int memo[310][310];
string s1,s2,s[MX];
int s1l,s2l;
int func(int i, int j)
{
    if(i==s1l || j==s2l)    return 0;
    if(memo[i][j]!=-1)      return memo[i][j];
    int ret=0;
    if(s1[i]==s2[j])
        ret=1+func(i+1,j+1);

    return memo[i][j]=ret;
}

int main()
{
    int kk=1;
    //READ;
    //WRITE;
    while(getline(cin,s1))
    {
        if(kk!=1)
            getline(cin,s1);
        getline(cin,s2);
        s1l=s1.length();
        s2l=s2.length();
        int res=0;
        SET(memo);
        for(int i=0;i<s1l;i++)
            for(int j=0;j<s2l;j++)
                res=max(res,func(i,j));
        //cout<<res<<endl;
        if(kk!=1)
            cout<<endl;

        if(!res)
            cout<<"No common sequence."<<endl;
        else
        {
            int cnt=0;
            for(int i=0;i<s1l;i++)
                for(int j=0;j<s2l;j++)
                    if(memo[i][j]==res)
                    {
                        //cout<<res<<endl;
                        s[cnt]="";
                        for(int k=i;k<i+res;k++)
                            s[cnt]+=s1[k];
                        cnt++;
                    }
            sort(s,s+cnt);
            cout<<s[0]<<endl;

            for(int i=1;i<cnt;i++)
                if(s[i]!=s[i-1])
                    cout<<s[i]<<endl;
        }
        kk++;
    }
}