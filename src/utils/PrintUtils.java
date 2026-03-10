package utils;

import java.util.List;

/**
 * 打印相关的工具类
 */
public class PrintUtils {

    public static void printlnList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj.toString());
            System.out.print("  ");
        }
    }

    public static void printList(int[][] list) {
        for (int[] arr : list) {
            System.out.print(arr[0] + " " + arr[1]);
            System.out.println();
        }
    }
}
