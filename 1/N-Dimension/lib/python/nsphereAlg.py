import sympy as sp
import sys

def volume(n, r):
    V = sp.Symbol('V')
    ans = sp.Eq(V,((sp.pi**(n/2)*(r**n))/sp.gamma((n/2)+1)))
    print(sp.solve(ans)[0])

if __name__ == "__main__":
    opt = sys.argv[1]
    num1 = sys.argv[2]
    num2 = sys.argv[3]
    if opt == "volume":
        volume(((int)(num1)), ((int)(num2)))
    else:
        print("Error, wrong opt")