package alg;

public class MergeSortedArray {
    
    /**
     * 新Copy nums1数组,初始3个指针,index1,index2,indexCopy，分别指向这3个数组起始位置。nums1作为输出数组。对nums1Copy
     * 与nums2数组开始进行遍历比较。若nums1Copy[indexCopy]比 nums2[index2]小,取小的值赋值给nums1[index1]。且indexCopy自增。反之index2自增
     * 每次赋值完index1也自增。若indexCopy或index2大于等于自身数组长度，则表明其中一个数组遍历完全。则表明剩下的数组,都要比已经nums[index1]里的数都要大。
     * 且剩下的数组也是有序,那么将剩余的数值拼接到nums1数组中即可.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
                
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        
        int index = 0;        
        int nums1Index = 0;
        int nums2Index = 0;
        
        while (nums1Index < m && nums2Index < n){
            nums1[index++] = nums1Copy[nums1Index] > nums2[nums2Index] ? nums2[nums2Index++] : nums1Copy[nums1Index++];
        };
        
        if(nums1Index >= m){
            System.arraycopy(nums2, nums2Index, nums1, index, n - nums2Index);
        }else{
            System.arraycopy(nums1Copy, nums1Index, nums1, index, m - nums1Index);
        }
        
        
    }
    
    
    public static void main(String[] args){
       int[] nums1 = new int[]{2,0};
       int[] nums2 =new int[]{1};
       
       merge(nums1,1,nums2,1);
       
    }
    
}
