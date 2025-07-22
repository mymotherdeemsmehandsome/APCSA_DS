public class FancyCalc {
    public static int pow(int base, int exponent) {
        if (exponent == 0)
        {
            return 1;
        }
        else {
            return pow(base, exponent - 1) * base;
        }
    }
    public static void main(String[] args) {
        System.out.println(pow(4, 5));
    }
}