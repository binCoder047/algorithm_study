package algo_impl.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 随机数去重并排序
 * 给定一个包含 n 个整数的数组 nums，
 * 随机数去重并排序。
 * 
 * 描述：
 * 对于给定的包含 n 个整数的数组 nums，
 * 随机数去重并排序。
 * 
 * 示例：
 * 输入：nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */
public class RandomNumRemoveRepeatAndSort {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 500, 5, 6, 7, 8, 9, 10 };
        int[] res = removeRepeatAndSort1(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 通过数组下标天然有序来实现去重并排序
     * 
     * @param nums
     * @return
     */
    public static int[] removeRepeatAndSort1(int[] nums) {
        int[] temp = new int[1001];
        for (int num : nums) {
            temp[num] = 1;
        }
        int[] res = new int[1001];
        int i = 0;
        for (int res2 : res) {
            if (res2 == 1) {
                res[i++] = res2;
            }
        }
        return res;
    }

    /**
     * 随机数去重并排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * @param nums 输入数组
     * @return 去重并排序后的数组
     */
    public static int[] removeRepeatAndSort2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        Arrays.sort(res);
        return res;
    }
}
