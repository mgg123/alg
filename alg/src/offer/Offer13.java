package offer;

/**
 * 剑指offer 机器人可移动范围，利用dfs来计算
 */
public class Offer13 {
    static int sum = 0;
    public static int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        dfs(grid,0,0,k);
        return sum;
    }



    static void dfs(int[][] grid,int x, int y,int k) {
        if(!inGrid(grid,x,y)) {
            return ;
        }

        if(grid[x][y] == 1) {
            return ;
        }
        int xbitnum = bitsum(x);
        int ybitnum = bitsum(y);
        if((xbitnum + ybitnum) <= k) {
            sum++;
            grid[x][y] = 1;
        } else {
            return ;
        }

        dfs(grid,x + 1,y,k);
        dfs(grid,x,y + 1,k);
        dfs(grid,x - 1,y,k);
        dfs(grid,x,y - 1,k);

    }

    //在网格中
    static boolean inGrid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >=0 && y < grid[0].length;
    }


    static int bitsum(int index) {
        int bitsum = 0;
        while (index != 0) {
            bitsum += index % 10;
            index = index / 10;
        }
        return bitsum;
    }


    public static void main(String[] args) {
        System.out.println(movingCount(3,2,2));
    }

}
