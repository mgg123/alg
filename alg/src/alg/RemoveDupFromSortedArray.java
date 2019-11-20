package alg;

public class RemoveDupFromSortedArray {
    
    public int removeDuplicates(int[] nums) {
        int newNumslength = nums.length;
        if (newNumslength == 1)
            return 1;       
        
        int newIndex = 0;
        int change = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            if (nums[i] == nums[j]) {
                change = j;
                newNumslength --;    
            } else {
                if (j > change) {
                    nums[newIndex = (newIndex + 1)] = nums[j];
                }
            }
        }        
        return newNumslength;
    }
    
    

}
