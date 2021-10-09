import java.util.Scanner;

public class Prims {
	static int SIZE = 10;
	static int INFINITY = 999;
	public static void main(String args[]) {
		int A[][] = new int[SIZE][SIZE];
		int i,j,n;
		System.out.println("**Prims Algo**");
		System.out.println("Enter the total no of nodes: ");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		System.out.println("Enter the weight matrix: ");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				A[i][j] = in.nextInt();
			}
		}
		
		System.out.println("Entered weight matrix: ");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(A[i][j]+"\t");
			}
			System.out.println();
		}
		
		Prim(A,n);
		
	}
	
	public static void Prim(int A[][],int n) {
		int str[] = new int[SIZE];
		int i,j,k;
		int mindist=0 , v1=0 ,v2=0 , total=0;
		
		for(i=0;i<n;i++)
			str[i]=0;
		System.out.println("Minimum spanning tree: ");
		str[0] = 1;
		
		for(k=0;k<n-1;k++) {
			mindist = INFINITY;
			for(i=k;i<n;i++) {
				for(j=0;j<n;j++) {
					if(A[i][j]!=0 && ((str[i]==1&&str[j]==0)||(str[i]==0 && str[j]==1))) {
						if(A[i][j]<mindist) {
							mindist = A[i][j];
							v1 = i;
							v2 = j;
						}
					}
				}
			}
			
			System.out.println("\nEdge["+v1+","+v2+"] and weight: "+mindist);
			str[v1]=str[v2]=1;
			total = total+mindist;
		}
		System.out.println("Total cost : "+total);
		System.out.println("****************");
	}
	
	
}
