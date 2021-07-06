package offer;

/**
 * 矩阵中的路径 剑指offer12 dfs搜索
 */
public class Offer12 {

    private static char[] words;
    public static boolean exist(char[][] board, String word) {
        words = word.toCharArray();
        boolean result = false;
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board[0].length; y++) {
                if(dfsexist(board,x,y,0)) {
                    return true;
                }
            }
        }
        return result;
    }


    //在网格中
    static boolean inGrid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >=0 && y < grid[0].length;
    }


    private static boolean dfsexist(char[][] board,int x, int y, int workindex) {
        if(!inGrid(board,x,y)) {
            return false;
        }
        if(board[x][y] != words[workindex]) {
            return false;
        }
        if(workindex == words.length - 1) {
            return true;
        }
        int nextworkindex = workindex + 1;
        board[x][y] = ' ';
        boolean y1 = dfsexist(board,x,y+1,nextworkindex);
        boolean y2 = dfsexist(board,x,y-1,nextworkindex);
        boolean x1 = dfsexist(board,x+1,y,nextworkindex);
        boolean x2 = dfsexist(board,x-1,y,nextworkindex);
        if(!(y1 || y2 || x1 || x2)) {
            board[x][y] = words[workindex];
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a','b','c'},
                {'b','d','e'},
                {'f','g','k'}
        };

        System.out.println(exist(board,"ba"));

    }

}
