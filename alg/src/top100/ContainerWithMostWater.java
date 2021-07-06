package top100;

/**
 * 盛最多水的容器 双指针法
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start != end) {
            result = Math.max(result,Math.min(height[start],height[end]) * (end - start));
            if(height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

}
