import java.util.Scanner;
public class bubbleSort {
    public static void main(String[] args) {
        int n;Scanner inp=new Scanner(System.in);
        System.out.println("Enter number of elements");
        n=inp.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements");
        for (int i=0;i<n;i++)
        {
            arr[i]=inp.nextInt();
        }
        int temp;
        for(int i=0;i<n-1;i++)
        {
            boolean sorted=true;
            for(int j=0;j<n-1-i;j++)     //with every step, largest element will get placed in the array so no need yo check again
            {
                if(arr[j+1]<arr[j])     //compare all the adjacent elements
                {
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    sorted=false;      //if swapping is done then list might be unsorted and if not swapped it means already sorted
                }
            }
            if (sorted)
                break;
        }
        for (int item:arr
             ) {
            System.out.print(item +  " ");

        }

    }
}

