// top-down/memoization

int memo[n+1];
int getMinSteps(int n) {
  if (n == 1) return 0;
  if (memo[n] != -1) return memo[n];
  int r = 1 + getMinSteps(n-1);
  if (n%2==0) r = min(r, 1 + getMinSteps(n/2));
  if (n%3==0) r = min(r, 1 + getMinSteps(n/3));
  memo[n] = r;
  return r;
}


// bottom-up
int getMinSteps(int n) {
  int dp[n+1];
  int i;
  dp[1] = 0;
  for (int i = 2; i <= n; i++) {
    dp[i] = dp[i-1] + 1;
    if (i%2==0) dp[i] = min(dp[i], 1+dp[i/2]);
    if (i%3==0) dp[i] = min(dp[i], 1+dp[i/3]);
  }
  return dp[n];
}