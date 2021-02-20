package alg;

/**
 *   Scanner in = new Scanner(System.in);
 *         while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
 *             int a = in.nextInt();
 *             int b = in.nextInt();
 *             System.out.println(a + b);
 *         }
 */

import java.util.Stack;

/**
 * Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         int ans = 0, x;
 *         for(int i = 0; i < n; i++){
 *             for(int j = 0; j < n; j++){
 *                 x = sc.nextInt();
 *                 ans += x;
 *             }
 *         }
 *         System.out.println(ans);
 */
public class TestMain {

    public static void main(String[] agrs) {
        //mmmcc    2[a3[m]]     mmmammma
        String str = "2[c]3[m]";
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        int lenght = chars.length;
        StringBuilder temp = new StringBuilder();
        for(int i = lenght - 1; i >= 0 ; i--) {
            stack.push(chars[i]);
            if(chars[i] >= 'a' && chars[i] <= 'z') {

            } else if (chars[i] != '[' && chars[i] != ']') {
                int num = Integer.valueOf(stack.pop().toString());
                do {
                    char ch = stack.pop();
                    if(ch >= 'a' && ch <= 'z') {
                        temp.append(ch);
                    }
                } while (stack.peek() != ']');
                stack.pop();
                for(int j = 0; j < num; j++) {
                    String a = temp.toString();
                    temp.append(a);
                }
            }
        }
        System.out.println(temp);
    }

//    public static int deleterep(StringBuilder builder,int lenght) {
//        char[] chars = builder.toString().toCharArray();
//        for(int i = 0,j = 1; i < lenght - 1 && j < lenght; i++,j++) {
//            if(chars[i] == chars[j]) {
//                builder.delete(i,j + 1);
//                break;
//            }
//        }
//        if(lenght == builder.length()) {
//            return lenght;
//        }
//        return deleterep(builder,builder.length());
//    }


}
