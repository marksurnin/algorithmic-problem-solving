int p[20], n = 20;
for (int i = 0; i < n; i++) p[i] = i;

for (int i = 0; i < (1 << n); i++) {  // for each subset, O(2^n)
  for (int j = 0; j < n; j++) {       // check membership, O(n)
    if (i & (1 << j)) {               // test if bit `j` is turned on in subset `i`
      printf("%d ", p[j]);
    }
    printf("\n");
  }
}