package grid;

/**
 * 网格的深度优先搜索
 * [0,1,1,1,1]
 * [1,1,1,1,0]
 * [0,0,0,0,1]
 */
public class GridDfs {

    void dfs(int[][] grid,int x, int y) {

        if(!inGrid(grid,x,y)) {
            return ;
        }

        dfs(grid,x + 1,y);
        dfs(grid,x - 1,y);
        dfs(grid,x,y + 1);
        dfs(grid,x,y - 1);

    }

    //在网格中
    boolean inGrid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >=0 && y < grid[0].length;
    }

}
