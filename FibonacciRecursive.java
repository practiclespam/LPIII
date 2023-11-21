package DAA1;

public class FibonacciRecursive {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

//    public static void printFibonacciSeries(int n) {
//        for (int i = 0; i <= n; i++) {
//            System.out.print(fibonacci(i) + " ");
//        }
//    }

    public static void main(String[] args) {
        int n = 10; // Change this to the desired Fibonacci number to calculate and print the series.
        System.out.print("Fibonacci Series up to " + n + ": "+fibonacci(n));
        
    }
}