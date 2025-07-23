public class FancyCalc {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int remainder = a % b;
        return gcd(b,remainder);
    }

    public static int fib(int n) {
        return helpFib(n);
    }

    private static int helpFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return helpFib(n - 1) + helpFib(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(206,40));
    }

    public int fact(int n) {
        return this.factHelp(n, 1);
    }

    private int factHelp(int n, int result) {
        if (n == 0) {
            return result;
        }
        else {
            return this.factHelp((n - 1), n * result);
        }
    }

    public boolean isPrime(int num) {
        return this.helpPrime(num, 2);
    }

    private boolean helpPrime(int num, int divisor) {
        if (divisor == num)
            return true;
        if (num % divisor == 0)
            return false;
        return this.helpPrime(num, divisor + 1);
    }

    public int pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else
        {
            return pow(base, exponent - 1) * base;
        }
    }

    public int fastPow ( int base, int exponent){
        //base case
        if (exponent == 0) return 1;
        if (exponent % 2 == 0) {
            return this.square(this.fastPow(base, exponent / 2));
        }
        return base * this.fastPow(base, exponent - 1);
    }
    public int square ( int x){
        return x * x;
    }
        //Struggled with this pretty hard because I forgot the difference from static and instantiatic methods, I had to consulte with
        //chatGPT to wrap my head around why my test class was throwing errors

}