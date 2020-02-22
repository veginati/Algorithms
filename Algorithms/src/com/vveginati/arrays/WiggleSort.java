/*
Given an unsorted array nums, reorder it in-place 
such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]

https://leetcode.com/problems/wiggle-sort/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Sort.
Memory Usage: 42.1 MB, less than 5.26% of Java online submissions for Wiggle Sort.
*/

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        
        for(int i=1;i<nums.length;i=i+2){
            int left = nums[i-1];
            int right = Integer.MIN_VALUE;
            
            if(i+1<nums.length){
                right = nums[i+1];
            }
            
            if(left>=nums[i] && left>=right){
                int temp = nums[i];
                nums[i] = left;
                nums[i-1] = temp;
            }else if(right>= nums[i] && right>= left){
                int temp = nums[i];
                nums[i]= right;
                nums[i+1] = temp;
            }
        }
        
    }
}