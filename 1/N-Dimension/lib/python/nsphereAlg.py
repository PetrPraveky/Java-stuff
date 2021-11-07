import sympy as sp
import sys

def volume(n, r):
    V = sp.Symbol('V')
    ans = sp.Eq(V,((sp.pi**(n/2)*(r**n))/sp.gamma((n/2)+1)))
    print(sp.solve(ans)[0])
    
def surface(n, r):
    A = sp.Symbol('A')
    ans = sp.Eq(A, ((2*sp.pi**(n/2)*(r**(n-1)))/sp.gamma(n/2)))
    print(sp.solve(ans)[0])

def volumeEq(n):
    c = 0
    if n == 1:
        c = 0
    else:
        if n == 2 or n == 3:
            c = 1
        elif n == 4 or n == 5:
            c = 2
        elif n == 6 or n == 7:
            c = 3
        elif n == 8 or n == 9:
            c = 4
        elif n == 10 or n == 11:
            c = 5
        elif n == 12 or n == 13:
            c = 6
        elif n == 14 or n == 15:
            c = 7
        elif n == 16 or n == 17:
            c = 8
        elif n == 18 or n == 19:
            c = 9
        elif n == 20 or n == 21:
            c = 10
    sp.print_latex(sp.nsimplify(((sp.pi**(n/2))/sp.gamma((n/2)+1))/(sp.pi**c)))
    sp.print_latex(sp.pi**c)

def surfaceEq(n):
    c = 0
    if n == 1:
        c = 0
    else:
        if n == 2 or n == 3:
            c = 1
        elif n == 4 or n == 5:
            c = 2
        elif n == 6 or n == 7:
            c = 3
        elif n == 8 or n == 9:
            c = 4
        elif n == 10 or n == 11:
            c = 5
        elif n == 12 or n == 13:
            c = 6
        elif n == 14 or n == 15:
            c = 7
        elif n == 16 or n == 17:
            c = 8
        elif n == 18 or n == 19:
            c = 9
        elif n == 20 or n == 21:
            c = 10
    sp.print_latex(sp.nsimplify(((2*sp.pi**(n/2))/sp.gamma((n/2)))/(sp.pi**c)))
    sp.print_latex(sp.pi**c)

if __name__ == "__main__":
    opt = sys.argv[1]
    num1 = sys.argv[2]
    num2 = sys.argv[3]
    if opt == "volume":
        volume(((int)(num1)), ((int)(num2)))
    elif opt == "surface":
        surface(((int)(num1)),((int)(num2)))
    elif opt == "volumeEq":
        volumeEq((int)(num1))
    elif opt == "surfaceEq":
        surfaceEq((int)(num1))
    else:
        print("Error, wrong opt")