#include <cstdio>
#include <cstdlib>
#include <cstring>

const int MAXN = 65600;
int n, p, q;
int stack[MAXN], hash[MAXN];

int main()
{
    int cases, t = 0;
    scanf("%d", &cases);
    while (cases--)
    {
        scanf("%d %d %d", &n, &p, &q);
        ++p, ++q;

        memset(hash, 0, sizeof(hash));

        for (int i = 1; i <= p; ++i)
        {
            int v;
            scanf("%d", &v);
            hash[v] = i;
        }

        int top = 0;
        stack[top] = -1;

        for (int i = 1; i <= q; ++i)
        {
            int v;
            scanf("%d", &v);
            v = hash[v];
            if (v)
            {
                if (v > stack[top])
                    stack[++top] = v;
                else
                {
                    int l = 1, r = top;
                    while (l <= r)
                    {
                        int mid = (l + r) >> 1;
                        if (stack[mid] < v)
                            l = mid + 1;
                        else
                            r = mid - 1;
                    }
                    stack[l] = v;
                }
            }
        }
        printf("Case %d: %d\n", ++t, top);
    }
    return 0;
}