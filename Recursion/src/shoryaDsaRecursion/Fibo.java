package shoryaDsaRecursion;

public class Fibo {

    public static void main(String[] args) {
        int ans=fibo(6);
        System.out.println(ans);
    }
    static int fibo(int num){
        if (num<2){
            return num;
        }
        return (fibo(num-1)+fibo(num-2));
    }
}