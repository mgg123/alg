package top100;

import java.util.Stack;

/**
 * 接雨水 leetcode 42
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 */
public class TrappingRainWater_42 {


    public static int trap(int[] height) {
       return  stack(height);
    }




    private static int stack(int[] height) {
        int lenght = height.length;
        int watger = 0;
        Stack<Integer> stack = new Stack<>();
        // push
        for(int i = 0; i < lenght; i++) {

            //
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int popnum = stack.pop();
                while(!stack.isEmpty() && height[popnum] == height[stack.peek()]) {
                    stack.pop();
                }

                if(!stack.isEmpty()) {
                    int hig = Math.min(height[i],height[stack.peek()]) - height[popnum];
                    int weight = i - stack.peek() - 1;
                    watger += hig * weight;
                }
            }
            stack.push(i);
        }
        return watger;
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    private static int doublePoint(int[] height) {

        int lefMax = height[0];
        int rightMax = height[height.length - 1];

        int lef = 0;
        int right = height.length - 1;
        int water = 0;
        while (lef < right) {
            if(lefMax < rightMax) {
                water += lefMax - height[lef] * 1;
                lef++;
                lefMax = Math.max(lefMax,height[lef]);
            } else {
                water += rightMax - height[right] * 1;
                right--;
                rightMax = Math.max(rightMax,height[right]);
            }
        }
        return water;
    }


    public static void main(String[] args) {
        int[] hight = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(doublePoint(hight));

    }

}
