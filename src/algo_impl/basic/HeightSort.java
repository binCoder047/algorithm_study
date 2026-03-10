package algo_impl.basic;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目
 * 小明今年升学到了小学一年级，来到新班级后，发现其他小朋友身高参差不齐，然后就想基于各小朋友和自己的身高差，对他们进行排序，请帮他实现排序。
 * <p>
 * 输入
 * 第一行入参为正整数H和N，其中0 < H < 200 为小明的身高，0 < N < 50 为新班级其他小朋友个数。
 * <p>
 * 第二行入参为 N 个正整数H1 ~ Hn分别是其他小朋友的身高，取值范围0 < Hi < 200，且N个正整数各不相同。
 * <p>
 * 输出
 * 输出排序结果，各正整数以空格分割，和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在后面.
 * 如果两个小朋友的身高和小明身高差一样，则个子较小的小朋友排在前面。
 */
public class HeightSort {

    public static void main(String[] args) {
        PrintUtils.printList(sortHeight(100, new ArrayList<>(List.of(99, 50, 45, 98, 105, 189, 1000))));
    }

    /**
     * 身高排序
     *
     * @param height     被比较身高
     * @param heightList 其他学生身高列表
     * @return 排序后身高列表
     */
    public static List<Integer> sortHeight(Integer height, List<Integer> heightList) {
        // 对 heightList 进行排序，将绝对值差的大的放到前面
        heightList.sort((o1, o2) -> {
            int diff1 = Math.abs(o1 - height);
            int diff2 = Math.abs(o2 - height);
            // 如果绝对值一样，则小的在前面
            if (diff1 == diff2) {
                return o1.compareTo(o2);
            }
            return Integer.compare(diff1, diff2);
        });
        return heightList;
    }
}
