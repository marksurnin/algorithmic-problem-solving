from math import tanh

xs = [-3, -2.5, -2, -1.5, -1, -0.5, -0.25, 0, 0.25, 0.5, 1, 1.5, 2, 2.5, 3]

for x in xs:
    output = tanh(1.5*x) - tanh(0.75*x)
    print(x, ": ", output)
