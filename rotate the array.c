#include <stdio.h>

void left_rotate(int arr,int d, int n)
{
    int i;
    for (int i=0;i<d ;i++ )
    {
        left_roate_byOne(arr,n);
    }
}

void left_roate_byOne(int arr[],int n  )
{
    int temp=arr[0],i;
    for (int i=0;i<n-1 ;i++ )
    arr[i]=arr[i+1];
    arr[n-1]=temp;

}
void printArray(int arr[], int n)
{
    int i;
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
}
int main()
{
    printf("Enter the number by which u want to rotate elements\n Total elements in the array is 9\n");
    int n;
    scanf("%d",&n);
    int array[]={1,2,3,4,5,6,7,8,9};
    left_rotate(array,n,9);
      printArray(array, 9);

    return 0;
}
