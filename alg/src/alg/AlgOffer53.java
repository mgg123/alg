package alg;

/**
 * 在排序数组中查找数字 I easy
 */
public class AlgOffer53 {
    public int search(int[] nums, int target) {

        int count = 0;
        for(int num : nums) {
            if(num == target) {
                count++;
            }
        }
        return count;
    }


    /**
     * 2
     * @param nums
     * @param target
     * @return
     */
    public static int searchLogN(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int i = 0,j = nums.length - 1;
        //找到数组中 最后一个target;
        while (i <= j) {
            int mid = (i + j) / 2;
            if(nums[mid] <= target) {
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        int last = i - 1;
        //若不存在，直接返回
        if(last >= 0 && nums[last] != target) {
            return 0;
        }
        //找到数组中 第一个target;
        i = 0;j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if(nums[mid] < target) {
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        int first = j + 1;
        return last - first + 1;
    }

    public static void main(String[] agrs) {

        int[] nums = new int[]{5};

        searchLogN(nums,8);

    }
}
