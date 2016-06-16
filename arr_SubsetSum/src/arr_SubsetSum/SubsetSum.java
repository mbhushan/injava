package arr_SubsetSum;

/*
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total. Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 *
 * Time complexity - O(input.size * total_sum)
 * Space complexity - O(input.size*total_sum)
 * Recurrence:
 * if (j < A[i]) {
 * 	T[i][j] = T[i-1][j]
 * } else {
 * 	T[i][j] = T[i-1][j] || T[i-1][j - A[i]]
 * }
 */
public class SubsetSum {

}
