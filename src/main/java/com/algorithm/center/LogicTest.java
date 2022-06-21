package com.algorithm.center;

/**
 * @author liuzhaowei
 * @date 2022/6/18 22:49
 */
public class LogicTest {
    public static void main(String[] args) {
        String[] words = new String[]{"y","z"};
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        System.out.println(masks);

    }
}
