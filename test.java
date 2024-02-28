import java.util.Scanner;

public class test{
    public static int fact(int n ){
        
        int a=1;
        for (int i = 1; i <= n; i++) {
            a=a*i;
        }
        return a;
    }
    
    public static int gcd(int a, int b){
 
        int g ;
        if (a>b) {
            g=a;
        }else{
            g=b;
        }
        
        for (int i = g; i >1; i--) {
            if (a%i==0 && b%i==0) {
                return i;
            }
        }
        return 1;
        
    }

    public static int lcm(int a, int b){
        if (b%a==0) {
            return a;
        }
        if (a%b==0) {
            return b;
        }

        int l=0;
        if (a>=b) {
            l=a;
        }else{
            l=b;
        }
        while(true){
            if(l%b==0 && l%a==0){
                return l;
            }
            l++;
        }
    }

    

    

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(gcd(5, 25));
        System.out.println(lcm(5, 25));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to check if it's  prime : ");
        int number = input.nextInt();

        boolean condForPrime = true;



        for (int i = 2; i <= number/2; ++i) {
            if (number % i == 0) {
                condForPrime = false;
                break;
            }
        }

        if(condForPrime && number > 2){
            System.out.println("The number " + number + " is prime!");
        } else {
            System.out.println("The " + number + " is not prime!");
        }
    }

}
