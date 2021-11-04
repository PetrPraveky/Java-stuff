import sys
import sympy as sp

def gammaFuncAcc(n):
    print(sp.gamma(n))

if __name__ == "__main__":
    opt = sys.argv[1]
    num1 = sys.argv[2]
    if opt == "gammaFunc":
        gammaFuncAcc(num1)
    else:
        print('Error, wrong opt')
    