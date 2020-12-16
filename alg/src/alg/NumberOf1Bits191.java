package alg;

public class NumberOf1Bits191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int flag = 1;
        int sum = 0;
        for(int i = 0; i < 32; i++) {
            if((flag & n) != 0) {
                sum += 1;
            }
            flag = flag << 1;
        }
        return sum;
    }


    public static void main(String[] agrs) {
        NumberOf1Bits191 test = new NumberOf1Bits191();
        System.out.println(test.hammingWeight(3));


    }

}
