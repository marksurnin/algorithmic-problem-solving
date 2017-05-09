// UVa 11151 - Longest Palindrome

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int T[1001][1001];

int main() {
  int t;
  cin >> t;
  string dummy;
  getline(cin, dummy);
  for (; t; t--) {
    // input
    string a, b;
    getline(cin, a);
    b = a;
    reverse(b.begin(), b.end());
    // lcs
    for (int j = 0; j <= b.length(); j++)
      T[0][j] = 0;
    for (int i = 1; i <= a.length(); i++) {
      T[i][0] = 0;
      for (int j = 1; j <= b.length(); j++)
        if (a[i - 1] == b[j - 1])
          T[i][j] = T[i - 1][j - 1] + 1;
        else
          T[i][j] = max(T[i - 1][j], T[i][j - 1]);
    }
    cout << T[a.length()][b.length()] << endl;
  }
  return 0;
}