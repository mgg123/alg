package alg;

public class RotateArray {
    
    /**
     * 4,5,6,7,8,9    k = 2
     * 9,8,7,6,5,4    k = 2
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {        
        int len = nums.length;
        k = k % len;
        //反转第一次。
        roate(nums, 0, len - 1);
        //反转第二次。
        roate(nums, 0, k - 1);
        //反转第三次。
        roate(nums, k, len - 1);
        
    }
    
    public void roate(int[] nums,int start,int end){   
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
    
    
}
