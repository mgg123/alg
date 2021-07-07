package offer;

/**
 * 剪绳子,数学推导.
 */
public class Offer14_1 {

    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        long result = 1;
        while(n > 4){
            n -= 3;
            result *= 3;
        }
        return (int)(n * result);
    }

}
