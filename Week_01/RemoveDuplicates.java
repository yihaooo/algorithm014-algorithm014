package com.kihao.demo;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;
        while(q<nums.length){
            if(nums[q]!=nums[p]){
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}
