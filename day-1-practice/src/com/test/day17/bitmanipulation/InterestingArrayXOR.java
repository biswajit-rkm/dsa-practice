package com.test.day17.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
/*

Q2. Interesting Array
You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
*/

public class InterestingArrayXOR {
    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5030, 7120, 5995, 237, 7582, 8476, 2174, 8787, 7611, 6616, 4640, 8907, 2164, 2753, 8246, 3858, 8795, 2762, 3378, 1527, 4725, 8119, 4447, 4834, 8465, 3253, 5664, 4404, 3114, 8380, 7844, 7975, 8413, 8338, 1682, 6535, 5500, 5400, 4160, 1849, 9472, 3114, 8330, 1255, 753, 4995, 4090, 7392, 4297, 65, 384, 2354, 847, 3906, 4016, 4424, 3316, 709, 6140, 5437, 2440, 2189, 130, 5699, 9506, 1243, 2862, 1141, 6659, 964, 7918, 5976, 5490, 9903, 9106, 2042, 2676, 3231, 3580, 299, 9134, 8663, 5389, 3268, 6394, 3092, 5235, 5109, 6224, 3314, 4611, 5381, 6032, 230, 5363, 3807, 3176, 4085, 966, 2880, 2591, 9157, 2971, 8330, 692, 5620, 7286, 665, 7865, 6799, 1393, 4977, 3075, 2960, 5979, 9158, 7903, 4771, 8390, 5238, 9661, 9410, 4020, 9300, 2499, 6477, 6404, 8553, 6809, 2659, 1930, 2559, 763, 2818, 9021, 5318, 9321, 286, 4721, 8026, 8236, 7179, 5207, 6036, 5518, 3781, 4672, 4357, 1274, 2218, 2158, 3079, 6340, 8790, 7674, 4099, 9847, 424, 3323, 7658, 2716, 2036, 6562, 1319, 5228, 433, 1287, 6290, 5199, 2479, 770, 5397, 6168, 1824, 1119, 7176, 8299, 3045, 6480, 7447, 764, 3381, 1095, 1318, 8162, 4862, 6442, 3061, 6213, 9495, 9439, 5961, 7153, 2888, 7218, 4371, 7009, 6645, 3701, 8882, 666, 9485, 8833, 3391, 4508, 1982, 4984, 6911, 711, 1902, 9143, 7240, 5051, 1199, 7843, 3519, 9739, 7046, 4694, 4537, 1014, 5507, 6184, 3731, 9066, 2129, 3345, 145, 5094, 4371, 7354, 6262, 9790, 8190));
        Assertions.assertEquals("No", solve(list));
        Assertions.assertEquals("Yes", solve(new ArrayList<>(Arrays.asList(9, 17))));
    }

    public String solve(ArrayList<Integer> A) {
        int c = 0;
        for(Integer x : A){
            c = c ^ x;
        }
        if(c % 2 == 0){
            return "Yes";
        }
        return "No";
    }
}