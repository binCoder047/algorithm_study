package algo_impl.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalMerge {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] merged = merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 对区间列表进行排序，根据区间的起始位置
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 合并区间
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果合并列表为空，或者结果区间 end 小于当前区间 start，则当前区间与列表最后一个区间不重叠，直接添加到列表
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 否则，合并当前区间与合并列表最后一个区间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
