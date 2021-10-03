public class NumberPalindrome {
    public static boolean isPalindrome (int number)
    {
        int last_digit;
        int reverse=0;
        int n2=number;
        while(n2!=0) {
            last_digit = n2 % 10;
            reverse = reverse * 10;
            reverse+=last_digit;
            n2=n2/10;
        }
        if(number==reverse)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }
}
