import java.util.*;

public class Problem13 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        for(int m : moves) {
            for(int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    stack.push(board[i][m - 1]);
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }

        Stack<Integer> answer = new Stack<>();
        for (Integer d : stack) {
            if (answer.isEmpty()) {
                answer.push(d);
            } else if (answer.peek().equals(d)) {
                answer.pop();
            } else {
                answer.push(d);
            }
        }
        return stack.size() - answer.size();
    }
}
