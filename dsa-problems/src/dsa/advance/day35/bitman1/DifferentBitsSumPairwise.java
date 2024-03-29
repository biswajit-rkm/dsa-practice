package dsa.advance.day35.bitman1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/*
We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f(2, 7) = 2,
since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
You are given an array of N positive integers, A1, A2 ,…, AN.
Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
For example,
A=[1, 3, 5]
f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) =
0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
*/

public class DifferentBitsSumPairwise {

    @Test
    public void test(){
        int[] arr = {1,3,5};
        Assertions.assertEquals(8, cntBits(arr));
    }

    public int cntBits(int[] array) {
        long sum = 0;
        for(int i = 0 ; i < 32; i++){
            int zeroCount = 0;
            int oneCount = 0;
            for(int j = 0; j < array.length; j ++){
                if(isIthBitSet(array[j], i)){
                    oneCount++;
                }else {
                    zeroCount++;
                }
            }
            sum+=((long) oneCount * (zeroCount)) %1000000007;
        }
        return (int)(2* sum % 1000000007);
    }

    private boolean isIthBitSet(int num, int i) {
        return ((num >> i) & 1 ) == 1;
    }
}

/*
    Assume that all values in input have only 1 bit i.e. Ai = 0 or 1.
    Let say A = count of elements which are 0, and B = count of elements which are 1
    In this case our answer is just 2AB, since each such pair contributes 1 to answer.
    Can you combine this logic if we have multiple bits?
    Note that all bits are independent in counting, since we are counting number of bits which are different in each pair.
    So, we just do the same process for all different bits. Since Ai is an integer, we just have to do this for 31 different bits, so our solution is O(31*N).
*/
