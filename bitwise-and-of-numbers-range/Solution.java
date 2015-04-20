public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        final int SIZE = Integer.SIZE;

        long[] POW = new long[SIZE + 1];

        for(int i = 0; i < SIZE; i++){
            POW[i] = (long)Math.pow(2, i);
        }

        for(int i = SIZE; i > 0; i--){
            if(POW[i - 1] <= m && m < POW[i]){
                if(POW[i - 1] <= n && n < POW[i]){
                    long p = POW[i - 1];
                    return (int)p | rangeBitwiseAnd((int)(m & (p - 1)), (int)(n & (p - 1)));
                }
            }
        }

        return 0;
    }
}
