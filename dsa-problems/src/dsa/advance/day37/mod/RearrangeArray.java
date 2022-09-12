package dsa.advance.day37.mod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
Example:
Input : [1, 0]
Return : [0, 1]
Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
*/
public class RearrangeArray {
    @Test
    public void test(){
        int[] array = {3,2,4,1,0};
        int[] expected = {1,4,0,2,3};
        Assertions.assertArrayEquals(expected, reArrange(array));
    }

    public int[] reArrange(int[] array) {
        int n = array.length;
        for(int i = 0; i < n; i++){
            array[i] = array[i] * n; //list.set(i, list.get(i)*n);
        }

        for(int i = 0; i < n; i++){
            array[i] = array[i] + array[array[i]/n]/n; //list.set(i, list.get(i) + list.get(list.get(i)/n)/n);
        }

        for(int i = 0; i < n; i++){
            array[i] = array[i] % n; //list.set(i, list.get(i)%n);
        }
        return array;
    }
    /*
    public void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
        for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
    }
    */
}
/*
If you had extra space to do it, the problem will be very easy.
Store a copy of Arr in B.

And then for every element, do Arr[i] = B[B[i]]

Lets restate what we just said for extra space :

If we could somehow store 2 numbers in every index ( that is, Arr[i] can contain the old value and the new value somehow ), then the problem becomes very easy.
NewValue of Arr[i] = OldValue of Arr[OldValue of Arr[i]]

Now, we will do a slight trick to encode 2 numbers in one index.
This trick assumes that N * N does not overflow.

1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
2) Divide every element by N.
Given a number as

A = B + C * N   if ( B, C < N )
A % N = B
A / N = C
*/
