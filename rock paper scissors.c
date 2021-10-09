#include <stdio.h>
#include <conio.h>
#include <math.h>
#include <strings.h>
#include <stdlib.h>
int generaterandomnumber(int n)
{
    srand(time(NULL));
    return rand()%n;
}
int greater (char char1, char char2)
{
    //first compare
    if  (char1==char2)
    {
        return -1;
    }
    if ((char1='R') && (char2=='S'))
    {
        return 1;
    }
    else
    {
        return 0;
    }
    if  (char1==char2)
    {
        return -1;
    }

    //next compare
    if ((char1='P') && (char2=='R'))
    {
        return 1;
    }
    else
    {
        return 0;
    }
// last compare
    if  (char1==char2)
    {
        return -1;
    }
    if ((char1='S') && (char2=='P'))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int main()
{
    int playerscore =0, compscore=0,temp;
    char playerchar, compchar;
    char dict[]= {'R','P','S'};
    printf("welcome to the rock paper scissors\n Player 1's turn:");
    scanf("%d",&temp);

    for (int i=0; i< 3; i++ )
    {
        // user input
        printf("Player 1's turn\n");
        printf("choose 1 for Rock, 2 for Paper and 3 for Scissors\n");
        scanf("%d",&temp);
        playerchar=dict[temp-1];
        printf("you choose  %c\n\n",playerchar);

            // computer input
        printf("Computer's turn\n");
        printf("choose 1 for Rock, 2 for Paper and 3 for Scissors\n");
        temp=generaterandomnumber(3) +1;
        compchar=dict[temp-1];
        printf("CPU choose %c\n\n",compchar);


        //
        if (greater(compchar,playerchar)==1)
        {
            compscore+=1;
        }
        else if (greater (compchar, playerchar)==-1)
        {
            compscore +=1;
            playerscore +=1;
        }
        else
        {
            playerscore +=1;
        }
    }
    if (playerscore > compscore)
    {
     printf("you won");
    }
    else if (playerscore<compscore)
    {
        printf("you lost");
    }
    else
    {
        printf("it is a draw");
    }

    return 0; 
}
