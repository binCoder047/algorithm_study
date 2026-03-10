package algo_impl.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
public class GracketsGenerate {

    /**
     * 存储所有有效的括号组合结果
     * 使用静态变量避免递归过程中频繁传递结果集合
     */
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        GracketsGenerate generator = new GracketsGenerate();

        // 测试用例：生成3对括号的所有有效组合
        System.out.println(generator.generateParenthesis(3));
    }

    /**
     * 生成括号
     *
     * @param n 括号对数
     * @return 所有可能的并且 有效的 括号组合
     */
    public List<String> generateParenthesis(int n) {
        // 清空之前的结果（避免多次调用时结果累积）
        res.clear();

        if (n == 0) {
            return res;
        }
        // 初始状态：n个左括号和n个右括号可用，从空字符串开始
        getParenthesis("", n, n);

        return res;
    }

    /**
     * 生成括号（递归辅助方法）
     *
     * @param str   当前构建的括号字符串
     * @param left  剩余左括号数量
     * @param right 剩余右括号数量
     */
    private void getParenthesis(String str, int left, int right) {
        // 终止条件：左右括号都用完了，得到一个有效组合
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        // 剩余左右括号数相等，下一个只能用左括号
        // 原因：如果用右括号，会导致右括号比左括号多，形成无效组合
        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {
            // 剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }
}
