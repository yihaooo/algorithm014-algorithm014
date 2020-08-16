package com.kihao.demo;

//42接雨水
public class Trap {
    public int trap(int[] height) {
        int len = height.length;
        if(len<3){
            return 0;
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int curHeight = Math.min(height[i],height[stack.peek()]) - height[top];
                int curWidth = i-stack.peek()-1;
                res+=curHeight*curWidth;
            }
            stack.push(i);
        }
        return res;
    }
}
