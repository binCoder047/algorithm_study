package algo_impl.strings;

/**
 * 进制转换
 * 16进制转换为10进制
 * 
 * 方法：从右到左，将第 i 位的数乘以 16 的 i 次方，将所有结果累加起来即可。
 * 
 * 示例：
 * 16进制数"1A"转换为10进制数为26
 */
public class ConvertNumberSystem {

    public static void main(String[] args) {
        String hex = "0xFA93";
        int dec = hexToDec(hex);
        System.out.println(dec);
    }

    /**
     * 16进制转换为10进制
     * @param hex
     * @return
     */
    public static int hexToDec(String hex) {
        int dec = 0;
        for (int i = hex.length(); i > 1; i--) {
            char c = hex.charAt(i - 1);
            int n = 0;
            if (c >= '0' && c <= '9') {
                n = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                n = c - 'A' + 10;
            } else if (c >= 'a' && c <= 'f') {
                n = c - 'a' + 10;
            }
            dec = dec + n * (int) Math.pow(16, hex.length() - i);
        }
        return dec;
    }
}
