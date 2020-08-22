package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class MostOfTheElements169 {


    public static int majorityElement(int[] nums) {
        int threshold = nums.length / 2 + 1;
        Map<Integer,Integer> maps = new HashMap<>();
        for(int num : nums) {
            if(maps.containsKey(num)) {
                maps.put(num,maps.get(num) + 1);
            } else {
                maps.put(num,1);
            }

            if(maps.get(num) >= threshold) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 投票算法
     * @param nums
     * @return
     */
    public int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    /**
     * 排序算法
     * @param nums
     * @return
     */
    public int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }



    public static void main(String[] agrs) {
        int[] nums = new int[]{3,2,3};
        System.out.println(majorityElement(nums));
    }

}
