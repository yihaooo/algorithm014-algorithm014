package com.kihao.demo;

//283 移动0
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int head = 0;
        for(int tail = 0; tail < nums.length;tail++){
            if(nums[tail]!=0){
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
                head++;
            }
        }
    }
}
