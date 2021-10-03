/*
QUESTION:
Write Java program for Maximum length Palindrome Substring of given String.

Sample Input1: BANANAS
Sample Output1: 5
Sample Input2: ABC
Sample Output2: 1
Sample Input3: AAA
Sample Output3: 3

*/
import java.io.*;
import java.lang.*;
import java.util.*;

public class MaximumLengthPalindrome
{
    public static int lcs(String a, String b, int dp[][], int i, int j)
    {
        if(i==0 || j==0) return 0;
        else if(dp[i][j]!=-1) return dp[i][j];
        else if(a.charAt(i-1)==b.charAt(j-1))
        {
            return dp[i][j]=1+lcs(a,b,dp,i-1,j-1);
        }
        else 
        {
            return dp[i][j]=Math.max(lcs(a,b,dp,i-1,j),lcs(a,b,dp,i,j-1));
        }
    }
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Input:");
		String input=sc.nextLine();
		StringBuffer temp=new StringBuffer(input);
		temp=temp.reverse();
		String input1=temp.toString();
		
		// find lcs of input, input1 (reverse of input) -> gives us max len of palindrome;
		
		int n=input.length();
		
		// using dp to find lcs : longest common subsequence size 
		int dp[][]=new int[n+1][n+1];
		for(int i=0;i<=n;i++)
		{
		    Arrays.fill(dp[i],-1);
		}
		int max_plaindrome_length=lcs(input,input1,dp,n,n);
		System.out.println("Output: "+max_plaindrome_length);
	}
		
}
