class BinomialCoefficientnCr {
    public static void main(String[] args) {
        int n = 6, r = 3;
        var _nCr = nCr(n, r);
        System.out.println("nCr: " + n + "-C-" + r + " " + _nCr);
    }

    /**
     * nCr -> ways of selecting r distinct elements out of n distinct elements
     * ____n!____= n(n-1)(n-2)...3.2.1
     * r!(n - r)!
     */
    private static long nCr(int n, int r) {
        r = Math.min(n - r, r);
        if (r > n)
            return 0;
        if (r == 0 || n == r)
            return 1;
        long numerator = 1, denominator = 1;
        for(int i = 0; i<r;i++){
            numerator*=(n-i);
            denominator*=(i+1);
        }
        return numerator/denominator;
    }
}