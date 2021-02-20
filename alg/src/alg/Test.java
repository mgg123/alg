package alg;

public class Test {

    public static String search(int[] a, int[] b) {
        StringBuilder sql = new StringBuilder();
        int jinwei = 0;
        for(int i = a.length - 1; i >= 0; i--) {
            int cur =  a[i] + b[i];
            if(jinwei != 0) {
                cur += jinwei;
            }
            jinwei = cur / 10;
            sql.append(cur % 10);
        }
        sql.append(jinwei);
        return sql.reverse().toString();
    }

    public static void main(String[] agrs) {
        int[] a = new int[]{9,2,3,4,5};
        int[] b = new int[]{1,2,3,4,5};
        System.out.println(search(a,b));
    }
}
