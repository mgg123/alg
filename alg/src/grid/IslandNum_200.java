package grid;

/**
 * leetcode200 岛屿数量
 */
public class IslandNum_200 {

    public static int numIslands(char[][] grid) {
        int res = 0;
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                if(grid[x][y] == '1') {
                    //进行深度遍历岛屿。
                    dfs(grid,x,y);
                    //遍历结束,岛屿数量加1
                    res ++;
                }
            }
        }
        return res;
    }



    static void dfs(char[][] grid,int x, int y) {
        //界限判断
        if(!inGrid(grid,x,y)) {
            return ;
        }

        //如果不为1说明不是岛屿或已遍历
        if(grid[x][y] != '1') {
            return ;
        }
        //将岛屿部分设置为2
        grid[x][y] = '2';
        dfs(grid,x + 1,y);
        dfs(grid,x - 1,y);
        dfs(grid,x,y + 1);
        dfs(grid,x,y - 1);
    }

    //在网格中
    static boolean inGrid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >=0 && y < grid[0].length;
    }


    public static void main(String[] args) {

        char[][] island = new char[][] {
                {'1','1','0','1','1','0'},
                {'1','0','1','0','1','1'},
                {'0','1','0','1','1','0'}
        };


        System.out.println(numIslands(island));
    }

}
