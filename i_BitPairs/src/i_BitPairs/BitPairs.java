package i_BitPairs;

/*
 Problem Description:

We define f (X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f (2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f (2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

Input:

The first line of each input consists of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, and the second line has the elements of the array.


Output:

In each separate line print sum of all pairs for (i, j) such that 1 ≤ i, j ≤ N and return the answer modulo 109+7.

******************** Solution ************************
Iterate the array, and count number of "on" bits in each bit index, for example [1, 3, 5]:

0 0 1
0 1 1
1 0 1
-----
1 1 3
Now, for each bit counter, calculate:

[bit count] * [array size - bit count] * 2
and sum for all bits...

With example above:

3 * (3 - 3) * 2 = 0
1 * (3 - 1) * 2 = 4
1 * (3 - 1) * 2 = 4
          total = 8
To show why this works, lets look at a subset of the problem, using a single bit. Let's see what happens if we have an array with: [1, 1, 0, 0, 1, 0, 1]. Our count is 4 and size is 7. If we examine the first bit with all the bits in the array (including self, as in the question), we get:

1 xor 1 = 0
1 xor 1 = 0
1 xor 0 = 1
1 xor 0 = 1
1 xor 1 = 0
1 xor 0 = 1
1 xor 1 = 0
As can be seen, the contribution of this bit is the number of "off" bits. The same holds true for any other "on" bit. We could say that each "on" bit counts as the number of "off" bits:

[bit count] * [array size - bit count]
And where does the multiplication by 2 comes from? well, since we do the same with the "off" bits, except that for these, the contribution is the number of "on" bits:

[array size - bit count] * [bit count]
which of course is the same as above, and we can just multiply...

Complexity is O(n*k) where k is number of bits (32 in your code).
 */
public class BitPairs {

}
