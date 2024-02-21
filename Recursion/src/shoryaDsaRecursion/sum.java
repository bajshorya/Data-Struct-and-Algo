package shoryaDsaRecursion;

public class sum {
    public static void main(String[] args) {
        int ans=sum(5);
        int ans2=sumOfDigits(1342);
        System.out.println(ans);
        System.out.println(ans2);
    }
    static int sum(int n){
        if (n<=1){
            return 1;
        }
        return n+sum(n-1);
    }
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+sumOfDigits(n/10);
    }
}
