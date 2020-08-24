package alg;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *[
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 */
public class searchMatrix240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[matrix.length - 1].length < 1) {
            return false;
        }
        //通过2分找到第一列第几行开始遍历的起点。
        int midindex = find(matrix,target);
        //设置列的下标
        int index = 0;
        while ((midindex <= matrix.length - 1 && midindex >= 0) && (index <= matrix[matrix.length -1].length -1)) {
            if(matrix[midindex][index] == target) {
                return true;
            } else if(matrix[midindex][index] < target){
                index++;
            } else if(matrix[midindex][index] > target) {
                midindex--;
            }
        }

        return false;
    }

    private static int find(final int[][] a, final int value) {
        int l = 0;
        int r = a.length - 1;

        while ( l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid][0] == value) {
                return mid;
            } else if (a[mid][0] < value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{-1,3}};
        System.out.println(searchMatrix(a,3));
    }
}
