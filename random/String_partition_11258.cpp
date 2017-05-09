#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <climits>
#include <algorithm>
using namespace std;

const int MAXN = 210;
long long int num[MAXN][MAXN];
long long int dp[MAXN];
char b[MAXN];

int main()
{
    int cases;
    scanf("%d%*c", &cases);
    while (cases--)
    {
        scanf("%s", b + 1);

        int n = strlen(b + 1);

        for (int p = 1; p <= 11; ++p)
            for (int i = 1, j = p; j <= n; ++i, ++j)
            {
                long long int temp = 0;
                for (int k = i; k <= j; ++k)
                    temp = temp * 10 + b[k] - '0';
                if (temp <= INT_MAX)
                    num[i][j] = temp;
                else
                    num[i][j] = 0;
            }

        memset(dp, 0, sizeof(dp));

        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= 11 && j <= i; ++j)
                dp[i] = max(dp[i], dp[i-j] + num[i-j+1][i]);
        
        printf("%lld\n", dp[n]);
    }
    return 0;
}