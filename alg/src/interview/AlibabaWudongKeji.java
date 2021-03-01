package interview;

import java.util.ArrayList;
import java.util.List;

public class AlibabaWudongKeji {

    //冒泡
    public static void bubbleSort1(int [] a){
        //int num[] = new int[]{7,3,2,5,6};
        int i, j = 0;
        int length = a.length;
        for(i=0; i < length; i++) {
            for (j = 1; j < length - 1; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(a);
    }
    //“ hello world java”
    //“ java world hello”
    //不清楚题目。.
    public static void revers() {
        String a = "   hello world java";
        String[] temp = a.split(" ");
        StringBuilder b = new StringBuilder();
        for(int i = temp.length - 1; i >= 0; i--) {
           b.append(temp[i]).append(" ");
        }
        b.delete(b.length() - 2,b.length()).insert(0," ");
        System.out.println(b.toString());
    }


    //动态规划，找最长子串
    public static String longString() {
        String a = "asasqwertiyopsaxqwertiyop";
        char[] chars = a.toCharArray();
        List<Character> temp = new ArrayList<>();
        List<Character> max = new ArrayList<>();
        //需要移除滑动集合中值
        List<Character> delstemp = new ArrayList<>();
        for(int i = 0; i < chars.length; i++) {
            int index = exist(chars[i],temp);
            if(index == -1) {
                temp.add(chars[i]);
                continue;
            }
            //若已有最大长度小于当前则重新赋值
            if (max.size() < temp.size()) {
                max.clear();
                max.addAll(temp);
            }
            //temp重新开始赋值
            //已知index = 1 temp = jav; 移除 ja.保留V
            //得公式保留temp index后面的值
            for(int del = 0; del <= index; del++) {
                delstemp.add(temp.get(del));
            }
            temp.removeAll(delstemp);
            delstemp.clear();
            temp.add(chars[i]);
        }
        List b = temp.size() > max.size() ? temp : max;

        b.forEach(c -> System.out.print(c));
        return null;
    }

    private static int exist(char a,List<Character> temp) {
        if(temp.contains(a)) {
            return temp.indexOf(a);
        }
        return -1;
    }



    public static void main(String[] agrs) {
        //revers();
        System.out.println(agrs);
    }


}
