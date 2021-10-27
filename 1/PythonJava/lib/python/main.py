import sys
import os
from sympy import *

workingdirectory=os.getcwd()
# print("Number of Arguments: ", len(sys.argv), "arguments.")
# print("argument List: ", str(sys.argv))

# def addition():
#     print(sys.argv[1])
#     num1=sys.argv[1]
#     num2=sys.argv[2]
#     numbers=[num1,num2]
#     print(numbers)
#     sumof=int(num1)+int(num2)
#     print("Sum of {0} and {1} is {2}".format(num1, num2, sumof))
    
# addition()
def main():
    # x = sympy.Symbol('x')
    # print(sympy.solve(sympy.Eq(x, 3), x))
    n = 5
    V = Symbol('V')
    R = 1
    r = Symbol("r")
    nCubeEquation = Eq(V, (pi**(n/2)/gamma((n/2)+1))*R**n)
    print_latex(solve(nCubeEquation))
    print_latex(gammasimp(nCubeEquation))
    print_latex(nsimplify(nCubeEquation))
    nCubeAns = solve(nCubeEquation)[0]
    print(nCubeAns)
    print("")
    print_latex(nsimplify(nCubeAns/pi**2))
    
if __name__ == "__main__":
    main()