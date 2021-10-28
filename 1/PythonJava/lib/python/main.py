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
    print(cos(pi))
    print(sin(pi/9))
    # # x = sympy.Symbol('x')
    # # print(sympy.solve(sympy.Eq(x, 3), x))
    # n = int(sys.argv[1])
    # coef = int(sys.argv[2])
    # V = Symbol('V')
    # R = 1
    # r = Symbol('r')
    # nCubeEquation = Eq(V, (pi**(n/2)/gamma((n/2)+1))*R**n)
    # print_latex(solve(nCubeEquation))
    # # print_latex(gammasimp(nCubeEquation))
    # # print_latex(nsimplify(nCubeEquation))
    # nCubeAns = solve(nCubeEquation)[0]
    # # print(nCubeAns)
    # # print("")
    # print_latex((nsimplify(nCubeAns/pi**coef))*(nsimplify(pi**coef))*(nsimplify(r**n)))
    
    # print("\n\n")
    # x1 = Symbol('x_1')
    # x2 = Symbol('x_2')
    # x3 = Symbol('x_3')
    # A = Symbol('A')
    # a1 = 2
    # a2 = 3
    # a3 = 4
    # # print_latex(x1*2)
    # print(solve(Eq(A, integrate(integrate(sqrt(1-a1/x1), (x1, 0, a1)))*x2, (x2, 0, a2)), A))
    # # print(
    # #     solve(
    # #         Eq(
    # #             A, (
    # #                 2**n*integrate(
    # #                     integrate(
    # #                         sqrt(
    # #                             (
    # #                                 1-(1-(a3**2/a1**2))*(x1**2/a1**2)-(1-(a3**2/a2**2))*(x2**2/a2**2)
    # #                             )/(
    # #                                 1-(x1**2/a1**2)-(x2**2/a2**2)
    # #                             )
    # #                         ), (x2, 0, (
    # #                             a2*sqrt(1-(x1**2/a1**2))
    # #                         ))
    # #                     ), (x1, 0, a1)
    # #                 )
    # #             )
    # #         ), A
    # #     )
    # # )
    
if __name__ == "__main__":
    main()