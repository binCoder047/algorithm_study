package algo_impl.strings;

/**
 * 统计字符出现次数
 * 给定一个字符串 s 和一个字符 c，
 * 统计字符 c 在字符串 s 中出现的次数。
 * 
 * 描述：
 * 对于给定的由大小写字母、数字和空格混合构成的字符串
 * 给定字符
 * 按要求统计：
 *  若 c 为大写或者小写字母，统计其大小写形态出现的次数和；
 *  若 c 为数字，统计其出现的次数。
 * 
 * 示例：
 * 输入：s = "hello", c = "l"
 * 输出：2
 */
public class CountCharAppear {

    public static void main(String[] args) {
        String s = "hello";
        char c = 'l';
        int count = countCharAppear(s, c);
        System.out.println(count);
    }

    /**
     * 统计字符出现次数
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param s 输入字符串
     * @param c 目标字符
     * @return 字符出现次数
     */
    public static int countCharAppear(String s, char c) {
        int count = 0;
        String upperS = s.toUpperCase();
        char upperC = Character.toUpperCase(c);
        
        for (int i = 0; i < upperS.length(); i++) {
            if (upperS.charAt(i) == upperC) {
                count++;
            }
        }
        return count;
    }
}
