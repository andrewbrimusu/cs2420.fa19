public class Fib {
    
    public static int fib(int x)
    {
        if (x <= 1) return 1;
        else return fib(x-1)+fib(x-2);
     }

    public static int fib2(int n)
    {
        int fib1 = 0, fib2 = 1, fib3 = 1, i=1;
        System.out.println("The Fibonacci Series is follows : " + fib1 + " " + fib2 + " ");
        while (i<=n)
        {   i++;
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
            System.out.print(fib3 + " ");
        }
       System.out.println();
       return fib3;
    }


    public static void main(String[] args) {
        System.out.println("fib(10): "+ fib(10));
        System.out.println("fib2(10): "+ fib2(10));
    }
}