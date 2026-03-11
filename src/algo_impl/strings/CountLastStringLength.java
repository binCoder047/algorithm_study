package algo_impl.strings;

/**
 * 计算字符串中最后一个单词的长度
 * 最后一个单词指的是字符串中从最后一个非空格字符开始，到字符串末尾的所有字符。
 * 
 * 示例：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是 "World"，长度为 5。
 */
public class CountLastStringLength {

    public static void main(String[] args) {
        String s = "Hello World 111";
        int length = countLastStringLength2(s);
        System.out.println(length);
    }

    public static int countLastStringLength1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    /**
     * 计算字符串中最后一个单词的长度
     * 从字符串末尾开始遍历，遇到非空格字符则长度加一，
     * 遇到空格字符且长度大于零则表示最后一个单词已遍历完成，跳出循环。
     * 
     * @param s 输入字符串
     * @return 最后一个单词的长度
     */
    public static int countLastStringLength2(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
        }
        return length;
    }

}
