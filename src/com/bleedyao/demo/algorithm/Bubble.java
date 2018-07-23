package com.bleedyao.demo.algorithm;

import com.bleedyao.demo.algorithm.result.Checker;
import com.bleedyao.demo.algorithm.utils.Utils;


/**
 * 冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        new Checker(new BubbleSort())
                .setSize(10000)
                .run();
    }

    /**
     * 冒泡排序
     */
    static class BubbleSort implements Checker.TestAlgorithm {

        @Override
        public void test(int[] testArray) {
            if (testArray == null || testArray.length < 2) {
                return;
            }
            for (int end = testArray.length - 1; end > 0; end--) {
                for (int i = 0; i < end; i++) {
                    if (testArray[i] > testArray[i + 1]) {
                        Utils.swap(testArray, i, i + 1);
                    }
                }
            }
        }
    }
}
