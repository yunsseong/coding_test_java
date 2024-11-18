import java.util.*;

public class Problem05 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {{1, 4}, {3, 2}, {4, 1}}, new int[][] {{3, 3}, {3, 3}})));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return result;
    }
}
