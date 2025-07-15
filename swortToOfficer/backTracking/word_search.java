package backTracking;

import java.util.*;

public class word_search {
    /**
     * LeetCode 79: Word Search
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     *
     * Example:
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i <board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backTracking(board,words, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, char[] words, int i, int j, int k){
        if(k == words.length) return true;

        //case1: 上下左右达到边界
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0) return false;
        
        //case 2: 如果当前元素不是我们希望的元素（字对不上）
        if(board[i][j] != words[k]) return false;

        //back tracking的基本套路
        //1. 修改，防止反复使用当前元素
        board[i][j] = '\0';

        //分别向左右上下找。
        boolean res = backTracking(board, words, i + 1, j, k + 1) || backTracking(board, words, i-1, j, k+1)||
                      backTracking(board, words, i, j + 1, k + 1) || backTracking(board, words, i, j-1, k+1);

        //复原被修改的元素：
        board[i][j] = words[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        word_search solver = new word_search();
        boolean result = solver.exist(board, word);
        System.out.println("Word '" + word + "' exists in board: " + result);
        System.out.println("test '"+ 1/2);
    }
}
