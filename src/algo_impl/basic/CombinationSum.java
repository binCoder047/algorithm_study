package algo_impl.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和问题
 * 给定一个无重复元素的数组 candidates 和一个目标数 target，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 示例：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        // 打印所有符合条件的组合
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    /**
     * 组合总和
     *
     * @param candidates 候选数组
     * @param target     目标值
     * @return 所有组合列表
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        // 剪枝优化：先对候选数组进行排序，这样可以提前终止无效的搜索路径
        Arrays.sort(candidates);
        dfs(candidates, target, ans, combine, 0);
        return ans;

    }

    /**
     * 深度优先搜索（回溯）函数
     *
     * @param candidates 候选数组（已排序）
     * @param target     剩余目标值
     * @param ans        结果集合，存储所有符合条件的组合
     * @param combine    当前正在构建的组合
     * @param idx        当前处理的候选元素索引
     */
    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        // 终止条件1：已经处理完所有候选元素
        if (idx == candidates.length) {
            return;
        }
        // 终止条件2：找到一个符合条件的组合
        if (target == 0) {
            // 深拷贝当前组合并添加到结果中
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        
        // 剪枝优化：如果当前元素已经大于剩余目标值，由于数组已排序，
        // 后面的元素只会更大，因此可以直接终止当前分支的搜索
        if (candidates[idx] > target) {
            return;
        }
        
        // 选择1：跳过当前元素，处理下一个元素
        dfs(candidates, target, ans, combine, idx + 1);
        
        // 选择2：使用当前元素（可以重复使用）
        // 剪枝优化：确保选择后不会超过目标值
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]); // 将当前元素添加到组合中
            // 递归处理，注意 idx 不变（因为可以重复使用当前元素）
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            // 回溯：移除最后添加的元素，恢复到之前的状态
            combine.remove(combine.size() - 1);
        }
    }
}
