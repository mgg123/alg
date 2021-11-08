package alg;

/**
 * 正数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 */
public class ReverseInteger_7 {

  public static int reverse(int x) {

    long result = 0;
    while (x != 0) {
      int yushu = x % 10;
      x = x / 10;
      if (x != 0) {
        result = result * 10 + yushu * 10;
      } else {
        result = result + yushu;
      }
    }
    if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      result = 0;
    }
    return (int) result;

  }

  public static void main(String[] args) {
     System.out.println(reverse(124522));
  }

}
