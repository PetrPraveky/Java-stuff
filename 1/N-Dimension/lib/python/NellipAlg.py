import sympy as sp
import sys

def volume(n, r):
    V = sp.Symbol('V')
    rSum = r; rList = [rSum]; rAns = 1
    i = 1
    while i < n:
        rSum = rSum+r
        rList.append(rSum)
        i += 1
    for j in range(len(rList)):
        rAns = rAns*rList[j]
    # print(rAns)
    ans = sp.Eq(V,((sp.pi**(n/2)*(rAns))/sp.gamma((n/2)+1)))
    print(sp.solve(ans)[0])
    
def surface(n, r):
    A = sp.Symbol('A')
    rSum = r; rList = [rSum]; rAns = 0; rAnsPow = 1; p = 1.6075
    i = 1; c = 0; d = 0; coef = 0
    while i < n:
        rSum = rSum+r
        rList.append(rSum)
        i += 1
    for j in range(n):
        for k in range(n-1):
            if (k+c) == n:
                coef = 0
            elif (k+c) > n:
                coef = d+1
                d += 1
            else:
                coef = k+c
            rAnsPow = rAnsPow*rList[coef]
        rAns = rAns+(rAnsPow**p)
        rAnsPow = 1
        c += 1; d = 0
    
    ans = sp.Eq(A, (((2*sp.pi**(n/2))/sp.gamma(n/2))*(((rAns)/(n))**(1/p))))
    print(sp.solve(ans)[0])

if __name__ == "__main__":
    opt = sys.argv[1]
    num1 = sys.argv[2]
    num2 = sys.argv[3]
    if opt == "volume":
        volume(((int)(num1)), ((int)(num2)))
    elif opt == "surface":
        surface(((int)(num1)),((int)(num2)))
    else:
        print("Error, wrong opt")