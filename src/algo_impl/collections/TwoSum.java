package algo_impl.collections;

import java.util.HashMap;

/**
 * 两数之和问题
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 26;
        int[] result = twoSumHash(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    /**
     * 两数之和（暴力枚举）
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 包含两个整数下标数组
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 两数之和（哈希表）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 包含两个整数下标数组
     */
    public static int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 遍历数据，如果目标值减去当前值在哈希表中存在，
        // 则返回目标值减去当前值的下标和当前值的下标
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
