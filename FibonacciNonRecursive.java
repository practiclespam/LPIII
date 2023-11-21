package DAA1;

public class FibonacciNonRecursive {
    public static int fibonacci(int n) {
        int i=0;
        int j=1;
        int result=0;
        
        System.out.print(i+" "+j);
        for(int k=2;k<=n;k++)
        {
        	result=i+j;
        	i=j;
        	j=result;
        	System.out.print(" "+result);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Change this to the desired Fibonacci number to calculate.
        int result = fibonacci(n);
        System.out.println("\nFibonacci(" + n + ") = " + result);
    }
}