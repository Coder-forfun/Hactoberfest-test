#include<bits/stdc++.h>
using namespace std;
int main()
{
  cout<<"Enter two numbers to be swapped\n";
  int a,b;
  cin>>a>>b;
  int t=a;
  a=b;
  b=t;
  cout<<"Numbers after swapping will be\n";
  cout<<a<<" "<<b<<"\n";
  return 0;
}
