#// Author :RUDRANSH SRIVASTAVA
import math
num=int(input("eneter your number :"))
n=num
rev=0
while n>0:
    
    d=n % 10

    rev=rev + pow(d,3)

    n=int(n/10)

if rev==num:
    print("{} is angstrom number".format(num))

else:
    print("{} is not angstrom number".format(num))
