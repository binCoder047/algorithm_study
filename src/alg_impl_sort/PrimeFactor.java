package alg_impl_sort;

public class PrimeFactor {

    public static void main(String[] args) {
        long n = 64577;
        primeFactor(n);
    }

    /**
     * 素因子分解 - 优化版本
     * 时间复杂度: O(√n)
     * 
     * @param num
     */
    public static void primeFactor(long num) {
        long temp = 2;
        
        // 只需检查到√num，因为如果num有因子f>√num，则必有对应因子num/f<√num
        while (temp * temp <= num) {
            // 内层循环：连续除以temp，处理重复因子
            // 例如：8 = 2×2×2，需要连续除以2三次
            while (num % temp == 0) {
                System.out.print(temp + " ");
                num = num / temp;
            }
            // 优化：跳过偶数（除了2），因为偶数不可能是素数
            if (temp == 2) {
                temp = 3;  // 从2跳到3
            } else {
                temp += 2;  // 之后只检查奇数：3,5,7,9,11...
            }
        }
        
        // 如果循环结束后num>1，说明num本身是素数
        // 例如：分解14后，num=7，7>1且7是素数
        if (num > 1) {
            System.out.print(num + " ");
        }
    }

}
