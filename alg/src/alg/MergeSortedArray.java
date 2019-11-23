package alg;

public class MergeSortedArray {
    
    /**
     * ��Copy nums1����,��ʼ3��ָ��,index1,index2,indexCopy���ֱ�ָ����3��������ʼλ�á�nums1��Ϊ������顣��nums1Copy
     * ��nums2���鿪ʼ���б����Ƚϡ���nums1Copy[indexCopy]�� nums2[index2]С,ȡС��ֵ��ֵ��nums1[index1]����indexCopy��������֮index2����
     * ÿ�θ�ֵ��index1Ҳ��������indexCopy��index2���ڵ����������鳤�ȣ����������һ�����������ȫ�������ʣ�µ�����,��Ҫ���Ѿ�nums[index1]�������Ҫ��
     * ��ʣ�µ�����Ҳ������,��ô��ʣ�����ֵƴ�ӵ�nums1�����м���.
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
