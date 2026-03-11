package algo_impl.strings;

import java.util.Scanner;

public class SplitString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        int i = 0;
        for (i = 0; i + 8 <= source.length(); i = i + 8) {
            // 没超过，累加i，到达8的倍数后输出
            // 超过长度了，判断当前累加的字符长度，不足8的，后面加0
            System.out.println(source.substring(i, i + 8));
        }

        // 处理最后一段不足8或前面直接为8的整数倍的情况
        if (!source.substring(i).isEmpty()) {
            System.out.println(source.substring(i) + "0".repeat(8 - source.length() + i));
        }

    }
}
