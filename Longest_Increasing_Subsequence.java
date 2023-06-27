package practice_Project3;

import java.util.ArrayList;
import java.util.List;

public class Longest_Increasing_Subsequence {
	
	    public static List<Integer> findLongestIncreingSubseq(int[] nums) {
	        int n = nums.length;
	        int[] dp = new int[n];
	        int[] prev = new int[n];

	        for (int i = 0; i < n; i++) {
	            dp[i] = 1;
	            prev[i] = -1;
	            for (int j = 0; j < i; j++) {
	                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
	                    dp[i] = dp[j] + 1;
	                    prev[i] = j;
	                }
	            }
	        }

	        int maxLength = 0;
	        int maxLengthIndex = -1;
	        for (int i = 0; i < n; i++) {
	            if (dp[i] > maxLength) {
	                maxLength = dp[i];
	                maxLengthIndex = i;
	            }
	        }

	        List<Integer> lis = new ArrayList<>();
	        int currentIndex = maxLengthIndex;
	        while (currentIndex != -1) {
	            lis.add(0, nums[currentIndex]);
	            currentIndex = prev[currentIndex];
	        }

	        return lis;
	    }

	    public static void main(String[] args) {
	        int[] n = {1, 9, 2, 5, 3, 7, 11, 18};
	        List<Integer> lis = findLongestIncreingSubseq(n);

	        System.out.println("Array:");
	        for (int num : n) {
	            System.out.print(num + " ");
	        }
	        System.out.println();

	        System.out.println("Longest Increasing Subsequence are :");
	        for (int num : lis) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }
	}

