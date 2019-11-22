package alg;

public class RotateArray {
    
    /**                  len = 7  
     * 4,5,6,7,8,9,10    k = 2
     * 9,8,7,6,5,4    k = 2
     * 
     * 9,10,4,5,6,7,8
     * 
     * 4,5,6,7,8,9,10             
     * 
     * 
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {        
        int len = nums.length;
        k = k % len;
        //��ת��һ�Ρ�
        roate(nums, 0, len - 1);
        //��ת�ڶ��Ρ�
        roate(nums, 0, k - 1);
        //��ת�����Ρ�
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
    
    
    static public void rotateRight(int[] sourceArray,int offset) {
        int arrayLength = sourceArray.length;
        //����offset���п��ܳ������鳤�ȣ�����������֮ǰ�����ȶ���ȡģ��
        int moduleOffset = offset % arrayLength;
        int startIndex = 0;
        int currentIndex = startIndex;
        int endIndex = (startIndex + moduleOffset) % arrayLength;
        int tempElement = sourceArray[startIndex];
        //���ڿ�ʼ��������ƶ�
        for (int counter = 0;counter < arrayLength;counter++) {
            if (startIndex != endIndex) {
                sourceArray[currentIndex] = sourceArray[endIndex];
                currentIndex = endIndex;
                endIndex = (currentIndex + moduleOffset) % arrayLength;
                for (int element:sourceArray) {
                    System.out.print(element + " ");
                }
                System.out.println("if");
            } else {
                sourceArray[currentIndex] = tempElement;
                currentIndex = ++startIndex;
                endIndex = (currentIndex + moduleOffset) % arrayLength;
                tempElement = sourceArray[startIndex];
                for (int element:sourceArray) {
                    System.out.print(element + " ");
                }
                System.out.println("else");
            }
        }
    }
    
    public static void main(String[] args){
        int[] nums = new int[]{4,5,6,7,8,9,10};
        
        rotateRight(nums,2);
    }
    
}
