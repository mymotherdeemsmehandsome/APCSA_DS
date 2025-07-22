public class FancyCalc {
    /*
    public static int pow(int base, int exponent) {
        if (exponent == 0)
        {
            return 1;
        }
        else {
            return pow(base, exponent - 1) * base;
        }

     */
    public int fastPow(int base, int exponent) {
            //base case
            if (exponent == 0) return 1;
            if (exponent % 2 == 0)
            {
                return this.square(this.fastPow(base, exponent / 2));
            }
            return base * this.fastPow(base, exponent-1);
        }
        public int square(int x){
        return x*x;
    }
    public static void main(String[] args) {
        FancyCalc fp = new FancyCalc();
        System.out.println(fp.fastPow(4, 5));
    }
    //Struggled with this pretty hard because I forgot the difference from static and instantiatic methods, I had to consulte with
    //chatGPT to wrap my head around why my test class was throwing errors
}
