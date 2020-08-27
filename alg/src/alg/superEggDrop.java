package alg;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 */
public class superEggDrop {

    /**
     *  当前楼层碎往下层继续找，当前楼层没碎往上层找 暴力破解 timeout 待优化
     * 思路：k=鸡蛋数，n=楼梯数 f(k,n) = 1 + max(f(k-1,x - 1),f(k,n - x))
     * @param K
     * @param N
     * @return
     */

    public static int superEggDrop(int K, int N) {
        if(N == 0 || K == 1 || N == 1) {
            return N;
        }
        //这里不能用2分法。如例子：假设一共100楼，2个鸡蛋，如果剩余一个用来线性探测
        //// 最坏情况下可能要50次，但实际上，第一次用五分而不是二分，那么剩余一个用来线性探测
        //int x = N % 2 == 0 ?  N / 2 : N / 2 + 1;
        int res = N;
        for(int i = 1; i <= N; i++) {
            int num = Math.max(superEggDrop(K - 1, i - 1), superEggDrop(K, N - i));
            res = Math.min(res,num + 1);
        }
        return res;
    }

    public static void main(String[] agrs) {
        System.out.println(superEggDrop(2,30));

    }
}
