package array;


/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * O(n)   O(1)
 */

public class OnlyOneNumberAppears136 {

    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] agrs) {
        int[] nums = new int[]{7,2,3,2,3};
        System.out.println(singleNumber(nums));
    }
}
